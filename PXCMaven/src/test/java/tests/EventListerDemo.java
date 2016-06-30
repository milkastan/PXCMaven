package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import common.EventHandlerAbstract;

public class EventListerDemo {
	public static void main(String[] args) {  
		 //Initializing instance of Webdriver  
		 WebDriver wDriver = new FirefoxDriver();  

		 //Initializing instance of EventFiringWebDriver  
		 EventFiringWebDriver driver = new EventFiringWebDriver(wDriver);  
		 //Now create object of EventListerHandler to register it with EventFiringWebDriver   
		// EventHandler handle = new EventHandler();
		 
		 EventHandlerAbstract handle = new EventHandlerAbstract();

		 System.out.println("===============================");  
		 //Registering it with EventFiringWebDriver   
		 driver.register(handle);  
		 driver.get("http://www.facebook.com");  
		 driver.findElement(By.id("email")).sendKeys("abcde@gmail.com");  
		 driver.findElement(By.id("pass")).sendKeys("aaaaaaaa");  
		 driver.findElement(By.id("loginbutton")).click();  
		 driver.get("http://www.gmail.com");  
		 driver.get("http://www.outlook.com");  
		 driver.navigate().back();  
		 driver.navigate().forward();  
		 driver.quit();  
		 driver.unregister(handle);  
		 System.out.println("===============================");  
		   }  

	
}
