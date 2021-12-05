package PageFactory_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Login_PFM1 {
	WebDriver driver;
	
	String username="Admin",password="admin123";
	
	public void Login_PFM1(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	@FindBy(id="txtUsername")
	WebElement username1;
	
	@FindBy(id="txtPassword")
   WebElement Password1;	
	
	@FindBy(name="Submit")
	  WebElement click1;	
	
 
  public void Login() throws Exception {
	  username1.sendKeys(username);
	  Password1.sendKeys(password);
	  click1.click();
	  
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
