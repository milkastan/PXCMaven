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


public class WPDashboard extends LoadableComponent<WPDashboard> {
	 
	private final static String title = "Brukersted dashbord";
	WebDriverWait wait = new WebDriverWait(Browser.driver, 60);
	public static String mainwin;

	//Main and Subdashboard and summary info filters
	
	//Filter workplace info by scope Active-All 
	@FindBy(how=How.ID, using ="cpmain_ucWorkplaceSummary_lblWpScope")
	  WebElement FilterScope;
	 @FindBy(how=How.ID, using ="cpmain_ucWorkplaceSummary_lbtnAllWp")
	  WebElement FilterAllWP;
	 @FindBy(how=How.ID, using ="cpmain_ucWorkplaceSummary_lbtnActiveWp")
	  WebElement FilterActiveWP;
	
	 //Filter workplace info by area
	  @FindBy(how=How.ID, using ="cpmain_ucWorkplaceSummary_lnkOptions")
	  WebElement FilterArea;
	  @FindBy(how=How.ID, using ="cpmain_ucWorkplaceSummary_lnkFirstButton")
	  WebElement FilterCurrentWP;
	  @FindBy(how=How.ID, using ="cpmain_ucWorkplaceSummary_lnkSecondButton")
	  WebElement FilterChildWP;

	  @FindBy(how=How.ID, using ="cpmain_ucWorkplaceSummary_lnkThirdButton")
	  WebElement FilterInvitedWholesaler;
	  @FindBy(how=How.ID, using ="cpmain_ucWorkplaceSummary_lnkFourthButton")
	  WebElement FilterInvitedCompany;
	  
	  //Workplace main dashboard links 
	  //left section
	  @FindBy(how=How.ID, using ="lbtnSuggestedUwp")
	  WebElement URWList;
	  @FindBy(how=How.ID, using ="lbtnImportedCompanies")
	  WebElement InvitedCompanies;
	  @FindBy(how=How.ID, using ="lbtnDepartments")
	  WebElement Subworkplaces;
	  //main dashboard middle section
	  @FindBy(how=How.ID, using ="hlnkProducts")
	  WebElement ProductsList;
	  @FindBy(how=How.ID, using ="hlnkSDSs")
	  WebElement SDSList;
	  @FindBy(how=How.ID, using ="lbtnDocuments")
	  WebElement DocumentsList;
	  //Main dashboard right section
	  @FindBy(how=How.ID, using ="hlnkDeviations")
	  WebElement Deviations;
	  // End of main dashboard summary info links
	  //workplace refresh button
	  @FindBy(how=How.ID, using ="cpmain_ucWorkplaceSummary_ibtnUpdateSummary")
	  WebElement RefreshWPBtn;
	  
	  //Distribute document green button
	  @FindBy(how=How.LINK_TEXT, using ="Skriv ut")
	  WebElement BtnDistributeDocuments ;
	  //Products summary info value
	  @FindBy(how=How.XPATH, using = "//*[@id='tblSummaryContainer']/tbody/tr[1]/td[2]")
	  WebElement WPProductsNum ;	
	  @FindBy(how=How.XPATH, using = "//*[@id='tblwpSummaryContainer']/tbody/tr[3]/td[2]")
	  WebElement WPDocsNum ;	
	  @FindBy(how=How.XPATH, using = "//*[@id='tblSummaryContainer']/tbody/tr[2]/td[4]")
	  WebElement InvCompNum ;	
	  

	  //green buttons
	  @FindBy(how=How.LINK_TEXT, using ="Legg til produkt")
	  WebElement BtnAddProduct;
	  @FindBy(how=How.LINK_TEXT, using ="Legg til dokument")
	  WebElement BtnAddDocument ;
	  @FindBy(how=How.LINK_TEXT, using ="Vis")
	  WebElement BtnViewWP;
	  @FindBy(how=How.LINK_TEXT, using ="Inviter bedrift")
	  WebElement BtnInviteCompany ;
   
	  //left menus
	  @FindBy(how=How.LINK_TEXT, using ="Vis brukersted")
	  WebElement MenuViewWP;
	  @FindBy(how=How.LINK_TEXT, using ="Inviter brukersted")
	  WebElement MenuInviteWP ;
	  @FindBy(how=How.LINK_TEXT, using ="Inviter bedrift")
	  WebElement MenuInviteComp ;
	  
