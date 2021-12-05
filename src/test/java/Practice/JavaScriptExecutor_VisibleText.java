package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class JavaScriptExecutor_VisibleText {
	
	WebDriver driver;
  @Test
  public void Mainmethod() throws Exception {
	  
	  
	  driver = TestBrowser.OpenChromeBrowser();
	  
	  driver.get("https://www.flipkart.com/plus");
	  Thread.sleep(1000);
	  WebElement Element = findElement(By.linkText("EPR Compliance"));
	  WebElement Element1 = findElement(By.linkText("Gift Cards"));
	  JavascriptExecutor js =(JavascriptExecutor)driver;		
      js.executeScript("arguments[0].scrollIntoView();",Element);
      js.executeScript("arguments[0].scrollIntoView();",Element1); 
	  
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
