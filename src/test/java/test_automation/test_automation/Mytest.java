package test_automation.test_automation;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Mytest {
	WebDriver driver;

  @Test
  public void openurl() throws IOException, InterruptedException {
//Opening URL
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\\\chromedriver_win32\\\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://auth.dev.vntech.io");
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

// Handling Cookie
	  
	  List<WebElement> cookiePopups = driver.findElements(By.xpath("//div[@class='MuiGrid-root MuiGrid-container css-3uuuu9']"));
	  if (!cookiePopups.isEmpty()) {
	  // Cookie pop-up is present, handle it
	  WebElement acceptButton = driver.findElement(By.xpath("(//button[@type='button'])[5]"));
	  acceptButton.click();
	  }
	  
//Signup With Email
//		driver.findElement(By.xpath("//a[text()='Sign up']")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//div[@class='MuiCollapse-root MuiCollapse-vertical MuiCollapse-entered css-c4sutr']")).click();
//		driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("test");
//		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("automation492");
//		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("testautomation492@gmail.com");
//		driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
 
//Sign in with Facebook
	
	  driver.findElement(By.xpath("//button[@class='jss13 medium']")).click(); 
      //Handle new window
	  String mainWindowHandle = driver.getWindowHandle();
      // Perform the action that opens the new window
	  Set<String> windowHandles = driver.getWindowHandles();
	  for (String handle : windowHandles) {
		
	    if (!handle.equals(mainWindowHandle)) {
	    	
	        driver.switchTo().window(handle);
	        break;
	     }
	  }
// Find and interact with elements in the new window
	  WebElement inputField = driver.findElement(By.id("email"));
	  inputField.sendKeys("testautomation492@gmail.com");
	  WebElement inputField1 = driver.findElement(By.id("pass"));
	  inputField1.sendKeys("Test@1234");
	  WebElement inputField2 = driver.findElement(By.id("loginbutton"));
	  inputField2.click();
	  WebElement inputField3 = driver.findElement(By.xpath("//span[text()='OK']"));
	  inputField3.click();
	 // Take Screenshot
	  File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Save the screenshot to a desired location
	  String destinationPath2 = "C:\\Users\\palad\\Pictures\\Saved Pictures\\screenshot1.png";
	  FileUtils.copyFile(screenshotFile2, new File(destinationPath2));
	  driver.close();
// Switch back to the main window
	  driver.switchTo().window(mainWindowHandle);

//login with Apple ID
	
	  driver.findElement(By.xpath("//button[@class='react-apple-signin-auth-btn react-apple-signin-auth-btn-dark jss14']")).click();
	
	  //Handle new window
	  String mainWindowHandle1 = driver.getWindowHandle();

      //Perform the action that opens the new window

	  Set<String> windowHandles1 = driver.getWindowHandles();
	  for (String handle : windowHandles1) {
		
	    if (!handle.equals(mainWindowHandle1)) {
	   
	        driver.switchTo().window(handle);
	        break;
	     }
	  }

	  boolean isPageOpen = false;
//
      try {
          WebElement element = driver.findElement(By.xpath("//a[@class='globalnav-link globalnav-link-apple']"));
//If the element is found, it indicates that the page is open
          isPageOpen = true;
	      } 
      catch (NoSuchElementException e) {
//	    // The element is not found, indicating that the page is not open
      isPageOpen = false;
	      }
 
	  if (isPageOpen) {
	    System.out.println("The apple page is open.");
	  } else {
	    System.out.println("The apple page is not open.");
	  }

	 driver.close();
	
//Switching to main window
	
  driver.switchTo().window(mainWindowHandle);
	

//Signup with microsoft
	
	
	driver.findElement(By.xpath("//div[@class='MuiGrid-root jss15 css-rfnosa']")).click();
	Stack<String> windowStack = new Stack<>();
	windowStack.push(driver.getWindowHandle());
	
	//Handle new window
	String mainWindowHandle13 = driver.getWindowHandle();

//Perform the action that opens the new window

	Set<String> windowHandles13 = driver.getWindowHandles();
	for (String handle : windowHandles13) {
		
	    if (!handle.equals(windowStack.peek())) {
	        windowStack.push(handle);
	        driver.switchTo().window(handle);
	        break;
	    }
	}
	WebElement inputField4 = driver.findElement(By.xpath("//input[@type='email']"));
	inputField4.sendKeys("testautomation492@gmail.com");
	
	WebElement inputField6 = driver.findElement(By.id("idSIButton9"));
	inputField6.click();
//	
//	// Switch to the second new window
//	windowHandles = driver.getWindowHandles();
//	for (String handle : windowHandles) {
//	    if (!handle.equals(windowStack.peek())) {
//	        windowStack.push(handle);
//	        driver.switchTo().window(handle);
//	        break;
//	    }
//	}
	driver.get("https://login.live.com/oauth20_authorize.srf?client_id=166f766d-47a4-442a-9a4e-0645cfdbf97e&scope=User.Read+openid+profile+offline_access&redirect_uri=https%3a%2f%2fauth.dev.vntech.io%2f&response_type=code&state=eyJpZCI6ImJlYjQ0ZDZhLTJiNjgtNGJmOS1iNmM0LWE0Y2M3MWMxYTJiMCIsIm1ldGEiOnsiaW50ZXJhY3Rpb25UeXBlIjoicG9wdXAifX0%3d&response_mode=fragment&nonce=2be52054-0c96-4f6e-ade3-9af2ac6b9cc7&code_challenge=8eiVdP3jS5twEXGcZ00iuD-inOv7h0rTUzgXvNvt-xM&code_challenge_method=S256&x-client-SKU=msal.js.browser&x-client-Ver=2.37.1&uaid=c780fb32f14b4a94ae6b772ffe93773f&msproxy=1&issuer=mso&tenant=common&ui_locales=en-US&client_info=1&epct=PAQABAAEAAAD--DLA3VO7QrddgJg7WevrLVTDHcx56ElQtrtiEkKlRKUQlxMPfGs73ozUTkhS9oVI_Tc55fHloLN8xUElit2x9LbzE9gzWSKTA-lwBiJ5KAWxW53E9ufG8cl9bw5V-WV3yFEKp4KfMNYHcA8RuyGiOOUz1HPa5dBRuZGZRfZMpLCJQ-Ih_fupggG2yi7veQjnt99mHHip0m6MH8VZjukpTgwnp3eKkvk780mjREqdvSAA&jshs=0&username=testautomation492%40gmail.com&login_hint=testautomation492%40gmail.com");
	
	WebElement inputField5 = driver.findElement(By.xpath("//input[@type='password']"));
	inputField5.sendKeys("mytest@1234");
	WebElement inputField7 = driver.findElement(By.xpath("//input[@type='submit']"));
	inputField7.click();
	//driver.get("https://login.live.com/ppsecure/post.srf?username=testautomation492%40gmail.com&client_id=166f766d-47a4-442a-9a4e-0645cfdbf97e&contextid=4DECA487F8AA5595&opid=82554384AB37305F&bk=1686839251&uaid=e6a419e514da491ab581bf4291b9e582&pid=15216");
	//WebElement inputField8 = driver.findElement(By.xpath("//input[@type='submit']"));
	//inputField8.click();
	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	// Save the screenshot to a desired location
	String destinationPath = "C:\\Users\\palad\\Pictures\\Saved Pictures\\screenshot.png";
	FileUtils.copyFile(screenshotFile, new File(destinationPath));

	driver.close();
	// Switch back to the main window
	driver.switchTo().window(mainWindowHandle);
	
	// Signin with google account	

	  driver.findElement(By.xpath("//div[@class='S9gUrf-YoZ4jf']")).click();
		
	//Handle new window
	  String mainWindowHandle8 = driver.getWindowHandle();

	//Perform the action that opens the new window

		Set<String> windowHandles8 = driver.getWindowHandles();
		for (String handle : windowHandles8) {
			
		    if (!handle.equals(mainWindowHandle8)) {
		    	
		        driver.switchTo().window(handle);
		        break;
		    }
		}
		  WebElement inputField10 = driver.findElement(By.xpath("//input[@type='email']"));
		  inputField10.sendKeys("testautomation492@gmail.com");
		    	
		  WebElement inputField11 = driver.findElement(By.xpath("(//span[@jsname='V67aGc'])[2]"));
		  inputField11.click();
		  Thread.sleep(5000);
		  WebElement inputField12 = driver.findElement(By.xpath("//input[@type='password']"));
	      inputField12.sendKeys("Test@1234");
	      WebElement inputField13 = driver.findElement(By.xpath("(//span[@class='VfPpkd-vQzf8d'])[2]"));
		  inputField13.click();
		  
		  driver.get("https://auth.dev.vntech.io");
	
	//Signin with others
	  
	  driver.findElement(By.xpath("//div[@class='MuiCollapse-root MuiCollapse-vertical MuiCollapse-entered css-c4sutr']")).click();
	  driver.findElement(By.id("email")).sendKeys("testautomation492@yopmail.com");
	  driver.findElement(By.id("password")).sendKeys("Test@1234");
	  driver.findElement(By.xpath("//button[@id='signin']")).click();
	  
	  File screenshotFile12 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Save the screenshot to a desired location
		String destinationPath12 = "C:\\Users\\palad\\Pictures\\Saved Pictures\\screenshot3.png";
		FileUtils.copyFile(screenshotFile12, new File(destinationPath12));
		
		
		
		driver.close();
		
	  }
	}


