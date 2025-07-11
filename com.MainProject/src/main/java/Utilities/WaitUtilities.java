package Utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilities {
	
	WebDriverWait wait;

	public void waitForElementToBeClickableByXpathLocator(WebDriver driver, String locatorValue, int timeOut) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
	}

	public void waitForElementToBeClickableByidLocator(WebDriver driver, String locatorValue, int timeOut) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
	}

	public void waitForElementToBeClickableByWebElement(WebDriver driver, WebElement element, int timeOut) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForAlertPresent(WebDriver driver, int timeOut) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.alertIsPresent());
	}
public void waitForElementInvisibilityOf(WebDriver driver,WebElement element,int timeOut) {
	
	wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
	wait.until(ExpectedConditions.invisibilityOf(element)); 
	}

	/*terminationDate.clear();
	terminationDate.sendKeys("2025-06-12");*/

	public void waitForElementVisibilityOf(WebDriver driver,WebElement element, int timeOut) {
	
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void fluentWaitForElementtoBeClickableByIdLocator_Utility(WebDriver driver, String locatorValue,
			int totalTimeOut, int pollingTimeOut) {

		FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(totalTimeOut))
				.pollingEvery(Duration.ofSeconds(pollingTimeOut)).ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
	}

}
