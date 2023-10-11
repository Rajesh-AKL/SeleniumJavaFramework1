package SeleniumTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsDemowithTestNG {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	WebDriver driver;

	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter("extentReports.html");

		//create ExtentReports and attach Reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}
	
	@BeforeTest
	public void setUpTest() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/Chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void test1() throws Exception {

		ExtentTest test = extent.createTest("Google Search Test", "This is a test to validate google search functionality");
		
		driver.get("https://google.com");
		test.pass("Navigated to google.com");
		test.log(Status.INFO, "Starting Test Case");
		test.info("This is Test1");
		test.fail("Failed Test");
		test.addScreenCaptureFromPath("");
	}


	@Test
	public void test2() throws Exception {

		ExtentTest test = extent.createTest("Google Search Test", "This is a test to validate google search functionality");
		driver.get("https://google.com");
		test.pass("Navigated to google.com");
		test.log(Status.INFO, "Starting Test Case");
		test.info("This is Test2");
		test.pass("Passed Test");
		test.addScreenCaptureFromPath("");
	}

	@AfterTest
	public void teardownTest() {
		
		//close browser
				driver.close();
				driver.quit();
				System.out.println("Test Completed Successfully");
	}
	
	@AfterSuite
	public void teardown() {
		extent.flush();
	}
}


