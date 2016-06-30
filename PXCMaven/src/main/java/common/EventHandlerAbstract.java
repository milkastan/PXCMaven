package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class EventHandlerAbstract extends AbstractWebDriverEventListener {
//@Overrider only methods that you use
	
	@Override
	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("After navigate to "+url);
	}
	
	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		 System.out.println("Find happened on =: " + by.toString());  
	}
	
	@Override
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("inside method afterClickOn on =: " + element.toString());  
	}
	
	@Override
	public void onException(Throwable throwable, WebDriver driver) {
		System.out.println("Exception occured at =: " + throwable.getMessage());
	}
}
