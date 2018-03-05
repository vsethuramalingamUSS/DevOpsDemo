package driver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	
	public static WebDriver getdriver() { 
	WebDriver driver = null;
	System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	/*String url = System.getenv("SFDC_URL");*/
	String url = "https://login.salesforce.com/";
	System.out.println("URL is "+url);
	
	driver.get(url);
	
   return driver;
	}
}