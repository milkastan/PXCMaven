package rls;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.Browser;
import pages.Common;
import common.ExcelDataConfig;

public class PXCRegistration extends LoadableComponent<PXCRegistration>{
	//Base URL
	static String regurl = "http://chemxchange.icb.bg/ProductXchange/RLS/Registration/RegisterStep1.aspx?Lang=No";
	private final static String title = "ProductXchange - Registrer ny bedrift";
	static WebDriverWait wait = new WebDriverWait(Browser.driver, 30);
	
	//Registration page company fields
	@FindBy(how=How.ID, id="cpmain_cpRegisterMain_txtCompanyRegNo")
	WebElement RegOrgNo;
	@FindBy(how=How.ID, id="cpmain_cpRegisterMain_txtCompanyName")	       
	WebElement RegOrgName;
	@FindBy(how=How.ID, id="cpmain_cpRegisterMain_btnViewCompanies")
	WebElement RegCheckCompanyBtn;
	@FindBy(how=How.ID, id="cpmain_btnRegisterNew")
	WebElement RegNewCompBtn;
	@FindBy(how=How.ID, id="cpmain_cpRegisterMain_ddlBusinessUnitCountry")
	WebElement RegBusinessUnit;
	@FindBy(how=How.ID, id="cpmain_cpRegisterMain_txtCompanyVisitingStreet1")
	WebElement RegCompAddr1;
	@FindBy(how=How.ID, id="cpmain_cpRegisterMain_txtCompanyVisitingPostalCode")
	WebElement RegPostalCode1;
	@FindBy(how=How.ID, id="cpmain_cpRegisterMain_txtCompanyPostalStreet2")
	WebElement RegcompAddr2;
	@FindBy(how=How.ID, id="cpmain_cpRegisterMain_txtCompanyPostalPostZIPcode")
	WebElement RegPostalCode2;
	@FindBy(how=How.ID, id="cpmain_cpRegisterMain_txtCompanyPhone")
	WebElement RegCompPhone;
	@FindBy(how=How.ID, id="cpmain_cpRegisterMain_txtCompanyEmail")
	WebElement RegCompEmail;
	//Registration company contact fileds
	@FindBy(how=How.ID, id="cpmain_cpRegisterMain_txtContactFirstName")
	WebElement RegUserFirstName;
	@FindBy(how=How.ID, id="cpmain_cpRegisterMain_txtContactLastName")
	WebElement RegUserLastName;
	@FindBy(how=How.ID, id="cpmain_cpRegisterMain_txtContactEmail")
	WebElement RegUserEmail;
	@FindBy(how=How.ID, id="cpmain_cpRegisterMain_txtContactPhone")
	WebElement RegUserPhone;
	//registration navigation
	@FindBy(how=How.ID, id="cpmain_cpRegisterMain_btnContinue")
	WebElement RegContinueBtn;
	@FindBy(how=How.ID, id="cpmain_cpRegisterMain_ucCaptchaImage_txtCaptchaCode")
	WebElement RegCapthaBtn;
	@FindBy(how=How.ID, id="cpmain_cpRegisterMain_chkAgreedToTermsAndConditions")
	WebElement RegAgreeTermsCheck;
	@FindBy(how=How.ID, id="cpmain_cpRegisterMain_btnRegister")
	WebElement RegisterBtn;
	@FindBy(how=How.ID, id="cpmain_cpRegisterMain_chkUseDefaultFilters")
	WebElement UseChemFiltersChk;
	@FindBy(how=How.ID, id="cpmain_cpRegisterMain_chkUseNationalProductFilter")
	WebElement UseProductFiltersChk;
	@FindBy(how=How.ID, id="cpmain_cpRegisterMain_btnRegister")
	WebElement RegRegisterBtn;
	
	
	//Registration variables
	String OrgNum, CompName, Country, PostalCode, CompPhone,CompEmail, UNFirst, UNLast,UserEmail, UPhone; 
	
