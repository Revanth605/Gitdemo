package JavaScript_Executors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScript_SendKeys {
	WebDriver driver;
	
  @Test
  public void Mainmethod() throws Exception {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	
	  WebElement username= findElement(By.id("txtUsername"));
	  WebElement Password =findElement(By.name("txtPassword")); 
	  WebElement Button = findElement(By.id("btnLogin"));
	  
	  
	  
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  
	  js.executeScript("arguments[0].style.border= '8px solid  green'",username);
	  js.executeScript("arguments[0].style.border= '3px solid  yellow'",Password);
	  js.executeScript("arguments[0].style.border= '4px solid pink'",Button);
	  
	  
	  js.executeScript("arguments[0].setAttribute('value','Admin')",username);
	  js.executeScript("arguments[0].setAttribute('value','admin123')",Password);
	  js.executeScript("arguments[0].click();",Button);
	  
	  
	  WebElement admin =findElement(By.id("menu_admin_viewAdminModule"));
	  js.executeScript("arguments[0].click();",admin);
	  WebElement qualifications =findElement(By.id("menu_admin_Qualifications"));
	  js.executeScript("arguments[0].scrollIntoView();",qualifications);
	  
	  

     
  }
  public  WebElement findElement(By by) throws Exception 
 	{
 				
 		 WebElement elem = driver.findElement(by);    	    
 		
 		 
 		if (driver instanceof JavascriptExecutor) 
 		{
 		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='10px solid red'", elem);
 	 
 		}
 		
 		return elem;
 	}
  
 	}
  
  
  

