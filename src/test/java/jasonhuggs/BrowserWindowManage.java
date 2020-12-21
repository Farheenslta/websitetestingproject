package jasonhuggs;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserWindowManage
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//maximize
		driver.manage().window().maximize();
		//open site
		driver.get("https://www.gmail.com");
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		Thread.sleep(5000);
		//Get details of browser window
		int w1=driver.manage().window().getSize().getWidth();
		int h=driver.manage().window().getSize().getHeight();
		System.out.println("Total width of browser window is " + w1 + "\nTotal height of browser window is " + h);
		//Set size for browser window
		Dimension d=new Dimension(200,100);
		driver.manage().window().setSize(d);
		Thread.sleep(5000);
		//Get position details of browser window
		int x=driver.manage().window().getPosition().getX();
		int y=driver.manage().window().getPosition().getY();
		System.out.println("X position of browser window is " + x + "\nY position of browser window is " + y);
		//Set position of browser window
		Point p=new Point(200,150);
		driver.manage().window().setPosition(p);
		Thread.sleep(5000);
		//close site
		driver.close();
	}
}
