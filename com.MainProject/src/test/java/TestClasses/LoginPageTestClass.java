package TestClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageClasses.DashBoardPageClass;
import PageClasses.LoginPageClass;
import Utilities.ExcelReadUtility;
import dataProvider.DataProviderClass;

public class LoginPageTestClass extends BaseClass {

	LoginPageClass lp;
	DashBoardPageClass dp;

	@Test(priority=1)
	public void verifySuccessfulLogin() throws IOException {

		lp = new LoginPageClass(driver);
		dp=lp.sign_in(ExcelReadUtility.getStringData(2, 0, "LoginPage"),ExcelReadUtility.getIntData(2, 1, "LoginPage"));

		String dashBoard = dp.getTextOfDashBoard();
		Assert.assertEquals(dashBoard,ExcelReadUtility.getStringData(0, 0, "Dashboard"));

	}

	@Test(dataProvider = "unSuccessfulLogin",dataProviderClass=DataProviderClass.class,priority=2)
	public void verifyUnsuccessfulLogin(String u,String p) throws IOException {

		lp = new LoginPageClass(driver);
		lp.sign_in(u,p);

		lp = new LoginPageClass(driver);
		String error = lp.getTextOfError();
		Assert.assertTrue(error.contains(ExcelReadUtility.getStringData(7, 0, "LoginPage")));
	}
}
