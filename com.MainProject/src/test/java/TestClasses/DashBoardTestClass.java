package TestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageClasses.DashBoardPageClass;
import PageClasses.LoginPageClass;
import Utilities.ExcelReadUtility;

public class DashBoardTestClass extends BaseClass {

	LoginPageClass lp;
	DashBoardPageClass dp;

	@Test(priority=3)
	public void verifyPageTitle() throws IOException {

		lp = new LoginPageClass(driver);
		dp=lp.sign_in(ExcelReadUtility.getStringData(2, 0, "LoginPage"),ExcelReadUtility.getIntData(2, 1, "LoginPage"));

		String title = dp.getPageTitle();
		Assert.assertEquals(title,ExcelReadUtility.getStringData(1, 0, "Dashboard"));
	}

	@Test(priority=4)
	public void verifyDashboardURL() throws IOException {

		lp = new LoginPageClass(driver);
		dp=lp.sign_in(ExcelReadUtility.getStringData(2, 0, "LoginPage"),ExcelReadUtility.getIntData(2, 1, "LoginPage"));

		String url = dp.getCurrentURL();
		Assert.assertEquals(url, "https://erp.qabible.in/admin/dashboard");
	}

	@Test(priority=5)
	public void verifyLogo() throws IOException {

		lp = new LoginPageClass(driver);
		dp=lp.sign_in(ExcelReadUtility.getStringData(2, 0, "LoginPage"),ExcelReadUtility.getIntData(2, 1, "LoginPage"));
		
		boolean logoDisplay=dp.isDisplayed();
		Assert.assertTrue(logoDisplay);
		
		
	}

	@Test(priority=6)
	public void verifySidebarMenuExpandsOnClick() throws IOException {

		lp = new LoginPageClass(driver);
		dp=lp.sign_in(ExcelReadUtility.getStringData(2, 0, "LoginPage"),ExcelReadUtility.getIntData(2, 1, "LoginPage"));
		
		dp.clickOnSidebarMenu();
		String sidebarMenu=dp.getTextOfDashBoard();
		Assert.assertEquals(sidebarMenu,ExcelReadUtility.getStringData(0, 0, "Dashboard"));
		
	}

	@Test(priority=7)
	public void verifyDashboardMenuExpandsOnClick() throws IOException {

		lp = new LoginPageClass(driver);
		dp=lp.sign_in(ExcelReadUtility.getStringData(2, 0, "LoginPage"),ExcelReadUtility.getIntData(2, 1, "LoginPage"));
		
		dp.clickOnDashboardMenu();
		String invoiceToday=dp.getTextOfInvoiceToday();
		Assert.assertEquals(invoiceToday,ExcelReadUtility.getStringData(2, 0, "Dashboard"));
	}
	
	@Test(priority=8)
	public void verifyTheTooltipTerminationIsShowingWhileHoveringMouseOnElement() throws IOException {
		
		lp = new LoginPageClass(driver);
		dp=lp.sign_in(   ExcelReadUtility.getStringData(2, 0, "LoginPage"),ExcelReadUtility.getIntData(2, 1, "LoginPage"));
		
		dp.mouseHoverOnTermination();
		String termination=dp.getTextOfTermination();
		Assert.assertEquals(termination,ExcelReadUtility.getStringData(3, 0, "Dashboard"));
		
		
	}

}
