package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsClassVerticalSliders 
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize Browser
		driver.manage().window().maximize();
		//open site
		driver.get("https://jqueryui.com/slider/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Vertical slider")));
		driver.findElement(By.linkText("Vertical slider")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='demo-frame']")));
		driver.switchTo().frame(0);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ui-slider-handle ui-corner-all ui-state-default']")));
		WebElement vs=driver.findElement(By.xpath("//*[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		Actions a=new Actions(driver);
		int x=vs.getLocation().getX();
		int y=vs.getLocation().getY();
		a.dragAndDropBy(vs, 0, 100).build().perform();
		Thread.sleep(4000);
		a.dragAndDropBy(vs, 0, -150).build().perform();
		Thread.sleep(4000);
		driver.switchTo().defaultContent();
		//close site
		driver.close();
	}
}
