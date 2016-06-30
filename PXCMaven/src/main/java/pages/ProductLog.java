package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductLog extends LoadableComponent<ProductLog> {
      private final static String title = "Produktlogg";
      WebDriverWait wait = new WebDriverWait(Browser.driver, 5);
	
	public ProductLog() {
		  PageFactory.initElements(Browser.driver, this);
	}

	@Override
	protected void load() {
	}

	@Override
	protected void isLoaded() throws Error {
	  Assert.assertTrue("Expected page title is not as actual",Browser.driver().getTitle().equals(title));
		System.out.println("Loaded page: "+Browser.driver().getTitle());
		System.out.println("Loaded page: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
     }
	
	
	}
