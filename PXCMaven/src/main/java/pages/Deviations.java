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

public class Deviations extends LoadableComponent<Deviations> {
	private final static String title = "Avvik";
	WebDriverWait wait = new WebDriverWait(Browser.driver, 30);
	
	  // Deviations sub-dashboard links
	  //left section
	  @FindBy(how=How.ID, using ="lbtnProductsWithFilterCriteria")
	  WebElement DPRwithFilterCriteria;
	  @FindBy(how=How.ID, using ="lbtnSDSwithFilterCriteria")
	  WebElement DSDSwithFilterCriteria;
	  //Middle section
	  @FindBy(how=How.ID, using ="lbtnMissingDoP")
	  WebElement DPRwithMissingDoP; 
	  @FindBy(how=How.ID, using ="lbtnMissingSDS")
	  WebElement DPRwithMissingSDS;
	  //right section
	  @FindBy(how=How.ID, using ="lbtnMissingA20Declaration")
	  WebElement DPRwithMissingA20;
	  @FindBy(how=How.ID, using ="lbtnMissingHEA9Declaration")
	  WebElement DPRwithMissingHEA9;
	  //Links for deviations from eco certifications
	  @FindBy(how=How.ID, using ="lbtn020oZBb$DBKQXHdZ6DtWNI")
	  WebElement DEnvPRDecl;
	  @FindBy(how=How.ID, using ="lbtn0Y1cWW4ovESfCygGr8guug")
	  WebElement DSwan;
	  @FindBy(how=How.ID, using ="lbtn20Kk1DGXr028qOlStJamTL")
	  WebElement DBREEAMA20Decl;
	  @FindBy(how=How.ID, using ="lbtn22uVfpV3r2CwuEp8WOpjXJ")
	  WebElement DBREEAMA20;
	  @FindBy(how=How.ID, using ="lbtn2KBYmA5F4Ht00000PR1IRl")
	  WebElement DTechApproval;
	  @FindBy(how=How.ID, using ="lbtn3MgtUVg7n0zvA_VqVb2LXl")
	  WebElement DEUFlower;
	  @FindBy(how=How.ID, using ="lbtn3PgDCtDhDELQuqNLuuv4$D")
	  WebElement DEcoSDS;
	  @FindBy(how=How.ID, using ="lbtn3tfgIqHj16APhmEo5bCTqn")
	  WebElement DBREEAMHEA9Decl;
	  @FindBy(how=How.ID, using ="lbtn3TJ6RbZqjDiA7jOoIIqfWJ")
	  WebElement DEmissClass;
	  
	 	  
	  //Back to  main
	  @FindBy(how=How.ID, using ="hlnkBackToDashboard")
	  WebElement DeviationsBacktoMain;
	  
	  //Send Feedback WebElements
	  @FindBy(how=How.ID, using ="cpmain_tableContent_ucProductList_gvData_imgFeedbackSent_0")
      WebElement SendFeedBackIcon;
	  @FindBy(how=How.ID, using ="TB_closeWindowButton")   //Button is in the  main window
	  WebElement CloseFeedBackPopUp;
	  @FindBy(how=How.ID, using ="cpmain_btnSend")       //Button is in the frame "TB_iframeContent"
	  WebElement SendFeedBackbtn;
	  @FindBy(how=How.ID, using ="cpmain_ucWorkplaceSummary_lblName")       //Button is in the frame "TB_iframeContent"
	  WebElement DeviationTitle;
	  
		
	public Deviations() {
		  PageFactory.initElements(Browser.driver, this);
	  }
	
	@Override
	protected void load() {
	}
	@Override
	protected void isLoaded() throws Error {
	  Assert.assertTrue("Expected page title is not as actual",Browser.driver().getTitle().equals(title));
	  System.out.println("Loaded page: "+Browser.driver().getTitle());
	  System.out.println("Loaded page: "+Browser.driver.findElement(By.id("cpmain_lblWorkplaceNameTitle")).getText());
	}
	
