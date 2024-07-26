package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Helpers.GenericMethods;

public class MenuBar extends GenericMethods{
	WebDriver driver;
	
	public MenuBar(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}
	By menu_Start_Process = By.xpath("//button[contains(@title,'Start a Process')]//div[contains(@class,'appmagic-button middle center')]");
	
	public void clickOnStartAProcess()
	{
		ClickOnElement(menu_Start_Process);
	}

}
