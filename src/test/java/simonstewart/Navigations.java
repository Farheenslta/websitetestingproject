package simonstewart;

import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations
{
	public static void main(String[] args) throws Exception
	{
		// Launch browser
		System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//maximize
		driver.manage().window().maximize();
		//open site
		driver.get("http://www.google.com");
		Thread.sleep(2000);
		driver.navigate().to("http://www.gmail.com");
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		//close site
		driver.close();
	}
}
