package PageObjects;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import Helpers.GenericMethods;

public class DailyServicesPag extends GenericMethods{
	WebDriver driver;
	Helpers.JavaScriptUtil jsUtil;
	
	public DailyServicesPag(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		jsUtil = new Helpers.JavaScriptUtil(driver);
	}
	
	By DTS= By.xpath("//body/div[@id='publishedCanvasContainer']/div[@id='responsiveScalingCanvasHost']/div[@id='publishedCanvas']/div[contains(@class,'app-canvas')]/div[contains(@class,'screen-animation animated')]/div[contains(@class,'canvasContentDiv container_gfluoe activeScreen')]/div[contains(@class,'container_1f0sgyp-o_O-containerFullSize_5t8a34')]/div[contains(@class,'appmagic-content-control-name appmagic-control-view canvasContentDiv')]/div[contains(@class,'appmagic-borderfill-container')]/div[contains(@class,'appmagic-border-inner')]/div[contains(@data-container-name,'ScreenContainerPR-container')]/div[contains(@class,'horizontal')]/div[contains(@class,'appmagic-content-control-name appmagic-control-view canvasContentDiv appmagic-auto-layout')]/div[contains(@class,'itemMeasurer_1mfsr54')]/div[contains(@class,'appmagic-borderfill-container')]/div[contains(@class,'appmagic-border-inner')]/div[contains(@data-container-name,'RightSideContainerPR-container')]/div[contains(@class,'vertical')]/div[contains(@class,'appmagic-content-control-name appmagic-control-view canvasContentDiv appmagic-auto-layout')]/div[contains(@class,'itemMeasurer_1mfsr54')]/div[contains(@class,'appmagic-borderfill-container')]/div[contains(@class,'appmagic-border-inner')]/div[contains(@data-container-name,'MainSectionContainerPR-container')]/div[contains(@class,'horizontal')]/div[contains(@class,'appmagic-content-control-name appmagic-control-view canvasContentDiv appmagic-auto-layout')]/div[contains(@class,'itemMeasurer_1mfsr54')]/div[contains(@class,'appmagic-borderfill-container')]/div[contains(@class,'appmagic-border-inner')]/div[contains(@class,'container_w3lqqm accessibility-container')]/div[contains(@class,'appmagic-fluidGrid')]/div[contains(@class,'scrollContainer_1iqg5j7-o_O-scrollbar_1te65uz')]/div[contains(@class,'scrollContent_1xligvk')]/div[contains(@class,'scrollContent_1xligvk')]/div[contains(@class,'appmagic-content-control-name appmagic-control-view canvasContentDiv')]/div[contains(@class,'appmagic-borderfill-container')]/div[contains(@class,'appmagic-border-inner appmagic-auto-height')]/div[contains(@class,'appmagic-card card_c5uw0h')]/div[contains(@class,'appmagic-content-control-name appmagic-control-view canvasContentDiv')]/div[contains(@class,'appmagic-borderfill-container')]/div[contains(@class,'appmagic-border-inner')]/div[contains(@class,'container_w3lqqm accessibility-container')]/div[contains(@class,'vertical')]/div[contains(@aria-label,'Gallery')]/div/div[contains(@class,'react-gallery-items-window')]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/button[1]/div[1]");
	By accountManagement = By.xpath("//body/div[@id='publishedCanvasContainer']/div[@id='responsiveScalingCanvasHost']/div[@id='publishedCanvas']/div[contains(@class,'app-canvas')]/div[contains(@class,'screen-animation animated')]/div[contains(@class,'canvasContentDiv container_gfluoe activeScreen')]/div[contains(@class,'container_1f0sgyp-o_O-containerFullSize_5t8a34')]/div[contains(@class,'appmagic-content-control-name appmagic-control-view canvasContentDiv')]/div[contains(@class,'appmagic-borderfill-container')]/div[contains(@class,'appmagic-border-inner')]/div[contains(@data-container-name,'ScreenContainerPGS-container')]/div[contains(@class,'horizontal')]/div[contains(@class,'appmagic-content-control-name appmagic-control-view canvasContentDiv appmagic-auto-layout')]/div[contains(@class,'itemMeasurer_1mfsr54')]/div[contains(@class,'appmagic-borderfill-container')]/div[contains(@class,'appmagic-border-inner')]/div[contains(@data-container-name,'RightSideContainerPGS-container')]/div[contains(@class,'vertical')]/div[contains(@class,'appmagic-content-control-name appmagic-control-view canvasContentDiv appmagic-auto-layout')]/div[contains(@class,'itemMeasurer_1mfsr54')]/div[contains(@class,'appmagic-borderfill-container')]/div[contains(@class,'appmagic-border-inner')]/div[contains(@data-container-name,'MainSectionContainerPGS-container')]/div[contains(@class,'horizontal')]/div[contains(@class,'appmagic-content-control-name appmagic-control-view canvasContentDiv appmagic-auto-layout')]/div[contains(@class,'itemMeasurer_1mfsr54')]/div[contains(@class,'appmagic-borderfill-container')]/div[contains(@class,'appmagic-border-inner')]/div[contains(@class,'container_w3lqqm accessibility-container')]/div[contains(@class,'appmagic-fluidGrid')]/div[contains(@class,'scrollContainer_1iqg5j7-o_O-scrollbar_1te65uz')]/div[contains(@class,'scrollContent_1xligvk')]/div[contains(@class,'scrollContent_1xligvk')]/div[contains(@class,'appmagic-content-control-name appmagic-control-view canvasContentDiv')]/div[contains(@class,'appmagic-borderfill-container')]/div[contains(@class,'appmagic-border-inner appmagic-auto-height')]/div[contains(@class,'appmagic-card card_c5uw0h')]/div[contains(@class,'appmagic-content-control-name appmagic-control-view canvasContentDiv')]/div[contains(@class,'appmagic-borderfill-container')]/div[contains(@class,'appmagic-border-inner')]/div[contains(@class,'container_w3lqqm accessibility-container')]/div[contains(@class,'vertical')]/div[contains(@aria-label,'Gallery')]/div/div[contains(@class,'react-gallery-items-window')]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/button[1]/div[1]");
	By userAccountCreation = By.xpath("//body/div[@id='publishedCanvasContainer']/div[@id='responsiveScalingCanvasHost']/div[@id='publishedCanvas']/div[contains(@class,'app-canvas')]/div[contains(@class,'screen-animation animated')]/div[contains(@class,'canvasContentDiv container_gfluoe activeScreen')]/div[contains(@class,'container_1f0sgyp-o_O-containerFullSize_5t8a34')]/div[contains(@class,'appmagic-content-control-name appmagic-control-view canvasContentDiv')]/div[contains(@class,'appmagic-borderfill-container')]/div[contains(@class,'appmagic-border-inner')]/div[contains(@data-container-name,'ScreenContainerPS-container')]/div[contains(@class,'horizontal')]/div[contains(@class,'appmagic-content-control-name appmagic-control-view canvasContentDiv appmagic-auto-layout')]/div[contains(@class,'itemMeasurer_1mfsr54')]/div[contains(@class,'appmagic-borderfill-container')]/div[contains(@class,'appmagic-border-inner')]/div[contains(@data-container-name,'RightSideContainerPS-container')]/div[contains(@class,'vertical')]/div[contains(@class,'appmagic-content-control-name appmagic-control-view canvasContentDiv appmagic-auto-layout')]/div[contains(@class,'itemMeasurer_1mfsr54')]/div[contains(@class,'appmagic-borderfill-container')]/div[contains(@class,'appmagic-border-inner')]/div[contains(@data-container-name,'MainSectionContainerPS-container')]/div[contains(@class,'horizontal')]/div[contains(@class,'appmagic-content-control-name appmagic-control-view canvasContentDiv appmagic-auto-layout')]/div[contains(@class,'itemMeasurer_1mfsr54')]/div[contains(@class,'appmagic-borderfill-container')]/div[contains(@class,'appmagic-border-inner')]/div[contains(@class,'container_w3lqqm accessibility-container')]/div[contains(@class,'appmagic-fluidGrid')]/div[contains(@class,'scrollContainer_1iqg5j7-o_O-scrollbar_1te65uz')]/div[contains(@class,'scrollContent_1xligvk')]/div[contains(@class,'scrollContent_1xligvk')]/div[contains(@class,'appmagic-content-control-name appmagic-control-view canvasContentDiv')]/div[contains(@class,'appmagic-borderfill-container')]/div[contains(@class,'appmagic-border-inner appmagic-auto-height')]/div[contains(@class,'appmagic-card card_c5uw0h')]/div[contains(@class,'appmagic-content-control-name appmagic-control-view canvasContentDiv')]/div[contains(@class,'appmagic-borderfill-container')]/div[contains(@class,'appmagic-border-inner')]/div[contains(@class,'container_w3lqqm accessibility-container')]/div[contains(@class,'vertical')]/div[contains(@aria-label,'Gallery')]/div/div[contains(@class,'react-gallery-items-window')]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]/div[1]");
	By vendorFname = By.xpath("//input[@appmagic-control='txtVendorFirstNameUACVtextbox']");
	By vendorLname = By.xpath("//input[@appmagic-control='txtVendorLastNameUACVtextbox']");
	By designation = By.xpath("//input[@appmagic-control='txtDesignationUACVtextbox']");
	By vendorCn = By.xpath("//input[@placeholder='Enter number here...']");
	By businessJustification = By.xpath("//textarea[@placeholder='Enter text here...']");
	By upload1 = By.xpath("//div[@class='AttachmentLeft_e388204b']//div[1]//div[2]//div[1]//input[1]");
	By upload2 = By.xpath("//div[@class='fui-FluentProvider fui-FluentProvider7 ___13yoiqc f19n0e5 f3e3pzq f1o700av fk6fouc fkhj508 figsok6 f1g96gwp']//div[2]//div[2]//div[1]//input[1]");
	By upload3 = By.xpath("//div[@class='AttachmentContentWrap__e388204b']//div[3]//div[2]//div[1]//input[1]");
	By upload4 = By.xpath("//div[@class='canvasContentWrap__e388204b canvasContentWrap_feae6028']//div[4]//div[2]//div[1]//input[1]");
	By uploadBtn = By.id("uploadPanelPopup");
	By uploadDrivecnf = By.xpath("//span[text()='Close Tab']");
	By uploadRefreshCnf = By.xpath("//body/div[@id='publishedCanvasContainer']/div[@id='responsiveScalingCanvasHost']/div[@id='publishedCanvas']/div[contains(@class,'app-canvas')]/div[contains(@class,'screen-animation animated')]/div[contains(@class,'canvasContentDiv container_gfluoe activeScreen')]/div[contains(@class,'container_1f0sgyp-o_O-containerFullSize_5t8a34')]/div[contains(@class,'appmagic-content-control-name appmagic-control-view canvasContentDiv')]/div[contains(@class,'appmagic-borderfill-container')]/div[contains(@class,'appmagic-border-inner')]/div[contains(@class,'canvasContentDiv container_msw6rx activeComponent')]/div[contains(@class,'container_1f0sgyp-o_O-containerFullSize_5t8a34')]/div[contains(@class,'appmagic-content-control-name appmagic-control-view canvasContentDiv')]/div[contains(@class,'appmagic-borderfill-container')]/div[contains(@class,'appmagic-border-inner')]/div[contains(@class,'appmagic-group groupStyle_11q1rc8')]/div[4]/div[1]/div[1]/div[1]/div[1]/button[1]/div[1]");
	By submitBtn= By.xpath("//div[contains(text(),'Submit')]");
	By frame = By.xpath("//iframe[@class='player-app-frame']");
	By uploadLink = By.xpath("//u[contains(text(),'To upload large files (size > 50 MB),')]");
	By refreshBtn = By.xpath("//div[@class='appmagic-button-label no-focus-outline'][normalize-space()='Refresh']");
	
