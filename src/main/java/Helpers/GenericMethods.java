package Helpers;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;





public class GenericMethods{
	
	WebDriver driver;
	WebDriverWait wait;
	public GenericMethods(WebDriver driver)
	{
		this.driver = driver;
	}
	public void WaitUntilElementAppear(By locator)
	{
		wait
		 = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		System.out.println("Element defined by locator: " + locator.toString() + " exists.");
	}
	
	public void ClickOnElement(By locator)
	{
		wait
		 = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		  driver.findElement(locator).click();
	}
	
	public void typeInput(By locator,String value)
	{
		wait
		 = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		driver.findElement(locator).sendKeys(value);
	}
	
	public String getText(By locator)
	{
		wait
		 = new WebDriverWait(driver,Duration.ofSeconds(20));
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator).getText();
	}
	
	public void switchToFrame(By locator)
	{
		wait
		 = new WebDriverWait(driver,Duration.ofSeconds(20));
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement element = driver.findElement(locator);
		driver.switchTo().frame(element);
		
	}

}
