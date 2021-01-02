package simonstewart;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class SynchronizationOrIPCWithFW 
{
	public static void main(String[] args)
	{
		//launch browser
		System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize browser
		driver.manage().window().maximize();
		//open site
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		FluentWait fw=new FluentWait(driver);
		fw.withTimeout(20, TimeUnit.SECONDS);
		fw.pollingEvery(2, TimeUnit.SECONDS);
		fw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Accept Cookies']")));
		driver.findElement(By.xpath("//button[text()='Accept Cookies']")).click();
		fw.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("13")));
		driver.findElement(By.linkText("13")).click();
		fw.until(ExpectedConditions.invisibilityOfElementLocated(By.className("raDiv")));
		driver.findElement(By.linkText("13")).click();
		fw.until(ExpectedConditions.invisibilityOfElementLocated(By.className("raDiv")));
		driver.findElement(By.linkText("31")).click();
		fw.until(ExpectedConditions.invisibilityOfElementLocated(By.className("raDiv")));
		String x=driver.findElement(By.xpath("//*[@class='label']")).getText();
		System.out.println("the date is " + x);
		//close site
		driver.close();
	}
}
