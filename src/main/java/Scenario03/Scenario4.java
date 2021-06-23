package Scenario03;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario4 extends TestBase{
	
	static WebDriverWait wait;
	
	
public static void main(String[] args) throws InterruptedException {
		
		Launch();				
		
}
	
	
public static void Launch() throws InterruptedException  {
	OpenURL();	
	Login();			
	OpenMenuItem("Container:Collect Data");
	switchToApolloFrame();
//	switchToFrameByXpath("//iframe[contains(@src,'StartPage')]");
	
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
	
	
	
	
	
	
	
	
	
	
	
	


