package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.Browser;

public class ProdMyHierarchyMenus extends BaseTest{

	
	@Before
	public void setUp() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");
    	System.out.println("ProductXchange Production - Open MyHierarchy menus!");
    	System.out.println("--------------------------------------------");
	}
	
    @After
    public void ShutDown() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");  
    	Browser.quit();
    }
  
 
	@Test
	//Open My hierarchy left menus ABT Bygg As
	public void OpenMyHierarchyMenus1 () {
		RunBrowser();
	    usrdash=super.ProdSignIn(super.produname, super.prodpass);
      
	   //Select main menu My Hierarchy	
	   myh=usrdash.navigateToMyHierarchy();
	   //Open page SDS on workplaces
	   myh.SelectSDSonWPs();
	  //Open page Products on workplaces
	   myh.SelectPRonWPs();
	  //Open page My hierarchy workplaces
	   myh.SelectWorkplaces();
	   
	}
}
