package dropdown_emailablereport;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Add_skills_dropdown {
	WebDriver driver;
	
	
 
 
 
  @Test
  public void Mainmethod() throws Exception  {
	  
	  Add_skills_dropdown re1th = new Add_skills_dropdown();
	  re1th.open_chrome();
	 re1th.open_HRMURL();
	  re1th.open_HRMloginpage();
	  re1th.open_myinfo();
  }
  public void open_chrome() throws Exception  {
	  
	  driver = TestBrowser.OpenChromeBrowser();
	  	  }
  
   public void open_HRMURL() {
	  
	  driver.get("https://opensource-demo.orangehrmlive.com");
	  }
	  
	  public void open_HRMloginpage() {
	driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("Admin");
	driver.findElement(By.cssSelector("input[id^='txtPass']")).sendKeys("admin123");
	driver.findElement(By.cssSelector("input[name$='bmit']")).click();
	List<WebElement>links = driver.findElements(By.tagName("input"));
	System.out.println("total links are;"+links.size());
	
	  }
	 public void  open_myinfo() {
		 driver.findElement(By.xpath("//*[@id='menu_pim_viewMyDetails']")).click();
		 driver.findElement(By.linkText("Personal Details")).click();
		 driver.findElement(By.cssSelector("input[id$='Save']")).click();
		 driver.findElement(By.cssSelector("input[name*='[txtEmpFirstName]']")).clear();
		 driver.findElement(By.cssSelector("input[name*='[txtEmpFirstName]']")).sendKeys("revanth");
		 driver.findElement(By.id("personal_txtEmpLastName")).clear();
		 driver.findElement(By.id("personal_txtEmpLastName")).sendKeys("kumar");
		 Select dropdown2 = new  Select(driver.findElement(By.name("personal[cmbMarital]")));
		 dropdown2.selectByVisibleText("Other");
		 Select dropdown = new  Select(driver.findElement(By.cssSelector("select#personal_cmbNation")));
		 dropdown.selectByIndex(154);
		driver.findElement(By.cssSelector("input#btnSave")).click();
	 }
	 
	
 }
  
  

