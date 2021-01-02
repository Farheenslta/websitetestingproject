package simonstewart;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CssValues 
{
	public static void main(String[] args) throws Exception
	{
			// launch browser
			System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
			ChromeDriver driver=new ChromeDriver();
			//maximize
			driver.manage().window().maximize();
			//open site
			driver.get("http://www.way2sms.com");
			WebDriverWait w=new WebDriverWait(driver, 20);
			w.until(ExpectedConditions.visibilityOfElementLocated(By.name("mobileNo")));
			String x=driver.findElement(By.name("mobileNo")).getCssValue("font-size");
			System.out.println("Font size value of mobile number element is " + x);
			Thread.sleep(5000);
			String y=driver.findElement(By.partialLinkText("click here")).getCssValue("color");
			System.out.println("Css value for \"Problems while logging\" element is " + y);
			//close site
			driver.close();
	}
}
