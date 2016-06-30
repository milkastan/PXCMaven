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


public class InviteCompany extends LoadableComponent<InviteCompany>{
    private final static String title = "Importer bedrift";
    WebDriverWait wait = new WebDriverWait(Browser.driver, 30);
    
    @FindBy(how=How.ID, using ="cpmain_txtSearch")
   	WebElement InvCompSearchField;
    @FindBy(how=How.ID, using ="cpmain_lblBtnSearch")
    WebElement InvCompSearchBtn;
    @FindBy(how=How.ID, using ="cpmain_btnInviteByMail")
   	WebElement InvCompByEmailBtn;
    @FindBy(how=How.ID, using ="cpmain_ucEmailList_txtAddEmail")
   	WebElement RecipientField;
    @FindBy(how=How.ID, using ="cpmain_ucEmailList_btnAddEmail")
   	WebElement RecipientAddBtn;
    @FindBy(how=How.ID, using ="cpmain_btnSend")
   	WebElement SendInviteEmailBtn;
    
    WebElement AddToBtn;
    
    public InviteCompany() {
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
	
	public InviteCompany SearchToInviteComp(String comp) {
		System.out.println("Search to invite company "+comp);
		InvCompSearchField.clear();
		InvCompSearchField.sendKeys(comp);
		InvCompSearchBtn.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+comp+"']")));
		System.out.println("Company "+comp+" is found for invite");
		System.out.println("--------------------------------------------");
		return this;
	}
	
	public InviteCompany SendInviteEmail(String comp) throws InterruptedException  {
		System.out.println("Search for company which does not exist: "+comp);
		InvCompSearchField.clear();
		InvCompSearchField.sendKeys(comp);
		InvCompSearchBtn.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_vsMessage")));
		System.out.println(Browser.driver.findElement(By.id("cpmain_vsMessage")).getText());
		InvCompByEmailBtn.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("TB_iframeContent")));
		Browser.driver.switchTo().frame("TB_iframeContent");
		System.out.println("Sending email to company recipient test@test.no");
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
		RecipientField.sendKeys("test@test.no");
		RecipientAddBtn.click();
		Thread.sleep(2000);
		SendInviteEmailBtn.click();
		Thread.sleep(2000);
		Browser.driver.switchTo().window(Browser.mainwin);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblSearch")));
		InvCompSearchField.clear();
		System.out.println("Returned to invite company main page");
		System.out.println(Browser.driver.findElement(By.xpath("//*[@id='cpmain_vsMessage']")).getText());
		System.out.println("--------------------------------------------");
		return this;
	}
	
	public InviteCompany InviteCompanyToWP(String comp)  {
		System.out.println("Search to invite company "+comp);
		InvCompSearchField.clear();
		InvCompSearchField.sendKeys(comp);
		InvCompSearchBtn.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+comp+"']")));
		AddToBtn = Browser.driver.findElement(By.xpath("//*[text()='"+comp+"']/../following-sibling::td/div/a"));
		//invite company to workplace
		AddToBtn.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+comp+"']/../following-sibling::td/div/a[@class='btnAdd btnCustomGrey']")));
		System.out.println("Company "+comp+" is invited to workplace");
		System.out.println("--------------------------------------------");
		return this;
	}
	//Check on workplace dashboard invited companies for invited company
	public InviteCompany CheckForInvitedCompany(String comp)  {
		System.out.println("Check for invited company");
		WebElement invcomp =Browser.driver.findElement(By.xpath("//*[text()='"+comp+"']"));
		 if (comp.equals(invcomp.getText())) {
        	System.out.println("Invited workplace: "+comp+" is created successfully"); 
		 }else {  
			 System.out.println("Invited workplace: "+comp+" is not created successfully"); 
		 }
		 System.out.println("Invited Company Color:"+invcomp.getCssValue("color").toString());
		return this;
	}
	
	public void CheckInvitedCompanyColor(String comp) {
		CheckForInvitedCompany(comp);
		
	}
}
