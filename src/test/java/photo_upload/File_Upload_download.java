package photo_upload;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import org.openqa.selenium.interactions.Actions;
import CommonUtil.TestBrowser;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

public class File_Upload_download {
	
	WebDriver driver;
	public String DestinationFile;
  @Test
  public void PhotoUpload() throws Exception{
	
	  File_Upload_download Z1= new File_Upload_download();
	  Z1.open_Browser();
	  Z1.open_HomePage();
      Z1.existing_Emplyoee();


	 String file="C:\\HTML Report\\EMP_Photos\\FILE1.txt";
     Z1. Fileupload(file);
	  
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

	public void Fileupload(String file) throws Exception {  
	
		
		findElement(By.id("btnAddAttachment")).click();
WebElement Choosefile= findElement(By.id("ufile"));
	
	Actions actions = new Actions(driver);
	
	 actions.moveToElement(Choosefile).click().build().perform();
	 
	 StringSelection sel= new StringSelection(file);
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
	 
	 findElement(By.id("btnSaveAttachment")).click();
	 
	 Thread.sleep(8000);
	//TO DOWNLOAD THE FILE
	 findElement(By.xpath("//*[@id='tblAttachments']/tbody/tr/td[2]/a")).click();
	 WebElement Element = findElement(By.xpath("//*[@id='tblAttachments']/tbody/tr/td[2]/a"));
	String revanth= Element.getText();	 
	 
	 String srcfile= "C:\\Users\\admin\\Downloads\\"+revanth;
	 String DestinationFile= "C:\\HTML Report\\"+revanth;
	 moveFile(srcfile,DestinationFile);
	}
	 
	 public static void moveFile(String src, String dest ) throws InterruptedException {
	        Path result = null;
	        try {
	           result =  Files.move(Paths.get(src), Paths.get(dest));
	           
	           
	           Thread.sleep(5000);
	        } catch (IOException e) {
	           System.out.println("Exception while moving file: " + e.getMessage());
	        }
	        if(result != null) {
	           System.out.println("File moved successfully.");
	        }
	        else{
	           System.out.println("File movement failed.");
	        }  
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
