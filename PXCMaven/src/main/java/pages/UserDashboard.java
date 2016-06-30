package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserDashboard extends LoadableComponent<UserDashboard>  {
	
	private final static String title = "Min organisasjon";
	WebDriverWait wait = new WebDriverWait(Browser.driver, 30);
	
      //Main menu TAB buttons 
	  @FindBy(how=How.LINK_TEXT, using ="Dashbord")
	   WebElement UserDashboardBtn;
	  @FindBy(how=How.LINK_TEXT, using ="Min organisasjon")
	   WebElement MyHierarchyBtn;
       @FindBy(how=How.LINK_TEXT, using ="Risikovurdering")
	   WebElement RiskAssBtn;
       @FindBy(how=How.LINK_TEXT, using ="Informasjonsblad")
	   WebElement InfoSheetBtn;
       @FindBy(how=How.LINK_TEXT, using ="Produktvurdering")
	   WebElement ProductAssBtn;
       @FindBy(how=How.LINK_TEXT, using ="Verktøy")
   	   WebElement ToolsBtn;
       @FindBy(how=How.LINK_TEXT, using ="Min brukerkonto")
   	   WebElement MyAccountBtn;
      
      //workplace summary links
 	  @FindBy(how=How.ID, using ="cpmain_repWorkplaces_wpSummary_0_ctl01_0_hlnkProducts_0")
	   WebElement UDProducts;
 	  @FindBy(how=How.ID, using ="cpmain_repWorkplaces_wpSummary_0_ctl01_0_hlnkSDSs_0")
	   WebElement UDSDS;
 	  @FindBy(how=How.ID, using ="cpmain_repWorkplaces_wpSummary_0_ctl01_0_hlnkDocuments_0")
	   WebElement UDDocuments;
	  @FindBy(how=How.ID, using ="cpmain_repWorkplaces_wpSummary_0_ctl01_0_hlnkSuggestedUwp_0")
	   WebElement UDURW;
	  @FindBy(how=How.ID, using ="cpmain_repWorkplaces_wpSummary_0_ctl01_0_hlnkImportedCompanies_0")
	   WebElement UDInvitedComp;
	  @FindBy(how=How.ID, using ="cpmain_repWorkplaces_wpSummary_0_ctl01_0_hlnkDepartments_0")
	   WebElement UDSubWP;
	  @FindBy(how=How.ID, using ="cpmain_repWorkplaces_wpSummary_0_ctl01_0_hlnkDeviations_0")
	   WebElement UDDeviations;
 	  
 	 
	  public UserDashboard() {
		  PageFactory.initElements(Browser.driver, this);
		  }
	  
		@Override
		protected void load() {
		}
		
		@Override
		protected void isLoaded() throws Error {
		  Assert.assertTrue("Expected page title is not as actual",Browser.driver().getTitle().equals(title));
		  System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblMyDashboard")).getText());
		  System.out.println("--------------------------------------------");
		}
		
		/* function has to be fixed
		public UserDashboard ViewLoggedUserName () {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ucLoginStatus_imgLoggedIn")));
			unames = Browser.driver.findElement(By.id("ucLoginStatus_imgLoggedIn")).getText();
			System.out.println(unames);
			return new UserDashboard();
		}  */
		
     public  MyHierarchyWP navigateToMyHierarchy() {
    	 MyHierarchyBtn.click();
    	 System.out.println("Selected main menu My Hierarchy");
    	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblViewMyHierarchy")));
    	 System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblViewMyHierarchy")).getText());
    	 System.out.println("--------------------------------------------");
    	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tree_lblBtnSearch")));
    	 return new MyHierarchyWP();
	}
	
     public  InformationSheet navigateToInformationSheet() {
    	 InfoSheetBtn.click();
    	 System.out.println("Selected main menu Information Sheet");
    	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblInstructionsListTitle")));
    	 System.out.println("Loaded page: "+Browser.driver().getTitle());
    	 System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblObjectName")).getText());
    	 System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblInstructionsListTitle")).getText());
    	 System.out.println("--------------------------------------------");
    	 return new InformationSheet();
	}
	
     public  RiskAssessment navigateToRiskAssessment() {
    	 RiskAssBtn.click();
    	 System.out.println("Selected main menu Risk Assessment");
    	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_RAcontent_lblRAListTitle")));
    	 System.out.println("Loaded page: "+Browser.driver().getTitle());
    	 System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblObjectName")).getText());
    	 System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_RAcontent_lblRAListTitle")).getText());
    	 System.out.println("--------------------------------------------");
    	 return new RiskAssessment();
	}
     
     public  ProductAssessmentCenter navigateToProductAssessment() {
    	 ProductAssBtn.click();
    	 System.out.println("Selected main menu Product Assessment");
    	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
    	 System.out.println("Loaded page: "+Browser.driver().getTitle());
       	 System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
    	 System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblAssessedProductsTitle")).getText());
    	 System.out.println("--------------------------------------------");
     	 return new ProductAssessmentCenter();
 	} 
     
     public  Tools navigateToTools() {
    	 ToolsBtn.click();
    	 System.out.println("Selected main menu Tools");
    	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
    	 System.out.println("Loaded page: "+Browser.driver().getTitle());
       	 System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
       	 System.out.println("--------------------------------------------");
     	 return new Tools();
 	} 
     
     public  MyAccount navigateToMyAccount() {
    	 MyAccountBtn.click();
    	 System.out.println("Selected main menu My Account");
    	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_hdrText")));
    	 System.out.println("Loaded page: "+Browser.driver().getTitle());
       	 System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_hdrText")).getText());
       	System.out.println("--------------------------------------------");
     	 return new MyAccount();
 	} 
     
     public  UserDashboard navigateToUserDashboard() {
    	 UserDashboardBtn.click();
    	 System.out.println("Selected main menu Dashboard");
    	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblMyDashboard")));
       	 System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblMyDashboard")).getText());
       	 System.out.println("--------------------------------------------");
     	 return this;
 	} 
     
     public Boolean FindWPonDashboard(String wp) {
    	 Boolean wpadded = false;
    	 List<WebElement> elements = Browser.driver.findElements(By.xpath("//*[@class='wpSummaryHeaderTitle']"));
    	 for(WebElement ele : elements){     
             if (wp.equals(ele.getText())) {
            	 System.out.println("Workplace "+ele.getText()+" exists on user dashboard");
            	 wpadded=true;
            	 break;
             }
          }
             //System.out.println(ele.getAttribute("id"));
             //System.out.println(ele.getTagName());
    	 System.out.println("--------------------------------------------");
    	 return wpadded;
     }
     
     public int getWPNumonUserDashboard() {
    	int wpnum=0;
    	List<WebElement> elements = Browser.driver.findElements(By.xpath("//*[@class='wpSummaryHeaderTitle']"));
    	wpnum=elements.size();
    	return wpnum; 
     }
        
     public UserDashboard RemoveWPfromUD(String wp){
    	System.out.println("Remove workplace "+wp+" from user dashboard");
    	if (FindWPonDashboard(wp))  
    	 Browser.driver.findElement(By.xpath("//*[text()='"+wp+"']/../following-sibling::td/div/a/span")).click();
    		Browser.driver.findElement(By.xpath("//a[contains(text(),'> Fjern fra dashbord')]")).click();
    	if (!FindWPonDashboard(wp)) {
    		System.out.println("Workplace: "+wp+"is removed from user dashboard");	
    	}
    	return this;
     }
     
     public UserDashboard RemainOnDashboardWP(String wp) {
    	if (FindWPonDashboard(wp)){  
    	 
    	 List<WebElement> elements = Browser.driver.findElements(By.xpath("//*[@class='wpSummaryHeaderTitle']"));
    	 for(WebElement ele : elements){     
             if (!wp.equals(ele.getText())) {
            	     RemoveWPfromUD(ele.getText());
             }
          }
       	 }
    	 System.out.println("--------------------------------------------");
    	 return this;
     }
     
 	public Products OpenUDProducts() {
		wait.until(ExpectedConditions.elementToBeClickable(UDProducts));
		UDProducts.click();
		System.out.println("Selected link Products");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblProductsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblProductsHeader")).getText());
	   	System.out.println("Dashboard title:"+Browser.driver.findElement(By.id("cpmain_ucWorkplaceSummary_lblName")).getText());	   	
	   	System.out.println("--------------------------------------------");
		return new Products();
	}
 	
	public Chemicals OpenUDChemicals() {
		wait.until(ExpectedConditions.elementToBeClickable(UDSDS));
		UDSDS.click();
		System.out.println("Selected link Chemicals");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblChemicalsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblChemicalsHeader")).getText());
		System.out.println("Dashboard title:"+Browser.driver.findElement(By.id("cpmain_ucWorkplaceSummary_lblName")).getText());
	   	System.out.println("--------------------------------------------");
		return new Chemicals();
	}
	
	public WPDashboard OpenUDDocuments() {
		wait.until(ExpectedConditions.elementToBeClickable(UDDocuments));
		UDDocuments.click();
		System.out.println("Selected link Documents");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return new WPDashboard();
	}
	
	public WPDashboard OpenUDSuggestedURW() {
		wait.until(ExpectedConditions.elementToBeClickable(UDURW));
		UDURW.click();
		System.out.println("Selected link Suggested unregistered workplaces");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return new WPDashboard();
	}
	
	public WPDashboard OpenUDInvitedCompanies() {   
		wait.until(ExpectedConditions.elementToBeClickable(UDInvitedComp));
		UDInvitedComp.click();
		System.out.println("Selected link Invited companies");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return new WPDashboard();
	}
	
	public WPDashboard OpenUDSubworkplaces() {   
		wait.until(ExpectedConditions.elementToBeClickable(UDSubWP));
		UDSubWP.click();
		System.out.println("Selected link Child workplaces");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return new WPDashboard();
	}
	
	public Deviations OpenUDDeviations() {
		wait.until(ExpectedConditions.elementToBeClickable(UDDeviations));
		UDDeviations.click();
		System.out.println("Selected link Deviations");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_ucWorkplaceSummary_lblName")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("hlnkBackToDashboard")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_ucWorkplaceSummary_lblName")).getText());
	   	System.out.println("--------------------------------------------");
		return new  Deviations();
	}
	//Open all links for workplace from user dashboard
	public void OpenUDFirstWPLinks() {
		System.out.println("Open all links for first workplace added to user dashboard");
		System.out.println("Workplace:"+Browser.driver.findElement(By.id("cpmain_repWorkplaces_wpSummary_0_lblName_0")).getText());
		OpenUDProducts();
		navigateToUserDashboard();
		OpenUDChemicals();
		navigateToUserDashboard();
		OpenUDDocuments();
		navigateToUserDashboard();
		OpenUDSuggestedURW();
		navigateToUserDashboard();
		OpenUDInvitedCompanies();
		navigateToUserDashboard();
		OpenUDSubworkplaces();
		navigateToUserDashboard();
		OpenUDDeviations();
		navigateToUserDashboard();
		System.out.println("--------------------------------------------");
		
	}
  }
