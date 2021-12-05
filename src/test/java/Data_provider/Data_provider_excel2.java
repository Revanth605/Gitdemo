package Data_provider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;

public class Data_provider_excel2 {
	
	WebDriver driver;
	
 	
@DataProvider(name= "emergency_contact_details")
public static Object[][] sravanthi() throws Exception {
ExcelApiTest4 eat= new ExcelApiTest4();
	Object[][] testObjArray= eat.getTableArray("C://HTML Report//OrangeHRM6//EmergencyDetails.xlsx","Sheet5");
	System.out.println(testObjArray.length);
	return(testObjArray);
}
	


	
@Test(dataProvider="emergency_contact_details")
  public void Mainmethod(String URL, String username, String password, String name, String relationship, String home_telephone , String work_phone  ) throws Exception {
	

	
	Data_provider_excel2 re1th = new Data_provider_excel2();
	   re1th.open_browser();
	   re1th.open_URL(URL);
	   re1th.openloginpage(username,password);
	   re1th.myinfo(name,relationship,home_telephone,work_phone);
  }
  
  
  public void open_browser()throws Exception {
	  driver=TestBrowser.OpenChromeBrowser();
  }
  
  public void open_URL( String URL) {
	  driver.get(URL);
	  
  }  
	  public void openloginpage( String username,String password ) {
		  driver.findElement(By.cssSelector("input[id^='txtUser']")).sendKeys(username);
		  driver.findElement(By.cssSelector("input[id$='Password']")).sendKeys(password);
		  driver.findElement(By.name("Submit")).click();
	  }
	  
	  
	  public void myinfo(String name,String relationship, String home_telephone , String work_phone) { 
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





