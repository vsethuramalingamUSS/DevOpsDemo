package pageFactory;

import org.openqa.selenium.WebDriver;

import java.lang.reflect.Method;

import org.openqa.selenium.By;

public class Login {


	WebDriver driver;

	public Login(WebDriver driver)
	
	{
		this.driver=driver;
	}
	
	public void userLogin(String username,String password) throws InterruptedException{
		
		Thread.sleep(5000);
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		System.out.println("Login successful");
		
	}
	
}
