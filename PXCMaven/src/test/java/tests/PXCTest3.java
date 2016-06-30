package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.Browser;

public class PXCTest3 extends BaseTest {

	
	@Before
	public void setUp() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");
    	System.out.println("ProductXchange - open workplace left menus!");
    	System.out.println("--------------------------------------------");
    	RunBrowser();
    	usrdash=super.SignIn(super.username,super.password);
	}
	
    @After
    public void ShutDown() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");  
    	//Browser.quit();
    }


    //Go through pages and open each page and main and sub-dashboard links
    @Test
    public void PXCTestExample() {
    	System.out.println("Test started!");
    	System.out.println("--------------------------------------------");
    	//Select Tools menu - opens Company filters
   	    tools=usrdash.navigateToTools();
	  	//open to company filters configuration
	  	cf =tools.navigateToCompanyFilters();	
	  	cf.SelectProductFilters();
	  	cf.SelectChemicalFilters();
	/*  	try {
			cf.CompanyFiltersWizard();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
  }
    
    /*@Test
  	public void PXCRA()  {
  		//Login to PXC
  		LoginPage logon = new LoginPage(Browser.driver);
  		logon.get();
  		logon.successFullLogin(username, password);
  		//Select My Hierarchy
  	    UserDashboard usrdash = new UserDashboard();
  		usrdash.navigateToRiskAssessment();
  		RiskAssessment ra = new RiskAssessment();
  		ra.ClickNewRA();
  		//Browser.driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
  		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("TB_iframeContent")));
  		Browser.driver.switchTo().frame("TB_iframeContent");
  		Browser.driver.findElement(By.id("cpmain_RAcontent_btnCreateTop")).click();
  		ra.CloseRA();	
  		}  */
    /*
    myh=usrdash.navigateToMyHierarchy(); 
    newwp="TESTWP_99840";
    docname = "Academic research";
   	myh.SearchWP(newwp);
	wpd=myh.ViewWP(newwp);
	ad=wpd.SelectAddDocument();
	ad.SearchByDocName(docname);
	ad.AddDocumentToWP(docname);
	wpd.SelectMenuViewWP();
	wpd.OpenDocumentsList();
	wpd.CheckDocumentsNumber("1");
	wpd.OpenDocumentsList();
	ad.CheckForDocument("Academic research"+"\n"+"Leverandør: NorDan AS");*/

}
