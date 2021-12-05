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
import Day_009_Extent_Reports.ExtentReport;//we should import  Day_009_Extent_Reports into our package or we should mention import.package name.class name i,e (import.Day_009_Extent_Reports.ExtentReports).

public class Extent_Reportt {
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
		   
		 
					
		Extent_Reportt sra1thi = new Extent_Reportt();
		sra1thi.Open_Chrome();
		sra1thi.loginHRMURL(URL);
		sra1thi.login_page(username,password);
		sra1thi.immigration_details(number,eligible_status,issued_by,comments);
		
		
  }
	
	public void Open_Chrome() throws Exception {
		
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
		
	}
  public void loginHRMURL(String URL) {
	  
	driver.get(URL);
}

public void login_page(String username,String password) throws Exception {
	
	driver.findElement(By.id("txtUsername")).sendKeys(username);
	
	driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(password);
	screenShotPath = ExtentReport.capture(driver,TestScriptName);
	logger.pass("Login Page - Entered password",MediaEntityBuilder.
			createScreenCaptureFromPath(screenShotPath).build());
	
	driver.findElement(By.cssSelector("input#btnLogin")).click();
}

public void immigration_details(String number,String eligible_status,String issued_by,String comments) throws Exception {
	
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