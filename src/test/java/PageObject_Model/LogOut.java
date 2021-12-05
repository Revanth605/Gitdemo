package PageObject_Model;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;



public class LogOut {
	
	WebDriver driver;
	
	
	public void LogOut(WebDriver driver) {
		this.driver=driver;
	}
 
  public void logout() throws Exception {
	  
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	findElement(By.linkText("Welcome Chandru")).click();
	 
	findElement(By.xpath("//*[@id='welcome-menu']/ul/li[3]/a")).click();
  }
  
  public   WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}
	

}
