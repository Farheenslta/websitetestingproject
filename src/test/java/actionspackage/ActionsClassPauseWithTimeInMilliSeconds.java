package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassPauseWithTimeInMilliSeconds
{
	public static void main(String[] args)
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//open site
		driver.get("https://www.google.co.in");
		Actions a=new Actions(driver);
		a.pause(5000).build().perform();
		WebElement e=driver.findElement(By.name("q"));
		a.click(e).build().perform();
		a.pause(5000).build().perform();
		//close site
		driver.close();
	}
}
