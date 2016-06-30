package tests;

import org.junit.After;
import org.junit.Before;
import org.testng.annotations.Test;
import common.DataproviderClass;

import pages.Browser;

public class MyHierarchyParam extends BaseTest{


	@Before
	public void setUp() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");
    	System.out.println("PXC -Open MyHierarchy menus by parameterized test!");
    	System.out.println("--------------------------------------------");
	}
	
    @After
    public void ShutDown() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");  
    	//Browser.quit();
    }
  
    @Test(dataProvider="MyHierarchyTest",dataProviderClass=DataproviderClass.class)
    public void MyHierarchyParamTest(String uname, String pass) {
        
    	System.out.println("Username="+uname+"   password="+pass);
    	RunBrowser();
    	usrdash=super.SignIn(uname,pass); 
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
 
    
}
