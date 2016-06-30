package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.Browser;
import pages.WPDashboard;

public class TestInviteCompany extends BaseTest{
	@Before
	public void setUp() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");
    	System.out.println("ProductXchange - Test invite company!");
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
	public void TestInviteCompanyMain () throws InterruptedException {
		//create new workplace
    	myh=usrdash.navigateToMyHierarchy(); 
    	wpwiz=myh.SelectCreateWPmenu();
   	    newwp = wpwiz.CreateNewWP();
        //invite company to workplace

    	WPDashboard wpd = new WPDashboard();
    	//-------------------------------------
    	System.out.println("Invite company which is not wholesaler");
    	invitedcomp="Dekor Bygg AS";
 		icomp=wpd.SelectInviteCompanyBtn();
   	    icomp.InviteCompanyToWP(invitedcomp);
      	//check in the invited companies list if exists
   	    wpd.SelectMenuViewWP();
    	wpd.OpenInvitedCompanies();
    	icomp.CheckForInvitedCompany(invitedcomp);
    	//------------------------------------
    	System.out.println("Invite company which is region of the company not wholesaler");
    	invitedcomp="Region1_BackeBygg";
 		icomp=wpd.SelectInviteCompanyBtn();
   	    icomp.InviteCompanyToWP(invitedcomp);
      	//check in the invited companies list if exists
   	    wpd.SelectMenuViewWP();
    	wpd.OpenInvitedCompanies();
    	icomp.CheckForInvitedCompany(invitedcomp);
    	//---------------------------------
    	System.out.println("Invite company which is wholesaler");
    	invitedcomp="AS Realbygg";
 		icomp=wpd.SelectInviteCompanyBtn();
   	    icomp.InviteCompanyToWP(invitedcomp);
      	//check in the invited companies list if exists
   	    wpd.SelectMenuViewWP();
    	wpd.OpenInvitedCompanies();
    	icomp.CheckForInvitedCompany(invitedcomp);
    	//check invitged companies number
    	wpd.RefreshWPSummaryInfo();
    	wpd.CheckInvitedCompaniesNumber("3");
    	//---------------------------
    	System.out.println("Send invite email");
    	wpd.SelectMenuInviteCompany();
    	icomp.SendInviteEmail("NotExistingCompany");
		System.out.println("--------------------------------------------");
	}

}