	public PXCRegistration(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@Override
	protected void load() {
		Browser.driver().get(regurl);
		System.out.println("Open PXC registration page ");
	}

	@Override
	protected void isLoaded() throws Error {
	  Assert.assertTrue("Expected page title is not as actual",Browser.driver().getTitle().equals(title));
	  System.out.println("Loaded Page Title: "+Browser.driver.findElement(By.id("cpmain_lblReg")));
	  System.out.println("--------------------------------------------");
	}
	
	//parameters sh=0 sheet number, row - excel row (1,2,3)
	public void ReadRegistrationData (int sh, int row) throws IOException {
		//First sheet is zero
		ExcelDataConfig excel = new ExcelDataConfig("D:\\00-DISK-D\\WebDriver PXC Projects\\TestingPXC2\\src\\testData\\CompTestData.xlsx");
		OrgNum	 = excel.getData(sh, row, 0);
		CompName = excel.getData(sh, row, 1);
		Country  = excel.getData(sh, row, 2);
		PostalCode=excel.getData(sh, row, 3);
		CompPhone= excel.getData(sh, row, 4);
		CompEmail= excel.getData(sh, row, 5);
		UNFirst	 = excel.getData(sh, row, 6);
		UNLast	 = excel.getData(sh, row, 7);
		UserEmail= excel.getData(sh, row, 8);
		UPhone	 = excel.getData(sh, row, 9);
		System.out.println(OrgNum);
		System.out.println(CompName);
	}
	
	public PXCRegistration SearchCompanyRegisterNew() {
		RegOrgNo.sendKeys(OrgNum);
		RegCheckCompanyBtn.click();
		Common.WaitForClickable(RegNewCompBtn,3);
		Browser.SwitchToFrame();
		RegNewCompBtn.click();
		Browser.SwitchToMain();
		Common.WaitForVisibility(By.id("cpmain_cpRegisterMain_txtCompanyName"), 3);

		return this;
	}
	
	
	public PXCRegistration FillCompanyData() throws InterruptedException{
		Actions action = new Actions(Browser.driver);
		RegOrgName.sendKeys(CompName);
		SelectCounty(Country);
		RegCompAddr1.sendKeys(CompName+" Addr1");
		RegPostalCode1.sendKeys(PostalCode);
		action.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		RegcompAddr2.sendKeys(CompName+" Addr2");
		RegPostalCode2.sendKeys(PostalCode);
		action.sendKeys(Keys.TAB).perform();
		Thread.sleep(1000);
		RegCompPhone.sendKeys(CompPhone);
		RegCompEmail.sendKeys(CompEmail);
		RegUserFirstName.sendKeys(UNFirst);
		RegUserLastName.sendKeys(UNLast);
		RegUserEmail.sendKeys(UserEmail);
		RegUserPhone.sendKeys(UPhone);
		
		return this;
	}
	
	public void ClickNext(){
		RegContinueBtn.click();
		Common.WaitForPresence(By.id("cpmain_cpRegisterMain_lblSubbelowhead"), 3);
	}
	
	public void GoToRegisterBtn() {
		Common.ScrollToElement(RegRegisterBtn);
	}
	
	public void SelectCounty(String cn) throws InterruptedException {
		//Norwegian -"No", UK - "En", Sweden - "Se"
		RegBusinessUnit.click();
		Select countrydd = new Select(RegBusinessUnit);
		//countrydd.selectByIndex(2);
		countrydd.selectByValue(cn);
		Thread.sleep(1000);
	}
	
	public PXCRegistration CheckLoadFilters(Boolean cf, Boolean pf) throws InterruptedException {
		Common.ScrollToElement(UseChemFiltersChk);
		if (!cf) {
			UseChemFiltersChk.click();	
			Thread.sleep(1000);
		}
		
		if (!pf) {
			UseProductFiltersChk.click();	
			Thread.sleep(1000);
		}
		return this;
	}
}
