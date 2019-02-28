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
			String username = System.getenv("SFDC_UserName");
			String password = System.getenv("SFDC_Password");
			/*String username = "devopsdev@demo.com";
			String password = "Deloitte#1234";*/
			driver.findElement(By.id("username")).sendKeys(username);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.id("Login")).click();
			Thread.sleep(5000);
			System.out.println("Login successful");
			
		}

}
