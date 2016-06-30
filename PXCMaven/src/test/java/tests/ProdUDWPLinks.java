package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.Browser;

public class ProdUDWPLinks extends BaseTest{
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
	public void OpenUSerDashboardWPLinks () {
		 RunBrowser();
	     usrdash=super.ProdSignIn(super.produname, super.prodpass);
		 usrdash.OpenUDFirstWPLinks();	
	}
}
