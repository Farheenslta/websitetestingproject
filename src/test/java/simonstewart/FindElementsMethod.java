package simonstewart;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindElementsMethod
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		RemoteWebDriver driver=new ChromeDriver();
		//Maximize
		driver.manage().window().maximize();
		//open site
		driver.get("https://www.mercurytravels.co.in/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("No, thanks"))).click();
		//counts of linksin page
		//Way-1
		List<WebElement> l1=driver.findElements(By.tagName("a"));
		System.out.println("Links count is: "+l1.size());
		//Way-2
		List<WebElement> l2=driver.findElements(By.xpath("//a"));
		System.out.println("Links count is: "+l2.size());
		//count of total tags in a page
		List<WebElement> l3=driver.findElements(By.xpath("//*"));
		System.out.println("The number of tags in the page are: "+l3.size());
		//count select tag drop downs in page
		List<WebElement> l4=driver.findElements(By.xpath("//select"));
		System.out.println("number of select tag dropdowns are: "+l4.size());
		int count1=0;
		int count2=0;
		for(int i=0;i<l4.size();i++)
		{
			if(l4.get(i).isDisplayed())
			{
				count1=count1+1;
			}
			else
			{
				count2=count2+1;
			}
		}
		System.out.println("Visible select tag dropdowns count is: " + count1);
		System.out.println("invisible select tag dropdowns count is: "+ count2);
		//Way-3
		List<WebElement> l5=driver.findElements(By.xpath("//select"));
		System.out.println("Number of select tag elements are: " + l5);
		//count of text boxes in page
		//Way-1
		int count3=0;
		List<WebElement> l6=driver.findElements(By.tagName("input")); 
		for(int i=0;i<l6.size();i++)
		{
			String value=l6.get(i).getAttribute("type");
			if(value.equals("text"))
			{
				count3=count3+1;
			}
		}
		System.out.println("Number of input tags with type attributes as text is: " +count3);
		
		//Way2
		int c=0;
		List<WebElement> l7=driver.findElements(By.xpath("//input"));
		for(int i=0;i<l7.size();i++)
		{
			String value=l7.get(i).getAttribute("type");
			if(value.equals("text"))
			{
				c=c+1;
			}
		}
		System.out.println("Total text boxes in page are "+c);		
		//Way3
		List<WebElement> l8=driver.findElements(By.xpath("//input[@type='text']"));
		System.out.println("Total text boxes in page are "+l8.size());
		
		//Count of images with <input> and <img>
		//Way1
		List<WebElement> l9=driver.findElements(By.xpath("//input[@type='image']"));
		List<WebElement> l10=driver.findElements(By.xpath("//img"));
		System.out.println(l9.size()+l10.size());
		//Way2
		List<WebElement> l11=driver.findElements(By.xpath("(//input[@type='image'])|(//img)"));
		System.out.println(l11.size());
	}
}
