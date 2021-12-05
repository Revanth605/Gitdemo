package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScript_ScrollByP_Pixel {
	
	WebDriver driver;
	
  @Test
  public void Mainmethod() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.flipkart.com/plus");
	  JavascriptExecutor js= (JavascriptExecutor)driver;
	  js.executeScript("window.scroll(0,3000)");
	  WebElement facebook= driver.findElement(By.linkText("Facebook"));
	  Thread.sleep(1000);
	  js.executeScript("arguments[0].scrollIntoView();",facebook);
	  js.executeScript("arguments[0].style.border= '5px solid orange'",facebook);
	  
  }
  
  
}
