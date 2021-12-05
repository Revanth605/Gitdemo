package PageFactory_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class General_info_PFM {
	
	WebDriver driver;
	String org_name="MEGHANA",a ="5555",mail_id="MEGHANA@gmail.com", place="mumbi",pin_code="520080",note="i am a boy";
	
	
	public void General_info_PFM(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="menu_admin_viewAdminModule")
	WebElement Admin;
	
	@FindBy(id="menu_admin_Organization")
	WebElement Organisation;
	
	@FindBy(id="menu_admin_viewOrganizationGeneralInformation")
	WebElement GeneralInformation;
	
	@FindBy(name="btnSaveGenInfo")
	WebElement Save;
	
	@FindBy(name="organization[name]")
	WebElement Orgname;
	
	@FindBy(name="organization[name]")
	WebElement Orgname1;
	
	@FindBy(name="organization[phone]")
	WebElement OrgPhone;
	
	@FindBy(name="organization[phone]")
	WebElement OrgPhone1;
	
	@FindBy(id="organization_email")
	WebElement OrgEmail;
	
	@FindBy(id="organization_email")
	WebElement OrgEmail1;
	
	@FindBy(name="organization[street1]")
	WebElement OrgStreet;
	
	@FindBy(name="organization[street1]")
	WebElement OrgStreet1;
	
	@FindBy(name="organization[zipCode]")
	WebElement OrgZipcode;
	
	@FindBy(name="organization[zipCode]")
	WebElement OrgZipcode1;
	
	@FindBy(name="organization[note]")
	WebElement OrgNote;
	
	@FindBy(name="organization[note]")
	WebElement OrgNote1;
	
	@FindBy(id="btnSaveGenInfo")
	WebElement save;
	
	
  
  public void general_info() throws Exception {
	  Admin.click();
	  Organisation.click();
	  GeneralInformation.click();
	  Save.click();
	  Orgname.clear();
	  Orgname1.sendKeys(org_name);
	  OrgPhone.clear();
	  OrgPhone1.sendKeys(a);
	  OrgEmail.clear();
	  OrgEmail1.sendKeys(mail_id);
	  OrgStreet.clear();
	  OrgStreet1.sendKeys(place);
	  OrgZipcode.clear();
	  OrgZipcode1.sendKeys(pin_code);
	  OrgNote.clear();
	  OrgNote1.sendKeys(note);
	  save.click();
	  
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

