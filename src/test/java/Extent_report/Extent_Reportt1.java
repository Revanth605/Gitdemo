package Extent_report;


import java.text.SimpleDateFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.util.Date;

import CommonUtil.TestBrowser;


public class Extent_Reportt1 {
	WebDriver driver;
	ExtentTest logger;
	ExtentReports extent;
	String screenShotPath;
	public static String TestScriptName = "Add_immigration";
	public static String TestName;		
	
	String URL="https://opensource-demo.orangehrmlive.com/",username= "Admin",password="admin123",number="25892",eligible_status="parent",issued_by="UG";
	String comments="i m a good boy" ;
	

	@Test
  public void MainMethod () throws Exception {
		   
		driver = TestBrowser.OpenChromeBrowser();
	
		          
		
	          SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MMM-dd-h-MM-ss-SSS-a");
				Date now = new Date();
				String strDate = sdfDate.format(now);
					
				TestName=TestScriptName+"_"+strDate+".html";
				TestScriptName=TestScriptName+"_"+strDate;
				String TestHtmlName="c:/HTML Report/test-output/ExtentReportScreenShots/"+TestScriptName+"/"+TestName;
					
				ExtentHtmlReporter reporter = new ExtentHtmlReporter(TestHtmlName);
					
				System.out.println("Html Report path is : "+TestHtmlName);

				extent = new ExtentReports();
				extent.attachReporter(reporter);
				logger=extent.createTest(TestName);
		
		
	driver.get(URL);



	driver.findElement(By.id("txtUsername")).sendKeys(username);
	
	driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(password);
	screenShotPath = ExtentReport.capture(driver,TestScriptName);
	logger.pass("Login Page - Entered password",MediaEntityBuilder.
			createScreenCaptureFromPath(screenShotPath).build());
	
	driver.findElement(By.cssSelector("input#btnLogin")).click();



	driver.findElement(By.id("menu_pim_viewMyDetails")).click();
	
	driver.findElement(By.xpath("//a[text()='Immigration']")).click();
	screenShotPath = ExtentReport.capture(driver,TestScriptName);
	logger.pass("home page - clicked on immigration",MediaEntityBuilder.
			createScreenCaptureFromPath(screenShotPath).build());
	
	
	driver.findElement(By.cssSelector("input#btnAdd")).click();
	
	driver.findElement(By.xpath("//*[@id='immigration_type_flag_2']")).click();
	
	driver.findElement(By.name("immigration[number]")).sendKeys(number);
	screenShotPath = ExtentReport.capture(driver,TestScriptName);
	logger.pass("home page - entered number",MediaEntityBuilder.
			createScreenCaptureFromPath(screenShotPath).build());
	
	driver.findElement(By.name("immigration[i9_status]")).sendKeys(eligible_status);
	
	Select dropdown= new Select(driver.findElement(By.id("immigration_country")));
	dropdown.selectByValue(issued_by);
	
	driver.findElement(By.cssSelector("textarea.formInputText")).sendKeys(comments);
	
	driver.findElement(By.id("btnSave")).click();
	screenShotPath = ExtentReport.capture(driver,TestScriptName);
	logger.pass("home page - saved successfully",MediaEntityBuilder.
			createScreenCaptureFromPath(screenShotPath).build());
	
	extent.flush();
}
}