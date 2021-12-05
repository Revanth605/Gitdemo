package Parallel_Methods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Parallel_classes.ContactDetails_Locators;

public class General_info_parameters_static2 {
	
	static String user_name= "Admin",password="admin123",URL="https://opensource-demo.orangehrmlive.com/";
	static String org_name="MIL",mail_id="mil@gmail.com", place="mumai",pin_code="520080",note="i am a bad boy";
	static String a ="5555" ;
	static  String	door_num="25/29/15/56",colony="ramachandrapuram",city ="hyderabad",state="telangana";
	static  String pincode ="521478",telephone="9874563210",mobile="123456789",email="bhavasri@gmail.com";
  @Test
  public static void General_Info()
  {
	  WebDriver  driver1;
	  System.setProperty("webdriver.chrome.driver","C:/chromedriver_win32/chromedriver.exe");
	   driver1 = new ChromeDriver();
		driver1.manage().window().maximize();
		
		driver1.get(URL);
		 
		driver1.findElement(By.id("txtUsername")).sendKeys(user_name);
		driver1.findElement(By.id("txtPassword")).sendKeys(password);
		driver1.findElement(By.id("btnLogin")).click();
		  
		driver1.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver1.findElement(By.id("menu_admin_Organization")).click();
		driver1.findElement(By.id("menu_admin_viewOrganizationGeneralInformation")).click();
		driver1.findElement(By.name("btnSaveGenInfo")).click();
		driver1.findElement(By.name("organization[name]")).clear();
		driver1.findElement(By.name("organization[name]")).sendKeys(org_name);
		driver1.findElement(By.name("organization[phone]")).clear();
		driver1.findElement(By.name("organization[phone]")).sendKeys(a);
		driver1.findElement(By.id("organization_email")).clear();
		driver1.findElement(By.id("organization_email")).sendKeys(mail_id);
		driver1.findElement(By.name("organization[street1]")).clear();
		driver1.findElement(By.name("organization[street1]")).sendKeys(place);
		driver1.findElement(By.name("organization[zipCode]")).clear();
		driver1.findElement(By.name("organization[zipCode]")).sendKeys(pin_code);
		driver1.findElement(By.name("organization[note]")).clear();
		driver1.findElement(By.name("organization[note]")).sendKeys(note);
		driver1.findElement(By.id("btnSaveGenInfo")).click();
		  
	 
  }
  
  @Test
  public  static void Contact_details() {
	  WebDriver  driver2;
	  System.setProperty("webdriver.chrome.driver","C:/chromedriver_win32/chromedriver.exe");
	  driver2 = new ChromeDriver();
	  driver2.manage().window().maximize();
		
	  driver2.get(URL);
		 
	  driver2.findElement(By.id("txtUsername")).sendKeys(user_name);
	  driver2.findElement(By.id("txtPassword")).sendKeys(password);
	  driver2.findElement(By.id("btnLogin")).click();
		  
	  driver2.findElement(By.xpath("//*[@id='menu_pim_viewMyDetails']/b")).click();
	  driver2.findElement(By.partialLinkText("Contact")).click();
	  driver2.findElement(By.xpath("//*[@id='btnSave']")).click();
			
	  driver2.findElement(By.cssSelector("input[type='text']")).clear();
	  driver2.findElement(By.cssSelector("input[type='text']")).sendKeys(door_num); 
	  driver2.findElement(By.xpath("//*[@id='contact_street2']")).clear();
	  driver2.findElement(By.xpath("//*[@id='contact_street2']")).sendKeys(colony);
	  driver2.findElement(By.cssSelector("input#contact_city")).clear();
	  driver2.findElement(By.cssSelector("input#contact_city")).sendKeys(city);
	  driver2.findElement(By.xpath("//input[@name='contact[province]']")).clear();
	  driver2.findElement(By.xpath("//input[@name='contact[province]']")).sendKeys(state);
			
	  driver2.findElement(By.xpath("//*[@id='contact_emp_zipcode']")).clear();
	  driver2.findElement(By.xpath("//*[@id='contact_emp_zipcode']")).sendKeys(pincode);
	  driver2.findElement(By.xpath("//*[@id='contact_emp_hm_telephone']")).clear();
	  driver2.findElement(By.xpath("//*[@id='contact_emp_hm_telephone']")).sendKeys(telephone);
	  driver2.findElement(By.xpath("//*[@id='contact_emp_mobile']")).clear();
	  driver2.findElement(By.xpath("//*[@id='contact_emp_mobile']")).sendKeys(mobile);
			
	  driver2.findElement(By.cssSelector("input[name*='[emp_work_email]']")).clear();
	  driver2.findElement(By.cssSelector("input[name*='[emp_work_email]']")).sendKeys(email); 
	  driver2.findElement(By.cssSelector("input#btnSave")).click(); 
	  
  }
	 
  
  
  
 
  
 

 }

  
  
  
  

  

  
  

