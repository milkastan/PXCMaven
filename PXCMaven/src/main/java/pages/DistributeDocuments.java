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

public class DistributeDocuments extends LoadableComponent<DistributeDocuments>{
	private final static String title = "Brukersted dashbord";
	WebDriverWait wait = new WebDriverWait(Browser.driver, 30);
	
	 @FindBy(how=How.ID, using ="cpmain_gvSdsList_chkSelectItem_0")
	  WebElement SDSDocCheck1;
	 @FindBy(how=How.ID, using ="cpmain_ucDirectDocumentList_gvData_chkSelectItem_0")
	  WebElement WPDocCheck1;
	 
	 @FindBy(how=How.ID, using ="cpmain_btnNextTop")
	  WebElement DistributeTopNext;
	
	public DistributeDocuments() {
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
	
	public DistributeDocuments DistributeAllDocuments() {
		System.out.println("Check distribute ALL types documents from main WP dashboard");
		Browser.driver.switchTo().frame("TB_iframeContent");
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
		//check 1st SDS from the list
		if (!SDSDocCheck1.isSelected())
			SDSDocCheck1.click();
		DistributeTopNext.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
		DistributeTopNext.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
		if (!WPDocCheck1.isSelected())
			WPDocCheck1.click();
		DistributeTopNext.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
		System.out.println("--------------------------------------------");
		Browser.ClosePopFrame();
		return this;
	}
	
	//Distribute SDS document from SDS subdashboard
	public DistributeDocuments DistributeSDSDocuments() {
		System.out.println("Check distribute SDS from Chemicals  subdashboard");
		Browser.driver.switchTo().frame("TB_iframeContent");
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
		//check 1st SDS from the list
		if (!SDSDocCheck1.isSelected())
			SDSDocCheck1.click();
		DistributeTopNext.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
		System.out.println("--------------------------------------------");
		Browser.ClosePopFrame();
		return this;
	}
	
	//Distribute project document from workplace subdashboard
		public DistributeDocuments DistributeWorkplaceDocuments() {
			System.out.println("Check distribute workplace documents from main WP dashboard");
			Browser.driver.switchTo().frame("TB_iframeContent");
			System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
			//check 1st SDS from the list
			if (!WPDocCheck1.isSelected())
				WPDocCheck1.click();
			DistributeTopNext.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
			System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
			System.out.println("--------------------------------------------");
			Browser.ClosePopFrame();
			return this;
		}

		//Distribute product documents
		public DistributeDocuments DistributeProductDocuments() {
			String wactual;
			String wexpected;
			System.out.println("Check distribute product documents from products subdashboard");
			Browser.driver.switchTo().frame("TB_iframeContent");
			System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
			DistributeTopNext.click();
		    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
			//check for warning
			wexpected="Du bør velge minst et produkt til å distribuere!";
			wactual = Browser.driver.findElement(By.xpath("//*[@id='cpmain_vs']/ul/li")).getText();
			Assert.assertTrue("Missing warning for required doc selection",wactual.equals(wexpected));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
			//System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
			System.out.println("--------------------------------------------");
			Browser.ClosePopFrame();
			return this;
		}	
		
	
				
	/*   
    //!!!! Not working Select TAB Workplaces implemented as radio button
    public void DistributeDocsSelectSDS() {
    	Browser.driver.switchTo().frame("TB_iframeContent");
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
   		List<WebElement> sds = Browser.driver.findElements(By.xpath("//input[type='checkbox']"));
      	System.out.println("SDS  checkboxes size:"+sds.size());                
    	sds.get(1).click();
    	sds.get(2).click();
 		
    	System.out.println("Selected 2 SDS to distribute");
    }
    */
}
