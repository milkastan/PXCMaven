package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class EventHandler extends AbstractWebDriverEventListener {

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before navigate to "+url);		
	}

	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("After navigate to "+url);
	
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Just before beforeNavigateBack =: " + driver.getCurrentUrl()); 
	}

	@Override
	public void afterNavigateBack(WebDriver driver) {
	  System.out.println("Inside the after navigateback to =: " + driver.getCurrentUrl());  
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Just before beforeNavigateForward =: " + driver.getCurrentUrl());
		
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		System.out.println("Inside the afterNavigateForward to =: " + driver.getCurrentUrl());  
     }

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("before FindBY =: "+by.toString()); 		
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		 System.out.println("Find happened on =: " + by.toString());  
	}

	@Override
	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("About to click on the " + element.toString());  
		
	}

	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("inside method afterClickOn on =: " + element.toString());  
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		 System.out.println("Inside the beforeChangeValueOf method =; "+element.toString()); 
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("inside method afterChangeValueOf on =: " + element.toString());  
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		System.out.println("Just before beforeScript =: " + script); 
		
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		System.out.println("Inside the afterScript to, Script is =: " + script);  
	}

	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		System.out.println("Exception occured at =: " + throwable.getMessage());
	}

	
}
