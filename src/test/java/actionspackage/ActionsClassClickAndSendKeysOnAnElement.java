package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassClickAndSendKeysOnAnElement
{
	public static void main(String[] args) throws Exception
	{
		// Launch browser
		System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize browser
		driver.manage().window().maximize();
		//open site
		driver.get("http://www.gmail.com");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("identifier")));
		WebElement e1=driver.findElement(By.name("identifier"));
		Actions a=new Actions(driver);
		a.sendKeys(e1, "farheensult").build().perform();
		//click via actions class
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']/parent::button")));
		WebElement e2=driver.findElement(By.xpath("//*[text()='Next']/parent::button"));
		Actions a2=new Actions(driver);
		a2.click(e2).build().perform();
		//wait for next page with password field
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		//close site
		driver.close();
	}
}
