package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.Browser;

public class DistributeDocs extends BaseTest{
	@Before
	public void setUp() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");
    	System.out.println("ProductXchange - test opening distribute documents!");
    	System.out.println("--------------------------------------------");
    	RunBrowser();
    	usrdash=super.SignIn(super.username,super.password);
	}
	
    @After
    public void ShutDown() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");  
    	Browser.quit();
    }

	@Test
	public void CheckDistributeDocs () {
		//Select main menu My Hierarchy	
	    myh=usrdash.navigateToMyHierarchy();
		//Search and View workplace by my hierarchy
		myh.SearchWP("PR_NonComplWP5");
		wpd=myh.ViewWP("PR_NonComplWP5");
	
	   //Test distribute all documents from main WP dashboard
		dd=wpd.SelectDistributeDocBtn();
		dd.DistributeAllDocuments();
		//open document link and start distribute
		wpd.OpenDocumentsList();
		dd=wpd.SelectDistributeDocBtn();
		dd.DistributeWorkplaceDocuments();
		//Open SDS list
		sds=wpd.OpenChemicalsSubdashboard();
		dd=wpd.SelectDistributeDocBtn();
		dd.DistributeSDSDocuments();
		sds.ChemicalsBacktoMain();

		//Open product list
		prod=wpd.OpenProductsSubdashboard();
		dd=wpd.SelectDistributeDocBtn();
		dd.DistributeProductDocuments();
		prod.ProductsBacktoMain();
		
	}
	
}
