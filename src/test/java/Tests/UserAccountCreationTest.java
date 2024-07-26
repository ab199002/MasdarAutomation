package Tests;

import java.awt.AWTException;

import org.testng.annotations.Test;

import PageObjects.DailyServicesPag;
import PageObjects.MenuBar;
import Utility.TestBase;

public class UserAccountCreationTest extends TestBase{
	
	LoginPageTest loginPageTest;
	MenuBar menuBar;
	DailyServicesPag dailyServicesPag;
	
	@Test
	public void userAccountCreationTest() throws AWTException, InterruptedException
	{
		test = reports.createTest("Verify User Account creation- Vendor functionality");
		loginPageTest = new LoginPageTest();
		menuBar = new MenuBar(driver);
		dailyServicesPag = new DailyServicesPag(driver);
		loginPageTest.loginTest();
		menuBar.clickOnStartAProcess();
		dailyServicesPag.clickOnDTS();
		dailyServicesPag.clickOnAccountManagement();
		dailyServicesPag.clickOnUserAccountCreation();
		dailyServicesPag.enterUserDetails(vFname, vLname, desg, vCn, justification);
		dailyServicesPag.uploadFiles();
	}
	
}
