package jasonhuggs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Method3
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//maximize
		driver.manage().window().maximize();
		//open site
		driver.get("http://www.gmail.com");
		WebDriverWait w=new WebDriverWait(driver, 20);
		//driver.findElement(By.xpath("//*[text()='Use another account']")).click();
		//Do login
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		driver.findElement(By.name("identifier")).sendKeys("farhahssn7");
		driver.findElement(By.xpath("//*[text()='Next']/parent::button")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='password']")));
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("AnSaSa1a1");
		driver.findElement(By.xpath("//*[text()='Next']/parent::button")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Compose']")));
		//Click compose
		driver.findElement(By.xpath("//div[text()='Compose']")).click();
		w.until(ExpectedConditions.elementToBeClickable(By.name("to")));
		driver.findElement(By.name("to")).sendKeys("farhahssn7@gmail.com");
		driver.findElement(By.name("subjectbox")).sendKeys("hello");
		driver.findElement(By.xpath("(//*[@aria-label='Message Body'])[2]")).sendKeys("Hello,\n\nHow are you? Hope all good.\n\nTake Care,\nBye");
		//send mail
		driver.findElement(By.xpath("//*[contains(@data-tooltip, 'Send')]")).click();
		//w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Message')]")));
		//do logout
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@aria-label,'Google Account')]")));
		driver.findElement(By.xpath("//a[contains(@aria-label,'Google Account')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Sign out']"))).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Choose an account']")));
		driver.get("http://www.google.com");
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		String y=driver.findElement(By.name("q")).getAttribute("maxlength");
		System.out.println("Value of an attribute is " + y);
		//close site
		driver.close();
	}
}
