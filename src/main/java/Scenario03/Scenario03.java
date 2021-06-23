package Scenario03;

import java.awt.RenderingHints.Key;
import java.io.Console;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario03 {
	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException {
	   OpenURL();
		Login();
		OpenMfgAuditTrailForm();
		RecordtypeDropdown();
		ViewsDropdown();
		NameDropdown();
		clicksearch();
		Selecttransaction();
		Selecttransactiontypes();
		TranscationFilter();
		clicksearch1();		
		ContainerSearch();
		ExpandtheInProccessdropdown();
		Clicksearch();
		Clicknextpage2();
		Clicknextpage3();
		Clicknextpage4();
		Clicknextpage5();
		Clicknextpage6();
		Selectpage20();
		Clicknextpagebutton();
		Clicklastpagebutton();
		Clickpreviouspagebutton();
		Clickfirstpagebutton();
		     
	}

	public static void OpenURL() {
		System.setProperty("webdriver.chrome.driver","C:\\chrome driver\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 60);
		driver.manage().window().maximize();
		driver.get("https://cltqacep1401.csiqa.local/CAMSTARPORTAL/");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//div[@class='aw-widgets-propertyContainer ng-scope ng-isolate-scope']//aw-property-text-box-val[@class='ng-isolate-scope']//input[@type='text']")));
	}

	public static void Login() {
		WebElement txtUserName = driver.findElement(By.xpath(
				"//div[@class='aw-widgets-propertyContainer ng-scope ng-isolate-scope']//aw-property-text-box-val[@class='ng-isolate-scope']//input[@type='text']"));
		txtUserName.sendKeys("CamstarAdmin");
		WebElement txtpassword = driver.findElement(
				By.xpath("//div[@class='aw-widgets-propertyContainer ng-isolate-scope']//input[@type='password']"));
		txtpassword.sendKeys("JJuneSummer((99");
		WebElement txtdomain = driver.findElement(By.xpath("//input[contains(@class,'gwt-ListBox')]"));
		txtdomain.clear();
		txtdomain.sendKeys("csiqa.local");
		WebElement logIn = driver
				.findElement(By.xpath("//button[contains(@class,'aw-base-blk-button ng-scope ng-isolate-scope')]"));
		logIn.click();
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	public static void OpenMfgAuditTrailForm() throws InterruptedException {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='apollo']")));
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("apollo");
		
		driver.findElement(By.className("ui-tabs-close")).click();
		}catch(Exception ex){
			
			String str=ex.getMessage();
			
		}
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='More...'])[2]")));
		WebElement More = driver.findElement(By.xpath("(//*[text()='More...'])[2]"));
		More.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@button-id='Search']")));
		WebElement Search = driver.findElement(By.xpath("//*[@button-id='Search']"));
		Search.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Mfg Audit Trail']")));
		// Navigate Mfg Audit Trail
		
		driver.findElement(By.xpath("//*[text()='Mfg Audit Trail']")).click();
		try {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("apollo");
		}catch(Exception ex){}
		List<WebElement> ele=driver.findElements(By.tagName("iframe"));
		for (WebElement webElement : ele) {
			try {				
		   
			String id=webElement.getAttribute("id");
			driver.switchTo().frame(id);
			}catch (Exception e) {
				// TODO: handle exception
			}
		}}
	
	
	public static void RecordtypeDropdown() throws InterruptedException {			
//		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_PanelFiltersSearchWP_CollapsibleSectionsAccordion_ctl05_MfgAuditTrailInquiry_RecordType_Edit']")).sendKeys(Keys.CONTROL+"A");
//		wait = new WebDriverWait(driver, 3000);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_PanelFiltersSearchWP_CollapsibleSectionsAccordion_ctl05_MfgAuditTrailInquiry_RecordType_Edit']"))).sendKeys("Container");
		driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_PanelFiltersSearchWP_CollapsibleSectionsAccordion_ctl05_MfgAuditTrailInquiry_RecordType_Edit']")).sendKeys("Container");
	}
	public static void ViewsDropdown() throws InterruptedException {	
//		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_PanelFiltersSearchWP_CollapsibleSectionsAccordion_ctl05_MfgAuditTrailInquiry_Views_Edit']"))).sendKeys(Keys.CONTROL+"A");
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_PanelFiltersSearchWP_CollapsibleSectionsAccordion_ctl05_MfgAuditTrailInquiry_Views_Edit']"))).sendKeys("QA");

	}
	public static void NameDropdown() throws InterruptedException {
//		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_PanelFiltersSearchWP_CollapsibleSectionsAccordion_ctl05_MfgAuditTrailInquiry_Name_ctl00']")).sendKeys("AuditContainer4");
	}
	public static void clicksearch() throws InterruptedException {	
//		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_PanelFiltersSearchTabWP_SearchTxnBtn']")).click();
	}
	public static void Selecttransaction() throws InterruptedException {	
//		Thread.sleep(3000);
		try
		{
			 driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_PanelFiltersSearchWP_CollapsibleSectionsAccordion_ctl08_Label']")).click();
		}catch(StaleElementReferenceException e) {
			 driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_PanelFiltersSearchWP_CollapsibleSectionsAccordion_ctl08_Label']")).click();
		}		
		}
	public static void Selecttransactiontypes() throws InterruptedException {	
//		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_PanelFiltersSearchWP_CollapsibleSectionsAccordion_ctl09_MfgAuditTrailInquiry_SelectTypes']/label")).click();
	}
	public static void TranscationFilter() throws InterruptedException {	
//		Thread.sleep(3000);
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_PanelFiltersSearchWP_CollapsibleSectionsAccordion_ctl09_MfgAuditTrailInquiry_TransactionTypes_Imbt']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='jqg_ctl00_WebPartManager_PanelFiltersSearchWP_CollapsibleSectionsAccordion_ctl09_MfgAuditTrailInquiry_TransactionTypes_Panl_ItemsGrid_eae46c4d']"))).click();
	
		Actions action = new Actions(driver); 
		action.moveByOffset(10, 15).perform();
	}
	public static void clicksearch1() throws InterruptedException {	
//		Thread.sleep(8000);
		driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_PanelFiltersSearchTabWP_SearchTxnBtn']")).click();
	}
	
	
	/****************************** ContainerSearch  *****************************************************************/
	public static void ContainerSearch() throws InterruptedException {

		driver.switchTo().defaultContent();
		driver.switchTo().frame("apollo");
		driver.findElement(By.className("ui-tabs-close")).click();
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='More...'])[2]")));
		WebElement More = driver.findElement(By.xpath("(//*[text()='More...'])[2]"));
		More.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@button-id='Search']")));
		WebElement Search = driver.findElement(By.xpath("//*[@button-id='Search']"));
		Search.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Container Search']")));
		driver.findElement(By.xpath("//*[text()='Container Search']")).click();
		try {
			driver.switchTo().defaultContent();
			driver.switchTo().frame("apollo");
			}catch(Exception ex){}
			List<WebElement> ele=driver.findElements(By.tagName("iframe"));
			for (WebElement webElement : ele) {
				try {				
			   
				String id=webElement.getAttribute("id");
				driver.switchTo().frame(id);
				}catch (Exception e) {
					// TODO: handle exception
				}
			}}
	
		
	public static void ExpandtheInProccessdropdown() throws InterruptedException {
//	Thread.sleep(3000);
	 driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_CurrentStatusWP_CollapsibleSectionsAccordion_ctl08_arrow']")).click();
//	 Thread.sleep(5000);
	 driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_CurrentStatusWP_CollapsibleSectionsAccordion_ctl09_ContainerSearchFilters_InProcess_Imbt']")).click();
//	 Thread.sleep(3000);
	 wait = new WebDriverWait(driver, 300);
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j1_5']/div"))).click();
	}
	
	public static void Clicksearch() throws InterruptedException {
//		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_ContainerSearchWP_ContainerSearch_Search']")).click();
		 
	}
	public static void Clicknextpage2() throws InterruptedException {
		try
		{
			 driver.findElement(By.xpath("//*[@id='next_ctl00_WebPartManager_ContainerSearch_ResultsWP_ContainerSearch_ResultsGrid_pager']/span")).click();
		}catch(StaleElementReferenceException e) {
			 driver.findElement(By.xpath("//*[@id='next_ctl00_WebPartManager_ContainerSearch_ResultsWP_ContainerSearch_ResultsGrid_pager']/span")).click();
		}
	}                                                                            
	public static void Clicknextpage3() throws InterruptedException {
	//	 Thread.sleep(3000);
		 wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='next_ctl00_WebPartManager_ContainerSearch_ResultsWP_ContainerSearch_ResultsGrid_pager']/span"))).click();
	}
	public static void Clicknextpage4() throws InterruptedException {
   //	 Thread.sleep(3000);
	     wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='next_ctl00_WebPartManager_ContainerSearch_ResultsWP_ContainerSearch_ResultsGrid_pager']/span"))).click();
	
	}
	public static void Clicknextpage5() throws InterruptedException {
	//	 Thread.sleep(3000);
		 wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='next_ctl00_WebPartManager_ContainerSearch_ResultsWP_ContainerSearch_ResultsGrid_pager']/span"))).click();
	
	}
	public static void Clicknextpage6() throws InterruptedException {
	//	 Thread.sleep(3000);
		 wait = new WebDriverWait(driver, 60);
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='next_ctl00_WebPartManager_ContainerSearch_ResultsWP_ContainerSearch_ResultsGrid_pager']/span"))).click();
	
	}
	public static void Selectpage20() throws InterruptedException {
		//	 Thread.sleep(3000);
		     wait = new WebDriverWait(driver, 60);
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ContainerSearch_ResultsWP_ContainerSearch_ResultsGrid_pager_left']/table/tbody/tr/td[3]/select"))).click();
		
		}
	
	public static void Clicknextpagebutton() throws InterruptedException {
		//	 Thread.sleep(3000);
		    wait = new WebDriverWait(driver, 60);
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='next_ctl00_WebPartManager_ContainerSearch_ResultsWP_ContainerSearch_ResultsGrid_pager']/span"))).click();
	}
	
	public static void Clicklastpagebutton() throws InterruptedException {
		//	 Thread.sleep(3000);
		     wait = new WebDriverWait(driver, 60);
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='last_ctl00_WebPartManager_ContainerSearch_ResultsWP_ContainerSearch_ResultsGrid_pager']/span"))).click();
	}
	
	public static void Clickpreviouspagebutton() throws InterruptedException {
		//	 Thread.sleep(3000);
	        wait = new WebDriverWait(driver, 60);
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='prev_ctl00_WebPartManager_ContainerSearch_ResultsWP_ContainerSearch_ResultsGrid_pager']/span"))).click();
	}
	
	public static void Clickfirstpagebutton() throws InterruptedException {
		//	 Thread.sleep(3000);
		     wait = new WebDriverWait(driver, 60);
			 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='first_ctl00_WebPartManager_ContainerSearch_ResultsWP_ContainerSearch_ResultsGrid_pager']/span"))).click();
	//		 Thread.sleep(5000);
			 driver.close();
	}
	
}
	
	
/*	************************************************* END  ************************************************************************************************************ */

	
	
	