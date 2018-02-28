package pageFactory;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Program {

	WebDriver driver;
	AllTabs allTabs = new AllTabs(driver);
	
	public Program(WebDriver driver) {
		this.driver = driver;
	}
	
	public String createProgram(String patientName) throws InterruptedException {
		
		//Select patient
		driver.findElement(By.xpath("//input[@title='New']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='CF00N60000002zklU_lkwgt']/img")).click();
		Thread.sleep(5000);
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> itr=handles.iterator();
		
		String parent=itr.next();
		String child=itr.next();
		
		driver.switchTo().window(child);
		Thread.sleep(2000);
		driver.switchTo().frame("searchFrame");
		driver.findElement(By.id("lksrch")).sendKeys(patientName);
		driver.findElement(By.xpath("//input[@title='Go!']")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("resultsFrame");
		driver.findElement(By.xpath("//th[contains(@scope,'row')]/a[1]")).click();
		Thread.sleep(5000);
		driver.switchTo().window(parent);
		
		WebElement element = driver.findElement(By.xpath(".//*[@id='00N60000002zkjn']"));
		Select select = new Select(element);
		select.selectByValue("Pending Treatment");
		
		element = driver.findElement(By.xpath(".//*[@id='00N60000002zkis']"));
		select = new Select(element);
		select.selectByValue("Abema US");
		
		
		//Select Assigned Claudia
		driver.findElement(By.xpath(".//*[@id='CF00N60000002zkin_lkwgt']/img")).click();
		Thread.sleep(5000);
		handles=driver.getWindowHandles();
		itr=handles.iterator();
		
		parent = itr.next();
		child = itr.next();
		
		driver.switchTo().window(child);
		Thread.sleep(2000);
		driver.switchTo().frame("searchFrame");
		driver.findElement(By.id("lksrch")).sendKeys("claudia");
		driver.findElement(By.xpath("//input[@title='Go!']")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("resultsFrame");
		driver.findElement(By.xpath("//th[contains(@scope,'row')]/a[1]")).click();
		Thread.sleep(5000);
		driver.switchTo().window(parent);
		
		Thread.sleep(2000);
		//Selct Reimbursement Specialist
		driver.findElement(By.xpath(".//*[@id='CF00N60000002zkmR_lkwgt']/img")).click();
		Thread.sleep(5000);
		handles=driver.getWindowHandles();
		itr=handles.iterator();
		
		parent = itr.next();
		child = itr.next();
		
		driver.switchTo().window(child);
		Thread.sleep(2000);
		driver.switchTo().frame("searchFrame");
		driver.findElement(By.id("lksrch")).sendKeys("Abema_US_ RS");
		driver.findElement(By.xpath("//input[@title='Go!']")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("resultsFrame");
		driver.findElement(By.xpath("//th[contains(@scope,'row')]/a[1]")).click();
		Thread.sleep(5000);
		driver.switchTo().window(parent);
		
		//input[@title='Save']
		driver.findElement(By.xpath("//input[@title='Save']")).click();
		Thread.sleep(5000);
		String program_id = driver.findElement(By.xpath("//h2[@class = 'pageDescription']")).getText();
		
		return program_id;
		
	}

}
