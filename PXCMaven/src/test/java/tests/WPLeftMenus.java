package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.Browser;

public class WPLeftMenus extends BaseTest {
	//public GenerateData gendata = new GenerateData();

	@Before
	public void setUp() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");
    	System.out.println("ProductXchange - open workplace left menus!");
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
	//Open left menus from workplace dashboard
	public void TestWPLeftMenus () {
		//Select main menu My Hierarchy	
	    myh=usrdash.navigateToMyHierarchy();
		//Search and View workplace by my hierarchy
		myh.SearchWP("PR_NonComplWP5");
		wpd2=myh.ViewWP2("PR_NonComplWP5");
		//Open the left workplace menus
	   	wpd2.OpenWPLeftMenus();	
	   	//wpd2.SelectWPGreenButtons(); 
	
	}
}
