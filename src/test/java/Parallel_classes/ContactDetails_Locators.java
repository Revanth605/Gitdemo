package Parallel_classes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ContactDetails_Locators {
	 WebDriver driver;
	 String URL="https://opensource-demo.orangehrmlive.com/",Username="Admin",password="admin123";
	  String	door_num="25/29/15/56",colony="ramachandrapuram",city ="hyderabad",state="telangana";
	String pincode ="202034",telephone="7889456123",mobile="2586258",email="bhavasri@gmail.com";
  @Test
  public  void Main_method() {
	  ContactDetails_Locators revanth = new ContactDetails_Locators();
	   revanth.open_chrome();
	   revanth.open_HRMURL(URL);
	   revanth.open_HRMloginpage(Username,password);
	  revanth.open_myinfo();
	   revanth.address(door_num,colony,city,state);
	   revanth.contact_details(pincode,telephone,mobile);
	   revanth.email_details(email);
  }
  
  public  void  open_chrome() {
	  System.setProperty("webdriver.chrome.driver","C:/chromedriver_win32/chromedriver.exe");
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
  
}
 public   void open_HRMURL(String URL) {
	 
	 driver.get(URL);
 }
  
 public  void open_HRMloginpage( String Username,String password) {
	 driver.findElement(By.cssSelector("input#txtUsername")).sendKeys(Username);
	 driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(password);
	driver.findElement(By.cssSelector("input#btnLogin")).click();
	List<WebElement>links = driver.findElements(By.tagName("input"));
	System.out.println("Total links are:"+links.size());
 }
public  void  open_myinfo() {	
	driver.findElement(By.xpath("//*[@id='menu_pim_viewMyDetails']/b")).click();
	driver.findElement(By.partialLinkText("Contact")).click();
	driver.findElement(By.xpath("//*[@id='btnSave']")).click();
}
	public  void  address( String door_num,String colony,String city, String state) {
	driver.findElement(By.cssSelector("input[type='text']")).clear();
	driver.findElement(By.cssSelector("input[type='text']")).sendKeys(door_num); 
	driver.findElement(By.xpath("//*[@id='contact_street2']")).clear();
	driver.findElement(By.xpath("//*[@id='contact_street2']")).sendKeys(colony);
	driver.findElement(By.cssSelector("input#contact_city")).clear();
	driver.findElement(By.cssSelector("input#contact_city")).sendKeys(city);
	driver.findElement(By.xpath("//input[@name='contact[province]']")).clear();
	driver.findElement(By.xpath("//input[@name='contact[province]']")).sendKeys(state);
	}
	public   void contact_details( String pincode,String telephone, String mobile) {
	driver.findElement(By.xpath("//*[@id='contact_emp_zipcode']")).clear();
	driver.findElement(By.xpath("//*[@id='contact_emp_zipcode']")).sendKeys(pincode);
	driver.findElement(By.xpath("//*[@id='contact_emp_hm_telephone']")).clear();
	driver.findElement(By.xpath("//*[@id='contact_emp_hm_telephone']")).sendKeys(telephone);
	driver.findElement(By.xpath("//*[@id='contact_emp_mobile']")).clear();
	driver.findElement(By.xpath("//*[@id='contact_emp_mobile']")).sendKeys(mobile);
	
	}
	//driver.findElement(By.cssSelector("input#formInputText")).sendKeys("2586258");
	public void  email_details(String email) {
	driver.findElement(By.cssSelector("input[name*='[emp_work_email]']")).clear();
	driver.findElement(By.cssSelector("input[name*='[emp_work_email]']")).sendKeys(email); 
	driver.findElement(By.cssSelector("input#btnSave")).click(); 
 }
 }
