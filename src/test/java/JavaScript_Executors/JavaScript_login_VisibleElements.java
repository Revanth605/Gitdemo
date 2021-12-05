package JavaScript_Executors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class JavaScript_login_VisibleElements {
	
	WebDriver driver;
  @Test
  public void Mainmethod() throws Exception {
	  
	   System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\Chromedriver.exe");
	   driver= new ChromeDriver();
	   driver.manage().window().maximize();
	 // driver= TestBrowser.OpenChromeBrowser();
	   driver.get("https://opensource-demo.orangehrmlive.com/");
	   findElement(By.name("txtUsername")).sendKeys("Admin");
		findElement(By.name("txtPassword")).sendKeys("admin123");
		findElement(By.name("Submit")).click();
		
          findElement(By.id("menu__Performance")).click();
		findElement(By.linkText("Employee Trackers")).click();
		WebElement element= findElement(By.id("footer"));
		 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
	   
  }
  public  WebElement findElement(By by) throws Exception 
 	{
 				
 		 WebElement elem = driver.findElement(by);    	    
 		
 		 
 		if (driver instanceof JavascriptExecutor) 
 		{
 		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
 	 
 		}
 		
 		return elem;
 	}
  
  
}


