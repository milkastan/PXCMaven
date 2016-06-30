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

public class SDSQA extends LoadableComponent<SDSQA> {
	private final static String title = "Kvalitetskontroll";
	WebDriverWait wait = new WebDriverWait(Browser.driver, 30);
	//SDSQA menus
	@FindBy(how=How.LINK_TEXT, using ="Brukeradministrasjon")
	WebElement MenuSDSUserAdmin;
	@FindBy(how=How.LINK_TEXT, using ="Min brukerkonto")
	WebElement MenuSDSMyAccount;
	@FindBy(how=How.LINK_TEXT, using ="Bedriftsprofil")
	WebElement MenuSDSCompProfile;
	@FindBy(how=How.LINK_TEXT, using ="Avansert søk")
	WebElement MenuSDSAdvSearch;
	@FindBy(how=How.LINK_TEXT, using ="Produsenter liste")
	WebElement MenuSDSManufacturers;
	@FindBy(how=How.LINK_TEXT, using ="Kvalitetssikring av SDS")
	WebElement MenuSDSQA;


	public SDSQA() {
		PageFactory.initElements(Browser.driver, this);
	}
	
	@Override
	protected void load() {
	}
	
	@Override
	protected void isLoaded() throws Error {
	  Assert.assertTrue("Expected page title is not as actual",Browser.driver().getTitle().equals(title));
	  System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
	  System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblFavourites")).getText());
	  System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblRecentlyViewed")).getText());
	  System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblSdsForQA")).getText());
	  System.out.println("--------------------------------------------");
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
    
    public  ManufacturerList navigateToManufacturersList() {
        wait.until(ExpectedConditions.elementToBeClickable(MenuSDSManufacturers));
        MenuSDSManufacturers.click();
      	 System.out.println("Selected SDS menu Manufacturers list");
      	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
      	 System.out.println("Loaded page: "+Browser.driver().getTitle());
        System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
        System.out.println("--------------------------------------------");
        return new ManufacturerList();
   	} 
    
    public  SDSQA navigateToSDSQA() {
        wait.until(ExpectedConditions.elementToBeClickable(MenuSDSQA));
        MenuSDSQA.click();
      	 System.out.println("Selected SDS menu QA on SDS");
      	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
      	 System.out.println("Loaded page: "+Browser.driver().getTitle());
        System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
  	    System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblFavourites")).getText());
        System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblRecentlyViewed")).getText());
    	 System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblSdsForQA")).getText());
        System.out.println("--------------------------------------------");
        return this;
   	} 
}
