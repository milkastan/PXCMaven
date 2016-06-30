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

import common.GenerateData;

public class CreateWPWizard extends LoadableComponent<CreateWPWizard> {
    private final static String title1 = "Opprett brukersted - Nivå i organisasjonen";
    //private final static String title2 = "Opprett brukersted - Brukerstedsdetaljer";
    WebDriverWait wait = new WebDriverWait(Browser.driver, 30);
    GenerateData gendata = new GenerateData();
    
   String wpidnum =gendata.generateRandomNumber(5);
   String wpname  ="ATESTWP_"+wpidnum;
   String stdate  = gendata.getCurrentDate("dd.MM.yyyy");
   String estdate= gendata.getCurrentDateNextYear("dd.MM.yyyy");
	
	//two methods from LoadableComponents
	@Override
	protected void load() {
	}
	@Override
	protected void isLoaded() throws Error {
	  Assert.assertTrue("Expected page title is not as actual",Browser.driver().getTitle().equals(title1));
	  System.out.println("Loaded page: "+Browser.driver().getTitle());
	}

	@FindBy(how=How.ID, using ="cpmain_TopNavigatorPlaceHolder_ucNavigatorTop_btnNext")
	WebElement NextBtn;
	@FindBy(how=How.ID, using ="cpmain_TopNavigatorPlaceHolder_ucNavigatorTop_btnFinish")
	 WebElement FinishBtn;
	
	//WP Details Fields
	@FindBy(how=How.ID, using ="cpmain_EditorControlsPlaceHolder_txtWPName")
	 WebElement WPNameField;
	@FindBy(how=How.ID, using ="cpmain_EditorControlsPlaceHolder_txtWPIDs")
	 WebElement WPIDField;
	@FindBy(how=How.ID, using ="cpmain_EditorControlsPlaceHolder_txtWPAddress")
	 WebElement WPAddrField;
	@FindBy(how=How.ID, using ="cpmain_EditorControlsPlaceHolder_txtWPCity")
	 WebElement WPCityField;
	@FindBy(how=How.ID, using ="cpmain_EditorControlsPlaceHolder_txtWPPostCode")
	 WebElement WPPostCodeField;
	@FindBy(how=How.ID, using ="cpmain_EditorControlsPlaceHolder_UCDatePickerStartDate_txtSelectedDate")
	 WebElement WPStartDateField;
	@FindBy(how=How.ID, using ="cpmain_EditorControlsPlaceHolder_UCDatePickerEstimatedEndDate_txtSelectedDate")
	 WebElement WPEstDateField;
		
	public CreateWPWizard() {
		PageFactory.initElements(Browser.driver, this);
    }
	
	public String CreateNewWP () {
		//Fill in workplace details fields
		System.out.println("Creating workplace: "+wpname);
		System.out.println("WorkplaceID: "+wpidnum);
		NextBtn.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
		//WPNameField.sendKeys(wpdata.getWPNAme());
		//WPIDField.sendKeys(wpdata.getWPID());
		//WPStartDateField.sendKeys(wpdata.getWPStartDate());
		//WPEstDateField.sendKeys(wpdata.getWPEstDate());
		WPNameField.sendKeys(wpname);
		WPIDField.sendKeys(wpidnum);
		WPAddrField.sendKeys("Address1");
		WPCityField.sendKeys("Oslo");
		WPPostCodeField.sendKeys("0010");
		WPStartDateField.sendKeys(stdate);
		WPEstDateField.sendKeys(estdate);
		
		//Click Next
		/*NextBtn.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));*/
		NextBtn.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
		NextBtn.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
		FinishBtn.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblWorkplaceNameTitle")));
		System.out.println("Workplace dashboard: "+Browser.driver.findElement(By.id("cpmain_lblWorkplaceNameTitle")).getText());
		System.out.println("--------------------------------------------");
		return wpname ;
		}
  	
	 
	public WPDashboard2 EditWP (String wpname) {
		//Fill in workplace details fields
		System.out.println("Editing workplace: "+wpname);
		NextBtn.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
		//Click Next
		NextBtn.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
		NextBtn.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblTitle")));
		FinishBtn.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblWorkplaceNameTitle")));
		System.out.println("Workplace dashboard: "+Browser.driver.findElement(By.id("cpmain_lblWorkplaceNameTitle")).getText());
		System.out.println("--------------------------------------------");
		return new WPDashboard2();
		}
  	
	
}
