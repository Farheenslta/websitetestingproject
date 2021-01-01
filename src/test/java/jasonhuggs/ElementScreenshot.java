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

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementScreenshot 
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//maximize browser
		driver.manage().window().maximize();
		//open site
		driver.get("https://www.google.com");
		WebDriverWait w=new WebDriverWait(driver,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		//take screen shot of page
		File src=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("fullss.png");
		FileHandler.copy(src, dest);
		//Take element screen shot
		WebElement e=driver.findElement(By.xpath("//img[@alt='Google']"));
		int x=e.getLocation().getX();
		int y=e.getLocation().getY();
		int wt=e.getSize().getWidth();
		int h=e.getSize().getHeight();
		File src1=driver.getScreenshotAs(OutputType.FILE);
		BufferedImage bfull=ImageIO.read(src1);
		BufferedImage bele=bfull.getSubimage(x, y, wt, h);
		ImageIO.write(bele, "png", src1);
		File dest1=new File("bele.png");
		FileHandler.copy(src1, dest1);
		//close site
		driver.close();
	}
}
