package PageFactory_Model;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import PageObject_Model.General_info;
import PageObject_Model.LogOut;
import PageObject_Model.Login_page;

public class Add_General_info_PFM {
	WebDriver driver;
 
	@BeforeTest
	public void OpenBrowser() throws Exception {
		driver= TestBrowser.OpenChromeBrowser();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		}
	
	@Test
  public void Generalinfo() throws Exception {
		
		Login_PFM1 L1= new Login_PFM1();
				L1.Login_PFM1(driver);
				L1.Login();
	  
				General_info_PFM G2=new General_info_PFM();
				G2.General_info_PFM(driver);
				G2.general_info();
				
				
				LogOut_PFM B1=new LogOut_PFM();
				B1.LogOut_PFM(driver);
				B1.LogOut();
  }
	@AfterTest
	public void closebrowser() {
		driver.quit();
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
