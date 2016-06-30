package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductTypeswithAssessment extends LoadableComponent<ProductTypeswithAssessment>{
   private final static String title = "ProductXchange";
   WebDriverWait wait = new WebDriverWait(Browser.driver, 5);
   //Products without assessment menu
   @FindBy(how=How.LINK_TEXT, using ="Produkt uten vurdering")
    WebElement ProdwoAssBtn;
   //Product types with assessment
   @FindBy(how=How.LINK_TEXT, using ="Produkttyper med vurdering")
    WebElement ProductTypesAssBtn;
   //Product assessment center
   @FindBy(how=How.LINK_TEXT, using ="Produkt evalueringssenter")
    WebElement ProductAssCenterBtn;
   
	public ProductTypeswithAssessment() {
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
}