	public WPDashboard DeviationsBacktoMain() {
		wait.until(ExpectedConditions.elementToBeClickable(DeviationsBacktoMain));
		DeviationsBacktoMain.click();
		System.out.println("Selected link Back to WP dashboard");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblWorkplaceNameTitle")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblWorkplaceNameTitle")).getText());
	   	System.out.println("--------------------------------------------");
		return new WPDashboard();
	}
	
	public Deviations OpenDeviationsSubdashboardLinks() {
		System.out.println("Open all links from Deviations Sub-dashboard");
		System.out.println("--------------------------------------------");
		OpenProductswithMissingDoP();
		OpenProductswithMissingSDS();
		OpenProductswithMissingA20();
		OpenProductswithMissingHEA9();
		//back to main dashboard
		//DeviationsBacktoMain();
	   	System.out.println("--------------------------------------------");
		return this;
	}
	
	public Deviations OpenDeviationEcoDocs () {
		//open link related to eco documentation
		OpenEnvDecl();
		OpenSwan();
		OpenBREEAMA20Decl();
		OpenBREEAMA20();
		OpenTechnicalApproval();
		OpenEUFlower();
		OpenEcoSDS();
		OpenBREEAMHEA9Decl();
		OpenEmissionClassification();
		return this;
	}
	
	public Deviations OpenProductswithFilterCriteria() {
		wait.until(ExpectedConditions.elementToBeClickable(DPRwithFilterCriteria));
		DPRwithFilterCriteria.click();
		System.out.println("Selected link Products with Filter criteria");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return this;
	}
	
	public Deviations OpenSDSwithFilterCriteria() {
		wait.until(ExpectedConditions.elementToBeClickable(DSDSwithFilterCriteria));
		DSDSwithFilterCriteria.click();
		System.out.println("Selected link SDS with Filter criteria");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return this;
	}
	public Deviations OpenProductswithMissingDoP() {
		wait.until(ExpectedConditions.elementToBeClickable(DPRwithMissingDoP));
		DPRwithMissingDoP.click();
		System.out.println("Selected link Products with missing DoP");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return this;
	}
	
	public Deviations OpenProductswithMissingSDS() {
		wait.until(ExpectedConditions.elementToBeClickable(DPRwithMissingSDS));
		DPRwithMissingSDS.click();
		System.out.println("Selected link Products with missing SDS");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return this;
	}
	
	public Deviations OpenProductswithMissingA20() {
		wait.until(ExpectedConditions.elementToBeClickable(DPRwithMissingA20));
		DPRwithMissingA20.click();
		System.out.println("Selected link Products with missing A20 declaration");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return this;
	}
	
	public Deviations OpenProductswithMissingHEA9() {
		wait.until(ExpectedConditions.elementToBeClickable(DPRwithMissingHEA9));
		DPRwithMissingHEA9.click();
		System.out.println("Selected link Products with missing HEA9 declaration");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return this;
	}
	
	public Deviations OpenEnvDecl() {
		wait.until(ExpectedConditions.elementToBeClickable(DEnvPRDecl));
		DEnvPRDecl.click();
		System.out.println("Selected link environmental product declaration");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return this;
	}
	
	public Deviations OpenSwan() {
		wait.until(ExpectedConditions.elementToBeClickable(DSwan));
		DSwan.click();
		System.out.println("Selected link Swan");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return this;
	}
	
	public Deviations OpenBREEAMA20Decl() {
		wait.until(ExpectedConditions.elementToBeClickable(DBREEAMA20Decl));
		DBREEAMA20Decl.click();
		System.out.println("Selected link BREEAM A20 declaration");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return this;
	}
	
	public Deviations OpenBREEAMA20() {
		wait.until(ExpectedConditions.elementToBeClickable(DBREEAMA20));
		DBREEAMA20.click();
		System.out.println("Selected link BREEAM A20");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return this;
	}
	
	public Deviations OpenTechnicalApproval() {
		wait.until(ExpectedConditions.elementToBeClickable(DTechApproval));
		DTechApproval.click();
		System.out.println("Selected link Technical approval");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return this;
	}
	
	public Deviations OpenEUFlower() {
		wait.until(ExpectedConditions.elementToBeClickable(DEUFlower));
		DEUFlower.click();
		System.out.println("Selected link EU Flower");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return this;
	}
	
	public Deviations OpenEcoSDS() {
		wait.until(ExpectedConditions.elementToBeClickable(DEcoSDS));
		DEcoSDS.click();
		System.out.println("Selected link SDS");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return this;
	}
	
	public Deviations OpenBREEAMHEA9Decl() {
		wait.until(ExpectedConditions.elementToBeClickable(DBREEAMHEA9Decl));
		DBREEAMHEA9Decl.click();
		System.out.println("Selected link BREEAM HEA9 declaration");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return this;
	}
	
	public Deviations OpenEmissionClassification() {
		wait.until(ExpectedConditions.elementToBeClickable(DEmissClass));
		DEmissClass.click();
		System.out.println("Selected link Emission Classification");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return this;
	}
	
}
