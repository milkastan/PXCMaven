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

public class AddDocuments extends LoadableComponent<AddDocuments>{
	private final static String title = "Legg til dokument";
	WebDriverWait wait = new WebDriverWait(Browser.driver, 30);

	//Web elements in Add  document page
	@FindBy(how=How.ID, using ="cpmain_txtSearchDocument")   //search document text field
	WebElement DocSearchTxtField;
	@FindBy(how=How.ID, using ="cpmain_lblBtnSearch")   //search document button
	WebElement DocSearchBtn;  
	@FindBy(how=How.ID, using ="cpmain_lblSearchHits")   //search result hits
	WebElement SearchResultHits;
	WebElement AddDocBtn;
	
	
	public AddDocuments() {
		  PageFactory.initElements(Browser.driver, this);
	  }
	
	@Override
	protected void load() {
	}
	@Override
	protected void isLoaded() throws Error {
	  Assert.assertTrue("Expected page title is not as actual",Browser.driver().getTitle().equals(title));
	  System.out.println("Loaded page: "+Browser.driver.findElement(By.id("cpmain_lblAddDocumentTitle")).getText());
	}
	
	//Search by document name
    public AddDocuments SearchByDocName(String doc) {
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblAddDocumentTitle")));
    	System.out.println("Search document by: "+doc);
    	DocSearchTxtField.clear();
    	DocSearchTxtField.sendKeys(doc);
    	DocSearchBtn.click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+doc+"']")));
    	System.out.println("Returned search results for document "+doc+": "+SearchResultHits.getText());
    	return this;
    }

    public AddDocuments AddDocumentToWP (String doc) {
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblAddDocumentTitle")));
    	System.out.println("Add document to WP: "+doc);
    	AddDocBtn = Browser.driver.findElement(By.xpath("//*[text()='"+doc+"']/../following-sibling::td/a"));
    	AddDocBtn.click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+doc+"']/../following-sibling::td/a[@class='btnAdd btnCustomGrey']")));
    	return this;
    }

	//Check on workplace dashboard document list for some document
	public AddDocuments CheckForDocument(String doc)  {
		System.out.println(Browser.driver.findElement(By.xpath("//*[text()='"+doc+"']")).getText());
		 if (doc.equals(Browser.driver.findElement(By.xpath("//*[text()='"+doc+"']")).getText())) {
        	System.out.println("Document: "+doc+" is added to workplace"); 
		 }else {  
			 System.out.println("Document: "+doc+" is not added to workplace"); 
		 }
		return this;
	}
}
	
