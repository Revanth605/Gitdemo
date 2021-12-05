package Broken_links;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import CommonUtil.TestBrowser;
import junit.framework.Assert;

public class broken_links {
	WebDriver driver;
	
	
  @Test
  public void f() throws Exception {
	  
	  driver=TestBrowser.OpenChromeBrowser();
	  driver.get("http://www.bhavasri.com/Frames/AllContacts.html");
	  List<WebElement> links = driver.findElements(By.tagName("a"));
	  System.out.println("Total num of links are "+links.size());
	  SoftAssert a= new SoftAssert();
	  
	  for(WebElement link : links)
	  {
		  String Url= link.getAttribute("href");
		  HttpURLConnection  re1th=(HttpURLConnection) new URL(Url).openConnection();
		  re1th.setRequestMethod("HEAD");
		  re1th.connect();
		 int response_code=re1th.getResponseCode();
		 System.out.println(response_code);
		 a.assertTrue(response_code<400,"the link with text" +link.getText()+"is broken with code"+response_code);
	  }
	  a.assertAll();
  }
}
/* SoftAssert a =new SoftAssert();

 

  for(WebElement link : links)

  {
  String url= link.getAttribute("href");
  HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();
  conn.setRequestMethod("HEAD");
   conn.connect();
  int respCode = conn.getResponseCode();
      System.out.println(respCode);

      a.assertTrue(respCode<400, "The link with Text"+link.getText()+" is broken with code" +respCode);

     

 

  }

 

  a.assertAll();
}*/
  
  
  