	public void clickOnDTS()
	{
		ClickOnElement(DTS);
	}
	public void clickOnAccountManagement()
	{
		ClickOnElement(accountManagement);
	}
	public void clickOnUserAccountCreation()
	{
		ClickOnElement(userAccountCreation);
	}
	
	public void enterUserDetails(String vFname,String vLname,String desg, String vCn,String justification) throws InterruptedException
	{
		switchToFrame(frame);
		clickWhenReady(vendorFname,20);
		Thread.sleep(20000);
		typeInput(vendorFname,vFname);
		typeInput(vendorLname,vLname);
		typeInput(designation,desg);
		typeInput(vendorCn,vCn);
		typeInput(businessJustification,justification);
	}
	
	public void uploadFiles() throws AWTException, InterruptedException
	{
		switchToFrame(frame);
		waitForElementClickable(businessJustification,20);
		jsUtil.scrollIntoView(businessJustification);
		Thread.sleep(10000);
		doClick(uploadLink);
		Thread.sleep(20000);
		windowHandles();
		fileUploadBySendKeys(upload1);
		fileUploadBySendKeys(upload2);
		fileUploadBySendKeys(upload3);
		fileUploadBySendKeys(upload4);
		doClick(uploadBtn);
		Thread.sleep(5000);
		doClick(uploadDrivecnf);
		Thread.sleep(20000);
		swithToLastActiveWindow();
		switchToFrame(frame);
		doClick(refreshBtn);
		Thread.sleep(10000);
		doClick(submitBtn);
		Thread.sleep(10000);
	}
	public void clickOnSubmitBtn()
	{
		ClickOnElement(submitBtn);
	}
}
