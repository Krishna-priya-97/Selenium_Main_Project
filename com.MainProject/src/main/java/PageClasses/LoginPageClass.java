package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.GeneralUtilities;
import utilities.WaitUtility;

public class LoginPageClass {

	WebDriver driver;
	WaitUtility wu = new WaitUtility();
	GeneralUtilities glu = new GeneralUtilities();

	public LoginPageClass(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='user_name']")
	WebElement username;
	@FindBy(xpath = "//input[@type='password']")
	WebElement password;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signIn;
	@FindBy(xpath = "//div[@class='alert alert-danger']")
	WebElement errorMessage;

	public DashBoardPageClass sign_in(String uname, String pword) {

		username.sendKeys(uname);
		password.sendKeys(pword);
		wu.waitForElementToBeClickableByXpathLocator(driver, "//button[@type='submit']", 3);
		signIn.click();
		
		return new DashBoardPageClass(driver);
	}

	public String getTextOfError() {

		return glu.getTextOfElements(errorMessage);
	}
}
