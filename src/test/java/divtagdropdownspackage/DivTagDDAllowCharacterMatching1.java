package divtagdropdownspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DivTagDDAllowCharacterMatching1
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//open site
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("(//*[text()='Dropdown'][@class='ui header'])[1]"))));
		//Automate drop-down that allow character matching
		WebElement e=driver.findElement(By.xpath("(//div[@class='ui selection dropdown'])[1]"));
		Actions a=new Actions(driver);
		a.click(e).build().perform();
		Thread.sleep(2000);
		a.sendKeys("f").build().perform();
		Thread.sleep(2000);
		a.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		//close site
		driver.close();		
	}
}
