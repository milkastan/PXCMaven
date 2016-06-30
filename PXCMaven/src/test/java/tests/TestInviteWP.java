package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.Browser;
import pages.WPDashboard;

public class TestInviteWP extends BaseTest {

	@Before
	public void setUp() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");
    	System.out.println("ProductXchange - Test invite workplace!");
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
	public void InviteWPMain() {
		//create new workplace
    	myh=usrdash.navigateToMyHierarchy(); 
    	wpwiz=myh.SelectCreateWPmenu();
   	    newwp = wpwiz.CreateNewWP();
   	    WPDashboard wpd = new WPDashboard();
        //invite workplace
    	invwp="Backe Bygg AS - BB-WP26900";
    	iwp=wpd.SelectMenuInviteWorkplace();
		iwp.InviteWP("244119c6-cc5c-4582-9502-3319f281dcf8");
		//Check invited WP
		wpd.SelectMenuViewWP();
		wpd.OpenInvitedCompanies();
		iwp.CheckForInvitedWorkplace(invwp);
		//Delete invited workplace beacuse can be invited only once in the company
		myh=usrdash.navigateToMyHierarchy(); 
		myh.SearchWP(newwp);
		myh.DeleteWP(newwp);
	}
}
