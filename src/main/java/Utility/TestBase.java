package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.util.*;
import extentreport.ExtentReport;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase extends ExtentReport
{
	public static WebDriver driver;
	public static String URL, email,password;
	
	public void selectBrowser(String os) throws IOException
	{
		readConfig();
		if(os.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(os.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(os.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Shared Brwoser is not Supported");
		}
	}
	@BeforeSuite
	@Parameters(value = "os")
	public void tearUp(String os) throws IOException
	{
//		os = "chrome";
		selectBrowser(os);
		driver.get(URL);
		driver.manage().window().maximize();
	}
	

	
	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}
	
	public void readConfig() throws IOException
	{
		FileInputStream inputStream = new FileInputStream("C:\\Users\\Lenovo\\eclipse-workspace\\TheHub\\src\\main\\resources\\App.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		URL = properties.getProperty("URL");
		email = properties.getProperty("email");
		password = properties.getProperty("password");
	}
	
}
