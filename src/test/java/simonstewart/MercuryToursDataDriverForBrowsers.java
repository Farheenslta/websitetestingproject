package simonstewart;

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

public class MercuryToursDataDriverForBrowsers 
{
	public static void main(String[] args)
	{
		//Declare Global Variable
		RemoteWebDriver driver=null;
		
		//Provide browser names
		//String[] bn= {"chrome", "edge", "firefox", "opera", "ie"};
		String[] bn= {"chrome", "firefox"};
		
		for(int i=0;i<bn.length;i++)
		{
			if(bn[i].equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				//System.setProperty("webdriver.chrome.silentOutput", "true");
				driver=new ChromeDriver();
			}
			/*else if(bn[i].equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}*/
			else if(bn[i].equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
			/*else if (bn[i].equalsIgnoreCase("opera"))
			{
				WebDriverManager.operadriver().setup();
				driver=new OperaDriver();
			}
			else if(bn[i].equalsIgnoreCase("ie"))
			{
				WebDriverManager.iedriver().setup();
				driver=new InternetExplorerDriver();
			}*/
			else
			{
				System.out.println("Enter correct browser name");
				System.exit(0);//Stop execution forcibly
			}
			//maximize the browser
			driver.manage().window().maximize();
			
			//Launch site
			driver.get("http://demo.guru99.com/test/newtours/");
			WebDriverWait w=new WebDriverWait(driver,20);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("REGISTER")));
			driver.findElement(By.linkText("REGISTER")).click();
			//w.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstName")));
			//driver.findElement(By.id("closeBtn")).click();
			w.until(ExpectedConditions.elementToBeClickable(By.name("firstName")));
			driver.findElement(By.name("firstName")).sendKeys("farheen");
			driver.findElement(By.name("lastName")).sendKeys("sult");
			driver.findElement(By.name("phone")).sendKeys("9875461234");
			driver.findElement(By.name("userName")).sendKeys("farheen@gmail.com");
			driver.findElement(By.name("address1")).sendKeys("17-8/m/4");
			driver.findElement(By.name("city")).sendKeys("Hyderabad");
			driver.findElement(By.name("state")).sendKeys("Telengana");
			driver.findElement(By.name("postalCode")).sendKeys("500042");
			WebElement e=driver.findElement(By.name("country"));
			Select s=new Select(e);
			s.selectByVisibleText("INDIA");
			driver.findElement(By.name("email")).sendKeys("farheen");
			driver.findElement(By.name("password")).sendKeys("farheen");
			driver.findElement(By.name("confirmPassword")).sendKeys("farheen");
			driver.findElement(By.name("submit")).click();
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(), 'Your user name is farheen')]")));
			String x=driver.findElement(By.xpath("//b[contains(text(), 'Your user name is farheen')]")).getText();
			if(x.contains("farheen"))
			{
				System.out.println("Test Passed");
			}
			else
			{
				System.out.println("Test Failed");
			}
			//close site
			driver.close();
		}
	}
}
