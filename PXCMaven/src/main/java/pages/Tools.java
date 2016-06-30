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

public class Tools extends LoadableComponent<Tools> {
	private final static String title = "Bedriftsfiltre";
	WebDriverWait wait = new WebDriverWait(Browser.driver, 30);
	  
    //Tools left menu items
	@FindBy(how=How.LINK_TEXT, using ="Filteroppsett")
	WebElement MenuCompFilters;
	@FindBy(how=How.LINK_TEXT, using ="Godkjenn eSDS")
	WebElement MenuApproveESDS;
	@FindBy(how=How.LINK_TEXT, using ="Eksponeringsregister")
	WebElement MenuExposureReg;
	@FindBy(how=How.LINK_TEXT, using ="Rapporter")
	WebElement MenuReports;
	@FindBy(how=How.LINK_TEXT, using ="Produktrapporter")
	WebElement MenuProductReports;
	@FindBy(how=How.LINK_TEXT, using ="Avfallveileder")
	WebElement MenuWasteHandling;
	@FindBy(how=How.LINK_TEXT, using ="Produktlogg")
	WebElement MenuProductLog;
	
	  
	public Tools() {
		  PageFactory.initElements(Browser.driver, this);
	}

	@Override
	protected void load() {
	}
	
	@Override
	protected void isLoaded() throws Error {
	  Assert.assertTrue("Expected page title is not as actual",Browser.driver().getTitle().equals(title));
		//System.out.println("Loaded page: "+Browser.driver().getTitle());
		System.out.println("Loaded page: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
     }
	
	   public  CompanyFilters navigateToCompanyFilters() {
		    MenuCompFilters.click();
		     System.out.println("Selected menu Tools/Company Filters");
	    	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
	    	 System.out.println("Loaded page: "+Browser.driver().getTitle());
	       	 System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
	       	 System.out.println("--------------------------------------------");
	     	 return new CompanyFilters();
	 	} 
	   
	   public  ApproveESDS navigateToApproveESDS() {
		     MenuApproveESDS.click();
		     System.out.println("Selected menu Tools/Approve ESDS");
	    	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblESTitle")));
	    	 System.out.println("Loaded page: "+Browser.driver().getTitle());
	       	 System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblESTitle")).getText());
	       	 System.out.println("--------------------------------------------");
	     	 return new ApproveESDS();
	 	} 
	   
	   public  ExposureRegister navigateToExposureRegister() {
		     MenuExposureReg.click();
		     System.out.println("Selected menu Tools/Exposure Register");
	    	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_cpTitle_lblObjName")));
	    	 System.out.println("Loaded page: "+Browser.driver().getTitle());
	       	 System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_cpTitle_lblObjName")).getText());
	       	 System.out.println("--------------------------------------------");
	     	 return new ExposureRegister();
	 	} 
	   
	   public  PXCReports navigateToReports() {
		     MenuReports.click();
		     System.out.println("Selected menu Tools/Reports");
	    	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
	    	 System.out.println("Loaded page: "+Browser.driver().getTitle());
	       	 System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
	         System.out.println("--------------------------------------------");
	     	 return new PXCReports();
	 	} 
	   
	   public  ProductReports navigateToProductReports() {
		     MenuProductReports.click();
		     System.out.println("Selected menu Tools/Products Reports");
	    	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
	    	 System.out.println("Loaded page: "+Browser.driver().getTitle());
	       	 System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
	       	 System.out.println("--------------------------------------------");
	     	 return new ProductReports();
	 	} 
	   
	   public  WasteHandling navigateToWasteHandling() {
		     MenuWasteHandling.click();
		     System.out.println("Selected menu Tools/Waste Handling");
	    	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
	    	 System.out.println("Loaded page: "+Browser.driver().getTitle());
	       	 System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
	       	 System.out.println("--------------------------------------------");
	     	 return new WasteHandling();
	 	} 
	   
	   public  ProductLog navigateToProductLog() {
		     MenuProductLog.click();
		     System.out.println("Selected menu Tools/Product Log");
	    	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
	    	 System.out.println("Loaded page: "+Browser.driver().getTitle());
	       	 System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
	       	 System.out.println("--------------------------------------------");
	     	 return new ProductLog();
	 	} 
}
