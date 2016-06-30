package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.Browser;


public class MyHierarchyMenus extends BaseTest {
	String [][] users= {
			{"bent.haugen@optimera.no","123456"},  
			{"optilag","inlag09"},     				
			{"itella","byggmakker"}
			};
	String uname;
	String passwd;

	@Before
	public void setUp() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");
    	System.out.println("ProductXchange - Open MyHierarchy menus!");
    	System.out.println("--------------------------------------------");
	}
	
    @After
    public void ShutDown() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");  
    	//Browser.quit();
    }
  
 
	@Test
	//Open My hierarchy left menus ABT Bygg As
	public void OpenMyHierarchyMenus1 () {
       uname = users[0][0];
       passwd = users[0][1];
       RunBrowser();
       usrdash=super.SignIn(uname,passwd);
	   //Select main menu My Hierarchy	
	   myh=usrdash.navigateToMyHierarchy();
	   //Open page SDS on workplaces
	   myh.SelectSDSonWPs();
	  //Open page Products on workplaces
	   myh.SelectPRonWPs();
	  //Open page My hierarchy workplaces
	   myh.SelectWorkplaces();
	   Browser.quit();
	}
	

	@Test
	//Open My hierarchy left menus and create new WP
	public void OpenMyHierarchyMenus2 () {
       uname = users[1][0];
       passwd = users[1][1];
       RunBrowser();
       usrdash=super.SignIn(uname,passwd);
	   //Select main menu My Hierarchy	
	   myh=usrdash.navigateToMyHierarchy();
	   //Open page SDS on workplaces
	   myh.SelectSDSonWPs();
	  //Open page Products on workplaces
	  myh.SelectPRonWPs();
	  //Open page My hierarchy workplaces
	  myh.SelectWorkplaces();
	  Browser.quit();
	}
	
	/*
	@Test
	//Open My hierarchy left menus and create new WP
	public void OpenMyHierarchyMenus3 () {
       uname = users[2][0];
       passwd = users[2][1];
       RunBrowser();
       usrdash=super.SignIn(uname,passwd);
	   //Select main menu My Hierarchy	
	   myh=usrdash.navigateToMyHierarchy();
	   //Open page SDS on workplaces
	   myh.SelectSDSonWPs();
	  //Open page Products on workplaces
	  myh.SelectPRonWPs();
	  //Open page My hierarchy workplaces
	  myh.SelectWorkplaces();
	  Browser.quit();
	}
	*/

}
