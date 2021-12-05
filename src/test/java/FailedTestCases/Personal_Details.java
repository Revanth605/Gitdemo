package FailedTestCases;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




import CommonUtil.TestBrowser;
public class Personal_Details {
	WebDriver driver;
	
	
 @BeforeTest	
public void open_chrome() throws Exception  {
		  
driver = TestBrowser.OpenChromeBrowser();

	  }
 
// @Parameters({"URL1","username1","password1","firstname1","secondname1"})
 @Test
  public void Mainmethod() throws Exception  {
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/");
	  Reporter.log("Pass-Application opened");
	  
	  driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("Admin");
	  Reporter.log("Pass-Enter Username");
		driver.findElement(By.cssSelector("input[id^='txtPass']")).sendKeys("admin123");
		Reporter.log("Pass- Enter password");
		driver.findElement(By.cssSelector("input[name$='bmit']")).click();
		Reporter.log("Pass- successful login");
		
		//List<WebElement>links = driver.findElements(By.tagName("input"));
		//System.out.println("total links are;"+links.size());
		
		driver.findElement(By.xpath("//*[@id='menu_pim_viewMyDetails']")).click();
		
		 driver.findElement(By.linkText("Personal Details")).click();
		 driver.findElement(By.cssSelector("input[id$='Save']")).click();
		 driver.findElement(By.cssSelector("input[name*='[txtEmpFirstName]']")).clear();
		
		 driver.findElement(By.cssSelector("input[name*='[txtEmpFirstName]']")).sendKeys("REVANTH");
		 Reporter.log("Pass- Added first name");
		 driver.findElement(By.id("personal_txtEmpLastName")).clear();
		 driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("REDDY");
		 Reporter.log("Pass- Added second name");
		 Select dropdown2 = new  Select(driver.findElement(By.name("personal[cmbMarital]")));
		 dropdown2.selectByVisibleText("Other");
		 Reporter.log("Pass- Added martial status");
		 Select dropdown = new  Select(driver.findElement(By.cssSelector("select#personal_cmbNation")));
		 dropdown.selectByIndex(154);
		 Reporter.log("Pass- added country");
		driver.findElement(By.cssSelector("input#btnSave")).click();
		 Reporter.log("Pass- successfully saved info");
	 
  }
  
	 @AfterTest
	 public void CloseBrowser() {
		  
		  driver.close();
		  }
 }
  
  

