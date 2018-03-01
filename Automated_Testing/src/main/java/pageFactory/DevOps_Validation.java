package pageFactory;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import utility_functions.Utility_Functions;


public class DevOps_Validation {

	WebDriver driver;
	
	
	public DevOps_Validation(WebDriver driver) {
		this.driver = driver;
	}

	public void Setup_Request() throws Exception {
	Utility_Functions util = new Utility_Functions(driver);
	driver.findElement(By.xpath(".//*[@id='01r1N000001JYEj_Tab']/a")).click();
	driver.findElement(By.xpath("//input[@title='New']")).click();
	driver.findElement(By.id("A360_DocumentReview:j_id8:therapeuticArea")).sendKeys("test");
	WebElement e = driver.findElement(By.xpath(".//*[@id='A360_DocumentReview:j_id8:drug']"));
	Select select = new Select(e);
	select.selectByVisibleText("Hybris");
	driver.findElement(By.id("A360_DocumentReview:j_id8:kpc")).sendKeys("contact");
	//driver.findElement(By.id("A360_DocumentReview:j_id8:ea")).sendKeys("contact@test.com");
	driver.findElement(By.xpath("//button")).click();
	util.getscreenshot("Setup Request");
	
	}
}
