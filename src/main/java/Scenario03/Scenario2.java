package Scenario03;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario2 extends TestBase {
//	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) throws InterruptedException {
	   OpenURL();
		Login();

		
 /*W   	ContainerSearch();
		expandContainerlevel();
		expandOwnerdropdown();
		expandStartreasondropdown();
		expandMfgdropdown();
		expandprioritycodedropdown();
		expandspecdropdown();
		expandOperationdropdown();
		expandholdreasondropdown();
		expandreworkreasondropdown();
		clearallbutton();
		expandprocessdropdown();
		clicksearch();
		containerelligibleforholdtxn();
		clearallbutton();
		expandprocess();
		clicksearch();
		Selectpage20();
		clickcurrentstatussearchresults();
		clicknextbutton();
		reloadActions();      */
		
/*W		Hold Multiple Page 
		Holdmultiple();
		expandholdreason();
		selectcancelorder();
		expandshowadditionalfields();
		clickholdselectedbutton();
		checkhidesuccessfultrans();
		uncheckhidesuccessfultrans();
		closetheholdmultiplepopupform(); */
		
/*W		Startrelease Page 
		Startrelease();
		Clickreleasemultiplebutton();
		Selectnewmaterialsfromdropdown();
		Clickreleasemultiplebutton();
		closethereleasemultiplepopupform();  */
		
		/*Container Search Historic Filters // No data parked as hold
		 ContainerSearch(); 
		 clickhistorttab();
		 selectoperation1();
		 startandenddate();
		 clicksearch();
		 clicklastbutton();
		 clickpreviouspagebutton();
		 selectpage17();
		 Clicknextpagebutton();
		 Clickfirstpagebutton();
		 clickallcheckboxes();
		 reloadActions();  */
		
		/*Move non-std(Multiple) popup 
		ContainerSearchforMovenonstdmultiple(); */ // No data parked as hold
		//Need to add methods hear
		
/*W		Quality Search 
		QualitySearch();
		clicksearchbuttoninqualitysearch(); */
		
		 
		/*Manage P/E */  // No data parked as hold
		
		
/*W		LineAssignment
		LineAssignment();  
		Expandworkcenterdropdown();
		Selectpackshipfromdropdown();
		Expandoperationdropdown();
		Selectpackagingfromdropdown();
		Expandresourceworkcelldropdown();
		Selectpackager1dropdown();
		Clicksetlineassignmentbutton(); 
	//	Reopenlineassignment(); //no data to clear */
		
		
/*	   	ESIG MULTI   */  // No data parked as hold
		
		
	}

	public static void OpenURL() {
		System.setProperty("webdriver.chrome.driver","C:\\chrome driver\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 300);
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

	
	
	/****************************** ContainerSearch  *****************************************************************/
	
	public static void ContainerSearch() throws InterruptedException {
		Thread.sleep(3000);
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
	
		
	
	
	public static void expandContainerlevel() throws InterruptedException  {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CurrentStatusWP_CollapsibleSectionsAccordion_ctl05_ContainerSearchFilters_ContainerLevel_Imbt']")));
		driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_CurrentStatusWP_CollapsibleSectionsAccordion_ctl05_ContainerSearchFilters_ContainerLevel_Imbt']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j1_1']/div"))).click();

	}
	
	
  	
	public static void expandOwnerdropdown() throws InterruptedException  {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CurrentStatusWP_CollapsibleSectionsAccordion_ctl05_ContainerSearchFilters_Owner_Imbt']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j2_1']/div"))).click();
	}
	
	public static void expandStartreasondropdown() throws InterruptedException  {
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CurrentStatusWP_CollapsibleSectionsAccordion_ctl05_ContainerSearchFilters_StartReason_Imbt']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j3_1']/div"))).click();
	}
	
	
	public static void expandMfgdropdown() throws InterruptedException  {
		driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_CurrentStatusWP_CollapsibleSectionsAccordion_ctl05_ContainerSearchFilters_MfgOrder_Imbt']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j4_1_anchor']"))).click();
	}
	
	
	public static void expandprioritycodedropdown() throws InterruptedException  {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CurrentStatusWP_CollapsibleSectionsAccordion_ctl06_arrow']")));
		driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_CurrentStatusWP_CollapsibleSectionsAccordion_ctl06_arrow']")).click();
		driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_CurrentStatusWP_CollapsibleSectionsAccordion_ctl07_ContainerSearchFilters_PriorityCode_Edit']")).sendKeys("High");

	}


	public static void expandspecdropdown() throws InterruptedException  {
		driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_CurrentStatusWP_CollapsibleSectionsAccordion_ctl07_ContainerSearchFilters_Spec_Edit']")).sendKeys("Cheese");

	}
	
	public static void expandOperationdropdown() throws InterruptedException  {
		driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_CurrentStatusWP_CollapsibleSectionsAccordion_ctl07_ContainerSearchFilters_Operation_Edit']")).sendKeys("Cheese");

	}
	
	public static void expandholdreasondropdown() throws InterruptedException  {

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CurrentStatusWP_CollapsibleSectionsAccordion_ctl08_arrow']"))).click();
		driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_CurrentStatusWP_CollapsibleSectionsAccordion_ctl09_ContainerSearchFilters_OnHold_Imbt']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j5_5']/div"))).click();
	}
	
	public static void expandreworkreasondropdown() throws InterruptedException  {
		driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_CurrentStatusWP_CollapsibleSectionsAccordion_ctl09_ContainerSearchFilters_ReworkReason_Edit']")).sendKeys("DoesNotMeetSpecification");

	}
	
	public static void clearallbutton() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ContainerSearchWP_ContainerSearch_ClearAll']")));
		driver.findElement(By.xpath("//*[@id='ctl00_WebPartManager_ContainerSearchWP_ContainerSearch_ClearAll']")).click();
	}

	public static void expandprocessdropdown() throws InterruptedException {
		Thread.sleep(3000);
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CurrentStatusWP_CollapsibleSectionsAccordion_ctl09_ContainerSearchFilters_InProcess_Imbt']"))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j6_5_anchor']"))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CurrentStatusWP_CollapsibleSectionsAccordion_ctl07_ContainerSearchFilters_Spec_Edit']"))).sendKeys("Start");
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CurrentStatusWP_CollapsibleSectionsAccordion_ctl05_ContainerSearchFilters_Product_Edit']"))).sendKeys("Anchovy");
	}
	
	public static void clicksearch() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ContainerSearchWP_ContainerSearch_Search']"))).click();

		
	} 
	
	public static void containerelligibleforholdtxn() throws InterruptedException {
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='a595a30c']/td[1]"))).click();
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='306b51bc']/td[1]"))).click();
	
	} 
	
	public static void expandprocess() throws InterruptedException {
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CurrentStatusWP_CollapsibleSectionsAccordion_ctl07_ContainerSearchFilters_Spec_Edit']"))).sendKeys("Start");
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CurrentStatusWP_CollapsibleSectionsAccordion_ctl05_ContainerSearchFilters_Product_Edit']"))).sendKeys("Anchovy");
	}
	
	public static void Selectpage20() throws InterruptedException {
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ContainerSearch_ResultsWP_ContainerSearch_ResultsGrid_pager_left']/table/tbody/tr/td[3]/select"))).click();
		
		}
	public static void clickcurrentstatussearchresults() throws InterruptedException {
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='jqgh_ctl00_WebPartManager_ContainerSearch_ResultsWP_ContainerSearch_ResultsGrid_cb']/label"))).click();
		
		}
	
	public static void clicknextbutton() throws InterruptedException {
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='next_ctl00_WebPartManager_ContainerSearch_ResultsWP_ContainerSearch_ResultsGrid_pager']/span"))).click();
		
		}

	
    public static void reloadActions() throws InterruptedException {
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='refresh_ctl00_WebPartManager_ContainerSearch_ResultsWP_ContainerSearch_ResultsGrid']/div/span"))).click();
	
	}

