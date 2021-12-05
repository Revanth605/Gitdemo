package Dataprovider_browserCompatability;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;

public class browsercompatability_excel {
	WebDriver driver;
@DataProvider(name="immigration")
public static Object revanth () throws Exception{

		ExcelApiTest4 eat= new ExcelApiTest4();
		Object[][] testObjectArray=eat.getTableArray("C://HTML Report//OrangeHRM6//EmergencyDetails.xlsx","Sheet3");
	System.out.println(testObjectArray.length);
	return testObjectArray;
	}
 
	@Test(dataProvider="immigration")
  public void MainMethod (String Browser,String URL,String username,String password,String number,String eligible_status,String issued_by,String comments ) throws Exception {
		browsercompatability_excel sra1thi = new browsercompatability_excel();
		sra1thi.loginbrowser(Browser);
		sra1thi.loginHRMURL(URL);
		sra1thi.login_page(username,password);
		sra1thi.immigration_details(number,eligible_status,issued_by,comments);
  }
  
	public void loginbrowser(String Browser) throws Exception {
		
		if(Browser.equalsIgnoreCase("Chrome")) {
			driver=TestBrowser.OpenChromeBrowser();
			}
		else if (Browser.equalsIgnoreCase("FireFox")) {
			driver=TestBrowser.FirefoxBrowser();
		}
	}
  
public void loginHRMURL(String URL) {
	driver.get(URL);
}

public void login_page(String username,String password) {
	driver.findElement(By.id("txtUsername")).sendKeys(username);
	driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys(password);
	driver.findElement(By.cssSelector("input#btnLogin")).click();
}

public void immigration_details(String number,String eligible_status,String issued_by,String comments) {
	
	driver.findElement(By.id("menu_pim_viewMyDetails")).click();
	driver.findElement(By.xpath("//a[text()='Immigration']")).click();
	driver.findElement(By.cssSelector("input#btnAdd")).click();
	driver.findElement(By.xpath("//*[@id='immigration_type_flag_2']")).click();
	driver.findElement(By.name("immigration[number]")).sendKeys(number);
	driver.findElement(By.name("immigration[i9_status]")).sendKeys(eligible_status);
	Select dropdown= new Select(driver.findElement(By.id("immigration_country")));
	dropdown.selectByValue(issued_by);
	driver.findElement(By.cssSelector("textarea.formInputText")).sendKeys(comments);
	driver.findElement(By.id("btnSave")).click();
}
}