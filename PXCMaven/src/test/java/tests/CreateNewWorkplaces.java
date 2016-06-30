package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.Browser;

public class CreateNewWorkplaces extends BaseTest{
	String uname = "milka1652@icb.bg";
	String pass = "123456";
	//int wpnum=2;			//number of new workplaces
	@Before
	public void setUp() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");
    	System.out.println("ProductXchange - Creating new workplaces!");
    	System.out.println("--------------------------------------------");
    	RunBrowser();
    	usrdash=super.SignIn(uname,pass);
	}
	
    @After
    public void ShutDown() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");  
    	Browser.quit();
    }

	@Test
	public void TestCreateworkplaces () {
	  //Select main menu My Hierarchy	
	  //for (int i=0;i<wpnum;i++) {
		  myh=usrdash.navigateToMyHierarchy();
		  wpwiz=myh.SelectCreateWPmenu();
	   	  newwp = wpwiz.CreateNewWP();
	 // }
	
		
	}
}
