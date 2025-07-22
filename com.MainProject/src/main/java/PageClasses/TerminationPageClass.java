package PageClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;
import Utilities.WaitUtilities;

public class TerminationPageClass {

	WebDriver driver;
	GeneralUtilities glu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();

	public TerminationPageClass(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='https://erp.qabible.in/admin/termination/new_termination']")
	WebElement newTermination;
	@FindBy(xpath = "//input[@name='notice_date']")
	WebElement noticeDate;
	@FindBy(xpath = "//input[@name='termination_date']")
	WebElement terminationDate;
	@FindBy(id = "file-save-button")
	WebElement save;
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement searchAllColumns;
	@FindBy(xpath="//i[@class='btn btn-xs btn-danger fa fa-trash-o']")
	WebElement delete;
	@FindBy(xpath="(//span[@class='select2-selection select2-selection--single'])[1]")
	WebElement employeeName;
	@FindBy(xpath="//a[@href='https://erp.qabible.in/admin/termination/']")
	WebElement allTermination;
	@FindBy(xpath="//table[@id='DataTables']/tbody/tr[1]/td")
	WebElement firstEmployeeName;

	public TerminationPageClass clickOnNewTermination() {

		newTermination.click();
		return this;
	}
	
	public TerminationPageClass clickOnEmployeeName() {

		employeeName.click();
		return this;
	}
	public TerminationPageClass employeeNameInsertionViaSendKeys(String name) {

		employeeName.sendKeys(name);
		return this;

	}
	public TerminationPageClass clickOnNoticeDate() {

		wu.waitForElementToBeClickableByXpathLocator(driver, "//input[@name='notice_date']", 10);
		noticeDate.click();
		return this;
	}

	public TerminationPageClass noticeDateInsertionViaSendKeys(String date) {

		noticeDate.sendKeys(date);
		return this;

	}

	public TerminationPageClass pressEnterKey() {

		glu.pressENTERKeyUsingKeyDown(driver);
		return this;
	}

	public TerminationPageClass clickOnTerminationDate() {

		terminationDate.click();
		return this;

	}

	public TerminationPageClass terminationDateInsertionViaSendKeys(String date) {

		terminationDate.sendKeys(date);
		return this;
	}

	public TerminationPageClass clickOnSave() {
		save.click();
		return this;
	}
	
	public TerminationPageClass clickOnSearchAllColumns() {

		searchAllColumns.click();
		return this;
	}
	
	public TerminationPageClass searchViaSendKeys(String name) {

		searchAllColumns.sendKeys(name);
		return this;

	}
	
	public String getTextOfName() {
		
		return glu.getTextOfElements(firstEmployeeName);
	}
	
	public TerminationPageClass clickOnDelete() {
		
		delete.click();
		return this;
	}
	
	public TerminationPageClass deleteAlertAcceptance() {
		
		glu.alertAccept(driver);
		return this;
	}

	public TerminationPageClass updateEmployeeNameViaSendkeys(String name) {
		
		employeeName.sendKeys(name);
		return this;
	}
	
	public TerminationPageClass clickOnAllTermination() {
		
		allTermination.click();
		return this;
		
	}

public String getTextOfFirstEmployeeName() {
		
		return glu.getTextOfElements(firstEmployeeName);
	}

public String getTextOfEmployeeName() {
	
	return glu.getTextOfElements(employeeName);
}
}
