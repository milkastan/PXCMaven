package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.Browser;

public class ProdWPLeftMenus extends BaseTest{
	@Before
	public void setUp() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");
    	System.out.println("ProductXchange - Test User dashboard workplace links!");
    	System.out.println("--------------------------------------------");
    }
	
    @After
    public void ShutDown() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");  
    	Browser.quit();
    }

	@Test
	//Open links from last WP added to user dashboard
	public void TestWPLeftMenus () {
		RunBrowser();
	    usrdash=super.ProdSignIn(super.produname, super.prodpass);
		//Select main menu My Hierarchy	
	    myh=usrdash.navigateToMyHierarchy();
		//Search and View workplace by my hierarchy
		 newwp="TestWP_2110";
		 myh.SearchWP(newwp);
		 wpd2=myh.ViewWP2(newwp);
		//Open the left workplace menus
	    wpd2.OpenWPLeftMenus();	
	   	//wpd2.SelectWPGreenButtons(); 
	}
}
