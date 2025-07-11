package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;
import utilities.WaitUtility;

public class DashBoardPageClass {

	GeneralUtilities glu = new GeneralUtilities();
	WebDriver driver;
	WaitUtility wu = new WaitUtility();

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

	public void clickOnSidebarMenu() {

		wu.waitForElementToBeClickableByXpathLocator(driver, "//a[@title='Dashboard']", 3);
		sidebarDashboard.click();

	}

	public void clickOnDashboardMenu() {

		invoiceToday.click();

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

	public void clickOnTermination() {

		terminatn.click();

	}

	public void mouseHoverOnTermination() {

		glu.mouseHoverElement_Utility(driver, terminatn);
	}

	public String getTextOfTermination() {

		return glu.getTextOfElements(terminatn);
	}
	
	public void clickOnTasks() {
		
		tasks.click();
	}

}
