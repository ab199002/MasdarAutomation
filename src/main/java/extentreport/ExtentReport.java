package extentreport;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Utility.GenerateScreenshot;
import Utility.TestBase;

public class ExtentReport 
{
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports reports;
	public static ExtentTest test;
	@BeforeTest
	@Parameters(value = "os")
	public void startReport(String os)
	{
		htmlReporter = new ExtentSparkReporter("ExtentReport//ExtentReport-TheHub.html");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);

		//add environments details 
		reports.setSystemInfo("Browser", os);
		reports.setSystemInfo("Envirnment", "Development");
		reports.setSystemInfo("Machine", "Lenovo-Laptop");
		reports.setSystemInfo("Operating System", "Windows");

		//configuration to change look and feel 
		htmlReporter.config().setDocumentTitle("ExtentReport-TheHub");
		htmlReporter.config().setReportName("TheHub Automation Report");
		htmlReporter.config().setTheme(Theme.STANDARD);

	}

	@AfterMethod
	public void getResult(ITestResult result) throws IOException
	{
		if(result.getStatus()== ITestResult.FAILURE)
		{
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
			test.fail(result.getThrowable());
			String screenShotPath = GenerateScreenshot.capture(TestBase.driver, dateName);
			test.log(Status.FAIL, "Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
		}
		else if(result.getStatus()== ITestResult.SUCCESS)
		{
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
		}
		else if(result.getStatus()== ITestResult.SKIP)
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.YELLOW));
		}

	}

	@AfterTest
	public void flushReport()
	{
		reports.flush();
	}
	


}
