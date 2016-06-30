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

public class Chemicals extends LoadableComponent<Chemicals> {
	private final static String title = "Stoffkartotek";
	WebDriverWait wait = new WebDriverWait(Browser.driver, 30);
	
	//Chemicals sub-dashboard links
	@FindBy(how=How.ID, using ="lbtnSDSs")
	WebElement CSDSList;
	@FindBy(how=How.ID, using ="hlnkMissingSDS")
	WebElement CPRMissingSDS;
	@FindBy(how=How.ID, using ="lbtnSDSwithFilterCriteria")
	WebElement CSDSwithFilterCriteria;
	//middle section
	@FindBy(how=How.ID, using ="lbtnWPRiskAssessments")
	WebElement CWPRiskAssessment;
	@FindBy(how=How.ID, using ="lbtnWPInstructions")
	WebElement CWPInfSheets;
	@FindBy(how=How.ID, using ="lbtnWPComments")
	WebElement CWPComments;
	@FindBy(how=How.ID, using ="lbtnHazardousWaste")
	WebElement CHazardowsWaste;
	@FindBy(how=How.ID, using ="lbtnLists")
	WebElement CSDSwithListsCriteria;
	
	 //Back to main dashboard
	@FindBy(how=How.ID, using ="hlnkBackToDashboard")
	WebElement ChemicalsBacktoMain;
	
	public Chemicals() {
		  PageFactory.initElements(Browser.driver, this);
	  }
	
	@Override
	protected void load() {
	}
	@Override
	protected void isLoaded() throws Error {
	  Assert.assertTrue("Expected page title is not as actual",Browser.driver().getTitle().equals(title));
	  System.out.println("Loaded page: "+Browser.driver.findElement(By.id("cpmain_ucWorkplaceSummary_lblName")).getText());
	}
	
	public WPDashboard ChemicalsBacktoMain() {
		wait.until(ExpectedConditions.elementToBeClickable(ChemicalsBacktoMain));
		ChemicalsBacktoMain.click();
		System.out.println("Selected link Back to WP dashboard");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_lblWorkplaceNameTitle")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblWorkplaceNameTitle")).getText());
	   	System.out.println("--------------------------------------------");
		return new WPDashboard();
	}
	
	public Chemicals OpenChemicalsSubdashboardLinks() {
		System.out.println("Open all links from Chemicals Sub-dashboard");
		System.out.println("--------------------------------------------");
		OpenProductswithMissingSDS();
		OpenSDSwithFilterCriteria();
		OpenWPRiskAssessment();
		OpenWPInformationSheets();
		OpenWPComments();
		OpenSDSHazardousWaste();
		OpenSDSwithListCriteria();
		OpenChemicalsList();
		ChemicalsBacktoMain();
	   	System.out.println("--------------------------------------------");
		return new Chemicals();
	}
	
	public Chemicals OpenProductswithMissingSDS() {
		wait.until(ExpectedConditions.elementToBeClickable(CPRMissingSDS));
		CPRMissingSDS.click();
		System.out.println("Selected link Products with missing SDS");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblDetailsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblDetailsHeader")).getText());
	   	System.out.println("Dashboard title:"+Browser.driver.findElement(By.id("cpmain_ucWorkplaceSummary_lblName")).getText());
	   	System.out.println("Return back to products subdashboard");
	   	Browser.driver.navigate().back();
	   	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblChemicalsHeader")));
	   	System.out.println("--------------------------------------------");
		return new Chemicals();
	}
	
	public Chemicals OpenSDSwithFilterCriteria() {
		wait.until(ExpectedConditions.elementToBeClickable(CSDSwithFilterCriteria));
		CSDSwithFilterCriteria.click();
		System.out.println("Selected link SDS with Filter Criteria");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblChemicalsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblChemicalsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return new Chemicals();
	}
	
	public Chemicals OpenWPRiskAssessment() {
		wait.until(ExpectedConditions.elementToBeClickable(CWPRiskAssessment));
		CWPRiskAssessment.click();
		System.out.println("Selected link Workplace Risk Assessment");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblChemicalsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblChemicalsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return new Chemicals();
	}
	
	public Chemicals OpenWPInformationSheets() {
		wait.until(ExpectedConditions.elementToBeClickable(CWPInfSheets));
		CWPInfSheets.click();
		System.out.println("Selected link Workplace Information sheets");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblChemicalsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblChemicalsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return new Chemicals();
	}
	
	public Chemicals OpenWPComments() {
		wait.until(ExpectedConditions.elementToBeClickable(CWPComments));
		CWPComments.click();
		System.out.println("Selected link Workplace SDS Comments");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblChemicalsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblChemicalsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return new Chemicals();
	}
	
	public Chemicals OpenSDSHazardousWaste() {
		wait.until(ExpectedConditions.elementToBeClickable(CHazardowsWaste));
		CHazardowsWaste.click();
		System.out.println("Selected link SDS Hazardows Waste");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblChemicalsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblChemicalsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return new Chemicals();
	}
	
	public Chemicals OpenSDSwithListCriteria() {
		wait.until(ExpectedConditions.elementToBeClickable(CSDSwithListsCriteria));
		CSDSwithListsCriteria.click();
		System.out.println("Selected link SDS with Lists Criteria");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblChemicalsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblChemicalsHeader")).getText());
	   	System.out.println("--------------------------------------------");
		return new Chemicals();
	}
	
	public Chemicals OpenChemicalsList() {
		wait.until(ExpectedConditions.elementToBeClickable(CSDSList));
		CSDSList.click();
		System.out.println("Selected link Chemicals List");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cpmain_tableContent_lblChemicalsHeader")));
	   	System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_tableContent_lblChemicalsHeader")).getText());
	   	System.out.println("Dashboard title:"+Browser.driver.findElement(By.id("cpmain_ucWorkplaceSummary_lblName")).getText());
	   	System.out.println("--------------------------------------------");
		return new Chemicals();
	}
	
}
