package sdsPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.Browser;

public class SelectSupplier extends LoadableComponent<SelectSupplier> {
	private final static String title = "Velg leverandør";
	WebDriverWait wait = new WebDriverWait(Browser.driver, 30);
	@FindBy(how=How.ID, using ="Lage SDS")
	WebElement MenuCreateSDS;
	@FindBy(how=How.XPATH, using ="//input[@type='text']")
    WebElement SupplierField;  
	@FindBy(how=How.XPATH, using ="//input[@type='submit']")
    WebElement ImpersonameSupplBtn;  
	@FindBy(how=How.XPATH, using ="//*[@class='igdd_DropDownButton']")
    WebElement DropDownBtn;  
	 
	public SelectSupplier() {
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
	
	public SDSList ImpersonateSupplier(String supname) {
		SupplierField.sendKeys(supname);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Browser.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		SupplierField.sendKeys(Keys.ARROW_DOWN);
		SupplierField.sendKeys(Keys.ENTER);
		ImpersonameSupplBtn.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblManufacturer")));
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblManufacturer")).getText());
		return new SDSList();
	}
}
