package Scenario03;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.function.Function;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class TestBase {
	
	static WebDriver driver;
	static WebDriverWait wait;

	
	public static void OpenURL() {
		String str=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver","C:\\chrome driver\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 60);		
		driver.manage().window().maximize();
		driver.get("https://cltqacep1401.csiqa.local/CAMSTARPORTAL/");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//div[@class='aw-widgets-propertyContainer ng-scope ng-isolate-scope']//aw-property-text-box-val[@class='ng-isolate-scope']//input[@type='text']")));
	}
	
	public static void Login() throws InterruptedException {
		WebElement txtUserName = driver.findElement(By.xpath("//div[@class='aw-widgets-propertyContainer ng-scope ng-isolate-scope']//aw-property-text-box-val[@class='ng-isolate-scope']//input[@type='text']"));
		txtUserName.sendKeys("CamstarAdmin");
		WebElement txtpassword = driver.findElement(By.xpath("//div[@class='aw-widgets-propertyContainer ng-isolate-scope']//input[@type='password']"));
		txtpassword.sendKeys("JJuneSummer((99");
		WebElement txtdomain = driver.findElement(By.xpath("//input[contains(@class,'gwt-ListBox')]"));
		txtdomain.clear();
		txtdomain.sendKeys("csiqa.local");
		WebElement logIn = driver.findElement(By.xpath("//button[contains(@class,'aw-base-blk-button ng-scope ng-isolate-scope')]"));
		logIn.click();			
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@name,'apollo')]")));
		
	}
	
	public static void waitForElementByXpath(String locator) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }
	
	public static void waitForElementById(String locator) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
    }
	 public static void clickBy(String method, String locator, String text) {  
		 
		 if (method.equalsIgnoreCase("xpath"))
	            driver.findElement(By.xpath(locator)).click();
	        else if (method.equalsIgnoreCase("css"))
	            driver.findElement(By.cssSelector(locator)).click();
	        else
	            driver.findElement(By.id(locator)).click();
	 }
	 
	 
	 public static void typeByXpath(String locator, String text) {
	    driver.findElement(By.xpath(locator)).sendKeys(text);
	 }
	 
	 public static WebElement findByXpath(String locator) {
		 return driver.findElement(By.xpath(locator));
	 }
	 public static WebElement findById(String locator) {
		 return driver.findElement(By.id(locator));
	 }
	 public static void switchToApolloFrame() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(findByXpath("//iframe[contains(@name,'apollo')]"));
	 }
	
	 public static void switchToFrameByXpath(String xpath) {
		driver.switchTo().frame(driver.findElement(By.xpath(xpath)));
	 }
	 public static void switchToSrcFrame(String frame) {
			switchToFrameByXpath("//iframe[contains(@src,'"+frame+"')]");
		}
		
	 public static void switchToFrameByName(String name) {		 
		 try {
			 driver.switchTo().frame(name);
		 }catch (NoSuchFrameException e) {			
		}
		 
	 }
	 
	 public static void waitUntilApolloFrameisLoad() {
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@name,'apollo')]")));	
	 }
	 
	 public static void switchTodefaultcontent() {
		 driver.switchTo().defaultContent();	
	 }
	 
	 public static void clickMoreButton() {
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='More...'])[2]"))); 
		 WebElement More = driver.findElement(By.xpath("(//*[text()='More...'])[2]"));
		 More.click();		 
	 }
	 
	 public static void clicksearchButton() {
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@button-id='Search']"))); 
		 WebElement Search = driver.findElement(By.xpath("(//*[@button-id='Search']"));
		 Search.click();		 
	 }
	 
	 
	 public static void switchToFrame() {		 
		 List<WebElement> ele=driver.findElements(By.tagName("iframe"));
			for (WebElement webElement : ele) {
				try {				
			   
				String id=webElement.getAttribute("id");
				driver.switchTo().frame(id);	
			
				}catch (Exception e) {
					
				}
			}
	 }
	 
	 public static void type(String method, String locator, String text) {
	        if (method.equalsIgnoreCase("xpath"))
	            driver.findElement(By.xpath(locator)).sendKeys(text);
	        else if (method.equalsIgnoreCase("css"))
	            driver.findElement(By.cssSelector(locator)).sendKeys(text);
	        else
	            driver.findElement(By.id(locator)).sendKeys(text);
	    }
	 
	 
	 public static boolean isElementPresent(String locator) {
	        try {
	            driver.findElement(By.xpath(locator));
	            return true;
	        } catch (NoSuchElementException e) {
	            return false;
	        }
	    }
	 public static void assertElementPresentByXpath(String locator) {	       
	      
		 Assert.assertTrue("Element " + locator + " not found.", isElementPresent(locator));
	       
	    }

	 public static void assertElementNotPresentByXpath(String locator) {      
	        Assert.assertFalse("Element " + locator + " not found.", isElementPresent(locator));
	    }    
	    
	    
	 public static boolean isElementVisible(String locator) {
	        try {
	            return driver.findElement(By.xpath(locator)).isDisplayed();
	        } catch (NoSuchElementException e) {
	            return false;
	        }
	    }
	    
	 public static String getText(String xpath) {
	        return driver.findElement(By.xpath(xpath)).getText();
	    }
	 
	 public static WebElement getWebElement(String xpath) {
	        return driver.findElement(By.xpath(xpath));
	    }
	public static WebElement FluentWait(final By locator)   {		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		        .withTimeout(Duration.ofSeconds(30))
		        .pollingEvery(Duration.ofSeconds(1))
		        .ignoring(NoSuchElementException.class,StaleElementReferenceException.class);				
		 		
		
		 WebElement foo = wait.until(
			        new Function<WebDriver, WebElement>() {
			            public WebElement apply(WebDriver driver) {
			                return driver.findElement(locator);
			            }
			        }
			    );
			  return foo;
		
	}
	

public static void expandDropDown(String pickListDropdownId) {
		
		waitForElementById(pickListDropdownId);
		try {
			findById(pickListDropdownId).click();
		} catch (StaleElementReferenceException e) {
			findById(pickListDropdownId).click();
		}catch (ElementClickInterceptedException e) {
			expandDropDown(pickListDropdownId);
		}
	}

public static void selectDropDownByText(String dropDownPanel,String text) {
	waitForElementByXpath(dropDownPanel);
	String xpath="//*[text()='"+text+"']";
	waitForElementByXpath(dropDownPanel+xpath);	
	
	try {
		findByXpath(dropDownPanel+xpath).click();
	} catch (StaleElementReferenceException e) {
		selectDropDownByText(dropDownPanel,text);
	}
	
}
public static void enterContainerAndTab(String filterId,String containerName) throws InterruptedException {
	waitForElementById(filterId);
	findById(filterId).click();
	Thread.sleep(3000);
	findById(filterId).sendKeys(containerName);
	findById(filterId).sendKeys(Keys.TAB);
}
	public static void selectDropdown(String pickListDropdownId,String dropDownPanel,String text) {
		
		findById(pickListDropdownId).click();		
		waitForElementByXpath(dropDownPanel);
		String xpath="//a[text()='"+text+"']";
		waitForElementByXpath(dropDownPanel+xpath);	
		findByXpath(dropDownPanel+xpath).click();
		
		
	}
	
	public static void enterTextBox(WebElement element,String text) {
		element.sendKeys(text);
	}
}
