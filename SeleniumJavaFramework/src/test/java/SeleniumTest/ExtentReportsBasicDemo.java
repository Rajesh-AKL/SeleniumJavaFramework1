package SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.*;

public class ExtentReportsBasicDemo {
	
	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
		
		//create ExtentReports and attach Reporter(s)
		ExtentReports extent  = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		//creates a toggle for the given test, adds all log events under it
		  ExtentTest test1 = extent.createTest("Google Search Test", "This is a test to validate google search functionality");
		  
		  String projectPath = System.getProperty("user.dir");
		  System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/Chromedriver/chromedriver.exe");
		  driver = new ChromeDriver();
		  
		  test1.log(Status.INFO, "Starting Test Case");
		  driver.get("https://google.com/");
		  test1.pass("Navigated to google.com");
		  
		  driver.findElement(By.name("q")).sendKeys("NZ");
		  test1.pass("Entered text in Search box");
		  
		  driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		  test1.pass("Pressed Keyboard Enter key");
		  
		  driver.close();
		  driver.quit();
		  test1.pass("Closed the browser");
		  
		  test1.info("Test Completed");
		  
		  
		//creates a toggle for the given test, adds all log events under it
		  ExtentTest test2 = extent.createTest("Google Search Test", "This is a test to validate google search functionality");
		  
		  System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/Chromedriver/chromedriver.exe");
		  driver = new ChromeDriver();
		  
		  test2.log(Status.INFO, "Starting Test Case");
		  driver.get("https://google.com/");
		  test2.pass("Navigated to google.com");
		  
		  driver.findElement(By.name("q")).sendKeys("NZ");
		  test2.pass("Entered text in Search box");
		  
		  driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		  test2.fail("Pressed Keyboard Enter key");
		  
		  driver.close();
		  driver.quit();
		  test1.pass("Closed the browser");
		  
		  test1.info("Test Completed");
		  
		  //calling flush writes everything to the log file
		  extent.flush();
		  ;
	}

}
