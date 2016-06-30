package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProducts extends LoadableComponent<AddProducts> {
	private final static String title = "Legg til produkt";
	WebDriverWait wait = new WebDriverWait(Browser.driver, 60);

	//WebElements in Add product page Simple product search
  @FindBy(how=How.ID, using ="cpmain_txtSupplier")   //search by supplier text field
  WebElement PSearchSupplierField;
  @FindBy(how=How.ID, using ="cpmain_txtSearchString")   //search by product name or identifier field
  WebElement PSearchNameIdField;
  @FindBy(how=How.ID, using ="cpmain_lblBtnSearch")   //search product button
  WebElement PSearchBtn;
  @FindBy(how=How.ID, using ="cpmain_lblSearchHits")   //search result hits
  WebElement SearchResultHits;
  @FindBy(how=How.ID, using ="cpmain_ucProductList_gvData_lblAddButton_0")   //search result hits
  WebElement AddBtnFirstProduct;
  @FindBy(how=How.ID, using ="cpmain_ucProductList_gvData_lblAddButton_1")   //search result hits
  WebElement AddBtnSecondProduct;
   
  
  	public AddProducts() {
		  PageFactory.initElements(Browser.driver, this);
	}
	
	@Override
	protected void load() {
	}
	@Override
	protected void isLoaded() throws Error {
	  Assert.assertTrue("Expected page title is not as actual",Browser.driver().getTitle().equals(title));
	  System.out.println("Loaded page: "+Browser.driver.findElement(By.id("cpmain_lblAddProductTitle")).getText());
	}
	
    //Select Simple product search radio button
    public void SelectSimpleProductSearch() {
    	List<WebElement> ps = Browser.driver.findElements(By.name("ctl00$cpmain$SearchMode"));
    	//System.out.println("Radio buttons size:"+ps.size());
    	if (!ps.get(0).isSelected()) {
    	     ps.get(0).click();
    	     System.out.println("Selected Simple product search");
    	} else {System.out.println("Simple product search is already selected"); }
    	//Browser.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_chkSdsOnly")));
   	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblAddProductTitle")).getText());
   	  System.out.println("--------------------------------------------");
    }
	
    //Select product type search radio button
    public void SelectProductTypeSearch() {
    	List<WebElement> ps = Browser.driver.findElements(By.name("ctl00$cpmain$SearchMode"));
    	//System.out.println("Radio buttons size:"+ps.size());
    	ps.get(1).click();
    	System.out.println("Selected product type search");
    	//Browser.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblChooseProductType")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblAddProductTitle")).getText());
	   	System.out.println("--------------------------------------------");
    }
   
    //Select advanced product search radio button
    public void SelectAdvancedProductSearch() {
    	List<WebElement> ps = Browser.driver.findElements(By.name("ctl00$cpmain$SearchMode"));
    	//System.out.println("Radio buttons size:"+ps.size());
    	ps.get(2).click();
    	System.out.println("Selected advanced product search");
    	//Browser.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitleSection1")));
       	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
       	System.out.println("--------------------------------------------");
    }
    
    //Search products by Supplier Name
    public void SearchBySupplier(String sup) {
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_txtSupplier")));
    	System.out.println("Search by supplier:"+sup);
    	PSearchNameIdField.clear();
    	PSearchSupplierField.clear();
    	PSearchSupplierField.sendKeys(sup);
    	PSearchBtn.click();
    	Browser.driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
    	System.out.println("Returned search results for supplier "+sup+": "+SearchResultHits.getText());
    }
    
    
    //Search product by product Name or identificator
    public void SearchByPRName_ID(String pr) {
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_txtSearchString")));
    	System.out.println("Search for product:"+pr);
    	PSearchSupplierField.clear();
    	PSearchNameIdField.clear();
    	PSearchNameIdField.sendKeys(pr);
    	PSearchBtn.click();
    	Browser.driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
    	System.out.println("Returned search results for product "+pr+": "+SearchResultHits.getText());
    }
    
    //Add first found product from search result to workplace
    public void AddProductToWP () {
    	System.out.println("Add product to workplace");
    	if (AddBtnFirstProduct.isEnabled()) {
    		System.out.println("Button Add product is enabled");  
    	}
    	AddBtnFirstProduct.click();
    }
    
    public void OpenAllProductSearchPages() {
    	SelectProductTypeSearch();
    	SelectAdvancedProductSearch();
    	SelectSimpleProductSearch();
    }
}
