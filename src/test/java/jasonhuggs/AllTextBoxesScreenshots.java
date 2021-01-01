package jasonhuggs;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllTextBoxesScreenshots
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		//open site
		WebDriverWait wait=new WebDriverWait(driver,20);
		driver.get("https://www.mercurytravels.co.in/");
		//close banner
		driver.findElement(By.linkText("No, thanks")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("holidays")));
		List<WebElement> text=driver.findElements(By.xpath("//input[@type='text']"));
		System.out.println("Number of text boxes are: "+text.size());
		int c=0;
		for(int i=0;i<text.size();i++)
		{
			if(text.get(i).isDisplayed())
			{
				c=c+1;
				int x=text.get(i).getLocation().getX();
				int y=text.get(i).getLocation().getY();
				int w=text.get(i).getSize().getWidth();
				int h=text.get(i).getSize().getHeight();
				//get screen shot
				File src=driver.getScreenshotAs(OutputType.FILE);
				BufferedImage pfull=ImageIO.read(src);
				BufferedImage eless=pfull.getSubimage(x,y,w,h);
				ImageIO.write(eless, "png", src);
				File dest=new File("F:\\Automation_PracticePrograms\\jasonhuggs\\elesss"+(i+1)+".png");
				FileHandler.copy(src, dest);
			}
		}
		System.out.println("Number of displayed text boxes are: " + c);
		//close site
		driver.close();
	}
}
