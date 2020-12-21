package jasonhuggs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActiveElement
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
		Thread.sleep(5000);
		//Do login
		driver.switchTo().activeElement().sendKeys("farheen");;
		Thread.sleep(5000);
		driver.findElement(By.name("identifier")).clear();
		Thread.sleep(5000);
		//close site
		driver.close();
	}
}
