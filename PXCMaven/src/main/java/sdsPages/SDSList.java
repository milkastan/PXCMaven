package sdsPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.Browser;

public class SDSList extends LoadableComponent<SDSList> {
	private final static String title = "SDS Liste";
	WebDriverWait wait = new WebDriverWait(Browser.driver, 30);
	 
	//SDS manufacturerRW menu items
	  @FindBy(how=How.LINK_TEXT, using ="Lage SDS")
	  WebElement MenuCreateSDS;
	  @FindBy(how=How.LINK_TEXT, using ="Liste over SDS")
	  WebElement MenuSDSList;
	  @FindBy(how=How.LINK_TEXT, using ="Importer SDS fra XML")
	  WebElement MenuImportSDS;
	  @FindBy(how=How.LINK_TEXT, using ="Setningsbibliotek")
	  WebElement MenuPhraseLib;
	  @FindBy(how=How.LINK_TEXT, using ="Stoffdatabase")
	  WebElement MenuSubstanceDB;
	  @FindBy(how=How.LINK_TEXT, using ="Eksponeringsscenario")
	  WebElement MenuExposureScn;
	  @FindBy(how=How.LINK_TEXT, using ="Brukeradministrasjon")
	  WebElement MenuSDSUserAdmin;
	  @FindBy(how=How.LINK_TEXT, using ="Min brukerkonto")
	  WebElement MenuSDSMyAccount;
	  @FindBy(how=How.LINK_TEXT, using ="Bedriftsprofil")
	  WebElement MenuSDSCompProfile;
	  @FindBy(how=How.LINK_TEXT, using ="Avansert søk")
	  WebElement MenuSDSAdvSearch;
	  @FindBy(how=How.ID, using ="cpmain_ucSDSList_gvSDSList_imgGrayPen_0")   
	  WebElement FirstSDSEditBtn;
	  
	  //in addition for role puncher
	  @FindBy(how=How.LINK_TEXT, using ="Velg leverandør")
	  WebElement MenuSelectSupplier;

	public SDSList() {
		PageFactory.initElements(Browser.driver, this);
	}
	
	@Override
	protected void load() {
	}
	
	@Override
	protected void isLoaded() throws Error {
	  Assert.assertTrue("Expected page title is not as actual",Browser.driver().getTitle().equals(title));
	  System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblManufacturer")).getText());
	  System.out.println("--------------------------------------------");
	}
	

    public  ImportSDS navigateToImportSDS() {
     wait.until(ExpectedConditions.elementToBeClickable(MenuImportSDS));
   	 MenuImportSDS.click();
   	 System.out.println("Selected SDS menu Import SDS");
   	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_EditorControlsPlaceHolder_lblInfo")));
   	 System.out.println("Loaded page: "+Browser.driver().getTitle());
     System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_EditorControlsPlaceHolder_lblInfo")).getText());
     System.out.println("--------------------------------------------");
     return new ImportSDS();
	} 
    
    public  PhraseLibrary navigateToPhraseLib() {
        wait.until(ExpectedConditions.elementToBeClickable(MenuPhraseLib));
        MenuPhraseLib.click();
      	 System.out.println("Selected SDS menu Phrase Library");
      	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblHeader")));
      	 System.out.println("Loaded page: "+Browser.driver().getTitle());
        System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblHeader")).getText());
        System.out.println("--------------------------------------------");
        return new PhraseLibrary();
   	} 
    
    public  SubstanceDB navigateToSubstanceDB() {
        wait.until(ExpectedConditions.elementToBeClickable(MenuSubstanceDB));
        MenuSubstanceDB.click();
      	 System.out.println("Selected SDS menu Substance DB");
      	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblSubstanceDB")));
      	 System.out.println("Loaded page: "+Browser.driver().getTitle());
        System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblSubstanceDB")).getText());
        System.out.println("--------------------------------------------");
        return new SubstanceDB();
   	} 

    public  ExposureScn navigateToExposureScn() {
        wait.until(ExpectedConditions.elementToBeClickable(MenuExposureScn));
        MenuExposureScn.click();
      	 System.out.println("Selected SDS menu Exposure Scenario");
      	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
      	 System.out.println("Loaded page: "+Browser.driver().getTitle());
        System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
        System.out.println("--------------------------------------------");
        return new ExposureScn();
   	} 
    
    public  SDSUserAdministration navigateToSDSUserAdmin() {
        wait.until(ExpectedConditions.elementToBeClickable(MenuSDSUserAdmin));
        MenuSDSUserAdmin.click();
      	 System.out.println("Selected SDS menu SDS User Administration");
      	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblUserListTitle")));
      	 System.out.println("Loaded page: "+Browser.driver().getTitle());
        System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblUserListTitle")).getText());
        System.out.println("--------------------------------------------");
        return new SDSUserAdministration();
   	} 
    
    public  SDSMyAccount navigateToSDSMyAccount() {
        wait.until(ExpectedConditions.elementToBeClickable(MenuSDSMyAccount));
        MenuSDSMyAccount.click();
      	 System.out.println("Selected SDS menu SDS My Account");
      	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_hdrText")));
      	 System.out.println("Loaded page: "+Browser.driver().getTitle());
        System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_hdrText")).getText());
        System.out.println("--------------------------------------------");
        return new SDSMyAccount();
   	} 
    
    public  SDSCompanyProfile navigateToSDSCompProfile() {
        wait.until(ExpectedConditions.elementToBeClickable(MenuSDSCompProfile));
        MenuSDSCompProfile.click();
      	 System.out.println("Selected SDS menu SDS company profile");
      	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_hdrText")));
      	 System.out.println("Loaded page: "+Browser.driver().getTitle());
        System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_hdrText")).getText());
        System.out.println("--------------------------------------------");
        return new SDSCompanyProfile();
   	} 
    
    public  AdvancedSearch navigateToSDSAdvSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(MenuSDSAdvSearch));
        MenuSDSAdvSearch.click();
      	 System.out.println("Selected SDS menu SDS Advanced Search");
      	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_ucAdvancedSearch_lblHeader")));
      	 System.out.println("Loaded page: "+Browser.driver().getTitle());
        System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_ucAdvancedSearch_lblHeader")).getText());
        System.out.println("--------------------------------------------");
        return new AdvancedSearch();
   	} 
    
    public  SelectSupplier navigateToImpersonateSupplier() {
        wait.until(ExpectedConditions.elementToBeClickable(MenuSelectSupplier));
        MenuSelectSupplier.click();
      	 System.out.println("Selected SDS menu Select supplier");
      	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
      	 System.out.println("Loaded page: "+Browser.driver().getTitle());
        System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
        System.out.println("--------------------------------------------");
        return new SelectSupplier();
   	} 
    
    public  CreateSDS navigateToCreateSDS() {
        wait.until(ExpectedConditions.elementToBeClickable(MenuCreateSDS));
        MenuCreateSDS.click();
      	 System.out.println("Selected SDS menu Create SDS");
      	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
      	 System.out.println("Loaded page: "+Browser.driver().getTitle());
        System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
        System.out.println("--------------------------------------------");
        return new CreateSDS();
   	} 
    
    public EditSDS EditFirstSDS() {
    	wait.until(ExpectedConditions.elementToBeClickable(FirstSDSEditBtn));
    	FirstSDSEditBtn.click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
    	return new EditSDS();
    }
    
}
