package jasonhuggs;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserWindow
{
	public static void main(String[] args) throws Exception
	{
		// launch browser
		System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//open site
		driver.get("https://www.sbicard.com");
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Login'])[3]")));
		driver.findElement(By.xpath("(//a[text()='Login'])[3]")).click();
		Thread.sleep(5000);
		Set<String> e=driver.getWindowHandles();
		ArrayList<String> l=new ArrayList<String>(e);
		/*int c=l.size();
		Thread.sleep(5000);
		for(int i=0; i<=c;i++)
		{
			System.out.println("Browser tab" +" is "+l.get(i));
		}
		Thread.sleep(5000);*/
		driver.switchTo().window(l.get(1));
		driver.findElement(By.name("username")).sendKeys("rohan");
		Thread.sleep(3000);
		driver.close();
		Thread.sleep(1000);
		driver.switchTo().window(l.get(0));
		driver.findElement(By.xpath("(//*[text()='Pay Now'])[2]")).click();
		Thread.sleep(3000);
		//close site
		driver.quit();
	}
}
