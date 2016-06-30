package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.Browser;

public class TestAddProducts extends BaseTest {
	@Before
	public void setUp() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");
    	System.out.println("Test Products search and Add products to workplace!");
    	System.out.println("--------------------------------------------");
    	RunBrowser();
    	usrdash=super.SignIn(super.username,super.password);

		//Browser.initIE();
	}
	
    @After
    public void ShutDown() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");  
    	Browser.quit();
    }

	@Test
	public void TestProductsSearch () {
		  newwp="TESTWP_1171";
		 //Select main menu My Hierarchy	
		   myh=usrdash.navigateToMyHierarchy();
			//Search and View workplace by my hierarchy
			myh.SearchWP(newwp);
			wpd2=myh.ViewWP2(newwp);
			//select add product page
		    ap=wpd.SelectAddProduct();
		    ap.OpenAllProductSearchPages();
		    
		    
		    ap.SelectSimpleProductSearch();
		    ap.SearchBySupplier("MOTEK AS");
		    //add one product to WP
		    ap.AddProductToWP();
		    //Search by product name
		    ap.SearchByPRName_ID("7311850023082");
		    ap.AddProductToWP();
		    ap.SearchByPRName_ID("Surfix");
		    ap.AddProductToWP();
		    //wpd.CheckProductsNumber("3");
		    
	}
	
	
	
	
}
