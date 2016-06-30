package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.Browser;

public class OpenMainPages extends BaseTest{

	@Before
	public void setUp() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");
    	System.out.println("ProductXchange - Open PXC main pages!");
    	System.out.println("--------------------------------------------");
    	RunBrowser();
    	usrdash=super.SignIn(super.username,super.password);
	}
	
    @After
    public void ShutDown() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");  
    	Browser.quit();
    }

	@Test
	//Open left menus from workplace dashboard
	public void OpenPXCPages () {
		//Open company information sheets
	    usrdash.navigateToInformationSheet();
		//open company risk assessment
		usrdash.navigateToRiskAssessment();
						
		//open company product assessment
		prass=usrdash.navigateToProductAssessment();
		//Open Product Assessment Menus
	   //Open products without assessment
	    prass.navigateToProductswoAssessment();
		//open product types with assessment
		prass.navigateToProductTypeswithAssessment();
				
	   //Select Tools menu - opens Company filters
    	 tools=usrdash.navigateToTools();
		//Open Approve eSDS
		tools.navigateToApproveESDS();
		//Open Exposure Register
	  	tools.navigateToExposureRegister();
	  	//open PXC Reports
	  	tools.navigateToReports();
	  	//open product reports
	  	tools.navigateToProductReports();
	  	//open waste handling
	  	tools.navigateToWasteHandling();
	  	//open product log
	  	tools.navigateToProductLog();
	  	//open to company filters configuration
	  	cf=tools.navigateToCompanyFilters();	
	  	try {
			cf.CompanyFiltersWizard();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			//Select My Account menus
		//Click on TAB button My Account
	  	myacc=usrdash.navigateToMyAccount();
		//Open user administration
		myacc.navigateToUserAdministration();
		//Open update company profile
		myacc.navigateToCompanyProfile();
		//open edit my account
		myacc.SelectMenuMyAccount();

   }
	
}