/*	************************************************* END of Container Search Page ************************************************************************************************************ */

/******************************************************* HOLD(Multiple)POPUP   ***************************************************************************************************************** */   	
    
    public static void Holdmultiple() throws InterruptedException {
        Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("apollo");
		driver.findElement(By.className("ui-tabs-close")).click();
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='More...'])[2]")));
		WebElement More = driver.findElement(By.xpath("(//*[text()='More...'])[2]"));
		More.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@button-id='Container']")));
		WebElement Search = driver.findElement(By.xpath("//*[@button-id='Container']"));
		Search.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Hold (Multiple)']")));
		driver.findElement(By.xpath("//*[text()='Hold (Multiple)']")).click();
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
               

      public static void expandholdreason() throws InterruptedException {	
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_MultiContainerHoldWP_Reason_Edit']")));
      }
      
      public static void selectcancelorder() throws InterruptedException {	
    	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_MultiContainerHoldWP_Reason_Edit']"))).sendKeys("Cancelled Order");
          }
     
      public static void expandshowadditionalfields() throws InterruptedException {	
    	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_MultiContainerHoldWP_CommentsField_CollapseImage']"))).click();
          }

      public static void clickholdselectedbutton() throws InterruptedException {	
    	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_MultiContainerHoldWP_Reason_Imbt']"))).click();
    	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j1_1_anchor']"))).click();
    	  
          }
      
      public static void checkhidesuccessfultrans() throws InterruptedException {	
    	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_MultiContainerHoldWP_HideSuccessfullTransactions']/label"))).click();
          }
      
      public static void uncheckhidesuccessfultrans() throws InterruptedException {	
    	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_MultiContainerHoldWP_HideSuccessfullTransactions']/label"))).click();
          }
        
      public static void closetheholdmultiplepopupform() throws InterruptedException {	
    	  driver.switchTo().defaultContent();
  		 driver.switchTo().frame("apollo");
    	  driver.findElement(By.className("ui-tabs-close")).click();
          }
