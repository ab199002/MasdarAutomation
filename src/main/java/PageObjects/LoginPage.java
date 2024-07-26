package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Helpers.GenericMethods;

public class LoginPage extends GenericMethods{
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	By loginEmail = By.name("loginfmt");
	By loginPassword = By.name("passwd");
	By submitBtn = By.id("idSIButton9");
	By frame = By.xpath("//iframe[@class='player-app-frame']");
	By homeText = By.xpath("//div[@class='ms-TooltipHost root-182']");
	
	public void enterEmail(String email)
	{
		typeInput(loginEmail,email);
	}
	public void clickonNextbtn()
	{
		ClickOnElement(submitBtn);
	}
	public void enterPassword(String password)
	{
		typeInput(loginPassword,password);
	}
	
	public String homePageText()
	{
		switchToFrame(frame);
		System.out.println("I am in iframe ");
		return getText(homeText);
	}

}
