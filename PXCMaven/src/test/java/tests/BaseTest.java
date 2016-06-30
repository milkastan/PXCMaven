package tests;

import pages.*;
import rls.PXCRegistration;
import common.GenerateData;

public class BaseTest {
	String username = "kaare@abt.no";
	String password = "ksfxW9JS";
	//production user credentials
    String produname="milkastan@gmail.com";
	String prodpass="123456";
	
	String 			newwp;          //New workplace name
	String			invitedcomp;    //invited company name
	String			invwp;			//name of the invited workplace
	String			docname;
	
	LoginPage 		logon;
	UserDashboard 	usrdash;
	MyHierarchyWP	myh;
	WPDashboard2	wpd2;
	WPDashboard 	wpd;
	ProductAssessmentCenter  prass;
    CreateWPWizard 	wpwiz;
    Tools			tools;
    MyAccount 		myacc;
    Products 		prod;
    Deviations		dev;
	Chemicals 		sds;
	AddProducts		ap;
	AddDocuments	ad;
	DistributeDocuments dd;
	InviteCompany	icomp;
	InviteWorkplace	iwp;
	PXCRegistration	reg;
	CompanyFilters	cf;
	
    public GenerateData gendata = new GenerateData();
	
	protected UserDashboard SignIn (String usr, String pass) {
		LoginPage logon = new LoginPage(Browser.driver);
		logon.get();
  		logon.successFullLogin(usr, pass);
		return new UserDashboard();
	}
  
	protected UserDashboard ProdSignIn (String usr, String pass) {
		LoginPage logon = new LoginPage(Browser.driver);
		Browser.driver.get(LoginPage.produrl);
  		logon.successFullLogin(usr, pass);
		return new UserDashboard();
	}
	
	public static void RunBrowser() {
		Browser.initFF();
		//Browser.initChrome();
		//Browser.initChrome();
	}
	
}
