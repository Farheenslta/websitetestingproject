package simonstewart;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Method2
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//maximize
		driver.manage().window().maximize();
		//Launch site
		driver.get("http://www.google.com");
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		//get title
		String title=driver.getTitle();
		System.out.println("Title of page is " + title);
		//get page source
		String pagesource=driver.getPageSource();
		System.out.println(pagesource);
		//get page course in file
		File f=new File("pagesource");
		FileWriter fw=new FileWriter(f);
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write("Page source code is: \n" + pagesource);
		//get current URL
		String url=driver.getCurrentUrl();
		System.out.println("Current url is " + url);
		if(url.contains("https"))
		{
			System.out.println("The site is secured site");
		}
		else 
		{
			System.out.println("The site in not a secured site");
		}
		//close site
		driver.close();
	}
}
