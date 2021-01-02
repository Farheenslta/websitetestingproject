package simonstewart;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cookies 
{
	public static void main(String[] args) 
	{
		//Launch browser
		//System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		//ChromeDriver driver=new ChromDriver();
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//maximize browser
		driver.manage().window().maximize();
		//delete all cookies
		driver.manage().deleteAllCookies();
		//open site
		
		driver.get("https://www.google.com");
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		int c=driver.manage().getCookies().size();
		System.out.println("Number of cookies that are loaded are: " +c);
		//validate
		if (c!=0)
		{
			System.out.println("Cookies are loaded");
		}
		else
		{
			System.out.println("Cookies are not loaded");
		}
		//Close site
		driver.close();
	}
}
