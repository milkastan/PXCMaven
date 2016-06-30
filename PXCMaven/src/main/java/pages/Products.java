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

public class Products extends LoadableComponent<Products>{
	private final static String title = "Produkter";
	WebDriverWait wait = new WebDriverWait(Browser.driver, 30);
	
	//Products sub-dashboard linkes
	  @FindBy(how=How.ID, using ="lbtnProducts")
	  WebElement PProductsList;
	  @FindBy(how=How.ID, using ="hlnkMissingDoP")
	  WebElement PPRMissingDoP;
	  @FindBy(how=How.ID, using ="hlnkMissingSDS")
	  WebElement PPRMissingSDS;
	  @FindBy(how=How.ID, using ="lbtnProductsWithFilterCriteria")
	  WebElement PPRFilterCriteria;
	  @FindBy(how=How.ID, using ="lbtnWPComments")
	  WebElement PWPComments;
	  @FindBy(how=How.ID, using ="hlnkMissingA20Declaration")
	  WebElement PPRMissingA20Decl;
	  @FindBy(how=How.ID, using ="hlnkMissingHEA9Declaration")
	  WebElement PMissingHEA9Descl;
	//end of links
	  
	  //Back to main dashboard
	 @FindBy(how=How.ID, using ="hlnkBackToDashboard")
     WebElement ProductsBacktoMain;
	  
	public Products() {
		  PageFactory.initElements(Browser.driver, this);
	  }
	
	@Override
	protected void load() {
	}
	
	@Override
	protected void isLoaded() throws Error {
	  Assert.assertTrue("Expected page title is not as actual",Browser.driver().getTitle().equals(title));
	  System.out.println("Loaded page: "+Browser.driver.findElement(By.id("cpmain_ucWorkplaceSummary_lblName")).getText());
	}
	
	public WPDashboard ProductsBacktoMain() {
		wait.until(ExpectedConditions.elementToBeClickable(ProductsBacktoMain));
		ProductsBacktoMain.click();
		System.out.println("Selected link Back to WP dashboard");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_ucWorkplaceSummary_lblName")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblWorkplaceNameTitle")).getText());
	   	System.out.println("--------------------------------------------");
		return new WPDashboard();
	}
	
	public Products OpenProductswithMissingDoP() {
		wait.until(ExpectedConditions.elementToBeClickable(PPRMissingDoP));
		PPRMissingDoP.click();
		System.out.println("Selected link Products with missing DoP");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
	   	System.out.println("Dashboard title:"+Browser.driver.findElement(By.id("cpmain_ucWorkplaceSummary_lblName")).getText());
	   	System.out.println("Return back to products subdashboard");
	   	Browser.driver.navigate().back();
	   	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblProductsHeader")));
	   	System.out.println("--------------------------------------------");
		return new Products();
	}
	
	public Products OpenProductswithMissingSDS() {
		wait.until(ExpectedConditions.elementToBeClickable(PPRMissingSDS));
		PPRMissingSDS.click();
		System.out.println("Selected link Products with missing SDS");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
		System.out.println("Dashboard title:"+Browser.driver.findElement(By.id("cpmain_ucWorkplaceSummary_lblName")).getText());
		System.out.println("Return back to products subdashboard");
	   	Browser.driver.navigate().back();
	   	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblProductsHeader")));
	   	System.out.println("--------------------------------------------");
		return new Products();
	}
	
	public Products OpenProductswithFilterCriteria() {
		wait.until(ExpectedConditions.elementToBeClickable(PPRFilterCriteria));
		PPRFilterCriteria.click();
		System.out.println("Selected link Products with Filter criteria");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblProductsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblProductsHeader")).getText());
	   	System.out.println("Dashboard title:"+Browser.driver.findElement(By.id("cpmain_ucWorkplaceSummary_lblName")).getText());	   	
	   	System.out.println("--------------------------------------------");
		return new Products();
	}
	
	public Products OpenProductsWPComments() {
		wait.until(ExpectedConditions.elementToBeClickable(PWPComments));
		PWPComments.click();
		System.out.println("Selected link Products workplace comments");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblProductsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblProductsHeader")).getText());
	   	System.out.println("Dashboard title:"+Browser.driver.findElement(By.id("cpmain_ucWorkplaceSummary_lblName")).getText());	   	
	   	System.out.println("--------------------------------------------");
		return new Products();
	}
	
	public Products OpenProductswithMissingA20() {
		wait.until(ExpectedConditions.elementToBeClickable(PPRMissingA20Decl));
		PPRMissingA20Decl.click();
		System.out.println("Selected link Products with missing A20 declaration");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
		System.out.println("Dashboard title:"+Browser.driver.findElement(By.id("cpmain_ucWorkplaceSummary_lblName")).getText());	   	
	   	System.out.println("Return back to products subdashboard");
	   	Browser.driver.navigate().back();
	   	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblProductsHeader")));
	   	System.out.println("--------------------------------------------");
		return new Products();
	}
	
	public Products OpenProductswithMissingHEA9() {
		wait.until(ExpectedConditions.elementToBeClickable(PMissingHEA9Descl));
		PMissingHEA9Descl.click();
		System.out.println("Selected link Products with missing HEA9 declaration");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
		System.out.println("Dashboard title:"+Browser.driver.findElement(By.id("cpmain_ucWorkplaceSummary_lblName")).getText());	   	
	   	System.out.println("Return back to products subdashboard");
	   	Browser.driver.navigate().back();
	   	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblProductsHeader")));
	   	System.out.println("--------------------------------------------");
		return new Products();
	}
	
	public Products OpenProductList() {
		wait.until(ExpectedConditions.elementToBeClickable(PProductsList));
		PProductsList.click();
		System.out.println("Selected link Products List");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblProductsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblProductsHeader")).getText());
	   	System.out.println("Dashboard title:"+Browser.driver.findElement(By.id("cpmain_ucWorkplaceSummary_lblName")).getText());	   	
	   	System.out.println("--------------------------------------------");
		return new Products();
	}
	
	public Products OpenProductSubdashboardLinks() {
		System.out.println("Open all links from Products Sub-dashboard");
		OpenProductswithFilterCriteria();
		OpenProductsWPComments();
		OpenProductswithMissingDoP();
		OpenProductswithMissingSDS();
		OpenProductswithMissingA20();
		OpenProductswithMissingHEA9();
		OpenProductList();
		ProductsBacktoMain();
	   	System.out.println("--------------------------------------------");
		return new Products();
	}
	
}
