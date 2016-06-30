package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class CompanyFilters extends LoadableComponent<CompanyFilters>{
	private final static String title = "Bedriftsfiltre";
	@FindBy(how=How.ID, using ="cpmain_TopNavigatorPlaceHolder_topNavigator_btnNext")
	  WebElement FiltersNextBtn;
	@FindBy(how=How.ID, using ="cpmain_EditorControlsPlaceHolder_UCViewAllFilters_btnConfigureFilters")
	  WebElement ConfigureFiltersBtn;
	@FindBy(how=How.ID, using ="cpmain_TopNavigatorPlaceHolder_topNavigator_ucProgress_lblStep0")
	  WebElement CFStep1;
	@FindBy(how=How.ID, using ="cpmain_TopNavigatorPlaceHolder_topNavigator_ucProgress_lblStep1")
	  WebElement CFStep2;
	@FindBy(how=How.ID, using ="cpmain_TopNavigatorPlaceHolder_topNavigator_ucProgress_lblStep2")
	  WebElement CFStep3;
	@FindBy(how=How.ID, using ="cpmain_TopNavigatorPlaceHolder_topNavigator_ucProgress_lblStep3")
	  WebElement CFStep4;
	@FindBy(how=How.ID, using ="cpmain_TopNavigatorPlaceHolder_topNavigator_ucProgress_lblStep4")
	  WebElement CFStep5;
	@FindBy(how=How.ID, using ="cpmain_TopNavigatorPlaceHolder_topNavigator_btnSave")
	  WebElement CFSaveBtn;
	@FindBy(how=How.ID, using ="cpmain_TabNavigationPlaceHolder_tabNavigation_lnkChemicalLists")
	  WebElement ChemFltBtn;
	//Product filters
	@FindBy(how=How.ID, using ="cpmain_TabNavigationPlaceHolder_tabNavigation_lnkProductFilters")
	  WebElement ProdFltBtn;
	@FindBy(how=How.ID, using ="cpmain_EditorControlsPlaceHolder_viewProductFilters_rptAllProductFilters_btnConfigureFilters_0")
	  WebElement ConfigureProdFiltersBtn;
	@FindBy(how=How.ID, using ="cpmain_EditorControlsPlaceHolder_btnReset")
	  WebElement ResetFilterBtn;
	@FindBy(how=How.ID, using ="cpmain_EditorControlsPlaceHolder_btnChange")
	  WebElement SearchAllFilterBtn;
	@FindBy(how=How.ID, using ="cpmain_EditorControlsPlaceHolder_btnCreatePF")
	  WebElement CreateFilterTemplBtn;
	
	public CompanyFilters() {
		  PageFactory.initElements(Browser.driver, this);
	}

	@Override
	protected void load() {
	}
	
	@Override
	protected void isLoaded() throws Error {
	  Assert.assertTrue("Expected page title is not as actual",Browser.driver().getTitle().equals(title));
		//System.out.println("Loaded page: "+Browser.driver().getTitle());
		System.out.println("Loaded page: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
	}
	
	public CompanyFilters ResetCompanyFilter() {
		ResetFilterBtn.click();
		Browser.SwitchToFrame();
		System.out.println("Page Title: "+Browser.driver.findElement(By.id("cpmain_lblTitle")).getText());
		
		
		return this;
	}
	
	public CompanyFilters CompanyFiltersWizard() throws InterruptedException {
		ConfigureFiltersBtn.click();
		Common.WaitForVisibility(By.id("cpmain_lblTitle"),2);
		Common.PrintText(By.id("cpmain_lblTitle"));
		//Step1 Fareutsagn
		System.out.println(CFStep1.getText());
		Thread.sleep(1000);
		//Common.ScrollToElement(FiltersNextBtn);
		FiltersNextBtn.click();
		Thread.sleep(1000);
		//Step2  Risikosetning
		System.out.println(CFStep2.getText());
		FiltersNextBtn.click();
		Thread.sleep(1000);
		//Step3 CAS nr. 
		System.out.println(CFStep3.getText());	
		FiltersNextBtn.click();
		Thread.sleep(1000);		
		//Step4 Lister
		System.out.println(CFStep4.getText());	
		FiltersNextBtn.click();
		Thread.sleep(1000);
		//Step5 Avfall
		System.out.println(CFStep5.getText());	
		Thread.sleep(1000);
		CFSaveBtn.click();
		Common.WaitForVisibility(By.id("cpmain_EditorControlsPlaceHolder_lblCompanyFilters"),2);
		return this;
	}
		
	public  CompanyFilters SelectProductFilters() {
		ProdFltBtn.click();
		Common.WaitForPresence(By.id("cpmain_EditorControlsPlaceHolder_viewProductFilters_rptAllProductFilters_lblProductFilter_0"), 2);
		return this;
	}
	public  CompanyFilters SelectChemicalFilters() {
		ChemFltBtn.click();
		Common.WaitForPresence(By.id("cpmain_TabNavigationPlaceHolder_tabNavigation_lnkChemicalLists"), 2);
		return this;
	}
	
	public CompanyFilters CheckProductFilters() {
		Common.ScrollToElement(ConfigureProdFiltersBtn);
		ConfigureProdFiltersBtn.click();
		Common.WaitForVisibility(By.id("cpmain_EditorControlsPlaceHolder_lblBtnSearch"), 2);
		
		return this;
	}
	

}
