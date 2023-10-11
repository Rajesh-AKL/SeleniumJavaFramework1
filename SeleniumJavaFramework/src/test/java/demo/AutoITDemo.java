package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoITDemo {
	
	public static void main(String[] args) throws Exception {
		
		test();
	}
	
	public static void test() throws Exception {
		
		System.setProperty("webdrive.chrome.driver", "C://Users/Admin/eclipse-workspace/SeleniumJavaFramework/Drivers/Chromedriver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://hiberfile.com/");
		driver.findElement(By.xpath("//label[contains(text(),'Select files to upload')]")).click();
		
		Runtime.getRuntime().exec("D://Users/RajeshJothi/Rajesh Data/Personal/Rajesh_Docs/SeleniumJava/FileUploadScript.exe");
		
		Thread.sleep(3000);
		//driver.close();
	}

}
