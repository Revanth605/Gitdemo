package FailedTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class ContactDetails_static {
	static WebDriver driver;
	static String URL="https://opensource-demo.orangehrmlive.com/",Username="Admin",password="admin123";
	static String	door_num="225/29/15/56",colony="ramachandrapuram",city ="hyderabad",state="telangana";
	static String pincode ="202034",telephone="7889456123",mobile="2586258",email="bhavasri@gmail.com";
 
	
	
	
@BeforeTest	
public static void  open_chrome() throws Exception {
	 driver=TestBrowser.OpenChromeBrowser();
}
	
@Test
  public static void Main_method() {
	
	  ContactDetails_static.open_HRMURL(URL);
	  ContactDetails_static.open_HRMloginpage(Username,password);
	  ContactDetails_static.open_myinfo();
	  ContactDetails_static.address(door_num,colony,city,state);
	  ContactDetails_static.contact_details(pincode,telephone,mobile);
	  ContactDetails_static.email_details(email);
  }
  
  
  

 public  static void open_HRMURL(String URL) {
	 
	 driver.get(URL);
 }
  
 public static void open_HRMloginpage( String Username,String password) {
	 driver.findElement(By.cssSelector("input#txtUsername")).sendKeys(Username);
	 driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(password);
	driver.findElement(By.cssSelector("input#btnLogin")).click();
	List<WebElement>links = driver.findElements(By.tagName("input"));
	System.out.println("Total links are:"+links.size());
 }
public static void  open_myinfo() {	
	driver.findElement(By.xpath("//*[@id='menu_pim_viewMyDetails']/b")).click();
	driver.findElement(By.partialLinkText("Contact")).click();
	driver.findElement(By.xpath("//*[@id='btnSave']")).click();
}
	public static void  address( String door_num,String colony,String city, String state) {
	driver.findElement(By.cssSelector("input[type='text']")).clear();
	driver.findElement(By.cssSelector("input[type='text']")).sendKeys(door_num); 
	driver.findElement(By.xpath("//*[@id='contact_street2']")).clear();
	driver.findElement(By.xpath("//*[@id='contact_street2']")).sendKeys(colony);
	driver.findElement(By.cssSelector("input#contact_city")).clear();
	driver.findElement(By.cssSelector("input#contact_city")).sendKeys(city);
	driver.findElement(By.xpath("//input[@name='contact[province]']")).clear();
	driver.findElement(By.xpath("//input[@name='contact[province]']")).sendKeys(state);
	}
	public  static void contact_details( String pincode,String telephone, String mobile) {
	driver.findElement(By.xpath("//*[@id='contact_emp_zipcode']")).clear();
	driver.findElement(By.xpath("//*[@id='contact_emp_zipcode']")).sendKeys(pincode);
	driver.findElement(By.xpath("//*[@id='contact_emp_hm_telephone']")).clear();
	driver.findElement(By.xpath("//*[@id='contact_emp_hm_telephone']")).sendKeys(telephone);
	driver.findElement(By.xpath("//*[@id='contact_emp_mobile']")).clear();
	driver.findElement(By.xpath("//*[@id='contact_emp_mobile']")).sendKeys(mobile);
	
	}
	
	public static void  email_details(String email) {
	driver.findElement(By.cssSelector("input[name*='[emp_work_email]']")).clear();
	driver.findElement(By.cssSelector("input[name*='[emp_work_email]']")).sendKeys(email); 
	driver.findElement(By.cssSelector("input#btnSave")).click(); 
 }
	
	@AfterTest	
	public static void  close() {
		driver.close();
	}
 }
