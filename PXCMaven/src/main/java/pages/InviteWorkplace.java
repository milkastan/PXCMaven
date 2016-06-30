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

public class InviteWorkplace extends LoadableComponent<InviteWorkplace> {
	 private final static String title = "Importer brukersted";
	 WebDriverWait wait = new WebDriverWait(Browser.driver, 30);
	 
	 //WebElements for inviting workplace
	   @FindBy(how=How.ID, using ="cpmain_txtSearch")
	   	WebElement InvWPSearchField;
	    @FindBy(how=How.ID, using ="cpmain_lblBtnSearch")
	   	WebElement InvWPSearchBtn;
	    
	    WebElement AddToWPBtn;    //button to invite workplace 
	    
		public InviteWorkplace() {
			  PageFactory.initElements(Browser.driver, this);
		}

		@Override
		protected void load() {
		}
		
		@Override
		protected void isLoaded() throws Error {
		  Assert.assertTrue("Expected page title is not as actual",Browser.driver().getTitle().equals(title));
			//System.out.println("Loaded page: "+Browser.driver().getTitle());
			System.out.println("Loaded page: "+Browser.driver.findElement(By.id("cpmain_lblInviteWorkplaceTitle")).getText());
	     }
		
		//244119c6-cc5c-4582-9502-3319f281dcf8   , BB-WP26900 
		public InviteWorkplace InviteWP(String wpkey)  {
			System.out.println("Invite workplace by entering workplace key");
			InvWPSearchField.clear();
			InvWPSearchField.sendKeys(wpkey);
			InvWPSearchBtn.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='btnAdd btnCustomGreen']")));
			AddToWPBtn = Browser.driver.findElement(By.xpath("//*[@class='btnAdd btnCustomGreen']"));
			//invite company to workplace
			AddToWPBtn.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='aspNetDisabled btnAdd btnCustomGrey']")));
			System.out.println("Workplace has invited");
			System.out.println("--------------------------------------------");
			return this;
		}
		
		//Check on workplace dashboard invited companies for invited company
		public InviteWorkplace CheckForInvitedWorkplace(String wpn)  {
			System.out.println(Browser.driver.findElement(By.xpath("//*[text()='"+wpn+"']")).getText());
			 if (wpn.equals(Browser.driver.findElement(By.xpath("//*[text()='"+wpn+"']")).getText())) {
	        	System.out.println("Invited workplace: "+wpn+" is created successfully"); 
			 }else {  
				 System.out.println("Invited workplace: "+wpn+" is not created successfully"); 
			 }
			return this;
		}
}
