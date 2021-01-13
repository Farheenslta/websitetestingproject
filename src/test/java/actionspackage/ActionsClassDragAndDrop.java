package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassDragAndDrop 
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//maximize browser
		driver.manage().window().maximize();
		//open site
		driver.get("https://jqueryui.com/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Droppable']")));
		WebElement e=driver.findElement(By.xpath("//a[text()='Droppable']"));
		Actions a=new Actions(driver);
		a.click(e).build().perform();
		driver.switchTo().frame(0);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));
		WebElement e1=driver.findElement(By.id("draggable"));
		WebElement e2=driver.findElement(By.id("droppable"));
		Actions a1=new Actions(driver);
		a1.dragAndDrop(e1, e2).build().perform();
		String result=driver.findElement(By.xpath("//div[@id='droppable']/child::p")).getText();
		if(result.contains("Dropped"))
		{
			System.out.println("Drag and drop test passed");
		}
		else
		{
			System.out.println("Drag and drop test failed");
		}
		driver.switchTo().defaultContent();
		//close site
		driver.close();
	}
}