	  //Titles of displayed lists
	  @FindBy(how=How.ID, using ="cpmain_tableContent_lblDetailsHeader")
	  WebElement ListTitle;

	
	public WPDashboard() {
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
	
	public WPDashboard SelectViewWPBtn() {
		BtnViewWP.click();
		System.out.println("Pressed button View Workplace");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblWorkplaceNameTitle")));
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblWorkplaceNameTitle")).getText());
		System.out.println("--------------------------------------------");
		return this;
	}
	public WPDashboard SelectMenuViewWP() {
		MenuViewWP.click();
		System.out.println("Selected menu View Workplace");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblWorkplaceNameTitle")));
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblWorkplaceNameTitle")).getText());
		System.out.println("--------------------------------------------");
		return this;
	}
	
	public InviteCompany SelectInviteCompanyBtn() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_TopSubMenu_hlImportCompany")));
		BtnInviteCompany.click();
		System.out.println("Pressed button Invite Company");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblInviteWorkplaceTitle")));
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblInviteWorkplaceTitle")).getText());
		System.out.println("--------------------------------------------");
		return new InviteCompany ();
	}

	public WPDashboard OpenSuggestedURW() {
		wait.until(ExpectedConditions.elementToBeClickable(URWList));
		URWList.click();
		System.out.println("Selected link Suggested unregistered workplaces");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return new WPDashboard();
	}
	
	public InviteCompany OpenInvitedCompanies() {   
		wait.until(ExpectedConditions.elementToBeClickable(InvitedCompanies));
		InvitedCompanies.click();
		System.out.println("Selected link Invited companies");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return new InviteCompany();
	}
	
	public InviteCompany SelectMenuInviteCompany() {
		MenuInviteComp.click();
		System.out.println("Selected menu Workplace Invite Company");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblInviteWorkplaceTitle")));
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblInviteWorkplaceTitle")).getText());
		System.out.println("--------------------------------------------");
		return new InviteCompany ();
	}
	
	public WPDashboard OpenSubworkplaces() {   
		wait.until(ExpectedConditions.elementToBeClickable(Subworkplaces));
		Subworkplaces.click();
		System.out.println("Selected link Child workplaces");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return new WPDashboard();
	}
	
	public Products OpenProductsSubdashboard() {
		wait.until(ExpectedConditions.elementToBeClickable(ProductsList));
		ProductsList.click();
		System.out.println("Selected link Products");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblProductsHeader")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("hlnkBackToDashboard")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblProductsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return new Products();
	}
	
	public Chemicals OpenChemicalsSubdashboard() {
		wait.until(ExpectedConditions.elementToBeClickable(SDSList));
		SDSList.click();
		System.out.println("Selected link Chemicals");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblChemicalsHeader")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("hlnkBackToDashboard")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblChemicalsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return new Chemicals();
	}
	
	
	public WPDashboard OpenDocumentsList() {
		wait.until(ExpectedConditions.elementToBeClickable(DocumentsList));
		DocumentsList.click();
		System.out.println("Selected link Documents");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return new WPDashboard();
	}
	

