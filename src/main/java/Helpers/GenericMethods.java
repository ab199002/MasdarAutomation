package Helpers;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;







public class GenericMethods{
	
	WebDriver driver;
	WebDriverWait wait;
	File file,tfile ;
	File rename;
	String currentHandle;
	public GenericMethods(WebDriver driver)
	{
		this.driver = driver;
		currentHandle = driver.getWindowHandle();
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
		 = new WebDriverWait(driver,Duration.ofSeconds(20));
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
	
	public void switchWindow(String type)
	{
		if(type.equalsIgnoreCase("TAB"))
		driver.switchTo().newWindow(WindowType.TAB);
		else if(type.equalsIgnoreCase("Window"))
			driver.switchTo().newWindow(WindowType.WINDOW);
		else
			System.out.println("No Appropriate Method Found");
	}
	
	public void windowHandles()
	{
		Set<String> handles = driver.getWindowHandles();
		for(String str:handles)
		{
			if(!(str.equals(currentHandle)))
				driver.switchTo().window(str);
		}
		
	}
	
	public void swithToLastActiveWindow()
	{
		driver.switchTo().window(currentHandle);
	}
	
	@SuppressWarnings("deprecation")
	public void implictWait()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public By getBy(String locatorType, String locatorValue) {
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "classname":
			locator = By.className(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "css":
			locator = By.cssSelector(locatorValue);
			break;
		case "linktext":
			locator = By.linkText(locatorValue);
			break;
		case "partiallinktext":
			locator = By.partialLinkText(locatorValue);
			break;
		case "tagname":
			locator = By.tagName(locatorValue);
			break;

		default:
			break;
		}

		return locator;
	}
	
	public WebElement getElement(By locator) {
		WebElement ele = driver.findElement(locator);
	
		return ele;
	}

	public void doClick(By locator) {
		System.out.println("click on : " + locator);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getElement(locator).click();

	}

	public void doClick(String locatorType, String locatorValue) {
		getElement(getBy(locatorType, locatorValue)).click();
	}

	public void doSendKeys(By locator, String value) {
		WebElement ele = getElement(locator);
		ele.clear();
		ele.sendKeys(value);
	}

	public void doSendKeys(String locatorType, String locatorValue, String value) {
		getElement(getBy(locatorType, locatorValue)).sendKeys(value);
	}

	public String doGetText(By locator) {
		return getElement(locator).getText();
	}

	public String doGetAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public int getElementCount(By locator) {
		return getElements(locator).size();
	}

	public void printElementsText(By locator) {
		List<WebElement> eleList = getElements(locator);
		for (WebElement e : eleList) {
			String text = e.getText();
			System.out.println(text);
		}
	}
	public void clickElementsInList(By locator) {
		List<WebElement> eleList = getElements(locator);
		for (WebElement e : eleList) {
			doClick(locator);
		}
	}
	/**
	 * This method will return the list of element's text
	 * 
	 * @param locator
	 * @return
	 */
	public List<String> getElementsTextList(By locator) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleTextList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String text = e.getText();
			if (!text.isEmpty()) {
				eleTextList.add(text);
			}
		}
		return eleTextList;
	}

	
	/**
	 * This method will return the list of element's attribute value
	 * 
	 * @param locator
	 * @param attrName
	 * @return
	 */
	public List<String> getElementsAttributeList(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		List<String> eleAttrList = new ArrayList<String>();
		for (WebElement e : eleList) {
			String attrVal = e.getAttribute(attrName);
			eleAttrList.add(attrVal);
		}
		return eleAttrList;
	}


	public void clickOnLink(By locator, String linkText) {
		List<WebElement> langList = getElements(locator);
		System.out.println(langList.size());
		for (WebElement e : langList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(linkText)) {
				e.click();
				break;
			}
		}
	}

	/******************************* Drop Down Utils ***************************/

	public void doSelectDropDownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doSelectDropDownByVisibleText(By locator, String visibleText) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
		
	}

	public void doSelectDropDownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public int getDropDownOptionsCount(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions().size();
	}

	public void selectValueFromDropDown(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		for (WebElement e : optionsList) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

	public List<String> getDropDownOptionsList(By locator) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();
		List<String> optionsTextList = new ArrayList<String>();
		System.out.println(optionsList.size());

		for (WebElement e : optionsList) {
			String text = e.getText();
			optionsTextList.add(text);
		}
		return optionsTextList;
	}

	public void selectMultiElementsByFloor(By locator, String multiElementName) {
		
		List<WebElement> eleList = getElements(locator);
		boolean numeric = true;
		try {
			Integer num = Integer.parseInt(multiElementName);
		} catch (NumberFormatException e) {
			numeric = false;
		}
		if (numeric) {
			
			int FloorNumber = Integer.parseInt(multiElementName);
			
			for (int index=1;index<eleList.size();index++) {
				
				if(index == FloorNumber) {
					eleList.get(index).click();
				    break;
				}
			}
			 
		}
		else
			    doClick(locator);
	
	}
	
   public void selectMultiElementsByText(By locator, String multiElementName) {
		
		List<WebElement> eleList = getElements(locator);
		
		for(int index=0;index<eleList.size();index++) {
			System.out.println((doGetText(locator)));
		    if(eleList.get(index).getText().contains(multiElementName)) {
		    	eleList.get(index).click();
		    	  break;
		    }
		}
	}
   
   public void selctTimeFormatButton(By locator,String time) {
		
	   if(!doGetText(locator).equalsIgnoreCase(time))
		   doClick(locator);
		
	}
	/****************** DatePicker *******************************/
	public void datePicker(By locator1, By locator2, By locator3, String month) {
		while (true) {
			String text = doGetText(locator1);
			if (text.equals(month)) {
				doClick(locator3);
				break;
			}
			else
				doClick(locator2);
		}
	}

	/******************* Actions methods **********************/

	public void doActionsSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}

	/**
	 * Clicks in the middle of the given element. Equivalent to:
	 * Actions.moveToElement(onElement).click()
	 * 
	 * @param locator
	 */
	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).perform();
	}

	/************************* Wait Utils **************************/

	/**
	 * An expectation for checking an element is visible and enabled such that you
	 * can click it.
	 * 
	 * @param locator
	 * @param timeOut
	 */
	public void waitForElementClickable(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	public void clickWhenReady(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		System.out.println(getElement(locator).isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForElementPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * An expectation for checking that there is at least one element present on a
	 * web page.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public List<WebElement> waitForElementsPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public void StaleElement(By locator) {
		
		for(int index = 0; index<=3; index++) {
			try {
				getElement(locator);
				doClick(locator);
				break;
			}
			catch(StaleElementReferenceException exc){
				exc.printStackTrace();
			}
		}
	
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible. Visibility means that the element is not only displayed but also
	 * has a height and width that is greater than 0. default polling time = 500 ms
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page
	 * and visible. Visibility means that the element is not only displayed but also
	 * has a height and width that is greater than 0. default polling time =
	 * customized time
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForElementVisible(By locator, int timeOut, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(pollingTime));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * An expectation for checking that all elements present on the web page that
	 * match the locator are visible. Visibility means that the elements are not
	 * only displayed but also have a height and width that is greater than 0.
	 * 
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public List<WebElement> waitForElementsVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	// non web elements: title, url, alert

	public boolean waitForPageTitle(String titleVal, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleContains(titleVal));
	}

	public boolean waitForPageActTitle(String actTitle, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleIs(actTitle));
	}

	public String doGetPageTitleContains(String titleVal, int timeOut) {
		if (waitForPageTitle(titleVal, timeOut)) {
			return driver.getTitle();
		}
		return null;
	}

	public String doGetPageTitleIs(String titleVal, int timeOut) {
		if (waitForPageActTitle(titleVal, timeOut)) {
			return driver.getTitle();
		}
		return null;
	}

	public String waitForUrlContains(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		try {
			if (wait.until(ExpectedConditions.urlContains(urlFraction))) {
				return driver.getCurrentUrl();
			}
		} catch (TimeoutException e) {
			return null;

		}
		return null;
	}

	public String waitForUrlToBe(String url, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

		try {
			if (wait.until(ExpectedConditions.urlToBe(url))) {
				return driver.getCurrentUrl();
			}
		} catch (TimeoutException e) {
			return null;

		}
		return null;
	}

	public Alert waitForAlert(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public String getAlertText(int timeOut) {
		return waitForAlert(timeOut).getText();
	}

	public void acceptAlert(int timeOut) {
		waitForAlert(timeOut).accept();
	}

	public void dismissAlert(int timeOut) {
		waitForAlert(timeOut).dismiss();
	}

	public WebDriver waitForFrameByIndex(int timeOut, int frameIndex) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}

	public WebDriver waitForFrameByLocator(int timeOut, By frameLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	public WebDriver waitForFrameByElement(int timeOut, WebElement frameElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}

	public WebElement waitForElementPresenceWithFluentWait(By locator, int timeOut, int pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
				.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.withMessage(locator + " is not found within the given time......");
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public WebElement waitForElementPresenceWithWait(By locator, int timeOut, int pollingTime) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.withMessage(locator + " is not found within the given time......");

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
	public Boolean waitForTextContainedInElementPresence(By locator, int timeOut, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		  return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
		}

	public void fileUploadByRobot() throws AWTException {
		
		StringSelection ss = new StringSelection(
				System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\TestSample_Image.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot r = new Robot();
		 r.delay(2000);
		// r.keyPress(KeyEvent.VK_ENTER);
		// r.keyRelease(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public void folderUploadByRobot() throws AWTException {


		StringSelection ss = new StringSelection(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\TestSample_Folder.zip");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot r = new Robot();
		// r.keyPress(KeyEvent.VK_ENTER);
		// r.keyRelease(KeyEvent.VK_ENTER);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		r.delay(3);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public String renameFile()
	{
		//calling for getting exiting file path 
		List<String> filePaths = getJpgFilePathsFromDirectory(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData");
		file = new File(filePaths.get(0));
		// Create an object of the File class 
        // Replace the file path with path of the directory 
		String filename = "TestSample_Image_1"+getRandomData()+".jpg";
        rename = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\"+filename); 
  
        // store the return value of renameTo() method in 
        // flag 
        boolean flag = file.renameTo(rename); 
  
        // if renameTo() return true then if block is 
        // executed 
        if (flag == true) { 
            System.out.println("File Successfully Rename"); 
        } 
        // if renameTo() return false then else block is 
        // executed 
        else { 
            System.out.println("Operation Failed"); 
        } 
        return rename.getAbsolutePath();
         
        
	}
	public static List<String> getJpgFilePathsFromDirectory(String directoryPath) {
        List<String> jpgFilePaths = new ArrayList<>();

        // Create a File object for the directory
        File directory = new File(directoryPath);

        // Check if the directory exists and is indeed a directory
        if (directory.exists() && directory.isDirectory()) {
            // List all files and directories inside the directory
            File[] filesList = directory.listFiles();

            if (filesList != null) {
                for (File file : filesList) {
                    // Check if it's a file (not a directory) and has a .jpg extension
                    if (file.isFile() && file.getName().toLowerCase().endsWith(".jpg")) {
                        jpgFilePaths.add(file.getAbsolutePath());
                    }
                }
            } else {
                System.out.println("The directory is empty or an I/O error occurred.");
            }
        } else {
            System.out.println("The path specified is not a directory or does not exist.");
        }

        return jpgFilePaths;
    }
	
	public void fileUploadBySendKeys(By locator)
	{
//		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\TestSample_Image_1.jpg");
		WebElement upload_file = driver.findElement(locator);
		System.out.println(renameFile());
		upload_file.sendKeys(renameFile());
	}
	
	public String isFileUploaded(By locator1, By locator2) {
		doClick(locator1);
		String text = doGetText(locator2);
		
		return text;
	}

	public static int getRandomData() {
		int randomNo = (int) (Math.random() * 1000);
		// String rNo = Integer.toString(randomNo);
		return randomNo;
	}

}
