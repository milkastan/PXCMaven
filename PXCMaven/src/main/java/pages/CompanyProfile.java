package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class CompanyProfile extends LoadableComponent<CompanyProfile> {
	   private final static String title = "Oppdater bedriftsprofil";
		
		public CompanyProfile() {
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
}
