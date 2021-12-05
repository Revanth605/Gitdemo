package FailedTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class General_info_parameters_static {
	static WebDriver driver;
	static String user_name= "Admin",password="admin123",URL="https://opensource-demo.orangehrmlive.com/";
	static String org_name="MEIL",mail_id="meil@gmail.com", place="mumbai",pin_code="520000",note="i am a good boy";
	static String a ="5555" ;
  @Test
  public static void Mainmethod() {
	  
	 
	  General_info_parameters_static.open_URL();
	  General_info_parameters_static.openHRM_URL(URL);	
	  General_info_parameters_static.login(user_name,password);
	  General_info_parameters_static.add_general_info(org_name,a,mail_id,place,pin_code,note);
  }
  
 public static void open_URL() {
  
  System.setProperty("webdriver.chrome.driver","C:/chromedriver_win32/chromedriver.exe");
   driver = new ChromeDriver();
	driver.manage().window().maximize();
  }
 public static void openHRM_URL(String URL) {
	  driver.get(URL);
  }
  public static void login(String user_name,String password) {
	  driver.findElement(By.id("txtUsername")).sendKeys(user_name);
	  driver.findElement(By.id("txtPassword")).sendKeys(password);
	  driver.findElement(By.id("btnLogin")).click();
	  }
  
  public static void add_general_info(String org_name,String a,String mail_id,String place,String pin_code, String note) {
  driver.findElement(By.id("menu_admin_viewAdminModule")).click();
  driver.findElement(By.id("menu_admin_Organization")).click();
  driver.findElement(By.id("menu_admin_viewOrganizationGeneralInformation")).click();
  driver.findElement(By.name("btnSaveGenInfo")).click();
  driver.findElement(By.name("organization[name]")).clear();
  driver.findElement(By.name("organization[name]")).sendKeys(org_name);
  driver.findElement(By.name("organization[phone]")).clear();
  driver.findElement(By.name("organization[phone]")).sendKeys(a);
  driver.findElement(By.id("organization_email")).clear();
  driver.findElement(By.id("organization_email")).sendKeys(mail_id);
  driver.findElement(By.name("organization[street1]")).clear();
  driver.findElement(By.name("organization[street1]")).sendKeys(place);
  driver.findElement(By.name("organization[zipCode]")).clear();
  driver.findElement(By.name("organization[zipCode]")).sendKeys(pin_code);
  driver.findElement(By.name("organization[note]")).clear();
  driver.findElement(By.name("organization[note]")).sendKeys(note);
  driver.findElement(By.id("btnSaveGenInfo")).click();
  
  }
}
  
  
  
  

  

  
  

