package OrangeHRMpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HRMlogin {
	WebDriver driver;
  @Test
  public void Mainmethod() {
	  
	 
  HRMlogin L2= new HRMlogin();
	  L2.open_URL();
	  L2.openHRM_URL();	
	  L2.login();
  }
  
 public void open_URL() {
  
  System.setProperty("webdriver.chrome.driver","C:/chromedriver_win32/chromedriver.exe");
   driver = new ChromeDriver();
	driver.manage().window().maximize();
  }
 public void openHRM_URL() {
	  driver.get("https://opensource-demo.orangehrmlive.com/");
  }
  public void login() {
	  driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	  driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	  driver.findElement(By.id("btnLogin")).click();
	  
	  
  }
  
}
