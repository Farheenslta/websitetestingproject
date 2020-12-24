package jasonhuggs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SynchronizationOrIPCWithWDW
{
	public static void main(String[] args)
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//maximize browser
		driver.manage().window().maximize();
		//open site
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Accept Cookies']")));
		driver.findElement(By.xpath("//*[text()='Accept Cookies']")).click();
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.className("raDiv")));
		driver.findElement(By.linkText("12")).click();
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.className("raDiv")));
		driver.findElement(By.linkText("12"));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.className("raDiv")));
		driver.findElement(By.linkText("31")).click();
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.className("raDiv")));
		String x=driver.findElement(By.xpath("//*[@class='label']")).getText();
		System.out.println("The text is " + x);
		//close site
		driver.close();
	}
}
