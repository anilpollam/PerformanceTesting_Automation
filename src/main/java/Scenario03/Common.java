package Scenario03;

import java.awt.RenderingHints.Key;
import java.io.Console;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common extends TestBase{	
	

	//static WebDriver driver;
	static WebDriverWait wait;
	
	
	public static void main(String[] args) throws InterruptedException {
		
		Launch();		
		
		
	}
	
	
	public static void Launch() throws InterruptedException  {
			OpenURL();	
			Login();			
			OpenMenuItem("Container:Start");
			switchToApolloFrame();
			switchToFrameByXpath("//iframe[contains(@src,'StartPage')]");
			ExpandProductPickList();//Step 4: Expand Product picklist
			/*
			 * Complete the following fields: 
			 * Container: PerfContainer1 
			 * Level: Batch 
			 * Owner:Owner1 
			 * Start Reason: Start1 
			 * Workflow: Standard 
			 * Qty: 100 
			 * UOM: Each
			 */
		//	completeStartFormFields();
			
	}
	
	public  static void completeStartFormFields(String conatinerName,String level,String owner,String startReason,String workflow,String qty,String uom) {
		
		enterContainerTextBox("Abccdef");
		selectLevelDropdown("Batch");
		selectOwnerDropDown("");
		
	}

	public static void selectOwnerDropDown(String string) {
		
		
	}


	public static void enterContainerTextBox(String container) {
		findById("ctl00_WebPartManager_StartPage_DetailsWP_Details_ContainerName_ctl00").click();
		findById("ctl00_WebPartManager_StartPage_DetailsWP_Details_ContainerName_ctl00").sendKeys(container);
	}
	
	public static void selectLevelDropdown(String level) {
		//findById("ctl00_WebPartManager_StartPage_DetailsWP_Details_ContainerName_ctl00").click();
		waitForElementById("ctl00_WebPartManager_StartPage_DetailsWP_Details_Level_Imbt");
		selectDropdown("ctl00_WebPartManager_StartPage_DetailsWP_Details_Level_Imbt", "//*[@id='ctl00_WebPartManager_StartPage_DetailsWP_Details_Level_Panl']", level);
		
	}

	public  static void ExpandProductPickList() {
		WebElement productpicklist=findByXpath("//div[@class='cs-picklist']/input[@id='ctl00_WebPartManager_StartPage_DetailsWP_Details_Product_Imbt']");
		productpicklist.click();
	}


	public static void OpenMenuItem(String menupath) throws InterruptedException {
				
		
		waitUntilApolloFrameisLoad();
		switchTodefaultcontent();		
		clickMoreButton();
		TestBase.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[@name='apollo']")));
		driver.findElement(By.xpath("//button[@id='"+menupath.split(":")[0]+"']")).click();		
		TestBase.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='"+menupath.split(":")[1]+"']")));
		driver.findElement(By.xpath("//a[text()='"+menupath.split(":")[1]+"']")).click();
		
	}	
	
	
}
