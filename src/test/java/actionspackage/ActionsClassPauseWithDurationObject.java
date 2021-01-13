package actionspackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassPauseWithDurationObject
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//maximize browser
		driver.manage().window().maximize();
		//open site
		driver.get("https://www.seleniumhq.org/");
		Actions a =new Actions(driver);
		Duration d=Duration.ofSeconds(5);
		//Duration d1=Duration.of(5,ChronoUnit.SECONDS);
		a.pause(d).build().perform();
		WebElement e=driver.findElement(By.linkText("Downloads"));
		a.click(e).build().perform();
		a.pause(d).build().perform();
		//close site
		driver.close();
	}
}
