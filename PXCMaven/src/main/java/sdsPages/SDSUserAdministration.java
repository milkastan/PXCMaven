package sdsPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.Browser;

public class SDSUserAdministration extends LoadableComponent<SDSUserAdministration>{

	private final static String title = "Liste over brukere";
	WebDriverWait wait = new WebDriverWait(Browser.driver, 30);
	

	public SDSUserAdministration() {
		PageFactory.initElements(Browser.driver, this);
	}
	
	@Override
	protected void load() {
	}
	
	@Override
	protected void isLoaded() throws Error {
	  Assert.assertTrue("Expected page title is not as actual",Browser.driver().getTitle().equals(title));
	  System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblUserListTitle")).getText());
	  System.out.println("--------------------------------------------");
	}
}
