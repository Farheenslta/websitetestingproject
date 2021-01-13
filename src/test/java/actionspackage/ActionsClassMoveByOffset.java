package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassMoveByOffset
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//maximize
		driver.manage().window().maximize();
		//open site
		driver.get("https://www.flipkart.com/");
		WebDriverWait wait=null;
		try
		{
			wait=new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='_2KpZ6l _2doB4z']")));
			if(driver.findElement(By.xpath("//*[@class='_2KpZ6l _2doB4z']")).isDisplayed())
			{
				driver.findElement(By.xpath("//*[@class='_2KpZ6l _2doB4z']")).click();
			}
		}
		catch (Exception ex)
		{
			System.out.println("Banner was not displayed");
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Women']")));
		WebElement e1=driver.findElement(By.xpath("//*[text()='Women']"));
		Actions a=new Actions(driver);
		int x=e1.getLocation().getX();
		int y=e1.getLocation().getY();
		a.moveByOffset(x+40, y+20).build().perform();
		Thread.sleep(5000);
		//close site
		driver.close();
	}
}
