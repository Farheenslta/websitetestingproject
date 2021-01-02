package simonstewart;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotCode 
{
	public static void main(String[] args) throws Exception
	{
		//launch browser
		System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		Thread.sleep(5000);
				
		//Way-1 (Screenshot in specific location)
		File src1=driver.getScreenshotAs(OutputType.FILE);
		File dest1=new File("F:\\Automation_PracticePrograms\\jasonhuggs\\bommaNew.png");
		FileHandler.copy(src1, dest1);
		Thread.sleep(8000);
		
		//Way-2 (Screenshot in project folder)
		File src2=driver.getScreenshotAs(OutputType.FILE);
		File dest2=new File("bommaNew.png");
		FileHandler.copy(src2, dest2);
		Thread.sleep(8000);
				
		//Way-3 (Screenshot in Specified Location with dynamic name)
		SimpleDateFormat sf=new SimpleDateFormat("dd-M-yyyy-hh-mm-ss");
		Date dt=new Date();
		String ssname=sf.format(dt)+".png";
		File src3=driver.getScreenshotAs(OutputType.FILE);
		File dest3=new File ("F:\\Automation_PracticePrograms\\jasonhuggs\\bommaNew"+ssname);
		FileHandler.copy(src3, dest3);
		Thread.sleep(8000);
		
		//Way-4 (Screenshot in project folder with dynamic name)
		SimpleDateFormat sf2=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
		Date dt2=new Date();
		String ssName=sf.format(dt)+".png";
		File src4=driver.getScreenshotAs(OutputType.FILE);
		File dest4=new File(ssName);
		FileHandler.copy(src4, dest4);
	}
}
