package actionspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClassTooltips
{
	public static void main(String[] args) throws Exception
	{
		//Launch browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		//Maximize browser
		driver.manage().window().maximize();
		//open site
		driver.get("https://www.w3schools.com/css/css_tooltip.asp");
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[contains(text(),'Top')]"))));
		//Get tool tip value
		WebElement e1=driver.findElement(By.linkText("JAVASCRIPT"));
		Actions a=new Actions(driver);
		a.moveToElement(e1).build().perform();
		String ttv1=e1.getAttribute("title");
		System.out.println("Tooltip value of JAVASCRIPT element is: "+ttv1);
		WebElement e2=driver.findElement(By.xpath("//div[contains(text(),'Top')]"));
		a.moveToElement(e2).build().perform();
		String ttv2=e2.getText();
		System.out.println("Tooltip value of Top element is: " +ttv2);
		WebElement e3=driver.findElement(By.xpath("//div[contains(text(),'Right')]"));
		a.moveToElement(e3).build().perform();
		String ttv3=e3.getText();
		System.out.println("Tooltip value of Right element is: " +ttv3);
		WebElement e4=driver.findElement(By.xpath("//div[contains(text(),'Bottom')]"));
		a.moveToElement(e4).build().perform();
		String ttv4=e4.getText();
		System.out.println("Tooltip value of Bottom element is: " +ttv4);
		WebElement e5=driver.findElement(By.xpath("//div[contains(text(),'Left')]"));
		a.moveToElement(e5).build().perform();
		String ttv5=e5.getText();
		a.release().build().perform();
		System.out.println("Tooltip value of Left element is: " +ttv5);
		Thread.sleep(2000);
		//Close site
		driver.close();
	}
}
