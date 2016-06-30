package tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pages.Browser;
import rls.PXCRegistration;
import common.GenerateData;

public class RegisterCompTest extends BaseTest{

	
	 public GenerateData gendata = new GenerateData();
		@Before
		public void setUp() {
	    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");
	    	System.out.println("ProductXchange - Open Registration page!");
	    	System.out.println("--------------------------------------------");
	    	RunBrowser();
	        
		}
		
	    @After
	    public void ShutDown() {
	    	gendata.PrintCurrentDateTime("dd/MM/yyyy HH:mm:ss");  
	    	//Browser.quit();
	    }
	    
	    @Test
			//Register in PXC new company
			public void RegisterNewCompanywoFilters () throws InterruptedException, IOException {
		    	PXCRegistration	reg = new PXCRegistration(Browser.driver);
		    	reg.get();
		    	//row 1 has data for Norwegian company
		    	//row 2 has data for UK company
		    	//row 3 has data for Swedish company
		    	//0 - is sheet 1
		    	reg.ReadRegistrationData(0,2);
		    	reg.SearchCompanyRegisterNew();
		       	reg.FillCompanyData();
		    	reg.ClickNext();
		    	reg.CheckLoadFilters(false, false);
		    	reg.ClickNext();
		    	reg.GoToRegisterBtn();
		    }
}
