package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import Day_010_Custimize_EmailableReport_Lab1.Reporter1;

public class customizable_email {
	WebDriver driver;
	Reporter1 R1;

	
@Parameters({"URL1","username1","password1","firstname1","secondname1"})
	 @Test
  public void Mainmethod(String URL,String username,String password,String firstname,String secondname) throws Exception {
		 
		 driver=TestBrowser.OpenChromeBrowser();
		 String Str= "Personal Details";
		 R1 = new Reporter1(driver,Str);
		 
		 //driver.get("https://opensource-demo.orangehrmlive.com/");
		 driver.get(URL);
		  R1.TakeScreenShotAuto(driver,"Opened Orange HRM","Pass");
		  
		  driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys(username);
		  R1.TakeScreenShotAuto(driver,"user name opened","Pass");
			driver.findElement(By.cssSelector("input[id^='txtPass']")).sendKeys(password);
			 R1.TakeScreenShotAuto(driver,"password opened","Pass");
			driver.findElement(By.cssSelector("input[name$='bmit']")).click();
			
			
			//List<WebElement>links = driver.findElements(By.tagName("input"));
			//System.out.println("total links are;"+links.size());
			
			driver.findElement(By.xpath("//*[@id='menu_pim_viewMyDetails']")).click();
			
			 driver.findElement(By.linkText("Personal Details")).click();
			 driver.findElement(By.cssSelector("input[id$='Save']")).click();
			 driver.findElement(By.cssSelector("input[name*='[txtEmpFirstName]']")).clear();
			
			 driver.findElement(By.cssSelector("input[name*='[txtEmpFirstName]']")).sendKeys(firstname);
			 R1.TakeScreenShotAuto(driver,"Entered firstname","Pass");
			 driver.findElement(By.id("personal_txtEmpLastName")).clear();
			 driver.findElement(By.id("personal_txtEmpLastName")).sendKeys(secondname);
			 R1.TakeScreenShotAuto(driver,"Entered secondname","Pass");
			 Select dropdown2 = new  Select(driver.findElement(By.name("personal[cmbMarital]")));
			 dropdown2.selectByVisibleText("Other");
			 Select dropdown = new  Select(driver.findElement(By.cssSelector("select#personal_cmbNation")));
			 dropdown.selectByIndex(154);
			 R1.TakeScreenShotAuto(driver,"Entered index","Pass");
			driver.findElement(By.cssSelector("input#btnSave")).click();
			 R1.TakeScreenShotAuto(driver,"details saved","Pass");
		 
	  
  }
}

