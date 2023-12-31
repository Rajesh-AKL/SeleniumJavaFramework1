import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserTest {

	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : "+projectPath);
		
		//System.setProperty("webdriver.gecko.driver", "C://Users/Admin/eclipse-workspace/SeleniumJavaFramework/Drivers/geckodriver/geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/Chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//System.setProperty("webdriver.ie.driver", projectPath+"/Drivers/IEdriver/IEDriverServer.exe");
		//WebDriver driver = new InternetExplorerDriver();
	
	driver.get("http://google.com/");
	
	//driver.findElement(By.id("APjFqb")).sendKeys("abcd");
	driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("abcd");
	
	List<WebElement> listOfInputElements = driver.findElements(By.xpath("//textarea"));
	int count = listOfInputElements.size();
	System.out.println("Count of Input Elements :"+count);
	//WebElement textBox = driver.findElement(By.id("APjFqb"));
	//textBox.sendKeys("Automation Step by Step");
	
	driver.close();
		
	}
	
}
