package PageObject_Model;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Add_Contact_Details {
	WebDriver driver;
	
	@BeforeTest
	public void open_browser() throws Exception {
	driver=TestBrowser.OpenChromeBrowser();
	driver.get("https://opensource-demo.orangehrmlive.com/");
	
	}
  @Test
  public void contact_details() throws Exception {
	  
	  Login_page L1= new Login_page();
		L1.Login_page(driver);
		L1.Login();
		
		
		Contact_details C1= new Contact_details();
		C1.Contact_details(driver);
		C1.contact_details1();

		
		LogOut B1=new LogOut();
		B1.LogOut(driver);
		B1.logout();
}
@AfterTest
public void closebrowser() {
driver.quit();
}

		
	  
  }

