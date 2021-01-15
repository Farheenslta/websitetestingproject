package divtagdropdownspackage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DivTagDDAllowCharacterMatchingCountNumOfCountriesWithGivenChar
{
	public static void main(String[] args) throws Exception
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//maximize
		driver.manage().window().maximize();
		//open site
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Dropdown'][@class='ui header'])[1]")));
		//Automate drop down which allows character matching
		//Collect all element which starts with "i"
		WebElement e=driver.findElement(By.xpath("(//*[@class='ui fluid search selection dropdown'])[1]"));
		Actions a=new Actions(driver);
		a.click(e).build().perform();
		Thread.sleep(2000);
		a.sendKeys("i").build().perform();
		Thread.sleep(1000);
		List<WebElement> l=driver.findElements(By.xpath("(//*[contains(@class,'ui fluid search selection dropdown')])[1]/div[2]/div"));
		ArrayList<String> al1=new ArrayList<String>();
		for(int i=0;i<l.size();i++)
		{
			String cv=l.get(i).getAttribute("class");
			if(!cv.equals("item filtered"))
			{
				al1.add(l.get(i).getText());
			}
		}
		System.out.println("Country names matching with given character are: "+al1.size());
		for(int i=0;i<al1.size();i++)
		{
			System.out.println(al1.get(i));
		}
		//close site
		driver.close();
	}
}
