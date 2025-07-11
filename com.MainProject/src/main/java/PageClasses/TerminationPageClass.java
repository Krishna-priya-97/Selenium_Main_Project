package PageClasses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;
import utilities.WaitUtility;

public class TerminationPageClass {

	WebDriver driver;
	GeneralUtilities glu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();

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

	public void clickOnNewTermination() {

		newTermination.click();
	}
	
	public void clickOnEmployeeName() {

		employeeName.click();
	}
	public void employeeNameInsertionViaSendKeys(String name) {

		employeeName.sendKeys(name);

	}
	public void clickOnNoticeDate() {

		wu.waitForElementToBeClickableByXpathLocator(driver, "//input[@name='notice_date']", 10);
		noticeDate.click();
	}

	public void noticeDateInsertionViaSendKeys(String date) {

		noticeDate.sendKeys(date);

	}

	public void pressEnterKey() {

		glu.pressENTERKeyUsingKeyDown(driver);
	}

	public void clickOnTerminationDate() {

		terminationDate.click();

	}

	public void terminationDateInsertionViaSendKeys(String date) {

		terminationDate.sendKeys(date);
	}

	public void clickOnSave() {
		save.click();
	}
	
	public void clickOnSearchAllColumns() {

		searchAllColumns.click();
	}
	
	public void searchViaSendKeys(String name) {

		searchAllColumns.sendKeys(name);

	}
	
	public String getTextOfName() {
		
		return glu.getTextOfElements(firstEmployeeName);
	}
	
	public void clickOnDelete() {
		
		delete.click();
	}
	
	public void deleteAlertAcceptance() {
		
		glu.alertAccept(driver);
	}

	public void updateEmployeeNameViaSendkeys(String name) {
		
		employeeName.sendKeys(name);
	}
	
	public void clickOnAllTermination() {
		
		allTermination.click();
		
	}

public String getTextOfFirstEmployeeName() {
		
		return glu.getTextOfElements(firstEmployeeName);
	}

public String getTextOfEmployeeName() {
	
	return glu.getTextOfElements(employeeName);
}
}
