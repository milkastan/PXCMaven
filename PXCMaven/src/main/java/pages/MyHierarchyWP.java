package pages;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyHierarchyWP extends LoadableComponent<MyHierarchyWP> {
	private final static String title = "Vis min organisasjon";
	WebDriverWait wait = new WebDriverWait(Browser.driver, 60);
	
	//My Hierarchy filters by WP Type
    @FindBy(how=How.ID, using ="ddlHierarchyType_arrow")
	 WebElement MHTypesArrow;
    @FindBy(how=How.LINK_TEXT,using="Registrert brukersteder")
	 WebElement MHRegisteredWP;
    @FindBy(how=How.LINK_TEXT,using="Uregistrert brukersteder")
	 WebElement MHURWP;
    @FindBy(how=How.LINK_TEXT,using="Uregistrert i mitt område")
	 WebElement MHURWP_MyArea;
    
    //My Hierarchy filters by WP scope
    @FindBy(how=How.ID, using ="ddlWorkplacesScope_arrow")
	 WebElement MHWPScopeArrow;
    @FindBy(how=How.ID, using ="ddlWorkplacesScope_msa_0")
	 WebElement MHActiveWP;
    @FindBy(how=How.ID, using ="ddlWorkplacesScope_msa_1")
	 WebElement MHAllWP;
    
    //My Hierarchy filters for delivery
    @FindBy(how=How.ID, using ="ddlFilter_arrow")
	 WebElement MHDeliveryArrow;
    @FindBy(how=How.ID, using ="ddlFilter_msa_0")
	 WebElement MHDeliveryAll;
    @FindBy(how=How.ID, using ="ddlFilter_msa_1")
	 WebElement MHNonDelivered;
    @FindBy(how=How.LINK_TEXT, using ="NAVN")
	 WebElement MHName;
            
    //My Hierarchy left menus elements
    //@FindBy(how=How.LINK_TEXT, using ="SDSer på brukersted")
    @FindBy(how=How.LINK_TEXT, using ="SDS i min organisasjon")
  	 WebElement SDSonWPmenu;
    @FindBy(how=How.ID, using ="cpmain_ucSDSList_lblSDSinListCount")
	 WebElement CompSDSCount;
     //@FindBy(how=How.LINK_TEXT, using ="Produkter på brukerstedet")
    @FindBy(how=How.LINK_TEXT, using ="Produkter i min organisasjon")
 	 WebElement ProductsonWPs;
	@FindBy(how=How.ID, using ="cpmain_ucProductList_lblProductsInListCount")
	 WebElement CompProductsCount;
     @FindBy(how=How.LINK_TEXT, using ="Brukersteder")
	 WebElement WokrplacesMenu;
     @FindBy(how=How.LINK_TEXT, using ="Opprett brukersted")
	 WebElement CreateWPmenu;
     
    
    //Search TAB, field and button
    @FindBy(how=How.ID, using ="cpmain_tree_txtValueToSearch")
  	 WebElement SearchField;
    @FindBy(how=How.ID, using ="cpmain_tree_lblBtnSearch")
  	 WebElement SearchBtn;
    //@FindBy(how=How.XPATH, using ="//table[@id='cpmain_tree_rbtnTreeMode']/tbody/tr/td[2]/label")
    @FindBy(how=How.ID, using ="cpmain_tree_rbtnTreeMode_1")
    WebElement SearchTABBtn;
    //@FindBy(how=How.XPATH, using ="//table[@id='cpmain_tree_rbtnTreeMode']/tbody/tr/td[1]/label")
    @FindBy(how=How.ID, using ="cpmain_tree_rbtnTreeMode_0")
    WebElement WPsTABBtn;
    
    //view WP from the first returned item used by ViewWP method
    @FindBy(how=How.ID, using="rptNodesOnLevel_menu_0")
  	 WebElement WPMenuIcon;
    @FindBy(how=How.ID, using="rptNodesOnLevel_hlnkView_0")
     WebElement ViewWPmenu;
	
	//two methods from LoadableComponents
	@Override
	protected void load() {
	}
	@Override
	protected void isLoaded() throws Error {
	  Assert.assertTrue("Expected page title is not as actual",Browser.driver().getTitle().equals(title));
	  System.out.println("Loaded page: "+Browser.driver().getTitle());
	}
	
	public MyHierarchyWP() {
	   PageFactory.initElements(Browser.driver, this);
    }
	

    public MyHierarchyWP MHSelect_URW () {
    	System.out.println("Selected menu Unregistered workplaces");
    	wait.until(ExpectedConditions.elementToBeClickable(MHTypesArrow));
    	MHTypesArrow.click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlHierarchyType_msa_1")));
    	MHURWP.click();
    	wait.until(ExpectedConditions.elementToBeClickable(MHTypesArrow));
    	System.out.println("--------------------------------------------");
    	return this;
    }
    
    public MyHierarchyWP MHSelect_URW_Area () {
    	System.out.println("Selected menu Unregistered workplaces in my area");
    	wait.until(ExpectedConditions.elementToBeClickable(MHTypesArrow));
    	MHTypesArrow.click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlHierarchyType_msa_2")));
    	MHURWP_MyArea.click();
    	wait.until(ExpectedConditions.elementToBeClickable(MHTypesArrow));
    	System.out.println("--------------------------------------------");
    	return this;
     }
    
    public void MHSelect_RegisteredWP () {
    	System.out.println("Selected menu Registered workplaces");
    	wait.until(ExpectedConditions.elementToBeClickable(MHTypesArrow));
    	MHTypesArrow.click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ddlHierarchyType_msa_0")));
    	MHRegisteredWP.click();
    	wait.until(ExpectedConditions.elementToBeClickable(MHTypesArrow));
    	System.out.println("--------------------------------------------");
      }
    
    public MyHierarchyWP MHSelect_AllWP () {
    	System.out.println("Selected menu All workplaces");
       	MHWPScopeArrow.click();
    	MHAllWP.click();
    	Browser.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	System.out.println("--------------------------------------------");
    	return this;
    }
    
    public MyHierarchyWP MHSelect_ActiveWP () {
    	System.out.println("Selected menu Active workplaces");
    	MHWPScopeArrow.click();
    	MHActiveWP.click();
    	Browser.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	System.out.println("--------------------------------------------");
    	return this;
    }
    
    public MyHierarchyWP MHSelect_NonDelivered () {
    	System.out.println("Selected menu Nondelivered workplaces");
    	MHDeliveryArrow.click();
       	MHNonDelivered.click();
    	Browser.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	System.out.println("--------------------------------------------");
    	return this;
    }
    
    public MyHierarchyWP MHSelect_DeliveredAll () {
    	System.out.println("Selected menu All workplaces");
    	MHDeliveryArrow.click();
       	MHDeliveryAll.click();
    	Browser.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    	System.out.println("--------------------------------------------");
    	return this;
    }
    
    public void CheckMyHierarchyWPFilters() {
    	//Change WP type
    	MHSelect_URW();
    	MHSelect_URW_Area();
    	MHSelect_RegisteredWP();
        //change WP scope
    	MHSelect_AllWP();
    	MHSelect_ActiveWP();
        //Show all and with nondelivery
    	MHSelect_NonDelivered();
    	MHSelect_DeliveredAll();
    }

    //Select TAB Search implemented as radio button
    public void MHSelectSearchTAB() {
    	List<WebElement> tabs = Browser.driver.findElements(By.name("ctl00$cpmain$tree$rbtnTreeMode"));
    	//System.out.println("tabs size:"+tabs.size());
    	tabs.get(1).click();
    	System.out.println("Selected Search TAB");
    }
   
    //Select TAB Workplaces implemented as radio button
    public void MHSelectWPTAB() {
    	List<WebElement> tabs = Browser.driver.findElements(By.name("ctl00$cpmain$tree$rbtnTreeMode"));
    	//System.out.println("tabs size:"+tabs.size());
    	tabs.get(1).click();
    	System.out.println("Selected Workplaces TAB");
    }
    
	public MyHierarchyWP TestSelectDD (int op) {
 	 //wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ddlHierarchyType_arrow")));
     MHTypesArrow.click();
     System.out.println("Arrow is clicked");
     Browser.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	 WebElement dd = Browser.driver.findElement(By.xpath("//div[@id='ddlHierarchyType_child']"));
	 List<WebElement> options = dd.findElements(By.xpath("//div[@id='ddlHierarchyType_child']/a"));
     System.out.println("tabs size:"+options.size());
	 System.out.println("Click option:"+options.get(op).getText());
     if (options.get(op).isDisplayed()) {
	     options.get(op).click();  
	     System.out.println("Option is selectged");
	     wait.until(ExpectedConditions.elementToBeClickable(MHTypesArrow));   
     }
	     else 
		 { System.out.println("Option is not visible");  }
      return new MyHierarchyWP();
	}
	
	
	 //select menu SDS on workplaces
		public SDSonWPs SelectSDSonWPs() {
			long start = System.currentTimeMillis();
			try {
			SDSonWPmenu.click();
			System.out.println("Selected menu SDS in my organization");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_ucSDSList_lblSDSinList")));
			} catch (NoSuchElementException e) {
				System.out.println("Failed opening Products in my organization");
			} finally {
				long start1 = System.currentTimeMillis();
				System.out.println("Failed opening SDS in my organization first time");
				SDSonWPmenu.click();
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_ucSDSList_lblSDSinList")));
				long finish1 = System.currentTimeMillis();
				long totalTime1 = (finish1-start1);
				System.out.println("Page Load Time2: "+totalTime1+" [ms]");
				System.out.println("SDS in the company:"+CompSDSCount.getText());
			}
			 long finish = System.currentTimeMillis();
			 long totalTime = (finish-start);
	    	 System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblSDSMyHierarchy")).getText());
	    	 System.out.println("Page Load Time [ms]: "+totalTime+" [ms]");
	    	 System.out.println("SDS in the company:"+CompSDSCount.getText());
	    	 System.out.println("--------------------------------------------");
			return new SDSonWPs();	
		}
		//select menu products on workplaces
		public ProductsonWPs SelectPRonWPs() {
			long start = System.currentTimeMillis();
			try {
			ProductsonWPs.click();
			System.out.println("Selected menu Products in my organization");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_ucProductList_lblProductsInList")));
			} catch (NoSuchElementException e) {
				System.out.println("Failed opening Products in my organization");
			}finally  {
				long start1 = System.currentTimeMillis();
				System.out.println("Failed opening Products in my organization first time");
				ProductsonWPs.click();
				wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_ucProductList_lblProductsInList")));
				 long finish1 = System.currentTimeMillis();
				 long totalTime1 = (finish1-start1);
				 System.out.println("Page Load Time2: "+totalTime1+" [ms]");
				System.out.println("Products in the company:"+CompProductsCount.getText());
			}
			 long finish = System.currentTimeMillis();
			 long totalTime = (finish-start);
	    	 System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
	    	 System.out.println("Page Load Time: "+totalTime+" [ms]");
	    	 System.out.println("Products in the company:"+CompProductsCount.getText());
	    	 System.out.println("--------------------------------------------");
			return new ProductsonWPs();	
		}
			
		
		//select menu my hierarchy workplaces
		public MyHierarchyWP SelectWorkplaces() {
			WokrplacesMenu.click();
			System.out.println("Selected menu My Hierarchy workplaces");
			 wait.until(ExpectedConditions.visibilityOf(SearchField));
	    	 System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblViewMyHierarchy")).getText());
	    	 System.out.println("--------------------------------------------");
			return this;	
		}
		
		//select menu CreateWP
		public CreateWPWizard SelectCreateWPmenu() {
			CreateWPmenu.click();
			System.out.println("Selected menu Create new workplace");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
			System.out.println("--------------------------------------------");
			return new CreateWPWizard();	
		}
		
	
		public MyHierarchyWP SearchWP(String wp)  {
			System.out.println("Search for workplace: "+wp);
			//((JavascriptExecutor) Browser.driver).executeScript("window.scrollBy(0,250)", "");
			//Actions action = new Actions(Browser.driver);
			Common.ScrollToElement(SearchField);
			wait.until(ExpectedConditions.elementToBeClickable(SearchField));
			SearchField.sendKeys(wp);
			wait.until(ExpectedConditions.elementToBeClickable(SearchBtn));
			//action.moveToElement(SearchBtn).perform();
			SearchBtn.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+wp+"']")));
			SearchField.clear();
			System.out.println("--------------------------------------------");
			Browser.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			return this;
		}
		
		//View workplace from the search result list-row selected by WP Name
		public WPDashboard2 ViewWP2 (String wp) {
			System.out.println("Select View workplace: "+wp);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+wp+"']/../following-sibling::*[@class='workplaceMenu']")));
			WebElement WPMenuIcon2 =Browser.driver.findElement(By.xpath("//*[text()='"+wp+"']/../following-sibling::*[@class='workplaceMenu']"));
			WPMenuIcon2.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+wp+"']/../following-sibling::div/ul/li/a[text()='Vis']")));
			WebElement ViewMenu2 = Browser.driver.findElement(By.xpath("//*[text()='"+wp+"']/../following-sibling::div/ul/li/a[text()='Vis']"));
			ViewMenu2.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblWorkplaceNameTitle")));
			System.out.println("--------------------------------------------");
			return new WPDashboard2();
		}
		
		//View workplace from the search result list-row selected by WP Name
		public WPDashboard ViewWP (String wp) {
			System.out.println("Select View workplace: "+wp);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+wp+"']/../following-sibling::*[@class='workplaceMenu']")));
			WebElement WPMenuIcon2 =Browser.driver.findElement(By.xpath("//*[text()='"+wp+"']/../following-sibling::*[@class='workplaceMenu']"));
			WPMenuIcon2.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+wp+"']/../following-sibling::div/ul/li/a[text()='Vis']")));
			WebElement ViewMenu2 = Browser.driver.findElement(By.xpath("//*[text()='"+wp+"']/../following-sibling::div/ul/li/a[text()='Vis']"));
			ViewMenu2.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblWorkplaceNameTitle")));
			System.out.println("--------------------------------------------");
			return new WPDashboard();
		}
		
		//View workplace from the search result list-row selected by WP Name
		public WPDashboard AViewWP (String wp) {
			System.out.println("Select View workplace: "+wp);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+wp+"']/../following-sibling::*[@class='workplaceMenu']")));
			Actions action = new Actions(Browser.driver);
			WebElement WPMenuIcon2 =Browser.driver.findElement(By.xpath("//*[text()='"+wp+"']/../following-sibling::*[@class='workplaceMenu']"));
			//WPMenuIcon2.click();
			action.click(WPMenuIcon2).perform();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+wp+"']/../following-sibling::div/ul/li/a[text()='Vis']")));
			WebElement ViewMenu2 = Browser.driver.findElement(By.xpath("//*[text()='"+wp+"']/../following-sibling::div/ul/li/a[text()='Vis']"));
			//ViewMenu2.click();
			action.click(ViewMenu2).perform();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblWorkplaceNameTitle")));
			System.out.println("--------------------------------------------");
			return new WPDashboard();
		}
		
		public MyHierarchyWP ViewWPMenus(String wp) {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+wp+"']/../following-sibling::*[@class='workplaceMenu']")));
			WebElement WPMenuIcon3 =Browser.driver.findElement(By.xpath("//*[text()='"+wp+"']/../following-sibling::*[@class='workplaceMenu']"));
			WPMenuIcon3.click();
			List<WebElement> elements = Browser.driver.findElements(By.xpath("//*[text()='"+wp+"']/../following-sibling::div/ul/li/a"));
			 for(WebElement ele : elements){     
	              	 System.out.println("Workplace menus"+ele.getText()+" "); 
	             }
		return this;
		}
		
		//select Edit some WP
		public CreateWPWizard SelectEditWPmenu(String wp) {
			System.out.println("Select Edit workplace: "+wp);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+wp+"']/../following-sibling::*[@class='workplaceMenu']")));
			WebElement WPMenuIcon2 =Browser.driver.findElement(By.xpath("//*[text()='"+wp+"']/../following-sibling::*[@class='workplaceMenu']"));
			WPMenuIcon2.click();
			WebElement EditWPWPMenu = Browser.driver.findElement(By.xpath("//*[text()='"+wp+"']/../following-sibling::div/ul/li/a[text()='Rediger']"));
			EditWPWPMenu.click();	
			System.out.println("--------------------------------------------");
			return new CreateWPWizard();	
		}
		
		public MyHierarchyWP DeleteWP(String wp) {
			System.out.println("Select Delete workplace: "+wp);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+wp+"']/../following-sibling::*[@class='workplaceMenu']")));
			WebElement WPMenuIcon2 =Browser.driver.findElement(By.xpath("//*[text()='"+wp+"']/../following-sibling::*[@class='workplaceMenu']"));
			WPMenuIcon2.click();
			WebElement DeleteWPMenu = Browser.driver.findElement(By.xpath("//*[text()='"+wp+"']/../following-sibling::div/ul/li/a[text()='Slett']"));
			DeleteWPMenu.click();	
			ConfirmPopUpOK();
			System.out.println("--------------------------------------------");
			return this;
		}
		
		public MyHierarchyWP AddWPtoUserDashboard(String wp) {
			System.out.println("Select Add to user dashboard workplace: "+wp);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+wp+"']/../following-sibling::*[@class='workplaceMenu']")));
			WebElement WPMenuIcon2 =Browser.driver.findElement(By.xpath("//*[text()='"+wp+"']/../following-sibling::*[@class='workplaceMenu']"));
			WPMenuIcon2.click();
			List<WebElement> elements = Browser.driver.findElements(By.xpath("//*[text()='"+wp+"']/../following-sibling::div/ul/li/a"));
			String AddUDMenu ="Legg til dashbord";
			Boolean mnufound=false;
			for(WebElement ele : elements){   
				 if (AddUDMenu.equals(ele.getText())) {
					 mnufound=true;
	            	 ele.click();
	            	 break;
	             }
			}		 
	        if (mnufound) {
				 System.out.println("Workplace "+wp+" is added to user dashboard");
	        } else {
	             System.out.println("Workplace "+wp+" exists on user dashboard");	
	            }
	     
			System.out.println("--------------------------------------------");
			return this;
		}
		
		public MyHierarchyWP DeleteMultipleWP(String[] arr) {
			for (int i=0;i<arr.length;i++) {
			Browser.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			WPsTABBtn.click();
			SearchWP(arr [i]);
			System.out.println("Select Delete workplace: "+arr[i]);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+arr[i]+"']/../following-sibling::*[@class='workplaceMenu']")));
			WebElement WPMenuIcon2 =Browser.driver.findElement(By.xpath("//*[text()='"+arr[i]+"']/../following-sibling::*[@class='workplaceMenu']"));
			WPMenuIcon2.click();
			WebElement DeleteWPMenu = Browser.driver.findElement(By.xpath("//*[text()='"+arr[i]+"']/../following-sibling::div/ul/li/a[text()='Slett']"));
			DeleteWPMenu.click();	
			ConfirmPopUpOK();
			}
			System.out.println("--------------------------------------------");
			return this;
		}
		
		public MyHierarchyWP ArchiveWP(String wp) {
			System.out.println("Select Archive workplace: "+wp);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+wp+"']/../following-sibling::*[@class='workplaceMenu']")));
			WebElement WPMenuIcon2 =Browser.driver.findElement(By.xpath("//*[text()='"+wp+"']/../following-sibling::*[@class='workplaceMenu']"));
			WPMenuIcon2.click();
			WebElement ArchiveWPMenu = Browser.driver.findElement(By.xpath("//*[text()='"+wp+"']/../following-sibling::div/ul/li/a[text()='Arkiv']"));
			ArchiveWPMenu.click();	
			ConfirmPopUpOK();
			System.out.println("--------------------------------------------");
			return this;
		}
		
		public MyHierarchyWP UnArchiveWP(String wp) {
			System.out.println("Select Unarchive workplace: "+wp);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+wp+"']/../following-sibling::*[@class='workplaceMenu']")));
			WebElement WPMenuIcon2 =Browser.driver.findElement(By.xpath("//*[text()='"+wp+"']/../following-sibling::*[@class='workplaceMenu']"));
			WPMenuIcon2.click();
			WebElement UnArchiveWPMenu = Browser.driver.findElement(By.xpath("//*[text()='"+wp+"']/../following-sibling::div/ul/li/a[text()='Dearkiver']"));
			UnArchiveWPMenu.click();	
			ConfirmPopUpOK();
			System.out.println("--------------------------------------------");
			return this;
		}
		
		public void ConfirmPopUpOK() {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='popup_ok']")));
			WebElement OKBtn = Browser.driver.findElement(By.xpath("//*[@id='popup_ok']"));
			WebElement MessageText =Browser.driver.findElement(By.xpath("//*[@id='popup_message']"));
			System.out.println(MessageText.getText());
			OKBtn.click();
			//wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='popup_ok']"))));
		}
		
		public void ConfirmPopUpCancel() {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='popup_cancel']")));
			WebElement CancelBtn = Browser.driver.findElement(By.xpath("//*[@id='popup_cancel']"));
			WebElement MessageText =Browser.driver.findElement(By.xpath("//*[@id='popup_message']"));
			System.out.println(MessageText.getText());
			CancelBtn.click();
			//wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='popup_ok']"))));
		}
}
