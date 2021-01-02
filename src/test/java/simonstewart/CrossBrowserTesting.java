package simonstewart;

import java.util.Scanner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserTesting
{
	public static void main(String[] args) throws Exception
	{
		//Declare Global objects
		RemoteWebDriver driver=null;
		
		//Take input from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the browser name");
		String bn=sc.nextLine();
		sc.close();
		
		//Similar to all browsers
		//System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		//Bonigarcia dependency code to get the browser driver s/w automatically wrt browser
		if(bn.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(bn.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(bn.equalsIgnoreCase("opera"))
		{
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
		}
		else if(bn.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else if(bn.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("Enter correct browser name");
			System.exit(0);//stop execution forcibly
		}
		
		//maximize the browser
		driver.manage().window().maximize();
		//launch site
		driver.get("http://www.google.com");
		Thread.sleep(5000);
		//close site
		driver.close();
	}
}
