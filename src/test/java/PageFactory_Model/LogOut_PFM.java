package PageFactory_Model;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;



public class LogOut_PFM {
	
	WebDriver driver;
	
	
	public void LogOut_PFM(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	@FindBy(linkText="Welcome Chandru")
	WebElement welcome;
 
	@FindBy(xpath="//*[@id='welcome-menu']/ul/li[3]/a")
	WebElement Logout; 
	
  public void LogOut() throws Exception {
	  
	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  welcome.click();
      Logout.click();
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
