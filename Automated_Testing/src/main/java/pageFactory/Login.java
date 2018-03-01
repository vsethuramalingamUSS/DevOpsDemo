package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

		WebDriver driver;

		public Login(WebDriver driver)
		
		{
			this.driver=driver;
		}
		
		public void userLogin() throws InterruptedException{
			
			Thread.sleep(5000);
			driver.findElement(By.id("username")).sendKeys("devopsdev@demo.com");
			driver.findElement(By.id("password")).sendKeys("Deloitte#123");
			driver.findElement(By.id("Login")).click();
			Thread.sleep(5000);
			System.out.println("Login successful");
			
		}

}
