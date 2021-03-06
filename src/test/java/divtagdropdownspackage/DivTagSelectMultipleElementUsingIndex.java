package divtagdropdownspackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DivTagSelectMultipleElementUsingIndex
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver","F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//Open site
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Dropdown'][@class='ui header'])[1]")));
		driver.findElement(By.xpath("(//*[contains(@class,'ui fluid dropdown')])[1]")).click();
		List<WebElement> l=driver.findElements(By.xpath("(//*[contains(@class,'ui fluid dropdown')])[1]/div[2]/div"));
		System.out.println("No of elements in <div> tag dropdown are "+l.size());
		//Select 1st, 5th, 11th, 15th elements in drop-down
		l.get(0).click();
		Thread.sleep(1000);
		l.get(4).click();
		Thread.sleep(1000);
		l.get(10).click();
		Thread.sleep(1000);
		l.get(14).click();
		Thread.sleep(1000);
		//Close drop-down
		Actions a=new Actions(driver);
		a.sendKeys(Keys.ESCAPE).build().perform();
		Thread.sleep(2000);
		//Close site
		driver.close();
	}
}
