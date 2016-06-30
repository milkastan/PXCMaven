package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WPDashboard2 extends LoadableComponent<WPDashboard2> {
	private final static String title = "Brukersted dashbord";
	WebDriverWait wait = new WebDriverWait(Browser.driver, 60);
	DistributeDocuments dd;
	
	  //Workplace related menu items
	  @FindBy(how=How.LINK_TEXT, using ="Vis brukersted")
	  WebElement MenuViewWP;
	  @FindBy(how=How.LINK_TEXT, using ="Opprett brukersted")
	  WebElement MenuCreateSubWP;
	  @FindBy(how=How.LINK_TEXT, using ="Brukersteddetaljer")
	  WebElement MenuWPDetails;
	  @FindBy(how=How.LINK_TEXT, using ="Tilpass filter")
	  WebElement MenuWPFilters;
	  @FindBy(how=How.LINK_TEXT, using ="Brukerstedinformasjon")
	  WebElement MenuWPInfo;
	  @FindBy(how=How.LINK_TEXT, using ="Risikovurdering")
	  WebElement MenuWPRA ;
	  @FindBy(how=How.LINK_TEXT, using ="Informasjonsblad")
	  WebElement MenuWPIS ;
	  @FindBy(how=How.LINK_TEXT, using ="Avfallsplan")
	  WebElement MenuWPWastePlan;
	  @FindBy(how=How.LINK_TEXT, using ="Eksponeringsregister")
	  WebElement MenuWPExpReg ;
	  @FindBy(how=How.LINK_TEXT, using ="Inviter bedrift")
	  WebElement MenuInviteComp ;
	  @FindBy(how=How.LINK_TEXT, using ="Inviter brukersted")
	  WebElement MenuInviteWP ;
	  @FindBy(how=How.LINK_TEXT, using ="Produktlogg")
	  WebElement MenuWPPRLog ;
	  @FindBy(how=How.LINK_TEXT, using ="Ventende Produkter")
	  WebElement MenuWPPendingPR ;
	  @FindBy(how=How.LINK_TEXT, using ="Mål for substitusjon av kjemikalier")
	  WebElement MenuWPSubstChemicals;
	  @FindBy(how=How.LINK_TEXT, using ="Brukersted status")
	  WebElement MenuWPStatus ;
	  
	  //green buttons
	  @FindBy(how=How.LINK_TEXT, using ="Rediger")
	  WebElement BtnEditWP ;

	 //wizards button
	  @FindBy(how=How.ID, using ="cpmain_TopNavigatorPlaceHolder_ucNavigatorTop_btnCancel")
	  WebElement CancelWPWizard;
	  @FindBy(how=How.ID, using ="cpmain_TopNavigatorPlaceHolder_ucNavigatorTop_btnNex")
	  WebElement FiltersCFGNext;
	  @FindBy(how=How.ID, using ="cpmain_TopNavigatorPlaceHolder_ucNavigatorTop_btnFinish")
	  WebElement FinishFilters;
	  
	  
	public WPDashboard2() {
		  PageFactory.initElements(Browser.driver, this);
	  }
	
	@Override
	protected void load() {
	}
	@Override
	protected void isLoaded() throws Error {
	  Assert.assertTrue("Expected page title is not as actual",Browser.driver().getTitle().equals(title));
	  //System.out.println("Loaded page: "+Browser.driver().getTitle());
	  System.out.println("Loaded page: "+Browser.driver.findElement(By.id("cpmain_lblWorkplaceNameTitle")).getText());
	}
	
    //**** Select workplace dashboard left menus ***** 
	
	public WorkplaceDetails SelectMenuWPDetails() {
		MenuWPDetails.click();
		System.out.println("Selected menu Workplace Details");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
		System.out.println("--------------------------------------------");
		return new WorkplaceDetails ();
	}

	public CompanyFilters SelectMenuWPFilters() {
		MenuWPFilters.click();
		System.out.println("Selected menu Workplace Filters");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
	   	System.out.println("--------------------------------------------");
		return new CompanyFilters ();
	}

	
	public WorkplaceInformation SelectMenuWPInfo() {
		MenuWPInfo.click();
		System.out.println("Selected menu Workplace Information");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_ucWI_lblWPInformation")));
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_ucWI_lblWPInformation")).getText());
		System.out.println("--------------------------------------------");
		return new WorkplaceInformation ();
	}
	
	public RiskAssessment SelectMenuWPRiskAssessment() {
		MenuWPRA.click();
		System.out.println("Selected menu Workplace Risk Assessment");
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_RAcontent_lblRAListTitle")));
	   	 System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblObjectName")).getText());
	   	 System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_RAcontent_lblRAListTitle")).getText());
	   	System.out.println("--------------------------------------------");
		return new RiskAssessment ();
	}

	
	public InformationSheet SelectMenuWPInformationSheet() {
		MenuWPIS.click();
		System.out.println("Selected menu Workplace Information Sheet");
		 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblInstructionsListTitle")));
		 System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblObjectName")).getText());
		 System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblInstructionsListTitle")).getText());
		 System.out.println("--------------------------------------------");
		return new InformationSheet ();
	}
	
	
	public WastePlan SelectMenuWPWastePlan() {
		MenuWPWastePlan.click();
		System.out.println("Selected menu Workplace Waste Plan");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitleWP")).getText());
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
		System.out.println("--------------------------------------------");
		return new WastePlan ();
	}
	
	public ExposureRegister SelectMenuWPExposureRegister() {
		MenuWPExpReg.click();
		System.out.println("Selected menu Workplace Exposure Register");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_cpTitle_lblWorkingRegisterTitle")));
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_cpTitle_lblObjName")).getText());
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_cpTitle_lblWorkingRegisterTitle")).getText());
		System.out.println("--------------------------------------------");
		return new ExposureRegister ();
	}
	
	public InviteCompany SelectMenuInviteCompany() {
		MenuInviteComp.click();
		System.out.println("Selected menu Workplace Invite Company");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblInviteWorkplaceTitle")));
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblInviteWorkplaceTitle")).getText());
		System.out.println("--------------------------------------------");
		return new InviteCompany ();
	}
	
	public InviteWorkplace SelectMenuInviteWorkplace() {
		MenuInviteWP.click();
		System.out.println("Selected menu Workplace Invite Wokrplace");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblInviteWorkplaceTitle")));
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblInviteWorkplaceTitle")).getText());
		System.out.println("--------------------------------------------");
		return new InviteWorkplace ();
	}
	
	public WPProductLog SelectMenuWPProductLog() {
		MenuWPPRLog.click();
		System.out.println("Selected menu Workplace Product Log");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblWorkplaceLogTitle")));
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblWorkplaceLogTitle")).getText());
		System.out.println("--------------------------------------------");
		return new WPProductLog ();
	}
	
	
	public WPPendingProducts SelectMenuWPPendingProducts() {
		MenuWPPendingPR.click();
		System.out.println("Selected menu Workplace Pending Products");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblPendingRequestsTitle")));
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblPendingRequestsTitle")).getText());
		System.out.println("--------------------------------------------");
		return new WPPendingProducts ();
	}
	
	public WPDashboard2 SelectMenuViewWP() {
		MenuViewWP.click();
		System.out.println("Selected menu View Workplace");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblWorkplaceNameTitle")));
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblWorkplaceNameTitle")).getText());
		System.out.println("--------------------------------------------");
		return this;
	}

	
	//*****  Workplace dashboard select green buttons
	


	//*********   End of green buttons functions **********
	
	
	//Check opening all WP related left menus
	public WPDashboard2 OpenWPLeftMenus() {
		System.out.println("Open all workplace related left menus!");
		System.out.println("--------------------------------------------");
		SelectMenuWPDetails();
		SelectMenuWPFilters();
		SelectMenuWPInfo();
		SelectMenuWPRiskAssessment();
		SelectMenuWPInformationSheet();
		SelectMenuWPWastePlan();
		SelectMenuWPExposureRegister();
		SelectMenuInviteCompany();
		SelectMenuInviteWorkplace();
		SelectMenuWPProductLog();
		SelectMenuWPPendingProducts();
		SelectMenuViewWP();
		return new WPDashboard2();
	}
	
	
	//There are problems on closing browser with report
	// not working!!!
	public WPDashboard2 GenerateWPReports() {
		System.out.println("Generate workplace report - substitution of chemicals");
		MenuWPStatus.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("firepath-matching-node")));
		
		for (String winHandle : Browser.driver.getWindowHandles()) {
		    Browser.driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		    System.out.println("Report window handle:"+winHandle);
		}
		Browser.driver.close();
		Browser.driver.switchTo().window(Browser.mainwin);

//		System.out.println("Generate workplace report - workplaces status");
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("firepath-matching-node")));
//		Browser.close();
		return new WPDashboard2();
	}
	

 }
