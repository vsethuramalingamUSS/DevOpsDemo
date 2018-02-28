package pageFactory;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import utility_functions.Utility_Functions;


public class AEPC {

	WebDriver driver;
	
	
	public AEPC(WebDriver driver) {
		this.driver = driver;
	}

	public void createAEPC(String programID) throws Exception {
		Utility_Functions util = new Utility_Functions(driver);
		WebElement element = driver.findElement(By.id("sen"));
		Select select = new Select(element);
		select.selectByVisibleText("Programs");
		driver.findElement(By.id("sbstr")).sendKeys(programID);
		driver.findElement(By.xpath("//input[@title='Go!']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@title='New Adverse Event / Product Complaint']")).click();
		Thread.sleep(5000);
		
		element = driver.findElement(By.id("p3"));
		select = new Select(element);
		select.selectByVisibleText("Product Complaint");
		driver.findElement(By.xpath("//input[@title='Continue']")).click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='testPage:theform:pan:reqSection:j_id40:j_id42']/preceding::span[@class='dateFormat']")).click();
		driver.findElement(By.xpath(".//*[@id='testPage:theform:pan:PatientId:patReporter']")).click();
		
		driver.findElement(By.xpath(".//*[@id='testPage:theform:pan:j_id150:j_id152:j_id154']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@title='New Suspect Drug/Device/Batch Information']")).click();
		
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='j_id0:theform:pan:firstSection:j_id43:j_id46']")).sendKeys("test123");
		driver.findElement(By.xpath("//img[@title='Batch Number Lookup (New Window)']")).click();
		Thread.sleep(5000);
		
		
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> itr=handles.iterator();
		
		String parent=itr.next();
		String child=itr.next();
		
		driver.switchTo().window(child);
		Thread.sleep(5000);
		driver.switchTo().frame("resultsFrame");
		driver.findElement(By.xpath("//th[contains(@scope,'row')]/a[1]")).click();
		Thread.sleep(5000);
		driver.switchTo().window(parent);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='Save']")).click();
		Thread.sleep(5000);
		
		util.getscreenshot("AEPC_Saved");
		
		driver.findElement(By.xpath("//input[@title='Submit']")).click();
		Thread.sleep(5000);
		
		//*[@id='eLtrMgmtPage:eLtrMgmtForm:pgBlock:pbButtons:sendButton']
		
		handles=driver.getWindowHandles();
		itr=handles.iterator();
		
		parent=itr.next();
		child=itr.next();
		
		driver.switchTo().window(child);
		Thread.sleep(7000);
		driver.findElement(By.xpath(".//*[@id='eLtrMgmtPage:eLtrMgmtForm:pgBlock:pbButtons:sendButton']")).click();
		Thread.sleep(25000);
	}
}
