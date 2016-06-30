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

public class MyAccount extends LoadableComponent<MyAccount> {
   private final static String title = "Endre brukerprofil";
   WebDriverWait wait = new WebDriverWait(Browser.driver, 30);
   
   //My account left menu items
  	@FindBy(how=How.LINK_TEXT, using ="Min brukerkonto")
  	WebElement MenuMyAccount;
 	@FindBy(how=How.LINK_TEXT, using ="Brukeradministrasjon")
  	WebElement MenuUserAdmin;
 	@FindBy(how=How.LINK_TEXT, using ="Bedriftsprofil")
  	WebElement MenuCompanyProfile;
  	
  	
  	
	public MyAccount() {
		  PageFactory.initElements(Browser.driver, this);
	}

	@Override
	protected void load() {
	}
	
	@Override
	protected void isLoaded() throws Error {
	  Assert.assertTrue("Expected page title is not as actual",Browser.driver().getTitle().equals(title));
		//System.out.println("Loaded page: "+Browser.driver().getTitle());
		System.out.println("Loaded page: "+Browser.driver.findElement(By.id("cpmain_hdrText")).getText());
     }
	
    public  MyAccount navigateToUserAdministration() {
    	MenuUserAdmin.click();
   	    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblUserListTitle")));
   	    System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblUserListTitle")).getText());
        System.out.println("--------------------------------------------");
    	return new MyAccount();
	} 
    
    public  MyAccount navigateToCompanyProfile() {
    	MenuCompanyProfile.click();
   	    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_hdrText")));
   	    System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_hdrText")).getText());
        System.out.println("--------------------------------------------");
    	return new MyAccount();
	} 
    
     public  MyAccount SelectMenuMyAccount() {
    	 MenuMyAccount.click();
   	     wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_hdrText")));
   	     System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_hdrText")).getText());
      	 System.out.println("--------------------------------------------");
    	 return new MyAccount();
	} 
}
