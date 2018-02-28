package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver)
	
	{
		this.driver = driver;
	}
	
	public void userLogin(String username) throws InterruptedException {
		
		
		driver.findElement(By.linkText(username)).click();
		Thread.sleep(5000);
	}

	
}
