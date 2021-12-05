package PageObject_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class General_info {
	
	WebDriver driver;
	String org_name="MEGHA",mail_id="MEGHA@gmail.com", place="mumbi",pin_code="520080",note="i am a boy";
	String a ="5555" ;
	
	public void General_info(WebDriver driver) {
		this.driver= driver;
	}
	
  @Test
  public void general_info() throws Exception {
	findElement(By.id("menu_admin_viewAdminModule")).click();
	findElement(By.id("menu_admin_Organization")).click();
	 findElement(By.id("menu_admin_viewOrganizationGeneralInformation")).click();
	 findElement(By.name("btnSaveGenInfo")).click();
	findElement(By.name("organization[name]")).clear();
	findElement(By.name("organization[name]")).sendKeys(org_name);
	 findElement(By.name("organization[phone]")).clear();
	 findElement(By.name("organization[phone]")).sendKeys(a);
	 findElement(By.id("organization_email")).clear();
	 findElement(By.id("organization_email")).sendKeys(mail_id);
	findElement(By.name("organization[street1]")).clear();
	findElement(By.name("organization[street1]")).sendKeys(place);
	findElement(By.name("organization[zipCode]")).clear();
	findElement(By.name("organization[zipCode]")).sendKeys(pin_code);
	  findElement(By.name("organization[note]")).clear();
	  findElement(By.name("organization[note]")).sendKeys(note);
	  findElement(By.id("btnSaveGenInfo")).click();
	  
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

