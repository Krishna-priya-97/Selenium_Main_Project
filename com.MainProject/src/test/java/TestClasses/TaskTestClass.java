package TestClasses;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageClasses.DashBoardPageClass;
import PageClasses.LoginPageClass;
import PageClasses.TaskPageClass;
import PageClasses.TerminationPageClass;
import Utilities.ExcelReadUtility;
import Utilities.RandomDataUtility;

public class TaskTestClass extends BaseClass {

	LoginPageClass lp;
	DashBoardPageClass dp;
	TaskPageClass tk;

	@Test
	public void verifyToImportTask() throws IOException {

		lp = new LoginPageClass(driver);
		dp=lp.sign_in(ExcelReadUtility.getStringData(2, 0, "LoginPage"),ExcelReadUtility.getIntData(2, 1, "LoginPage"));

		dp.clickOnTasks();

		tk = new TaskPageClass(driver);
		tk.clickOnImportTasks();
		String file=tk.getTextOfSelectFile();
		tk.uploadFile("D:\\JAVA\\com.MainProject\\src\\test\\resources\\uploaddocument.doc");
		String change=tk.getTextOfChange();
		Assert.assertNotEquals(file, change);
		tk.clickOnUpload();

	}

	@Test
	public void verifyToCreateNewTask() throws IOException {

		lp = new LoginPageClass(driver);
		dp=lp.sign_in(ExcelReadUtility.getStringData(2, 0, "LoginPage"),ExcelReadUtility.getIntData(2, 1, "LoginPage"));
		
		dp.clickOnTasks();

		tk = new TaskPageClass(driver);
		tk.clickOnNewTask();
		tk.clickOnTaskName();
		String taskName=RandomDataUtility.getTaskName();
		tk.updateTaskNameViaSendkeys(taskName);
		tk.clickOnDueDate();
		tk.dueDateInsertionViaSendKeys(ExcelReadUtility.getIntData(0, 0, "Task"));
		tk.pressEnterKey();
		tk.clickOnSave();
		dp.clickOnTasks();
		tk.clickOnAllTask();
		String newTaskName=tk.getTextOfNewTaskName();
		Assert.assertEquals(taskName, newTaskName);
		
	}
}
