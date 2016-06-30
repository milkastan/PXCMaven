package sdsPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.Browser;

public class ExposureScn extends LoadableComponent<ExposureScn> {
	private final static String title = "Eksponeringsscenario liste";
	WebDriverWait wait = new WebDriverWait(Browser.driver, 30);
	

	public ExposureScn() {
		PageFactory.initElements(Browser.driver, this);
	}
	
	@Override
	protected void load() {
	}
	
	@Override
	protected void isLoaded() throws Error {
	  Assert.assertTrue("Expected page title is not as actual",Browser.driver().getTitle().equals(title));
	  System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
	  System.out.println("--------------------------------------------");
	}
}
