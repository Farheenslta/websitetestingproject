package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassSliders 
{
	public static void main(String[] args) throws Exception
	{
		// Launch browser
		System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		//open site
		driver.get("https://jqueryui.com/slider/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='demo-frame']")));
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		WebElement hs=driver.findElement(By.xpath("//*[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		int x=hs.getLocation().getX();
		int y=hs.getLocation().getY();
		Actions a=new Actions(driver);
		//Left to Right
		a.dragAndDropBy(hs, 400, 0).build().perform();
		Thread.sleep(4000);
		//Right to Left
		a.dragAndDropBy(hs, -300, 0).build().perform();
		Thread.sleep(4000);
		//Back to page
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Vertical slider")));
		driver.findElement(By.linkText("Vertical slider")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='demo-frame']")));
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		WebElement vs=driver.findElement(By.xpath("//*[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		int x1=vs.getLocation().getX();
		int y1=vs.getLocation().getY();
		Thread.sleep(4000);
		//Top to bottom
		a.dragAndDropBy(vs, 0, 80).build().perform();
		Thread.sleep(4000);
		//Bottom to top
		a.dragAndDropBy(vs, 0, -80).build().perform();
		Thread.sleep(4000);
		//top to bottom
		a.dragAndDropBy(vs, 0, 90).build().perform();
		Thread.sleep(4000);
		//Back to page
		driver.switchTo().defaultContent();
		//close site
		driver.close();
	}
}
