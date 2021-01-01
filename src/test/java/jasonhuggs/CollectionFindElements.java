package jasonhuggs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CollectionFindElements
{
	public static void main(String[] args)
	{
		//launch browser
		System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//maximize browser
		driver.manage().window().maximize();
		//open site
		driver.get("https://www.mercurytravels.co.in/");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("holidays")));
		driver.findElement(By.linkText("No, thanks")).click();
		List<WebElement> l=driver.findElements(By.xpath("//*[contains(text(), 'Select Holiday Type')]/following-sibling::*"));
		System.out.println("The number of countries in the select tag dropdown are: "+l.size());
		for(int i=0; i<l.size();i++)
		{
			System.out.println("The countries in the drop down are as follows: "+l.get(i).getText());
		}
		//different examples for find-elements 
		List<WebElement> all=driver.findElements(By.xpath("//*"));
		System.out.println("Number of elements in page are: "+all.size());
		//all anchor tag elements
		List<WebElement> atag=driver.findElements(By.xpath("//a"));
		System.out.println("The anchor tag elemnts are: "+atag.size());
		//all images
		List<WebElement> imgtag=driver.findElements(By.xpath("(//img)|(//input[@type='image'])"));
		System.out.println("Total number of images are: "+imgtag.size());
		String x=imgtag.get(10).getAttribute("alt");
		System.out.println("Alt value for 11th images is: "+x);
		int text=driver.findElements(By.xpath("//input[@type='text']")).size();
		System.out.println("Count of text boxes in pages are: "+text);
		//close site
		driver.close();
	}
}
