package divtagdropdownspackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DivTagDDAllowCharacterMatching2 
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Dropdown'][@class='ui header'])[1]")));
		//Automate drop down that allow character matching
		//Collect all elements which starts with "m"
		WebElement e=driver.findElement(By.xpath("//*[@class='ui fluid dropdown selection multiple']"));
		Actions a=new Actions(driver);
		a.click(e).build().perform();
		Thread.sleep(2000);
		a.sendKeys("m").build().perform();
		Thread.sleep(2000);
		List<WebElement> l=driver.findElements(By.xpath("(//*[contains(@class,'ui fluid dropdown')])[1]/div[2]/div[starts-with(text(),'P')]"));
		for(int i=0;i<l.size();i++)
		{
			System.out.println((i+1)+"."+l.get(i).getText());
			l.get(i).click();
			Thread.sleep(5000);
		}
		//close site
		driver.close();
	}
}
