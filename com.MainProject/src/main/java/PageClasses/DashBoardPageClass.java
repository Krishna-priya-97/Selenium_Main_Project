package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;
import Utilities.WaitUtilities;


public class DashBoardPageClass {

	GeneralUtilities glu = new GeneralUtilities();
	WebDriver driver;
	WaitUtilities wu = new WaitUtilities();

	public DashBoardPageClass(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://erp.qabible.in/admin/dashboard'and@class='text-muted']")
	WebElement dashboard;
	@FindBy(xpath = "//a[@href='https://erp.qabible.in/admin/termination'and@title='Termination']")
	WebElement termination;
	@FindBy(xpath = "(//img[@src='https://erp.qabible.in/uploads/SurviCamLogoHighResTransparent.png'])[1]")
	WebElement logo;
	@FindBy(xpath = "//a[@title='Dashboard']")
	WebElement sidebarDashboard;
	@FindBy(xpath = "//a[@href='https://erp.qabible.in/admin/invoice/manage_invoice'and@class='mt0 mb0']")
	WebElement invoiceToday;
	@FindBy(xpath = "//a[@href='https://erp.qabible.in/admin/invoice/manage_invoice'and@class='text-muted']")
	WebElement invoice;
	@FindBy(xpath = "//a[@title='Termination']")
	WebElement terminatn;
	@FindBy(xpath = "//a[@title='File Manager']")
	WebElement fileManager;
	@FindBy(xpath="//a[@title='Tasks']")
	WebElement tasks;

	public DashBoardPageClass clickOnSidebarMenu() {

		wu.waitForElementToBeClickableByXpathLocator(driver, "//a[@title='Dashboard']", 10);
		sidebarDashboard.click();
		return this;

	}

	public DashBoardPageClass clickOnDashboardMenu() {

		invoiceToday.click();
		return this;

	}

	public String getTextOfDashBoard() {

		return glu.getTextOfElements(dashboard);
	}

	public String getPageTitle() {

		return glu.getPageTitle(driver);
	}

	public String getCurrentURL() {

		return glu.getCurrentUrl(driver);
	}

	public boolean isDisplayed() {

		return glu.isElementDisplayed(logo);
	}

	public String getTextOfInvoiceToday() {

		return glu.getTextOfElements(invoice);
	}

	public  TerminationPageClass clickOnTermination() {

		terminatn.click();
		return new TerminationPageClass(driver);

	}

	public DashBoardPageClass mouseHoverOnTermination() {

		glu.mouseHoverElement_Utility(driver, terminatn);
		return this;
	}

	public String getAttributeOfTermination(){
		
		return glu.getAttributeOfElement(termination,"title");
	}
	
	public TaskPageClass clickOnTasks() {
		
		tasks.click();
		return new TaskPageClass(driver);
	}

}
