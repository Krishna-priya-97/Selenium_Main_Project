package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;
import Utilities.WaitUtilities;

public class TaskPageClass {

	WebDriver driver;
	GeneralUtilities glu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();

	public TaskPageClass(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://erp.qabible.in/admin/tasks/import']")
	WebElement importTasks;
	@FindBy(xpath = "//input[@name='upload_file']")
	WebElement chooseFile;
	@FindBy(xpath = "//button[text()=' Upload']")
	WebElement upload;
	@FindBy(xpath = "//span[@class='fileinput-filename']")
	WebElement fileName;
	@FindBy(xpath = "//a[@href='https://erp.qabible.in/admin/tasks/create']")
	WebElement newTask;
	@FindBy(xpath = "//input[@name='task_name']")
	WebElement taskName;
	@FindBy(xpath = "//input[@name='due_date']")
	WebElement dueDate;
	@FindBy(xpath = "//button[@type='submit'and@class='btn btn-sm btn-primary']")
	WebElement save;
	@FindBy(xpath = "//table[@id='DataTables']/tbody/tr/td[2]")
	WebElement newTaskName;
	@FindBy(xpath="//a[contains(text(),'All Task')]")
	WebElement allTask;
	@FindBy(css="span.fileinput-new")
	WebElement selectFile;
	@FindBy(css="span.fileinput-exists")
	WebElement change;
	
	public String getTextOfSelectFile() {

		return glu.getTextOfElements(selectFile);
	}

	public TaskPageClass clickOnImportTasks() {

		importTasks.click();
		return this;
	}

	public TaskPageClass uploadFile() {
		
		glu.fileUpload(chooseFile,System.getProperty("user.dir")+"\\src\\test\\resources\\uploaddocument.doc");
		return this;

	}

	public String getTextOfFileName() {

		return glu.getTextOfElements(fileName);
	}

	public TaskPageClass clickOnUpload() {

		upload.click();
		return this;
	}

	public TaskPageClass clickOnNewTask() {

		newTask.click();
		return this;
	}

	public TaskPageClass clickOnTaskName() {

		taskName.click();
		return this;

	}

	public TaskPageClass updateTaskNameViaSendkeys(String taskname) {

		taskName.sendKeys(taskname);
		return this;
	}

	public TaskPageClass clickOnDueDate() {

		dueDate.click();
		return this;
	}

	public TaskPageClass dueDateInsertionViaSendKeys(String date) {

		dueDate.sendKeys(date);
		return this;

	}

	public TaskPageClass pressEnterKey() {

		glu.pressENTERKeyUsingKeyDown(driver);
		return this;
	}

	public TaskPageClass clickOnSave() {

		save.click();
		return this;
	}

	public String getTextOfNewTaskName() {

		return glu.getTextOfElements(newTaskName);
	}
	
	public TaskPageClass clickOnAllTask() {
		
		wu.waitForElementToBeClickableByXpathLocator(driver, "//a[contains(text(),'All Task')]", 10);
		allTask.click();
		return this;
	}

	public String getTextOfChange() {
		
		return glu.getTextOfElements(change);
	}

}
