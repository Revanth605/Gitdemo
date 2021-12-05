package Data_provider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;

public class Data_provider2 {
	
	WebDriver driver;
	
@DataProvider(name= "emergency_contact_details")
public static Object[][] sravanthi() {
Object[][] data= new Object[2][7]; 
	 
	 data[0][0]="https://opensource-demo.orangehrmlive.com/";
	 data[0][1]="Admin";
     data[0][2]="admin123";
     data[0][3]="revanth";  
     data[0][4]= "parents"; 
     data[0][5] ="2569872";
     data[0][6]="258975";
     
     data[1][0]="https://opensource-demo.orangehrmlive.com/";
	 data[1][1]="Admin";
     data[1][2]="admin123";
     data[1][3]="sravanthhi";  
     data[1][4]= "sister"; 
     data[1][5] ="2589971";
     data[1][6]="32534687";
     return data;
	}
	
@Test(dataProvider="emergency_contact_details")
  public void Mainmethod(String URL1, String username1, String password1, String name1, String relationship1, String home_telephone1, String work_phone1 ) throws Exception {
	  Data_provider2 re1th = new Data_provider2();
	   re1th.open_browser();
	   re1th.open_URL(URL1);
	   re1th.openloginpage(username1,password1);
	   re1th.myinfo(name1,relationship1,home_telephone1,work_phone1);
  }
  
  
  public void open_browser()throws Exception {
	  driver = TestBrowser.OpenChromeBrowser();
  }
  
  public void open_URL( String URL) {
	  driver.get(URL);
	  
  }  
	  public void openloginpage( String username,String password ) {
		   driver.findElement(By.cssSelector("input[id^='txtUser']")).sendKeys(username);
		  driver.findElement(By.cssSelector("input[id$='Password']")).sendKeys(password);
		  driver.findElement(By.name("Submit")).click();
	  }
	  
	  
	  public void myinfo(String name,String relationship,String home_telephone,String work_phone) {
		driver.findElement(By.cssSelector("a#menu_pim_viewMyDetails")).click();
		  driver.findElement(By.partialLinkText("Emergency")).click();
		  driver.findElement(By.id("btnAddContact")).click();
		  driver.findElement(By.xpath("//*[@id='emgcontacts_name']")).sendKeys(name);
		  driver.findElement(By.name("emgcontacts[relationship]")).sendKeys(relationship);
		  driver.findElement(By.cssSelector("input#emgcontacts_homePhone")).sendKeys(home_telephone);
		  driver.findElement(By.cssSelector("input[class$='InputText'")).sendKeys(work_phone);
		  driver.findElement(By.xpath("//*[@id='btnSaveEContact']")).click();
		   }
	  
  }





