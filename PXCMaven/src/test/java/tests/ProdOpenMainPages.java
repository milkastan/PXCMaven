package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.Browser;

public class ProdOpenMainPages extends BaseTest {
	
	@Before
	public void setUp() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");
    	System.out.println("ProductXchange Production- Open main pages!");
    	System.out.println("--------------------------------------------");
	}
	
    @After
    public void ShutDown() {
    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");  
    	Browser.quit();
    }

	@Test
	//Open left menus from workplace dashboard
	public void OpenPXCPages () {
		RunBrowser();
	     usrdash=super.ProdSignIn(super.produname, super.prodpass);
	          
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
	  	//open waste handling
	  	tools.navigateToWasteHandling();
	  	//open product log
	  	tools.navigateToProductLog();
	  	//open to company filters configuration
	  	tools.navigateToCompanyFilters();	    
			
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
