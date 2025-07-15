package TestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageClasses.DashBoardPageClass;
import PageClasses.LoginPageClass;
import PageClasses.TerminationPageClass;
import Utilities.ExcelReadUtility;
import Utilities.RandomDataUtility;

public class TerminationTestClass extends BaseClass {

	LoginPageClass lp;
	DashBoardPageClass dp;
	TerminationPageClass tn;

	@Test(priority=1)
	public void verifyToAddTermination() throws IOException {

		lp = new LoginPageClass(driver);
		dp=lp.sign_in(ExcelReadUtility.getStringData(2, 0, "LoginPage"),ExcelReadUtility.getIntData(2, 1, "LoginPage"));

		dp.clickOnTermination();

		tn = new TerminationPageClass(driver);
		tn.clickOnNewTermination();
		tn.clickOnEmployeeName();
		tn.employeeNameInsertionViaSendKeys(ExcelReadUtility.getStringData(0, 0, "Termination"));
		tn.pressEnterKey();
		tn.clickOnNoticeDate();
		tn.noticeDateInsertionViaSendKeys(ExcelReadUtility.getIntData(1, 0, "Termination"));
		tn.pressEnterKey();
		tn.clickOnTerminationDate();
		tn.terminationDateInsertionViaSendKeys(ExcelReadUtility.getIntData(1, 0, "Termination"));
		tn.pressEnterKey();
		tn.clickOnSave();
		tn.clickOnAllTermination();
		String employeeName=tn.getTextOfFirstEmployeeName();
		Assert.assertEquals(employeeName,ExcelReadUtility.getStringData(2, 0, "Termination") );

	}

	@Test(priority=2)
	public void verifyToDeleteTermination() throws IOException {

		lp = new LoginPageClass(driver);
		dp=lp.sign_in(ExcelReadUtility.getStringData(2, 0, "LoginPage"),ExcelReadUtility.getIntData(2, 1, "LoginPage"));
		
		dp.clickOnTermination();
		
		tn=new TerminationPageClass(driver);
		tn.clickOnSearchAllColumns();
		tn.searchViaSendKeys(ExcelReadUtility.getStringData(0, 0, "Termination"));
		String name=tn.getTextOfName();
		Assert.assertEquals(name, ExcelReadUtility.getStringData(2, 0, "Termination"));
		tn.clickOnDelete();
		tn.deleteAlertAcceptance();
		tn.clickOnSearchAllColumns();
		tn.searchViaSendKeys(ExcelReadUtility.getStringData(0, 0, "Termination"));
		String newName=tn.getTextOfName();
		Assert.assertNotEquals(newName,ExcelReadUtility.getStringData(2, 0, "Termination") );

	}
}
