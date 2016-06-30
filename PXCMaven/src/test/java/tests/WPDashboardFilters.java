package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.Browser;

public class WPDashboardFilters extends BaseTest {
	@Before
	public void setUp() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");
    	System.out.println("ProductXchange - test workplace dashboard filters!");
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
	public void CheckWPDashboardFilters () {
		//Select main menu My Hierarchy	
	    myh=usrdash.navigateToMyHierarchy();
		//Search and View workplace by my hierarchy
		myh.SearchWP("PR_NonComplWP5");
		wpd=myh.ViewWP("PR_NonComplWP5");
		//check active WP and change area filter
		wpd.SelectWPFilterCurrentWorkplace();
		wpd.CheckProductsNumber("8");
		wpd.SelectWPFilterChildWorkplace();
		wpd.CheckProductsNumber("11");
		wpd.SelectWPFilterInvitedWholesaler();
		wpd.CheckProductsNumber("22");
		//Check Active/Invited companies
		wpd.SelectWPFilterInvitedCompanies();
		wpd.CheckProductsNumber("37");
		
		//Check All WP and change area filter
		wpd.SelectWPFilterAllWorkplaces();
		wpd.CheckProductsNumber("46");
		wpd.SelectWPFilterInvitedWholesaler();
		wpd.CheckProductsNumber("25");
		wpd.SelectWPFilterChildWorkplace();
		wpd.CheckProductsNumber("17");
		wpd.SelectWPFilterCurrentWorkplace();
		wpd.CheckProductsNumber("8");
		
	}
}
