package dataProvider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Utilities.ExcelReadUtility;

public class DataProviderClass {
	
	@DataProvider(name="unSuccessfulLogin")
	  public Object[][] dp() throws IOException {
	    return new Object[][] {
	      new Object[] { ExcelReadUtility.getStringData(2, 2, "LoginPage"), ExcelReadUtility.getIntData(2, 3, "LoginPage") },
	      new Object[] { ExcelReadUtility.getStringData(3, 2, "LoginPage"), ExcelReadUtility.getIntData(3, 3, "LoginPage") },
	      new Object[] { ExcelReadUtility.getStringData(4, 2, "LoginPage"), ExcelReadUtility.getIntData(4, 3, "LoginPage") },
	    };
	  }

}
