package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Patient {

	WebDriver driver;
	
	public Patient(WebDriver driver) {
		this.driver = driver;
	}
	
	public void createPatient(String FN, String LN, String Gender, String DOB) throws InterruptedException {
		driver.findElement(By.xpath("//input[@title='New']")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("00N60000002zkh4")).sendKeys(LN);
		driver.findElement(By.id("00N60000002zkgz")).sendKeys(FN);
		Select select = new Select(driver.findElement(By.id("00N60000002zkh1")));
		select.selectByValue(Gender);
		driver.findElement(By.id("00N60000002zkgy")).sendKeys(DOB);
		driver.findElement(By.xpath("//input[@title='Save']")).click();
		Thread.sleep(5000);
		System.out.println("Patient is created");
	}

}
