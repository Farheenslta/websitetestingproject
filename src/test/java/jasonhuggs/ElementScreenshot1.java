package jasonhuggs;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementScreenshot1 
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//maximize
		driver.manage().window().maximize();
		//open browser
		driver.get("https://www.facebook.com");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Facebook']")));
		WebElement e=driver.findElement(By.xpath("//img[@alt='Facebook']"));
		//take screen shot
		File src1=driver.getScreenshotAs(OutputType.FILE);
		File dest1=new File("fbpss.png");
		FileHandler.copy(src1, dest1);
		//Take screenshot of element
		int x=driver.findElement(By.xpath("//img[@alt='Facebook']")).getLocation().getX();
		int y=driver.findElement(By.xpath("//img[@alt='Facebook']")).getLocation().getY();
		int w=driver.findElement(By.xpath("//img[@alt='Facebook']")).getSize().getWidth();
		int h=driver.findElement(By.xpath("//img[@alt='Facebook']")).getSize().getHeight();
		File src2=driver.getScreenshotAs(OutputType.FILE);
		BufferedImage bfull=ImageIO.read(src2);
		BufferedImage fbeless=bfull.getSubimage(x, y, w, h);
		ImageIO.write(fbeless, "png", src2);
		File dest2=new File("fbeless.png");
		FileHandler.copy(src2, dest2);
		//close site
		driver.close();
	}
}
