package Web_Tables;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;



import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;

public class Web_Tables {
	WebDriver driver;
	
  @Test
  public void Pim_Employee() throws Exception {
	  
	  Web_Tables Z1= new Web_Tables();
	  Z1.open_Browser();
	  Z1.open_HomePage();
      Z1.existing_Emplyoee();
      Z1.Export_Employee();
	  
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
	  
		
  }
		public void Export_Employee() throws Exception {
	
			String Empcolumns="//*[@id='resultTable']/thead/tr/th";
			List<WebElement> columns=driver.findElements(By.xpath(Empcolumns));
			System.out.println("total number of columns in a webtable are "+columns.size());
			
			String Emprows="//*[@id='resultTable']/tbody/tr/td[2]";
			List<WebElement> rows=driver.findElements(By.xpath(Emprows));
			System.out.println("total number of rows in a webtable are "+rows.size());
			
			
			ExcelApiTest4 eat = new ExcelApiTest4();
			for(int i=1;i<=rows.size();i++)
			{
			for(int j=2,k=0;j<=columns.size();j++,k++)
			{
				String WebElement=findElement(By.xpath(" //*[@id='resultTable']/tbody/tr[" + i +"]" + "/td" + "[" + j + "]")).getText();
				
				if (WebElement != null)
					eat.PutCellData("C:\\HTML Report\\OrangeHRM6\\Employee_Export.xlsx","Sheet1",i-1,k,WebElement);
				else
					eat.PutCellData("C:\\HTML Report\\OrangeHRM6\\Employee_Export.xlsx","Sheet1",i-1,k,"Blank Data");
			}
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
