package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClassContextClick 
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//maximize browser
		driver.manage().window().maximize();
		//open site
		driver.get("https://www.google.co.in");
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		WebElement e=driver.findElement(By.name("q"));
		Actions a=new Actions(driver);
		if(e.isDisplayed())
		{
			a.contextClick(e).build().perform();
			Thread.sleep(2000);
		}
		//close site
		driver.close();
	}
}
