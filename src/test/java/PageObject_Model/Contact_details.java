package PageObject_Model;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Contact_details {
	WebDriver driver;
	  String	door_num="25/29/18/56",colony="ramapuram",city ="hyderabad",state="gana";
		String pincode ="20204",telephone="7889456123",mobile="2586258",email="bhava@gmail.com";
	

	public void Contact_details(WebDriver driver) {
		this.driver=driver;
		
	}
  @Test
  public void contact_details1() throws Exception {
	  
	  
	  
	/*  Contact_details C1=new Contact_details();
	  C1.open_myinfo();
	  C1.address(door_num,colony,city,state); 
	  C1.contact_details(pincode,telephone,mobile); 
	  C1.email_details(email);*/
	  
  
  
	//public  void  open_myinfo() throws Exception {	
	    findElement(By.xpath("//*[@id='menu_pim_viewMyDetails']/b")).click();
		findElement(By.partialLinkText("Contact")).click();
		findElement(By.xpath("//*[@id='btnSave']")).click();
	
		//public  void  address( String door_num,String colony,String city, String state) throws Exception {
		findElement(By.cssSelector("input[type='text']")).clear();
		findElement(By.cssSelector("input[type='text']")).sendKeys(door_num); 
		findElement(By.xpath("//*[@id='contact_street2']")).clear();
		findElement(By.xpath("//*[@id='contact_street2']")).sendKeys(colony);
		findElement(By.cssSelector("input#contact_city")).clear();
	findElement(By.cssSelector("input#contact_city")).sendKeys(city);
		findElement(By.xpath("//input[@name='contact[province]']")).clear();
		findElement(By.xpath("//input[@name='contact[province]']")).sendKeys(state);
		
		//public   void contact_details( String pincode,String telephone, String mobile) throws Exception {
		findElement(By.xpath("//*[@id='contact_emp_zipcode']")).clear();
		findElement(By.xpath("//*[@id='contact_emp_zipcode']")).sendKeys(pincode);
		findElement(By.xpath("//*[@id='contact_emp_hm_telephone']")).clear();
		findElement(By.xpath("//*[@id='contact_emp_hm_telephone']")).sendKeys(telephone);
		findElement(By.xpath("//*[@id='contact_emp_mobile']")).clear();
		findElement(By.xpath("//*[@id='contact_emp_mobile']")).sendKeys(mobile);
		
		
		//driver.findElement(By.cssSelector("input#formInputText")).sendKeys("2586258");
		//public void  email_details(String email) throws Exception {
		findElement(By.cssSelector("input[name*='[emp_work_email]']")).clear();
		findElement(By.cssSelector("input[name*='[emp_work_email]']")).sendKeys(email); 
		findElement(By.cssSelector("input#btnSave")).click(); 
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
