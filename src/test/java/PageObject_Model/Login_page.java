package PageObject_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Login_page {
	WebDriver driver;
	
	String username="Admin",password="admin123";
	
	public void Login_page(WebDriver driver) {
	this.driver=driver;
	}
	
 
  public void Login() throws Exception {
	findElement(By.cssSelector("input[id^='txtUser']")).sendKeys(username);
	 findElement(By.cssSelector("input[id$='Password']")).sendKeys(password);
	  findElement(By.name("Submit")).click();
	  
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
