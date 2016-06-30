package pages;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {
	private static String filepath ="D:\\00-DISK-D\\WebDriver PXC Projects\\";
	private Date date;
	
	public Common() {
	}
	//scroll to web element
	public static void ScrollToElement (WebElement el)  {
	WebDriverWait wait = new WebDriverWait(Browser.driver, 30);	
	((JavascriptExecutor) Browser.driver).executeScript("arguments[0].scrollIntoView(true);", el);
	wait.until(ExpectedConditions.visibilityOf(el));
	}

     //click on element by JavascriptExecutor 
	//((JavascriptExecutor) Browser.driver).executeScript("arguments[0].click();", el);
	//Type in a Text Box by JSE
	//((JavascriptExecutor) Browser.driver).executeScript("document.getElementByID('elementid').value='test data'");

	public static void PrintConsoleToFile(String testResultFile) throws IOException {
		try {
		File file = new File(filepath+testResultFile); 
		FileOutputStream fis = new FileOutputStream(file);  
		PrintStream out = new PrintStream(fis);  
		System.setOut(out);
		} catch (FileNotFoundException e){
			System.out.println("Failed opening text file");
		}
    }
	
	 public void PrintCurrentDateTime(String format)
	 {
		 //Create object of SimpleDateFormat class and decide the format
         DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
         //get current date with Date()
         this.date = new Date();
         //Now format the date
         String date1 = dateFormat.format(date);
         //return string with current date and time             
         System.out.println("Current date&time: "+date1);
	 }
	 
	 public void visit (String url){Browser.driver.get(url); 	}
	 
	 public static WebElement find (By locator){ return Browser.driver.findElement(locator); 	}
	 
	 public static void click(By locator){	find(locator).click(); 	}
	 
	 public static void PrintText(By locator) {
		 System.out.println(find(locator).getText());
	 }
	 
	 
	 public static Boolean isDisplayed(By locator){
			try {
				return find(locator).isDisplayed();
			} catch (org.openqa.selenium.NoSuchElementException e) {
				return false;
			}
		}
	 
	 public static Boolean isDisplayed(By locator, int MaxTime){
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),MaxTime);
			} catch (org.openqa.selenium.TimeoutException e) {
				return false;
			}
			return true;
		}
	 
	 public static void WaitForPresence(By locator, int MaxTime) {
		 try {
				waitFor(ExpectedConditions.presenceOfElementLocated(locator),MaxTime);
			} catch (org.openqa.selenium.TimeoutException e) {
			}
	  }
	 
	 public static void WaitForVisibility(By locator, int MaxTime) {
		 try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),MaxTime);
			} catch (org.openqa.selenium.TimeoutException e) {
			}
	  }
	 
	 public static void WaitForClickable(WebElement el, int MaxTime) {
		 try {
				waitFor(ExpectedConditions.elementToBeClickable(el), MaxTime);
				} catch (org.openqa.selenium.TimeoutException e) {
			}
	  }
		
		private static void waitFor(ExpectedCondition<WebElement> condition, Integer timeout){
			timeout=timeout !=null?timeout:5;
			WebDriverWait wait=new WebDriverWait(Browser.driver, timeout);
			wait.until(condition);
		}
		

}
