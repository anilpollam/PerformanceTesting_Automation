package Scenario03;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario5 extends TestBase {
//static WebDriverWait wait;
//	static WebDriverWait wait;
	
	

	public static void main(String[] args) throws InterruptedException {
	   OpenURL();
		Login();
		
		Integer packageName=GeneratePackageName();
	//	Createpackagepage();
		OpenMenuItem("Change Management:Create Package");
		Expandpackagecreationtemplet();
		Fillpackagenamefield("Package0"+packageName);  // Need to change package everytime while running the code 
		
		Selectpct1();	
		Expandpackageownerpicklist();
		Selectinsiteadmin();
		
		Expandpackageprioritycode();
		Selectppc1();
		
		Expandpackagecreationreason();
		Selectpcr1();
		
		Expandchangemgtworkflow();
		Selectcamstar();
	
		Clickichangepackagepopupappers();
		Clickclosebutton();
		Clickonthecreateandgotoupdatebutton();
		Selectownerpluscollaborators();
		Expanddeploymentdetailsform();
		Selecttargetserverfromtargetsystem("cltqacep995");//Targer Server Name
		populaterecommendeddeploymentdate();   
		Clickupdatebutton();
		
		
		  //Openpackagesearch();
	      OpenMenuItem("Change Management:Package Search");
		   Clickclearallbutton();
		    Expandemployeepicklist();
		 Selectadministrator(); 
		 Clicksearchbutton();
		  Selectpackage1fromgrid("Package"+packageName); // Need to change package
		  Clickonassigncontent(); 
		  Selectcontainerlevelfromobject();
		 Selectbatchfrominstance();
		 Clickaddtogridbutton();
		  Expandrow1fromobjecttypename(); 
		  Selectbatchfromgrid();
		  Clickwhereusedbutton();
		  Expandrow2fromobjecttypename();
		  SelectRL2348clickadd(); 
		  // Clickibutton();--> Not required //
		  clickclosebutton();
		  Clickassignbutton(); 
		  Selectcontentflyoutonpackage();
		  Selectpackagedetails();
		  Selectattachdocument(); 
		  Expanddocumentinstance();
		  Selectnotepad();
		  pressattach();
		  // Selectdocumentsetflyout(); //Not required
		  // Closedocumentsetflyout(); 
		  Selecthistoryflyout();
		  Selectcontentchangehistory(); 
		  Expandobjecttype(); 
		  Selectcontainerlevel();
		  Expandinstancename();
		  Selectbatch(); 
		  Expandlastchangeuser();
		  Selectcamstaradmin();
		  Pressclearall(); 
		  Presssearch();
		  Selectinstancnamelink();
		 
		 /* Closemodelingaudittrailpopup(); Selectcontentflyoutonpackage();
		 * Selectactivationimpact(); Expandselectedtargetlist(); Selecttargetserver();
		 * Expandobjecttyp(); Selectcontainer(); Pressreviewactivationimpact();
		 * Pressexportbutton(); Exportallresultstoexcel();
		 * 
		 * Openpackagesearch(); Clickclearallbutton(); Selectgeneralsearchtab();
		 * Expandpackagestatus(); Selectopen(); Expandchangemgmworkflow(); camstar();
		 * Expandchangemgmtstep(); Selectdraftcamstar(); Expandtargetsystem();
		 * Selecttargetserve(); Expandpackagepriority(); Selectppc();
		 * Expandcontainsmodelingobject(); Selectcontainerlevl();
		 * Expandcontainsmodelinginstance(); Selectbtch(); Clicksearch();
		 * Selectpackagefromgrid(); Clickonupdatepackage(); Selectapprovestab();
		 * Expandapprovaltemplet(); Selectat1(); Selectcollaboratorstab();
		 * 
		 * Expandcollaborattemplet(); Selectct1(); Clickupdatebutton();
		 * 
		 * Openpackagesearch(); Clickclearallbutton(); Clicksearchbutton();
		 * Selectpackage1forrouteapproval(); Routeforapproval();
		 * 
		 * //Need to check code from hear Openpackagesearch(); Clickclearallbutton();
		 * Clicksearchbutton(); SelectPack1andcancelapprovebutton();
		 * Clickoncancelapprovebutton();
		 * 
		 * 
		 * Openpackagesearch(); Clickclearallbutton(); Clicksearchbutton();
		 * SelectPack1clickonrouteforapproval(); Clickonrouteforapprovbutton();
		 * Routeforapproval(); Openpackagesearch(); Clickclearallbutton();
		 * Clicksearchbutton(); SelectPack1clickonapprovcamstar();
		 * Selectapprovestatustabforcamstar(); Selectviewhistory(); Selectapprovetab();
		 * Expandrolepicklistinapprovepackage(); Selectpackageapproval();
		 * Expandapproval(); Selectcamsta(); Approvaldecision(); Selectapp();
		 * Selectonsavedecision();
		 * 
		 * Openpackagesearch(); Clickclearallbutton(); Clicksearchbutton();
		 * Selectpackage1clickondeploypackage(); populatedeploymentcommentfield();
		 * Clickonresetbutton(); Clickondeploybutton(); Clickonrefreshbutton();
		 * 
		 * Openpackagesearch(); Clickclearallbutton(); Clicksearchbutton();
		 * Clickonselectpackage1(); Clickonalterstepbutton();
		 * Expandselectnewpackagestep(); Selectdraftcamsta();
		 * Clickonalterpackagebutton();
		 */
		
		
	}
	
		public static int GeneratePackageName() {
			Random rand = new Random();
			int n = rand.nextInt(1000);
			return n;
			}

		public static void OpenURL() {
			System.setProperty("webdriver.chrome.driver","C:\\chrome driver\\chromedriver.exe");
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver, 300);
			driver.manage().window().maximize();
			driver.get("https://cltqacep1259.csiqa.local/CAMSTARPORTAL/");
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

		
		
/****************************** Create Package Page  *****************************************************************/
		
		public static void Createpackagepage() throws InterruptedException {		
			
			
			
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			driver.switchTo().frame("apollo");
			driver.findElement(By.className("ui-tabs-close")).click();
			driver.switchTo().defaultContent();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@button-id='Change Management']")));
			WebElement Search = driver.findElement(By.xpath("//*[@button-id='Change Management']"));
			Search.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Create Package']")));
			driver.findElement(By.xpath("//*[text()='Create Package']")).click();
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
		
		public static void OpenMenuItem(String menupath) throws InterruptedException {

			
			//waitUntilApolloFrameisLoad();
			switchTodefaultcontent();
			
			try {
				TestBase.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@name,'apollo')]")));	
			} catch (NoSuchElementException e) {
				OpenMenuItem(menupath);	
			}	
			closeModuleTab();
			switchTodefaultcontent();
			//clickMoreButton();		
			driver.findElement(By.xpath("//button[@id='" + menupath.split(":")[0] + "']")).click();		
			waitForElementByXpath("//a[text()='" + menupath.split(":")[1] + "']");
			TestBase.wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='" + menupath.split(":")[1] + "']")));
			driver.findElement(By.xpath("//a[text()='" + menupath.split(":")[1] + "']")).click();

		}
		public static void closeModuleTab() {
			switchToApolloFrame();
			List<WebElement> tabs=driver.findElements(By.xpath("//*[@id='tabContainerControl']//ul//a[@class='ui-tabs-close']"));
			if (tabs.size()>1) {
				for(int i=0;i<tabs.size();i++) {
					tabs.get(i).click();
				}
			}
			
			
		}
		public static void Expandpackagecreationtemplet() throws InterruptedException {
			switchToApolloFrame();			
			switchToSrcFrame("StartChangePkg_VP");
			
		   wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_GeneralGroupWP_PackageCreationTemplate_Imbt']"))).click();	
		}
		
		public static void Selectpct1() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j1_1_anchor']"))).click();
		}
		
		public static void Fillpackagenamefield(String packageName) throws InterruptedException  {	
			
			waitForElementByXpath("//*[@id='ctl00_WebPartManager_GeneralGroupWP_ChangePackageName_ctl00']");
		//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_GeneralGroupWP_ChangePackageName_ctl00']"))).sendKeys(packageName);
			
			enterTextBox(findByXpath("//*[@id='ctl00_WebPartManager_GeneralGroupWP_ChangePackageName_ctl00']"), packageName);
			Thread.sleep(2000);
		
		}
		
		public static void Expandpackageownerpicklist() throws InterruptedException  {
			waitForElementByXpath("//*[@id='ctl00_WebPartManager_GeneralGroupWP_PackageOwner_Imbt']");
			waitForElementByXpath("//*[@id='ctl00_WebPartManager_GeneralGroupWP_PackageOwner_Edit']");
			try {
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_GeneralGroupWP_PackageOwner_Imbt']"))).click();
			} catch (StaleElementReferenceException e) {
				Expandpackageownerpicklist();
			}
			
	
		
		}

		public static void Selectinsiteadmin() throws InterruptedException  {
			
			enterContainerAndTab("ctl00_WebPartManager_GeneralGroupWP_PackageOwner_Panl_Filter_Fltc",
					"InSiteAdmin");
			selectDropDownByText("//*[@id='ctl00_WebPartManager_GeneralGroupWP_PackageOwner_Panl']",
					"InSiteAdmin");
			
			/*
			 * waitForElementByXpath(
			 * "//*[@id='ctl00_WebPartManager_GeneralGroupWP_PackageOwner_Panl']");
			 * driver.findElement(By.xpath(
			 * "//*[@id='ctl00_WebPartManager_GeneralGroupWP_PackageOwner_Edit']")).clear();
			 * driver.findElement(By.xpath(
			 * "//*[@id='ctl00_WebPartManager_GeneralGroupWP_PackageOwner_Edit']")).sendKeys
			 * ("InsiteAdmin"); driver.findElement(By.xpath(
			 * "//*[@id='ctl00_WebPartManager_GeneralGroupWP_PackageOwner_Edit']")).sendKeys
			 * (Keys.ENTER);
			 */
			
		
		}
		
		public static void Expandpackagecreationreason() throws InterruptedException  {
			waitForElementByXpath("//*[@id='ctl00_WebPartManager_GeneralGroupWP_CreationReason_Imbt']");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_GeneralGroupWP_CreationReason_Imbt']"))).click();
		
		}
		
		public static void Selectpcr1() throws InterruptedException  {
			//waitForElementById("ctl00_WebPartManager_GeneralGroupWP_CreationReason_Panl_Filter_Fltc");
			//waitForElementByXpath("//*[@id='ctl00_WebPartManager_GeneralGroupWP_CreationReason_Panl']");
			waitForElementByXpath("//*[@id='ctl00_WebPartManager_GeneralGroupWP_CreationReason_Panl']//a[text()='PCR1']");	
			//enterContainerAndTab("ctl00_WebPartManager_GeneralGroupWP_CreationReason_Panl_Filter_Fltc","PCR1");
			//selectDropDownByText("//*[@id='ctl00_WebPartManager_GeneralGroupWP_CreationReason_Panl']","PCR1");	
			
		//	selectDropDownByText("//*[@id='ctl00_WebPartManager_GeneralGroupWP_CreationReason_Panl']", "PCR1");
			
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_GeneralGroupWP_CreationReason_Panl']//a[text()='PCR1']"))).click();
		
		}
		
		public static void Expandpackageprioritycode() throws InterruptedException  {
			waitForElementByXpath("//*[@id='ctl00_WebPartManager_GeneralGroupWP_PkgPriority_Imbt']");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_GeneralGroupWP_PkgPriority_Imbt']"))).click();
		
		}
		
		public static void Selectppc1() throws InterruptedException  {
			waitForElementByXpath("//*[@id='ctl00_WebPartManager_GeneralGroupWP_PkgPriority_Panl']//a[text()='PPC1']");
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j3_1_anchor']"))).click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_GeneralGroupWP_PkgPriority_Panl']//a[text()='PPC1']"))).click();
		
		}
		
		public static void Expandchangemgtworkflow() throws InterruptedException  {
			waitForElementByXpath("//*[@id='ctl00_WebPartManager_GeneralGroupWP_StartChangePkg_Workflow_Imbt']");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_GeneralGroupWP_StartChangePkg_Workflow_Imbt']"))).click();
		
		}
	
		public static void Selectcamstar() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_GeneralGroupWP_StartChangePkg_Workflow_Panl']//a[text()='Camstar']"))).click();
		
		}
		
		public static void Clickichangepackagepopupappers() throws InterruptedException  {
			waitForElementByXpath("//*[@name='ctl00$WebPartManager$GeneralGroupWP$InfoButton']");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_GeneralGroupWP_InfoButton']"))).click();
		
		}
		
		public static void Clickclosebutton() throws InterruptedException  {			
			waitForElementByXpath("//*[@id='ctl00_CloseLink']");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_CloseLink']"))).click();
				
		}
	
		public static void Clickonthecreateandgotoupdatebutton() throws InterruptedException  {		
			waitForElementByXpath("//*[@id='ctl00_WebPartManager_ButtonsBar_SaveUpdate']");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ButtonsBar_SaveUpdate']"))).click();
				
		}
		
		public static void Selectownerpluscollaborators() throws InterruptedException  {		
			try {
				waitForElementByXpath("//*[@id='ctl00_WebPartManager_GeneralGroupWP_TrueControl']/label");
				Thread.sleep(3000);
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_GeneralGroupWP_TrueControl']/label"))).click();
			} catch (StaleElementReferenceException e) {
				Selectownerpluscollaborators();
			}
			
				
		}
		
		public static void Expanddeploymentdetailsform() throws InterruptedException  {	
			try {
				Thread.sleep(3000);
				waitForElementByXpath("//*[@id='ctl00_WebPartManager_General_WP_DeploymentDetailsToggle']/div//img");
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_General_WP_DeploymentDetailsToggle']/div//img"))).click();
					
			} catch (StaleElementReferenceException e) {
				Expanddeploymentdetailsform();
			}
			
		}
		
		public static void Selecttargetserverfromtargetsystem(String server) throws InterruptedException  {
			switchToApolloFrame();			
			switchToSrcFrame("StartChangePkg_VP");
			waitForElementByXpath("//table[@id='ctl00_WebPartManager_DeploymentDetailsWP_TargetsGrid']");
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='ctl00_WebPartManager_DeploymentDetailsWP_TargetsGrid']//tr/td[text()='"+server+"']/../td[1]/label"))).click();
				
		}
		
		public static void populaterecommendeddeploymentdate() throws InterruptedException  {
			
			JavascriptExecutor je = (JavascriptExecutor) driver;
			WebElement element = driver.findElement(By.xpath("//*[@id='WebPart_DeploymentDetailsWP']/table/tbody/tr[4]/td/span/button"));
			je.executeScript("arguments[0].scrollIntoView(true);",element);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='WebPart_DeploymentDetailsWP']/table/tbody/tr[4]/td/span/button"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[3]"))).click();
				
		}
		
		public static void Clickupdatebutton() throws InterruptedException  {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ButtonsBar_UpdateAction']"))).click();
			
				
		}
	    
		public static void Openpackagesearch() throws InterruptedException {
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			driver.switchTo().frame("apollo");
			driver.findElement(By.className("ui-tabs-close")).click();
			driver.switchTo().defaultContent();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@button-id='Change Management']")));
			WebElement Search = driver.findElement(By.xpath("//*[@button-id='Change Management']"));
			Search.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Package Search']")));
			driver.findElement(By.xpath("//*[text()='Package Search']")).click();
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
		
        
		
		public static void Clickclearallbutton() throws InterruptedException  {
//			Thread.sleep(5000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("apollo");
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'PackageInquiry_VP')]")));
//			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CM_Button_WP_ClearAllButton']"))).click();
				
		}
		
		public static void Expandemployeepicklist() throws InterruptedException  {
			waitForElementByXpath("//*[@id='ctl00_WebPartManager_EmployeeAssignmentSearchWP_PackageInquiry_PackageOwner_Imbt']");
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_EmployeeAssignmentSearchWP_PackageInquiry_PackageOwner_Imbt']"))).click();
				
		}
		
		public static void Selectadministrator() throws InterruptedException  {
			//enterContainerAndTab("//*[@id='ctl00_WebPartManager_EmployeeAssignmentSearchWP_PackageInquiry_PackageOwner_Imbt']",
					//"Administrator");
			//selectDropDownByText("//*[@id='ctl00_WebPartManager_EmployeeAssignmentSearchWP_PackageInquiry_PackageOwner_Panl']",
					//"Administrator");
			waitForElementByXpath("//*[@id='ctl00_WebPartManager_EmployeeAssignmentSearchWP_PackageInquiry_PackageOwner_Panl']//a[text()='Administrator']");
			
			//driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_EmployeeAssignmentSearchWP_PackageInquiry_PackageOwner_Edit']")).sendKeys("InsiteAdmin");
			driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_EmployeeAssignmentSearchWP_PackageInquiry_PackageOwner_Panl']//a[text()='Administrator']")).click();
			//*[@id='ctl00_WebPartManager_EmployeeAssignmentSearchWP_PackageInquiry_PackageOwner_Panl']//a[text()='Administrator']
		}
		
		public static void Clicksearchbutton() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CM_Button_WP_SearchButton']"))).click();
				
		}
		
		public static void Selectpackage1fromgrid(String packageName) throws InterruptedException  {
			waitForElementByXpath("//table[@id='ctl00_WebPartManager_CM_ChangePkgSearchResult_WP_ChangePackageGrid']");
			//write click next code
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@id='ctl00_WebPartManager_CM_ChangePkgSearchResult_WP_ChangePackageGrid']//td[@title='"+packageName+"']"))).click();
				
		}
		
		public static void Clickonassigncontent() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ActionsControl_CMAssignContentAction']"))).click();
				
		}
		
		public static void Selectcontainerlevelfromobject() throws InterruptedException  {
			Thread.sleep(5000);
	//		driver.switchTo().frame("iframe1");
			driver.switchTo().defaultContent();
			driver.switchTo().frame("apollo");
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'AssignChangePkgContent_VP')]")));
			