/******************************************************* END HOLD(Multiple)POPUP   ***************************************************************************************************************** */   
      
/********************************************   Start Release (Multiple)POPUP    ************************************************************************************************************************* */ 
     
        public static void Clickreleasemultiplebutton() throws InterruptedException {	
        	
        	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_MultiContainerReleaseWP_Reason_Imbt']"))).click();
        	
        }

        public static void Selectnewmaterialsfromdropdown() throws InterruptedException {	
        	
       	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j1_2_anchor']"))).click();
       	
       }
      
        public static void closethereleasemultiplepopupform() throws InterruptedException {	
      	  driver.switchTo().defaultContent();
    	 driver.switchTo().frame("apollo");
      	  driver.findElement(By.className("ui-tabs-close")).click();
            }
      
/******************************************************* END RELEASE(Multiple)POPUP   ***************************************************************************************************************** */      
      
/********************************************   CONTAINER SEARCH- Historic Filters   ************************************************************************************************************************* */      
        public static void Startrelease() throws InterruptedException {
            Thread.sleep(3000);
      		driver.switchTo().defaultContent();
      		driver.switchTo().frame("apollo");
      		driver.findElement(By.className("ui-tabs-close")).click();
      		driver.switchTo().defaultContent();
      		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='More...'])[2]")));
      		WebElement More = driver.findElement(By.xpath("(//*[text()='More...'])[2]"));
      		More.click();
      		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@button-id='Container']")));
      		WebElement Search = driver.findElement(By.xpath("//*[@button-id='Container']"));
      		Search.click();
      		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Release (Multiple)']")));
      		driver.findElement(By.xpath("//*[text()='Release (Multiple)']")).click();
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
      					
      				}
      			}}

               
        public static void clickhistorttab() throws InterruptedException {	
        	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CurrentStatusWP_CollapsibleSectionsAccordion_ctl10_Label']"))).click();
        	 
              }
        
        public static void selectoperation1() throws InterruptedException {	
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CurrentStatusWP_CollapsibleSectionsAccordion_ctl11_ContainerSearchFilters_OperationHistory_Imbt']"))).click();
       	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j1_8_anchor']"))).click();
       	 
             }
        
        public static void startandenddate() throws InterruptedException {	
          	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CurrentStatusWP_CollapsibleSectionsAccordion_ctl11_CollapsableAccordionSectionTable']/div[5]/div/span/button"))).click();
          	 //pending on mouse click
          	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_CurrentStatusWP_CollapsibleSectionsAccordion_ctl11_CollapsableAccordionSectionTable']/div[6]/div/span/button"))).click();
          	 
                }
        
        //86 and 87 steps pending
        
        public static void clicklastbutton() throws InterruptedException {	
          	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='last_ctl00_WebPartManager_ContainerSearch_ResultsWP_ContainerSearch_ResultsGrid_pager']/span"))).click();
          	 
                }
        
        public static void clickpreviouspagebutton() throws InterruptedException {
    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='prev_ctl00_WebPartManager_ContainerSearch_ResultsWP_ContainerSearch_ResultsGrid_pager']/span"))).click();
    	}
    	
        public static void selectpage17() throws InterruptedException {
    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click();
    	}
    	
        public static void Clicknextpagebutton() throws InterruptedException {
    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='next_ctl00_WebPartManager_ContainerSearch_ResultsWP_ContainerSearch_ResultsGrid_pager']/span"))).click();
    	}
        public static void Clickfirstpagebutton() throws InterruptedException {
    	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='first_ctl00_WebPartManager_ContainerSearch_ResultsWP_ContainerSearch_ResultsGrid_pager']/span"))).click();
        }
        public static void clickallcheckboxes() throws InterruptedException {
   		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='jqgh_ctl00_WebPartManager_ContainerSearch_ResultsWP_ContainerSearch_ResultsGrid_cb']/label"))).click();
   		
   		}
        
        
 /********************************************  END CONTAINER SEARCH- Historic Filters   ************************************************************************************************************************* */       
 /********************************************  START Move non-std(Multiple) popup    ************************************************************************************************************************* */       
        public static void ContainerSearchforMovenonstdmultiple() throws InterruptedException {
             Thread.sleep(3000);
    		driver.switchTo().defaultContent();
    		driver.switchTo().frame("apollo");
    		driver.findElement(By.className("ui-tabs-close")).click();
    		driver.switchTo().defaultContent();
    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='More...'])[2]")));
    		WebElement More = driver.findElement(By.xpath("(//*[text()='More...'])[2]"));
    		More.click();
    		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@button-id='Container']")));
    		WebElement Search = driver.findElement(By.xpath("//*[@button-id='Container']"));
    		Search.click();
    		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("Move Non-Std (Multiple)")));
    		driver.findElement(By.xpath("//*[text()='Move Non-Std (Multiple)']")).click();
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
    					
    				}
    			}}
    	
        
        
        public static void expandtheworkflowdropdown() throws InterruptedException {
      		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_MultiContainerMoveNonStdWP_ToWorkflow_Imbt']"))).click();
      		
      		}   
        
        public static void expandstanardworkflowindropdown() throws InterruptedException {
     		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j1_43_anchor']"))).click();
     		
     		}   
        //pending
        public static void expandstanardROR() throws InterruptedException {
    		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click();
    		
    		} 
      //pending
        public static void selectsaucestep() throws InterruptedException {
    		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click();
    		
    		} 
      //pending
        public static void clickmoveselectedbutton() throws InterruptedException {
    		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click();
    		
    		} 
                
     //    checkhidesuccessfultrans();
    //	uncheckhidesuccessfultrans();
        
        public static void closethemoveNonstdmultiplepopup() throws InterruptedException {	
      	  driver.switchTo().defaultContent();
    		 driver.switchTo().frame("apollo");
      	  driver.findElement(By.className("ui-tabs-close")).click();
            }
        
 /******************************************** END Move non-std(Multiple) popup  ************************************************************************************************************************* */        
        
 /********************************************  START QUALITY SEARCH  ************************************************************************************************************************* */        
     
        public static void QualitySearch() throws InterruptedException {

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
    		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Quality Search']")));
    		driver.findElement(By.xpath("//*[text()='Quality Search']")).click();
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
    					
    				}
    			}}
    	
        public static void clicksearchbuttoninqualitysearch() throws InterruptedException {
   		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ButtonsWP_SearchButton']"))).click();
   		
   		} 
        
