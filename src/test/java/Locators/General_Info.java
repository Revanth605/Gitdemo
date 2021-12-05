package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class General_Info {
	WebDriver driver;
  @Test
  public void Mainmethod() {
	  
	  General_Info L2= new General_Info();
	  L2.open_URL();
	  L2.openHRM_URL();	
	  L2.login();
	  L2.add_general_info();
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
  
  public void add_general_info () {
  driver.findElement(By.id("menu_admin_viewAdminModule")).click();
  driver.findElement(By.id("menu_admin_Organization")).click();
  driver.findElement(By.id("menu_admin_viewOrganizationGeneralInformation")).click();
  driver.findElement(By.name("btnSaveGenInfo")).click();
  driver.findElement(By.name("organization[name]")).sendKeys("MEIL");
  driver.findElement(By.name("organization[phone]")).sendKeys("5555");
  driver.findElement(By.id("organization_email")).clear();
  driver.findElement(By.id("organization_email")).sendKeys("meil@gmail.com");
  driver.findElement(By.name("organization[street1]")).sendKeys("mumbai");
  driver.findElement(By.name("organization[zipCode]")).sendKeys("520000");
  driver.findElement(By.name("organization[note]")).sendKeys("i am a good boy");
  driver.findElement(By.id("btnSaveGenInfo")).click();
  
  }
}
  
  
  
  

  

  
  

