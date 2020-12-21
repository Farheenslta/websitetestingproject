package jasonhuggs;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DisplayedEnabledSelected2
{
	public static void main(String[] args)
	{
		////Launch Browser
		System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//maximize
		driver.manage().window().maximize();
		//open Browser
		driver.get("https://www.mercurytravels.co.in/");
		WebDriverWait w=new WebDriverWait(driver, 20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='white-text']")));
		driver.findElement(By.xpath("//*[@class='white-text']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='flights']")));
		driver.findElement(By.xpath("//a[@id='flights']")).click();
		try
		{
			if(driver.findElement(By.xpath("(//*[@name='tripType'][@type='radio'])[2]")).isDisplayed())
			{
				if(driver.findElement(By.xpath("(//*[@name='tripType'][@type='radio'])[2]")).isEnabled())
				{
					if(driver.findElement(By.xpath("(//*[@name='tripType'][@type='radio'])[2]")).isSelected())
					{
						System.out.println("Is already selected");
					}
					else
					{
						System.out.println("Is not selected");
					}
				}
				else
				{
					System.out.println("Element is disabled");
				}
			}
			else
			{
				System.out.println("It is alreadt invisible");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		//close site
		driver.close();

	}

}