/********************************************  END QUALITY SEARCH  ************************************************************************************************************************* */        
/********************************************  START MANAGE P/E  ************************************************************************************************************************* */      
       
        public static void clickonresult() throws InterruptedException {
      		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click();
      		
      		} 
        public static void clickseteditbutton() throws InterruptedException {
     		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click();
     		
     		} 
        public static void clickfailurestab() throws InterruptedException {
    		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click();
    		
    		}
        public static void Expandfailuremodedropdown() throws InterruptedException {
   		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click();
   		
   		}
        public static void Selectfm01fromfailuremodedropdown() throws InterruptedException {
      		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click();
      		
      		}
        public static void Clickaddfailurebutton() throws InterruptedException {
     		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click();
     		
     		}
        public static void Clicksave() throws InterruptedException {
    		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click();
    		
    		}
        public static void Clickoninvestigationtab() throws InterruptedException {
   		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click();
   		
   		}
        public static void Expandcausecodedropdown() throws InterruptedException {
      		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click();
      		
      		}
        public static void SelectNCRcausecode1fromdropdown() throws InterruptedException {
     		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click();
     		
     		}
        public static void Clickthesetviewmodebutton() throws InterruptedException {
    		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click();
    		
    		}
/******************************************** END START MANAGE P/E  ************************************************************************************************************************* */        
        
