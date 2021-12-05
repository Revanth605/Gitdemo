package Practice;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import CommonUtil.TestBrowser;
import Day_009_Extent_Reports.ExtentReport;

public class Extent_Reports {
	WebDriver driver;
	ExtentTest logger;
	ExtentReports extent;
	String ScreenShotPath;
	public static  String TestScriptName ="Immigration_Details";
	public static String TestName;
	

	String URL="https://opensource-demo.orangehrmlive.com/",username= "Admin",password="admin123",number="252350",eligible_status="sun",issued_by="UG";
	String comments="i m a best boy" ;
	
	
	
	
	
 @Test
  public void Mainmethod () throws Exception {
	 
	 Extent_Reports re1th = new  Extent_Reports();
	 re1th.open_URL();
	 re1th.loginHRMURL(URL);
	 re1th.login_page( username,password);
	 re1th.immigration_details( number, eligible_status,issued_by,comments);
	 
	 
	 
  }
 
 public void open_URL() throws Exception {
	 
	 driver = TestBrowser.OpenChromeBrowser();
	// step3 start here - ExtendsHtmlReport starts
			 SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy_MMM_dd_h_mm_ss_SSS_a");
			 Date now = new Date();
			 String strDate = sdfDate.format(now);
			 
			 TestName=TestScriptName+"_"+strDate+".html";
			 TestScriptName=TestScriptName+"_"+strDate;
			  String TestHtmlName="C:/HTML Report/test-output/ExtentReportScreenShots/"+ TestScriptName +"/"+TestName;
			  
			 //String TestHtmlName=TestName;
			 ExtentHtmlReporter reporter=new ExtentHtmlReporter(TestHtmlName);
			 
			 System.out.println("Html Report path is : "+TestHtmlName);
			 
			 extent=new ExtentReports();
			 extent.attachReporter(reporter);
			 logger=extent.createTest(TestName);
	
		 }
 
 public void loginHRMURL(String URL) {
	  
	driver.get(URL);
     }
 public void login_page(String username,String password) throws Exception {
		
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		
		driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(password);
		ScreenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("Login Page - Entered password",MediaEntityBuilder.
				createScreenCaptureFromPath(ScreenShotPath).build());
		
		driver.findElement(By.cssSelector("input#btnLogin")).click();
	}

	public void immigration_details(String number,String eligible_status,String issued_by,String comments) throws Exception {
		
		driver.findElement(By.id("menu_pim_viewMyDetails")).click();
		
		driver.findElement(By.xpath("//a[text()='Immigration']")).click();
		ScreenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("home page - clicked on immigration",MediaEntityBuilder.
				createScreenCaptureFromPath(ScreenShotPath).build());
		
		
		driver.findElement(By.cssSelector("input#btnAdd")).click();
		
		driver.findElement(By.xpath("//*[@id='immigration_type_flag_2']")).click();
		
		driver.findElement(By.name("immigration[number]")).sendKeys(number);
		ScreenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("home page - entered number",MediaEntityBuilder.
				createScreenCaptureFromPath(ScreenShotPath).build());
		
		driver.findElement(By.name("immigration[i9_status]")).sendKeys(eligible_status);
		
		Select dropdown= new Select(driver.findElement(By.id("immigration_country")));
		dropdown.selectByValue(issued_by);
		
		driver.findElement(By.cssSelector("textarea.formInputText")).sendKeys(comments);
		
		driver.findElement(By.id("btnSave")).click();
		ScreenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("home page - saved successfully",MediaEntityBuilder.
				createScreenCaptureFromPath(ScreenShotPath).build());
      
		extent.flush();
		
		
		driver.close();
	
	}
	}
 


