package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends LoadableComponent<LoginPage> {
	//Base URL
	static String url = "http://chemxchange.icb.bg/productxchange/rls/logon.aspx?Lang=No";
	//PXC production login URL
	public static String produrl ="https://app.productxchange.com/rls/logon.aspx?Lang=No";
	private final static String title = "ProductXchange - Logg inn";
	static WebDriverWait wait = new WebDriverWait(Browser.driver, 30);
	

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.ID, id="cpmain_ucLogOn_txtUser")
	WebElement usernameField;
	@FindBy(how=How.ID, id="cpmain_ucLogOn_txtPwd")
	WebElement passwordField;
	@FindBy(how=How.ID, id="cpmain_ucLogOn_btnLogin")
	WebElement Loginbtn;
	@FindBy (how=How.PARTIAL_LINK_TEXT,using="Forgotten")
	WebElement forgotPassLnk;
	//Log out icon
	@FindBy(how=How.ID, id="ucLoginStatus_imgLoggedIn")
	static WebElement LogOutIcon;
	//@FindBy(how=How.XPATH, id="//div[2]/div/div[3]/div[2]/a")
	@FindBy (how=How.PARTIAL_LINK_TEXT,using="Logg ut")
	static WebElement LogOutBtn;
	
	
	@Override
	protected void load() {
		long start = System.currentTimeMillis();
		Browser.driver().get(url);
		long finish = System.currentTimeMillis();
		long totalTime = (finish-start);
		System.out.println("Open PXC Login page: "+ totalTime+ "ms");
	}

	@Override
	protected void isLoaded() throws Error {
	  Assert.assertTrue("Expected page title is not as actual",Browser.driver().getTitle().equals(title));
	  System.out.println("Page Title: "+Browser.driver().getTitle());
	  System.out.println("--------------------------------------------");
	}
	
    
	public UserDashboard successFullLogin(String email, String password) {
		usernameField.sendKeys(email);
		passwordField.sendKeys(password);
		Loginbtn.click();
		System.out.println("user:"+email+", password:"+password+" logged in PXC");
		System.out.println("--------------------------------------------");
		return new UserDashboard();
	}

	public LoginPage invalidLogin(String email, String password) {
		usernameField.sendKeys(email);
		passwordField.sendKeys(password);
		Loginbtn.click();
		return this;
	}

	public static void LogOut() {
		LogOutIcon.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*div/a[@id='ucLoginStatus_loginStatus']")));
		LogOutBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cpmain_Summary")));
  }
}
