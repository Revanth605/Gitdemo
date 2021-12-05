package photo_upload;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.openqa.selenium.interactions.Actions;
import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

public class Photo_Upload_Excel {
	
	WebDriver driver;
	
	
@DataProvider(name="photo_upload")
public static  Object[][] Authentication1() throws Exception{
	
		ExcelApiTest4 eat= new ExcelApiTest4();
      Object[][] testObjArray = eat.getTableArray("C://HTML Report//OrangeHRM6//TC02_Photo.xlsx","Sheet2");
       System.out.println(testObjArray.length);
        return (testObjArray); 
	}


  @Test(dataProvider= "photo_upload")
  public void PhotoUpload(String PhotoPath) throws Exception{
	
	  Photo_Upload_Excel Z1= new Photo_Upload_Excel();
	  Z1.open_Browser();
	  Z1.open_HomePage();
      Z1.existing_Emplyoee();


	// String PhotoPath="C:\\HTML Report\\EMP_Photos\\image2.jpg";
     Z1. photoupload(PhotoPath);
	  
  }  
  
  
  
	public void open_Browser() throws Exception { 
	 driver=TestBrowser.OpenChromeBrowser();
	 
	} 
	public void open_HomePage() throws Exception {   
		
  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
     driver.get("https://opensource-demo.orangehrmlive.com/");  
	findElement(By.id("txtUsername")).sendKeys("Admin");
	findElement(By.id("txtPassword")).sendKeys("admin123");
	findElement(By.id("btnLogin")).click();
	
	
	
	  } 
	public void existing_Emplyoee() throws Exception {
		
		findElement(By.xpath("//*[@id='menu_pim_viewPimModule']/b")).click();
		findElement(By.linkText("Employee List")).click();
	    findElement(By.id("empsearch_id")).sendKeys("0002");
		findElement(By.id("searchBtn")).click();
		findElement(By.xpath("//*[@id='resultTable']/tbody/tr/td[2]/a")).click();
		
		 //String photo="C:\\HTML Report\\EMP_Photos\\image2.jpg";
        // photoupload(photo);
	}

	public void photoupload(String PhotoPath) throws Exception {  
		
		
	findElement(By.id("empPic")).click();
	
	WebElement Choosephoto= findElement(By.id("photofile"));
	
	Actions actions = new Actions(driver);
	
	 actions.moveToElement(Choosephoto).click().build().perform();
	 
	 StringSelection sel= new StringSelection(PhotoPath);
	 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
	 System.out.println("selection"+sel);
	 
	 Robot robot= new Robot();
	 Thread.sleep(2000);
	 
	 robot.keyPress(KeyEvent.VK_CONTROL);
	 robot.keyPress(KeyEvent.VK_V);
	 
	 robot.keyRelease(KeyEvent.VK_CONTROL);
	 robot.keyRelease(KeyEvent.VK_V);
	 Thread.sleep(2000);
	 
	 robot.keyPress(KeyEvent.VK_ENTER);
	 robot.keyRelease(KeyEvent.VK_ENTER);
	 
	 Thread.sleep(3000);
	 
	 findElement(By.id("btnSave")).click();
	 
	 Thread.sleep(8000);
	 
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
