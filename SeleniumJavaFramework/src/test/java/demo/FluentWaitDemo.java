package demo;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.WebElement;
import com.google.common.base.Function;

public class FluentWaitDemo {

	public static void main(String[] args) throws Exception {

		test();
	}

	public static void test() throws Exception {

		System.setProperty("webdriver.chrome.driver", "C://Users/Admin/eclipse-workspace/SeleniumJavaFramework/Drivers/Chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("abcd");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);

		driver.findElement(By.linkText("What is the ABCD ? - ABCD")).click();

		Wait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class)
				.ignoring(ElementNotInteractableException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
				WebElement linkElement = driver.findElement(By.linkText("What is the ABCD ? - ABCD"));

				if(linkElement.isEnabled()) {

					System.out.println("Element Found");
				}

				return linkElement;
			}
		});

		element.click();

		Thread.sleep(3000);
		driver.close();
		driver.quit();


	}
}
