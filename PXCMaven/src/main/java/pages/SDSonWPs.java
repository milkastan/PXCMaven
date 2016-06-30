package pages;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SDSonWPs  extends LoadableComponent<SDSonWPs> {
	private final static String title = "SDS i min organisasjon";
	WebDriverWait wait = new WebDriverWait(Browser.driver, 60);
	
	  public SDSonWPs() {
		  PageFactory.initElements(Browser.driver, this);
	  }
	
	@Override
	protected void load() {
		
	}

	@Override
	protected void isLoaded() throws Error {
	  Assert.assertTrue("Expected page title is not as actual",Browser.driver().getTitle().equals(title));
	  System.out.println("Loaded page: "+Browser.driver().getTitle());
	}
}
