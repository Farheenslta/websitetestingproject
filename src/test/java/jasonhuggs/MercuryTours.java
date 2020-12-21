package jasonhuggs;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MercuryTours 
{
	public static void main(String[] args)
	{
		//Declare Global Properties
		RemoteWebDriver driver=null;
		
		//Take input from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the browser name");
		String bn=sc.nextLine();
		sc.close();
		
		//Similar for all browsers
		//System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		//System.setProperty("chromedriver.chrome.silentOutput", "true");
		//driver=new ChromeDriver();
		
		//Bonigarcia dependency code to get compatible browser driver s/w automatically wrt browser
		if(bn.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.silentOutput", "true");
			driver=new ChromeDriver();
		}
		else if(bn.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();			
		}
		else if(bn.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
		}
		else if(bn.equalsIgnoreCase("opera"))
		{
			WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
		}
		else if(bn.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else 
		{
			System.out.println("Enter correct browser name");
			System.exit(0);//Stop execution forcibly
		}
		
		//Maximize
		driver.manage().window().maximize();
		
		//Launch site
		driver.get("http://demo.guru99.com/test/newtours/");
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("REGISTER")));
		driver.findElement(By.linkText("REGISTER")).click();
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("firstName")));
		driver.findElement(By.name("firstName")).sendKeys("farheen");
		driver.findElement(By.name("lastName")).sendKeys("sultana");
		driver.findElement(By.name("phone")).sendKeys("9648795463");
		driver.findElement(By.name("userName")).sendKeys("farheen@gmail.com");
		driver.findElement(By.name("address1")).sendKeys("17-1-1278");
		driver.findElement(By.name("city")).sendKeys("Hyderabad");
		driver.findElement(By.name("state")).sendKeys("Telengana");
		driver.findElement(By.name("postalCode")).sendKeys("500049");
		WebElement e=driver.findElement(By.name("country"));
		Select s=new Select(e);
		s.selectByVisibleText("INDIA");
		driver.findElement(By.name("email")).sendKeys("farheen@gmail.com");
		driver.findElement(By.name("password")).sendKeys("farheen");
		driver.findElement(By.name("confirmPassword")).sendKeys("farheen");
		driver.findElement(By.name("submit")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'Your user name is farheen@gmail.com')]")));
		String x=driver.findElement(By.xpath("//b[contains(text(),'Your user name is farheen@gmail.com')]")).getText();
		//Validation
		if(x.contains("farheen"))
		{
			System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
		}
		driver.close();
	}
}
