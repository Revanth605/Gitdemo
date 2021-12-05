package PageObject_Model;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Add_Generali_nfo {
	WebDriver driver;
 
	@BeforeTest
	public void OpenBrowser() throws Exception {
		driver= TestBrowser.OpenChromeBrowser();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		}
	
	@Test
  public void Generalinfo() throws Exception {
		
		Login_page L1= new Login_page();
				L1.Login_page(driver);
				L1.Login();
	  
				General_info G2=new General_info();
				G2.General_info(driver);
				G2.general_info();
				
				
				LogOut B1=new LogOut();
				B1.LogOut(driver);
				B1.logout();
  }
	@AfterTest
	public void closebrowser() {
		driver.quit();
	}
	
	
	
	
}
