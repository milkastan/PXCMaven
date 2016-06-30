package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.Browser;

public class AllDashboardLinks extends BaseTest {
	String uname="optilag";
	String pass="inlag09";

	@Before
	public void setUp() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");
    	System.out.println("ProductXchange - Test All dashboards links!");
    	System.out.println("--------------------------------------------");
	}
	
    @After
    public void ShutDown() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");  
    	Browser.quit();
    }

	@Test
	//Open links in the main and all subdashboards
	public void OpenDashboardLinks () {
	   RunBrowser();
       usrdash=super.SignIn(super.username,super.password);
	   //Select main menu My Hierarchy	
	   myh=usrdash.navigateToMyHierarchy();
		//Search and View workplace by my hierarchy
	   newwp="ATESTWP_DEV_FB";
		myh.SearchWP(newwp);
		wpd=myh.AViewWP(newwp);
	   //Open main dashboard links
		wpd.OpenSuggestedURW();             
		wpd.OpenInvitedCompanies();			
		wpd.OpenSubworkplaces();		
		prod = wpd.OpenProductsSubdashboard();   	
		prod.OpenProductSubdashboardLinks();
		sds=wpd.OpenChemicalsSubdashboard();
		sds.OpenChemicalsSubdashboardLinks();
		wpd.OpenDocumentsList();
		dev=wpd.OpenDeviationsSubdashboard();
		dev.OpenDeviationsSubdashboardLinks();
		//dev.OpenDeviationEcoDocs();
		dev.DeviationsBacktoMain();
	   //Finished opening links
		//open add product and check options
		ap=wpd.SelectAddProduct();
		ap.OpenAllProductSearchPages();
		//open add document page
		ad=wpd.SelectAddDocument();
	}
	
	/*
	@Test
	//dashboard links performance
	public void DashboardLinksPerf() {
		   RunBrowser();
	       usrdash=super.SignIn(uname,pass);
		   //Select main menu My Hierarchy	
		   myh=usrdash.navigateToMyHierarchy();
			//Search and View workplace by my hierarchy
		   newwp="Montér Egersund";
		   myh.SearchWP(newwp);
		   wpd=myh.AViewWP(newwp);
		   //Open products dashboard links
		   prod = wpd.OpenProductsSubdashboard();   	
		   prod.OpenProductSubdashboardLinks();
		   //open chemicals dashboard links
		   sds=wpd.OpenChemicalsSubdashboard();
		   sds.OpenChemicalsSubdashboardLinks();
		   //open deviations dashboard links
		   dev=wpd.OpenDeviationsSubdashboard();
		   dev.OpenDeviationsSubdashboardLinks();
		   dev.DeviationsBacktoMain();
	}
	*/
}