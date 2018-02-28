package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AllTabs {
	
	WebDriver driver;

	public AllTabs(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectTab(String tabName) throws InterruptedException {
		
		driver.findElement(By.xpath("//img[@title='All Tabs']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'"+tabName+"')]")).click();
		Thread.sleep(5000);
		System.out.println(tabName+" is selected");
	}

}
