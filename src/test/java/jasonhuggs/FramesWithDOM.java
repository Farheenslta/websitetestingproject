package jasonhuggs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FramesWithDOM
{
	public static void main(String[] args) throws Exception
	{
		//Launch site
		System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//maximize
		driver.manage().window().maximize();
		//open site
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert2");
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tryhome']")));
		WebElement e=driver.findElement(By.name("iframeResult"));
		driver.switchTo().frame(e);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Try it']")));
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		String x=driver.switchTo().alert().getText();
		System.out.println("Text message in the alert is " + x);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		//close site
		driver.close();
	}
}
