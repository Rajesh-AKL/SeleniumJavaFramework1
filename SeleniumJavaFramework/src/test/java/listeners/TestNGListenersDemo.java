package listeners;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.TestNGListeners.class)
public class TestNGListenersDemo {

	@Test
	public void test1() {

		System.out.println("I am inside Test 1");
	}

	@Test
	public void test2() {

		System.out.println("I am inside Test 2");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : "+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/Chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://google.com/");
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("abcd");
		driver.findElement(By.xpath("//textarea[@name='xyz']")).sendKeys("abcd");
	
		driver.close();
	}

	@Test
	public void test3() {

		System.out.println("I am inside Test 3");
		throw new SkipException("This test is skipped");
	}
}