/*doubt*///	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_InstanceList_WP_ModelingObjectList_txtSearch']/input"))).sendKeys(Keys.chord(Keys.CONTROL,"Container Level"));
//			Actions actions= new Actions (driver);
//			driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_InstanceList_WP_ModelingObjectList_txtSearch']/input")).sendKeys("Container Level");
//			driver.findElement(By.id("input-prompt-undefined")).sendKeys("Container Level");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_InstanceList_WP_ModelingObjectList_mainObjectsList']/div/a[34]")).click();
//			actions.sendKeys(Keys.TAB);
			
			
				
		}
		
		public static void Selectbatchfrominstance() throws InterruptedException  {
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='62594341']/td[1]/label"))).click();
				
		}
		
		public static void Clickaddtogridbutton() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_InstanceList_WP_AddToGridButton']"))).click();
				
		}
		
		public static void Expandrow1fromobjecttypename() throws InterruptedException  {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='000000']/td[1]/a/span"))).click();
				
		}
		
		public static void Selectbatchfromgrid() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='000000']/td[1]/label"))).click();
				
		}
		
		public static void Clickwhereusedbutton() throws InterruptedException  {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_DependenciesWP_WhereUsedBtn']"))).click();
				
		}
		
		public static void Expandrow2fromobjecttypename() throws InterruptedException  {
			Thread.sleep(6000);
	    	driver.switchTo().defaultContent();
     		driver.switchTo().frame("apollo");
//			Thread.sleep(5000);
     		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'AssignChangePkgContent_VP')]")));
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'AssignChangePkgContentWhereUsed_VP')]")));
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("window.scrollBy(0,400)");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[3]/div[1]/div[2]/div/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/table/tbody/tr[2]/td/div[2]/div[3]/div[3]/div/table/tbody/tr[4]/td[1]/a/span"))).click();
				
		}
		
		public static void SelectRL2348clickadd() throws InterruptedException  {
	//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[3]/div[1]/div[2]/div/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/table/tbody/tr[2]/td/div[2]/div[3]/div[3]/div/table/tbody/tr[5]/td[2]/div/div/div[3]/div[3]/div/table/tbody/tr[3]/td[1]/label"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/form/div[3]/div[1]/div[2]/div/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div/table/tbody/tr[2]/td/div[2]/div[3]/div[3]/div/table/tbody/tr[5]/td[2]/div/div/div[3]/div[3]/div/table/tbody/tr[3]/td[1]/label"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ButtonsBar_OkBtn']"))).click();
				
		}    
			
		
		public static void Clickibutton() throws InterruptedException  {
			Thread.sleep(3000);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollBy(0,800)", "");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_DependenciesWP_PkgContentSummaryBtn']"))).click();
				
		}
		
		public static void clickclosebutton() throws InterruptedException  {
			Thread.sleep(3000);
//			WebElement element = driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_ButtonsBar_Close']"));
//			JavascriptExecutor executor = (JavascriptExecutor)driver;
//			executor.executeScript("arguments[0].click();", element);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ButtonsBar_Close']"))).click();
				
		}
		
		public static void Clickassignbutton() throws InterruptedException  {
			driver.switchTo().defaultContent();
     		driver.switchTo().frame("apollo");
//			Thread.sleep(5000);
     		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'AssignChangePkgContent_VP')]")));
     		Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ButtonsBar_SubmitButton']"))).click();
				
		}
		
		public static void Selectcontentflyoutonpackage() throws InterruptedException  {
			Thread.sleep(3000);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollBy(0,-450)", "");
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CM_InstanceHeader_WP_Content_CollapseImage']"))).click();
				
		}
		
		public static void Selectpackagedetails() throws InterruptedException  {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ContentWP_Control']/b"))).click();
				
		}
		
		
		public static void Selectattachdocument() throws InterruptedException  {
			Thread.sleep(5000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("apollo");
			Thread.sleep(3000);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'CM_PackageDetails_VP')]")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CM_InstanceHeader_WP_AttachDocument']"))).click();
			
				
		}
					
		public static void Expanddocumentinstance() throws InterruptedException  {
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("apollo");
			
			Thread.sleep(3000);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'CM_PackageDetails_VP')]")));
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'AttachDocument_VP')]")));
						
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_AttachDocument_WP_AttachDocument_DocumentInstance_Imbt']"))).click();
				
		}
		
		public static void Selectnotepad() throws InterruptedException  {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_AttachDocument_WP_AttachDocument_DocumentInstance_Edit']")).sendKeys("Notepad");
			driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_AttachDocument_WP_AttachDocument_DocumentInstance_Edit']")).sendKeys(Keys.TAB);
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_AttachDocument_WP_AttachDocument_DocumentInstance_Edit']"))).sendKeys("Notepad");
				
		}
		
		public static void pressattach() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ButtonsBar_Submit']"))).click();
				
		}
		
		public static void Selectdocumentsetflyout() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CM_InstanceHeader_WP_ChangePkg_Documents_CollapseImage']"))).click();
				
		}
		
		public static void Closedocumentsetflyout() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CM_InstanceHeader_WP_ChangePkg_Documents_ChangePkg_DocumentsButton']"))).click();
				
		}
		
		public static void Selecthistoryflyout() throws InterruptedException  {
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("apollo");
			Thread.sleep(3000);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'CM_PackageDetails_VP')]")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CM_InstanceHeader_WP_History_CollapseImage']"))).click();
				
		}
		
		public static void Selectcontentchangehistory() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_HistoryWP_Control']/b"))).click();
				
		}
		
		public static void Expandobjecttype() throws InterruptedException  {
			driver.switchTo().defaultContent();
			driver.switchTo().frame("apollo");
			Thread.sleep(3000);
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'ContentChangeHistoryInq')]")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_BlankWP_ContentChangeHistoryInquiry_ObjectType_Imbt']"))).click();
				
		}
		
		public static void Selectcontainerlevel() throws InterruptedException  {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j1_5_anchor']"))).click();
				
		}
		
		public static void Expandinstancename() throws InterruptedException  {
			Thread.sleep(3000);
//			driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_BlankWP_ContentChangeHistoryInquiry_InstanceName_Imbt']")).clear();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_BlankWP_ContentChangeHistoryInquiry_InstanceName_Imbt']"))).click();
				
		}
		
		public static void Selectbatch() throws InterruptedException  {
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j2_3_anchor']"))).click();
				
		}
		
		public static void Expandlastchangeuser() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_BlankWP_ContentChangeHistoryInquiry_LastChangeUser_Imbt']"))).click();
				
		}
		
		public static void Selectcamstaradmin() throws InterruptedException  {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j2_4_anchor']"))).click();
				
		}
		
		public static void Pressclearall() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CM_Button_WP_ClearAllButton']"))).click();
				
		}
		
		public static void Presssearch() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CM_Button_WP_SearchButton']"))).click();
				
		}
		
		public static void Selectinstancnamelink() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ViewModelingHistoryLink_B%00a%00t%00c%00h%00']"))).click();
				
		}
		
		public static void Closemodelingaudittrailpopup() throws InterruptedException  {
			driver.switchTo().defaultContent();
			driver.switchTo().frame("apollo");
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'ModelingAuditTrailPopup_VP')]")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ButtonsBar_Close']"))).click();
				
		}
		
		// Add this method Selectcontentflyoutonpackage()
		
		
		public static void Selectactivationimpact() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ContentWP_Control0']/b"))).click();
				
		}
		
		public static void Expandselectedtargetlist() throws InterruptedException  {
			driver.switchTo().defaultContent();
			driver.switchTo().frame("apollo");
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'ActivationImpact_VP')]")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CM_ActivationImpact_Filter_targetSystem_Imbt']"))).click();
				
		}
		
		public static void Selecttargetserver() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j2_3_anchor']"))).click();
				
		}
		
		public static void Expandobjecttyp() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CM_ActivationImpact_Filter_objectTypes_Imbt']"))).click();
				
		}
		
		public static void Selectcontainer() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j1_3_anchor']"))).click();
				
		}
		
		public static void Pressreviewactivationimpact() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CM_ActivationImpact_WP_btnView']"))).click();
				
		}
		
		public static void Pressexportbutton() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CM_ActivationImpact_WP_differenceGrid_pager_excelSelectorTrigger']"))).click();
				
		}
		
		public static void Exportallresultstoexcel() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CM_ActivationImpact_WP_differenceGrid_excelSelectorDiv']/ul/span[1]"))).click();
				
		}
				
		public static void Selectgeneralsearchtab() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_TabContainer_WP_PackageInquery_TabContainer']/div[1]/div/ul/li[2]"))).click();
				
		}
		
		public static void Expandpackagestatus() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_GeneralSearchWP_PackageInquiry_PackageStatus_Imbt']"))).click();
				
		}
		
		public static void Selectopen() throws InterruptedException  {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='bc956f6']/td[1]/label"))).click();
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='f7b67784']/td[1]/label"))).click();
			Actions action = new Actions(driver); 
			action.moveByOffset(10, 15).perform();
				
		}
		
		public static void Expandchangemgmworkflow() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_GeneralSearchWP_PackageInquiry_Workflow_Imbt']"))).click();
				
		}
		
		public static void camstar() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j1_1_anchor']"))).click();
				
		}
		
		public static void Expandchangemgmtstep() throws InterruptedException  {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_GeneralSearchWP_PackageInquiry_PackageSteps_Imbt']"))).click();
				
		}
		
		public static void Selectdraftcamstar() throws InterruptedException  {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='1f504191']/td[1]/label"))).click();
			Actions action = new Actions(driver); 
			action.moveByOffset(10, 15).perform();
				
		}
		
		public static void Expandtargetsystem() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_GeneralSearchWP_PackageInquiry_TargetSystem_Imbt']"))).click();
				
		}
		
		public static void Selecttargetserve() throws InterruptedException  {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j2_4_anchor']"))).click();
				
		}
		
		public static void Expandpackagepriority() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_GeneralSearchWP_PackageInquiry_PackagePriorityCode_Imbt']"))).click();
				
		}
		
		public static void Selectppc() throws InterruptedException  {
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j3_1_anchor']"))).click();
				
		}
		
		public static void Expandcontainsmodelingobject() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_GeneralSearchWP_PackageInquiry_SelectedObjectType_Edit']"))).click();
				
		}
		
		public static void Selectcontainerlevl() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_GeneralSearchWP_PackageInquiry_SelectedObjectType_Edit']"))).sendKeys("Container Level");
				
		}
		
		public static void Expandcontainsmodelinginstance() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_GeneralSearchWP_PackageInquiry_SelectedInstance_Imbt']"))).click();
				
		}
		
		public static void Selectbtch() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j4_1_anchor']"))).click();
				
		}
		
		public static void Clicksearch() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CM_Button_WP_SearchButton']"))).click();
				
		}
		
		public static void Selectpackagefromgrid() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='000000']/td[2]"))).click();
				
		}
		
		public static void Clickonupdatepackage() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ActionsControl_CMUpdatePackageAction']"))).click();
				
		}
		
		public static void Selectapprovestab() throws InterruptedException  {
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("apollo");
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'UpdateChangePkg_VP')]")));			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ui-id-2']"))).click();
				
		}
		
		public static void Expandapprovaltemplet() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CM_Approvers_WP_ApprovalTemplate_Imbt']"))).click();
				
		}
		
		public static void Selectat1() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j1_1_anchor']"))).click();
				
		}
		
	
		
		public static void Selectcollaboratorstab() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[3]/div/div[2]/div[1]/div/table/tbody/tr[2]/td[1]/div/div/table/tbody/tr/td/div/div/table/tbody/tr/td/div/div[1]/div/ul/li[3]/a"))).click();
				
		}
		
		public static void Expandcollaborattemplet() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_Collaborators_CollaboratorTemplateName_Imbt']"))).click();
				
		}
		
		public static void Selectct1() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j2_1_anchor']"))).click();
				
		}
		
			
		
		public static void Selectpackage1forrouteapproval() throws InterruptedException  {
//			Thread.sleep(3000);
//			driver.switchTo().defaultContent();
//			driver.switchTo().frame("apollo");
//			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'PackageInquiry')]")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='000000']/td[2]"))).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_ActionsControl_CMRouteApprovalAction']")).click();
				
		}
		
		public static void Routeforapproval() throws InterruptedException  {
			Thread.sleep(5000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("apollo");
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'RouteApproval_VP')]")));
			Thread.sleep(3000);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ButtonsBar_RouteAction']"))).click();
				
		}
		

		
		public static void SelectPack1andcancelapprovebutton() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='000000']/td[2]"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ActionsControl_CMCancelApprovalAction']"))).click();
				
		}
		
		public static void Clickoncancelapprovebutton() throws InterruptedException  {
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("apollo");
		    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'CancelApproval_VP')]")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ButtonsBar_CancelAction']"))).click();
				
		}
	 
		public static void SelectPack1clickonrouteforapproval() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='000000']/td[2]"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ActionsControl_CMRouteApprovalAction']"))).click();
				
		}
		
		public static void Clickonrouteforapprovbutton() throws InterruptedException  {
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("apollo");
		    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'RouteApproval_VP')]")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ButtonsBar_RouteAction']"))).click();
				
		}
		
		public static void SelectPack1clickonapprovcamstar() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='000000']/td[2]"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ActionsControl_CMAssignApprovalAction']"))).click();
				
		}
		
		public static void Selectapprovestatustabforcamstar() throws InterruptedException  {
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("apollo");
		    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'SignatureApproval_VP')]")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ui-id-6']"))).click();
		    }
		
			public static void Selectviewhistory() throws InterruptedException  {
				driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_ApprovalStatusTab_WP_ViewHistory']/label")).click();
							
			}
			
			public static void Selectapprovetab() throws InterruptedException  {
				driver.findElement(By.xpath("//*[@id='ui-id-7']")).click();
							
			}
			
		public static void Expandrolepicklistinapprovepackage() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ApproveTab_WP_ApprovalForRole_Imbt']"))).click();
						
		}
		
		public static void Selectpackageapproval() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j1_1_anchor']"))).click();
						
		}
		
		public static void Expandapproval() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ApproveTab_WP_ApprovalFor_Imbt']"))).click();
						
		}
		
		public static void Selectcamsta() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j2_1_anchor']"))).click();
						
		}
		
		public static void Approvaldecision() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ApproveTab_WP_ApprovalDecision_Imbt']"))).click();
						
		}
	   
		public static void Selectapp() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j3_1_anchor']"))).click();
						
		}
		
		public static void Selectonsavedecision() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ButtonsBar_SaveDecisionBtn']"))).click();
						
		}
		
		
		public static void Selectpackage1clickondeploypackage() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='000000']/td[2]"))).click();
			driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_ActionsControl_CMDeployPackageAction']")).click();
			
				
		}
		
		public static void populatedeploymentcommentfield() throws InterruptedException  {
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("apollo");
		    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'DeployChangePkg_VP')]")));
			driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_DeployPackage_WP_Comment_ctl00']")).sendKeys("Hi");
							
		}
		
		public static void Clickonresetbutton() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ActionoBtns_WP_ResetBtn']"))).click();
			
				
		}
		
		public static void Clickondeploybutton() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ActionoBtns_WP_DeployBtn']"))).click();
			
				
		}
		
		public static void Clickonrefreshbutton() throws InterruptedException  {
//			Thread.sleep(3000);
//			driver.switchTo().defaultContent();
//			driver.switchTo().frame("apollo");
//		    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'DeployChangePkg_VP')]")));
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ActionoBtns_WP_RefreshBtn']"))).click();
			driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_ActionoBtns_WP_RefreshBtn']")).click();
					
		}
		//Below step missed in excel sheet
		public static void Clickonselectpackage1() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='000000']/td[2]"))).click();
						
		}
		
		public static void Clickonalterstepbutton() throws InterruptedException  {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ActionsControl_CMAlterStateAction']"))).click();
						
		}
		
		public static void Expandselectnewpackagestep() throws InterruptedException  {
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("apollo");
		    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'MoveNonStdChangePkg_VP')]")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_BlankWP_MoveNonStdChangePkg_ToStep_Imbt']"))).click();
							
			}
		
		public static void Selectdraftcamsta() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j1_3_anchor']"))).click();
							
			}
		
		public static void Clickonalterpackagebutton() throws InterruptedException  {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_BlankWP_Control0_ctl00']"))).click();
							
			}
			
}
/*********************************************************    END      ****************************************************************************************************/