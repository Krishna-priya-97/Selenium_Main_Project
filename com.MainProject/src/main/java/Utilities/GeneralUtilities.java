package Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	
	public String getTextOfElements(WebElement element) {
		return element.getText();

	}

	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public String getAttributeOfElement(WebElement element, String attribute) {
		return element.getAttribute(attribute);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	
	// ***********************************JavaScript*******************************************//
	
	//for clicking
		public void clickUsingJavaScriptExecutor(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}

		//for scrolling -method1
		public void scrollUsingJavaScriptExecutor(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);

		}
		
		//for scrolling -method 2
		public void scrollUsingJavaScriptExecutor_ScrollBy(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)" );

		}
		
		//mouse hovering
		public void mouseHoverElement_Utility(WebDriver driver, WebElement element) {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).perform();
		}
		
		public void pressENTERKeyUsingKeyDown(WebDriver driver) {
			Actions act =new Actions(driver);
			act.keyDown(Keys.ENTER).perform();
		}
		
		//mouse hovering and click
		public void mouseHoverAndClick(WebDriver driver, WebElement element) {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();
			
		}
		
		//file upload
		public void fileUpload(WebElement element, String filepath) {
			element.sendKeys(filepath);
		}
		
		//is multi select drop down
		public boolean isMultipleSelectDropdown(WebElement element) {
			Select select = new Select(element);
			return select.isMultiple();
		}
		
		public void selectDropdownValueByIndex(WebElement element, int index) {
			Select select = new Select(element);
			select.selectByIndex(index);
		}
		
		public List<String> getAllDropDownOptions(WebElement element) {
			Select select = new Select(element);
			return select.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
			
		}
		
		public List<String> getAllSelectedOptionsFromDropDown(WebElement element) {
			Select select = new Select(element);
			return select.getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList());
			
		}
		
		//alert accept
		public void alertAccept(WebDriver driver) {
			driver.switchTo().alert().accept();
			
		}
		
		//getting text from alert
		public String getTextOfAlertMessage(WebDriver driver) {
			return driver.switchTo().alert().getText();
			
		}
		
		//getoptions
		public List<String> getOptions(WebElement element){
			Select select = new Select(element);
			List<WebElement> allOptions=select.getOptions();
			List<String> optionText=new ArrayList<String>();
			for ( WebElement webelement : allOptions) {
				optionText.add(webelement.getText());
				
			}
			return optionText;
		}
		
		//switch to frame by name or id
		public void switchToFrameByNameOrID(WebDriver driver, String NameOrID) {
			driver.switchTo().frame(NameOrID);
		}
		
		//for thread.sleep
		public void addSleep(long timeOut) throws InterruptedException {
			Thread.sleep(timeOut);
		}

}
