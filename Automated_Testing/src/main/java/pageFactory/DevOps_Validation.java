package pageFactory;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utility_functions.Utility_Functions;


public class DevOps_Validation {

	WebDriver driver;
	
	
	public DevOps_Validation(WebDriver driver) {
		this.driver = driver;
	}

	public void Patient_Task() throws Exception{

	Utility_Functions util = new Utility_Functions(driver);
	driver.findElement(By.xpath("//a[@title='Patient Enrollment Form Tab']")).click();
	Thread.sleep(5000);
	
	Select s=new Select(driver.findElement(By.id("pageId:formId:pb:pbs:gen")));
	s.selectByVisibleText("Male");
	
	driver.findElement(By.id("pageId:formId:pb:pbs:fn")).sendKeys("Test");
	driver.findElement(By.id("pageId:formId:pb:pbs:ln")).sendKeys("Automation");
	driver.findElement(By.id("pageId:formId:pb:pbs:dob")).sendKeys("3/5/1990");
	driver.findElement(By.id("pageId:formId:pb:pbs:email")).sendKeys("test@automation.com");
	driver.findElement(By.id("pageId:formId:pb:pbs:uninsured")).click();
	
	s = new Select(driver.findElement(By.id("pageId:formId:pb:pbs:condition_unselected")));
	s.selectByVisibleText("Asthma");
	
	driver.findElement(By.id("pageId:formId:pb:pbs:condition_right_arrow")).click();
	
	driver.findElement(By.id("pageId:formId:pb:pbsAddress:s1")).sendKeys("Street1");
	driver.findElement(By.id("pageId:formId:pb:pbsAddress:s2")).sendKeys("Street3");
	driver.findElement(By.id("pageId:formId:pb:pbsAddress:city")).sendKeys("City");
	s=new Select(driver.findElement(By.id("pageId:formId:pb:pbsAddress:cntry")));
	s.selectByVisibleText("United States");
	
	s=new Select(driver.findElement(By.id("pageId:formId:pb:pbsAddress:state")));
	s.selectByVisibleText("RI");
	
	driver.findElement(By.id("pageId:formId:pb:j_id1:bottom:enrol")).click();
	WebElement element = driver.findElement(By.xpath("//a[text()='Follow-up with patient for services opt-in']"));
	if(element.isDisplayed())
		System.out.println("Open Activities record is displayed");
	element = driver.findElement(By.xpath("//a[contains(text(),'PA-')]"));
	if(element.isDisplayed())
		System.out.println("Patient Address record is displayed");
		}
}
