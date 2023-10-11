package SeleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class TestNGSample {

	WebDriver driver = null;
	public static String browserName = null;

	@BeforeTest
	public void setUpTest() {

		String projectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();
		
		if(browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/Chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", projectPath+"/Drivers/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
		} 
	}

	@Test
	public void googleSearch() {

		//goto google.com
		driver.get("https://google.com");

		//enter text in search box
		driver.findElement(By.name("q")).sendKeys("Automation Step by Step");

		//click on search button
		//driver.findElement(By.name("btnK")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);



	}

	@AfterTest
	public void teardownTest() {

		//close browser
		//driver.close();
		driver.quit();
		System.out.println("Test Completed Successfully");
	}
}
