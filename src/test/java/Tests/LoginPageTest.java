package Tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import Utility.TestBase;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	
	@Test
	public void loginTest()
	{
		test = reports.createTest("Verify Login functionality");
		loginPage = new LoginPage(driver);
		loginPage.enterEmail(email);
		loginPage.clickonNextbtn();
		loginPage.enterPassword(password);
		loginPage.clickonNextbtn();
		Assert.assertEquals(loginPage.homePageText(), "Home");
	}
	
	@Test
	public void failedTest()
	{
		test = reports.createTest("Verify Failed Test functionality");
		Assert.assertTrue(false);
	}
	
	@Test
	public void skippedTest()
	{
		test = reports.createTest("Verify Skipped Test functionality");
		throw new SkipException("Skipping the test Case with Exception..");
	}


}