/********************************************LINE ASSIGNMENT  ************************************************************************************************************************* */       
        
        public static void LineAssignment() throws InterruptedException {
            Thread.sleep(3000); 
    		driver.switchTo().defaultContent();
    		driver.switchTo().frame("apollo");
    		driver.findElement(By.className("ui-tabs-close")).click();
    		driver.switchTo().defaultContent();
    		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='More...'])[3]")));
    		WebElement More = driver.findElement(By.xpath("(//*[text()='More...'])[3]"));
    		More.click();
    		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@button-id='cmdSettings']")));
    		WebElement Search = driver.findElement(By.xpath("//*[@button-id='cmdSettings']"));
    		Search.click();
    		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Set Line Assignment']")));
    		driver.findElement(By.xpath("//*[text()='Set Line Assignment']")).click();
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
    					
    				}
    			}}
    	      
        public static void Expandworkcenterdropdown() throws InterruptedException {
   		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_LineAssignmentWP_Control_Workcenter_Imbt']"))).click();
   		}
         
        public static void Selectpackshipfromdropdown() throws InterruptedException {
      	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j1_1_anchor']"))).click();
      		}
        
        public static void Expandoperationdropdown() throws InterruptedException {
      		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_LineAssignmentWP_Control_Operation_Imbt']"))).click();
      		}
        public static void Selectpackagingfromdropdown() throws InterruptedException {
     		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j2_1_anchor']"))).click();
     		}
        public static void Expandresourceworkcelldropdown() throws InterruptedException {
     		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_LineAssignmentWP_Control_ResourceWorkcell_Imbt']"))).click();
     		}
       public static void Selectpackager1dropdown() throws InterruptedException {
    		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j3_1']/div"))).click();
    		}
       public static void Clicksetlineassignmentbutton() throws InterruptedException {
  		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='ctl00_WebPartManager_ButtonsBar_SetAssignment']"))).click();
  		}
       //pending //no data to clear
       public static void Reopenlineassignment() throws InterruptedException {
    		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click();
    		}
        
/******************************************** END LINE ASSIGNMENT  ************************************************************************************************************************* */       
/******************************************** START ESIG MULTI  ************************************************************************************************************************* */       
       
       
       
       
       
       public static void Selectcontainertohold() throws InterruptedException {
   		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click();
   		}
       
       public static void Expandholdreasondropdown() throws InterruptedException {
     		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(""))).click();
     		}
       
       
       
       
       
        
        
}   

	
	



