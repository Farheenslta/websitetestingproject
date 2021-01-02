package simonstewart;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Method1
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//maximize
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://www.sbicard.com/");
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.elementToBeClickable(By.linkText("Login")));
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(5000);
		//close both sites
		driver.quit();
	}
}
