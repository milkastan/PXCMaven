package sdsPages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.Browser;
import pages.Common;

public class EditSDS extends LoadableComponent<EditSDS>{
	private final static String title = "Rediger SDS";
	WebDriverWait wait = new WebDriverWait(Browser.driver, 30);
	//menu SDS list
	  @FindBy(how=How.LINK_TEXT, using ="Liste over SDS")
	  WebElement MenuSDSList;
	//edit SDS elements
	@FindBy(how=How.ID, using ="cpmain_btnSimpleContainer")  
	WebElement SDSSimpleBtn;
	@FindBy(how=How.ID, using ="cpmain_btnFullContainer")   
	WebElement SDSFullBtn;
	@FindBy(how=How.ID, using ="cpmain_btnSaveTop")   
	WebElement SDSSaveBtn;
	@FindBy(how=How.ID, using ="cpmain_btnPublishTop")   
	WebElement SDSPublishBtn;
	@FindBy(how=How.XPATH, using ="//*[@id='cpmain_tblSDSData']/tbody/tr[1]")   
	WebElement SDSSec1;
	@FindBy(how=How.XPATH, using ="//*[@id='tblData']/tbody/tr[3]/td/table/tbody/tr[1]/td[2]")   
	WebElement SDSTradeNameFld;
	@FindBy(how=How.XPATH, using ="//*[@id='txtString']")   
	WebElement SDSTradeNameTxt;
	@FindBy(how=How.XPATH, using ="//*[@id='tblData']/tbody/tr[5]/td/table/tbody/tr[3]/td[2]")   
	WebElement SDSProdTypeFld;
	//phrase library frame Save Btn
	@FindBy(how=How.ID, using ="cpmain_ucPhraseLibraryEditor_btnEditSave")   
	WebElement PhraseSaveBtn;
	@FindBy(how=How.XPATH, using ="//input[@id='x:1757994065.2:mkr:Input']")   
	WebElement PhraseTextField;
	@FindBy(how=How.XPATH, using ="//*[@class='igdd_DropDownButton']")   
	WebElement PhraseDropDownBtn;
	
	
	public EditSDS() {
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
	
	public EditSDS SelectSDSsection(String secno) throws InterruptedException  {
		String SSecPath = "//*[@id='cpmain_tblSDSData']/tbody/tr["+secno.toString()+"]";
		WebElement SSecFld = Browser.driver.findElement(By.xpath(SSecPath));
		SSecFld.click();
		Thread.sleep(5000);
		return this;
	}
	
    public  SDSList navigateToSDSList() {
        wait.until(ExpectedConditions.elementToBeClickable(MenuSDSList));
        MenuSDSList.click();
      	 System.out.println("Selected SDS menu SDS List");
      	 wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblManufacturer")));
      	 System.out.println("Loaded page: "+Browser.driver().getTitle());
        System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblManufacturer")).getText());
        System.out.println("--------------------------------------------");
        return new SDSList();
   	} 
	
	public EditSDS OpenSESSection1() {
		System.out.println("Open SDS section 1");
		SDSSec1.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='1.1 PRODUKTIDENTIFIKATOR']")));
		return this;
	}
	
    public EditSDS AddSDSTradeName(String tradename) throws InterruptedException  {
       System.out.println("Enter Trade Name");
       Common.WaitForClickable(SDSTradeNameFld, 5);
       Thread.sleep(1000);
       SDSTradeNameFld.click();
       Thread.sleep(1000);
       Common.WaitForVisibility((By.xpath("//*[@id='txtString']")), 5);
       SDSTradeNameTxt.clear();
       SDSTradeNameTxt.sendKeys(tradename);
       SDSSaveBtn.click();
       System.out.println("Trade Name is saved");
	  return this;
    }
    
   
    public EditSDS AddSDSProductType() throws InterruptedException{
    	System.out.println("Select Product Type");
    	//click on product type field
    	Actions action = new Actions(Browser.driver);
    	action.moveToElement(SDSProdTypeFld);
    	Thread.sleep(1000);
       	action.doubleClick(SDSProdTypeFld).perform();
       	Thread.sleep(1000);
    	Common.WaitForPresence((By.id("TB_iframeContent")), 5);
    	Browser.driver.switchTo().frame("TB_iframeContent");
		System.out.println("Opened phrase library to select product type");
		//PhraseTextField.click();
		//System.out.println("Clicked on pt phrase");
		action.sendKeys("A0").perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.ARROW_DOWN).perform();;
		System.out.println("Key down is pressed"); 
		Thread.sleep(2000);
		PhraseSaveBtn.click();
		Thread.sleep(1000);
		Browser.SwitchToMain();		
	  	return this;
    }
    
    public EditSDS PublishSDS() throws InterruptedException{
    	SDSPublishBtn.click();
    	System.out.println("SDS is published");
    	Thread.sleep(5000);
    	return this;
    }
    
    public EditSDS SaveSDS()throws InterruptedException {
    	SDSSaveBtn.click();
    	Thread.sleep(4000);
    	return this;
    }

}