	public Deviations OpenDeviationsSubdashboard() {
		wait.until(ExpectedConditions.elementToBeClickable(Deviations));
		Deviations.click();
		System.out.println("Selected link Deviations");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_ucWorkplaceSummary_lblName")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("hlnkBackToDashboard")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_ucWorkplaceSummary_lblName")).getText());
	   	System.out.println("--------------------------------------------");
		return new  Deviations();
	}
	
	//Not implemented, switch frame - TB_iframeContent as risk assessment
	public DistributeDocuments SelectDistributeDocBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(BtnDistributeDocuments));
		BtnDistributeDocuments.click();
		System.out.println("Pressed button Distribute documents");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("TB_iframeContent")));
		System.out.println("--------------------------------------------");
		return new DistributeDocuments ();
	}
	
	//change scope to all workplaces
	public void SelectWPFilterAllWorkplaces() {
		System.out.println("Change workplace filter to All workplaces");
	    FilterScope.click();
		FilterAllWP.click();
		wait.until(ExpectedConditions.elementToBeClickable(ProductsList));
		Assert.assertEquals("Not changed to All workplaces",FilterScope.getText(),"Alle brukersteder");		
	}
	
	//change scope to all workplaces
	public void SelectWPFilterActiveWorkplaces() {
		System.out.println("Change workplace filter to Active workplaces");
		FilterScope.click();
		FilterActiveWP.click();
		wait.until(ExpectedConditions.elementToBeClickable(ProductsList));
		Assert.assertEquals("Not changed to active workplaces",FilterScope.getText(),"Aktive brukersteder");   
	}
	
	//change area to current workplace
	public void SelectWPFilterCurrentWorkplace() {
		System.out.println("Change workplace filter to Current workplace");
		FilterArea.click();
		FilterCurrentWP.click();
		wait.until(ExpectedConditions.elementToBeClickable(ProductsList));
		Assert.assertEquals("Not changed to current workplaces",FilterArea.getText(),"Dette brukersted");
	}
	
	//change area to child workplaces
	public void SelectWPFilterChildWorkplace() {
		System.out.println("Change workplace filter to Child workplaces");
		FilterArea.click();
		FilterChildWP.click();
		wait.until(ExpectedConditions.elementToBeClickable(ProductsList));
		Assert.assertEquals("Not changed to child workplaces",FilterArea.getText(),"Underordnet brukersted");
	}
	
	//change area to invited wholesaler
	public void SelectWPFilterInvitedWholesaler() {
		System.out.println("Change workplace filter to Invited wholesaler");
		FilterArea.click();
		FilterInvitedWholesaler.click();
		wait.until(ExpectedConditions.elementToBeClickable(ProductsList));
		Assert.assertEquals("Not changed to invited wholesaler",FilterArea.getText(),"Inviterte grossist");	
	}
	
	//change area to invited wholesaler
	public void SelectWPFilterInvitedCompanies() {
		System.out.println("Change workplace filter to Invited companies");
		FilterArea.click();
		FilterInvitedCompany.click();
		wait.until(ExpectedConditions.elementToBeClickable(ProductsList));
		Assert.assertEquals("Not changed to invited companies",FilterArea.getText(),"Inviterte bedrifter");			
	}
	
	//Check number of products on main dashboard summary info
	public void CheckProductsNumber(String pn) {
		System.out.println("Check expected products: "+pn);
		wait.until(ExpectedConditions.elementToBeClickable(ProductsList));
		Assert.assertEquals("Products are not updated as expected",WPProductsNum.getText(),pn);
		System.out.println("--------------------------------------------");
	}
	
	//Check number of documents on main dashboard summary info
	public void CheckDocumentsNumber(String dn) {
		System.out.println("Check expected document: "+dn);
		wait.until(ExpectedConditions.elementToBeClickable(ProductsList));
		Assert.assertEquals("Documents are not updated as expected",WPDocsNum.getText(),dn);
		System.out.println("--------------------------------------------");
	}
	
	//Check number of products on main dashboard summary info
	public void CheckInvitedCompaniesNumber(String icn) {
		System.out.println("Check expected invited companies: "+icn);
		wait.until(ExpectedConditions.elementToBeClickable(InvCompNum));
		Assert.assertEquals("invited companies are not updated as expected",InvCompNum.getText(),icn);
		System.out.println("--------------------------------------------");
	}
	
	public void RefreshWPSummaryInfo() {
		System.out.println("Update workplace summary info");
		wait.until(ExpectedConditions.elementToBeClickable(RefreshWPBtn));
		RefreshWPBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(ProductsList));
	}
		
	public AddProducts SelectAddProduct() {
		BtnAddProduct.click();
		System.out.println("Pressed button Add product");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblAddProductTitle")));
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblAddProductTitle")).getText());
		System.out.println("--------------------------------------------");
		return new AddProducts ();
	}
	
	public AddDocuments SelectAddDocument() {
		BtnAddDocument.click();
		System.out.println("Pressed button Add document");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblAddDocumentTitle")));
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblAddDocumentTitle")).getText());
		System.out.println("--------------------------------------------");
		return new AddDocuments ();
	}	
	
	public InviteWorkplace SelectMenuInviteWorkplace() {
		MenuInviteWP.click();
		System.out.println("Selected menu Workplace Invite Wokrplace");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblInviteWorkplaceTitle")));
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblInviteWorkplaceTitle")).getText());
		System.out.println("--------------------------------------------");
		return new InviteWorkplace ();
	}
		
}
