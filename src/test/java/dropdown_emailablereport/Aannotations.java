package dropdown_emailablereport;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Aannotations {
	WebDriver driver;


@BeforeTest
 public void open_chrome() throws Exception  {
		  
driver= TestBrowser.OpenChromeBrowser();
}
@Parameters({"URL1","username","password","firstvalue","secondvalue","dropdown6", "dropdown7"})
//@Optional or defined  
@Test
 public void Mainmethod(@Optional("URL1")String URL1,@Optional("username")String username,@Optional("password")String password,@Optional("firstvalue")String firstvalue,@Optional("secondvalue")String secondvalue,@Optional("dropdown6")String dropdown6,@Optional("dropdown7")String dropdown7)throws Exception{
	Aannotations L1=new Aannotations();
			L1.loginbrowser(URL1);
			L1.login(username,password);
			L1.contact_info(firstvalue,secondvalue,dropdown6,dropdown7);
			
}	
	public void loginbrowser(String URL) { 
	driver.get(URL);
    Reporter.log("pass-HRMURL opened");
	 }
    
    public void login(String username,String password) {
    driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys(username);
	Reporter.log("pass-username add");
driver.findElement(By.cssSelector("input[id^='txtPass']")).sendKeys(password);
	Reporter.log("pass-pasword add");
	driver.findElement(By.cssSelector("input[name$='bmit']")).click();
	/*List<WebElement>links = driver.findElements(By.tagName("input"));
	System.out.println("total links are;"+links.size());*/
	
    }
    public void contact_info(String firstvalue,String secondvalue,String dropdown6,String dropdown7 ) {
	driver.findElement(By.xpath("//*[@id='menu_pim_viewMyDetails']")).click();
		driver.findElement(By.linkText("Personal Details")).click();
		driver.findElement(By.cssSelector("input[id$='Save']")).click();
		driver.findElement(By.cssSelector("input[name*='[txtEmpFirstName]']")).clear();
		driver.findElement(By.cssSelector("input[name*='[txtEmpFirstName]']")).sendKeys(firstvalue);
		 Reporter.log("pass- first name  add");
		driver.findElement(By.id("personal_txtEmpLastName")).clear();
		driver.findElement(By.id("personal_txtEmpLastName")).sendKeys(secondvalue);
		 Reporter.log("pass-second name add");
		 Select dropdown2 = new  Select(driver.findElement(By.name("personal[cmbMarital]")));
		 dropdown2.selectByVisibleText(dropdown6);
		 Select dropdown = new  Select(driver.findElement(By.cssSelector("select#personal_cmbNation")));
		 
		 Integer dropdown7Value = Integer.valueOf(dropdown7);
		 dropdown.selectByIndex(dropdown7Value);
	driver.findElement(By.cssSelector("input#btnSave")).click();
	 }


@AfterTest
	 public void close_chrome() throws Exception  {
			  
	driver.close();
			
	 }
	
 }
  
  

