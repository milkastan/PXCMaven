package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RiskAssessment extends LoadableComponent<RiskAssessment> {
	private final static String title = "Administrer risikovurderingsmal";
	
	//GenerateData gendata = new GenerateData();
	//public String RAName = "RATEST_"+gendata.generateRandomNumber(4);
	public static String RAName = "RA_0902";
	WebDriverWait wait = new WebDriverWait(Browser.driver, 30);
	public static WebElement ViewRABtn;
	public static WebElement EditRABtn;
	public static WebElement DeleteRABtn;
	
	//main buttons for risk assessment
    @FindBy(how=How.ID, using ="cpmain_topSubMenu_menu_hlCreateRA")
	WebElement NewRABtn;
    @FindBy(how=How.ID, using ="cpmain_topSubMenu_menu_hlRAList")
   	WebElement RAListRABtn;
       
    //Create new risk assessment 
    @FindBy(how=How.ID, using ="cpmain_RAcontent_btnCreateTop")
  	WebElement NextRATopBtn;
    @FindBy(how=How.ID, using ="cpmain_RAcontent_btnNextTop")
  	WebElement NextStepRABtn;
    @FindBy(how=How.ID, using ="cpmain_RAcontent_btnSaveBottom")
  	WebElement SaveRABtn;
    @FindBy(how=How.ID, using ="cpmain_RAcontent_ucSimpleSearch_txtTradeName")
	WebElement SDSNameField;
    @FindBy(how=How.ID, using ="cpmain_RAcontent_ucSimpleSearch_lblBtnSearch")
   	WebElement SearchSDSBtn;
    @FindBy(how=How.ID, using ="cpmain_RAcontent_SDSListResults_gvData_lblAddButton_0")
   	WebElement AddSDS1Btn;
    @FindBy(how=How.ID, using ="cpmain_RAcontent_txtRAName")
   	WebElement RiskNameField;
    @FindBy(how=How.ID, using ="cpmain_RAcontent_ucViewRA_lblRiskAssessmentName")
   	WebElement RiskNameTitle;
    @FindBy(how=How.ID, using ="cpmain_RAcontent_gvRiskAssessmentList")
   	WebElement RiskList;
    
   //Buttons view , edit, delete for risk assessment specified by RAName
   /* WebElement ViewRABtn = Browser.driver.findElement(By.xpath("//*[text()='"+RAName+"']/../following-sibling::td/a[1]/img[@original-title='Vis']")); 
    WebElement EditRABtn = Browser.driver.findElement(By.xpath("//*[text()='"+RAName+"']/../following-sibling::td/a[2]/img[@original-title='Rediger']"));
    WebElement DeleteRABtn = Browser.driver.findElement(By.xpath("//*[text()='"+RAName+"']/../following-sibling::td/a[3]/img[@original-title='Slett']")); 
  */
    
      
	public RiskAssessment() {
		  PageFactory.initElements(Browser.driver, this);
		  //Browser.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  //ViewRABtn = Browser.driver.findElement(By.xpath("//*[text()='"+RAName+"']/../following-sibling::td/a[1]/img[@original-title='Vis']"));
		  //EditRABtn = Browser.driver.findElement(By.xpath("//*[text()='"+RAName+"']/../following-sibling::td/a[2]/img[@original-title='Rediger']"));
		  //DeleteRABtn = Browser.driver.findElement(By.xpath("//*[text()='"+RAName+"']/../following-sibling::td/a[3]/img[@original-title='Slett']")); 
		   }
	  
		@Override
		protected void load() {
		}
		
		@Override
		protected void isLoaded() throws Error {
		  Assert.assertTrue("Expected page title is not as actual",Browser.driver().getTitle().equals(title));
		  //System.out.println("Loaded page: "+Browser.driver.findElement(By.id("cpmain_RAcontent_lblRAListTitle")).getText());
		}
	
		public RiskAssessment ClickNewRA() {
			NewRABtn.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("TB_iframeContent")));
			return new RiskAssessment();
		}
		
		public RiskAssessment CreateNewRA() {
			System.out.println("Create new risk assessment");
			Browser.driver.switchTo().frame("TB_iframeContent");
			SDSNameField.sendKeys("afk");
			SearchSDSBtn.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_RAcontent_SDSListResults_gvData_imgAdd_0")));
			AddSDS1Btn.click();
			NextRATopBtn.click();
			NextStepRABtn.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_RAcontent_txtRAName")));
			System.out.println(RAName);
			RiskNameField.sendKeys(RAName);
			SaveRABtn.click();
			//System.out.println("Risk Assessment is saved");
			System.out.println(RiskNameTitle.getText());
			//Assert.assertTrue("Check with created RA Title",RiskNameTitle.getText().equals(RAName));
			return new RiskAssessment();
		}

		//	View risk assessment list from pop-up
		//popup=true - RA list is viewed in pop-up
		//popup=false - RA list is on main page
		public RiskAssessment ViewRAList(boolean popup) {
			if (popup){
				Browser.driver.switchTo().frame("TB_iframeContent");
				System.out.println("View risk assessment list in popup");
			} else {
				System.out.println("View risk assessment list on main page");
			}
			RAListRABtn.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_RAcontent_gvRiskAssessmentList")));
			return new RiskAssessment();
		}
		
		//Check if exist in RA list risk assessment with name RAName
		public RiskAssessment CheckRA(){
			List<WebElement> ralist = Browser.driver.findElements(By.xpath("//*[@id='lblRAName']"));
			for (WebElement risk : ralist){
				if (risk.getText().equals(RAName)){
						System.out.println("Risk is found in the list");
				}							
			}
			return new RiskAssessment();
		}
		
		public RiskAssessment DeleteRA() {
			
			 
			return new RiskAssessment();
		}
		
		public RiskAssessment ViewRA() {
			System.out.println("View RA from company RA list");
			ViewRABtn.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("TB_iframeContent")));
			System.out.println("Viewed risk assessment report");
			CloseRA();			 
			return new RiskAssessment();
		}
		
		public RiskAssessment EditRA() {
			System.out.println("Edit RA from company RA list");
			EditRABtn.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("TB_iframeContent")));
			Browser.driver.switchTo().frame("TB_iframeContent");
			System.out.println("Risk Assessment step 1 New/Edit: ");
			NextRATopBtn.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_RAcontent_lblGuidance")));
			System.out.println("Risk Assessment step 2 - Exposure level/Frequency of use: ");
			NextStepRABtn.click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_RAcontent_lblChosenProductsTitle")));
			System.out.println("Risk Assessment step 3 - Remarks,status, conclusion: ");
			SaveRABtn.click();
			CloseRA();		
			return new RiskAssessment();
		}
		
		public RiskAssessment CloseRA() {
			Browser.driver.switchTo().window(Browser.mainwin);
			WebElement CloseRABtn = Browser.driver.findElement(By.id("TB_closeWindowButton"));
			CloseRABtn.click();	
			System.out.println("Close risk assessment popup");
			return new RiskAssessment();
		}
}
