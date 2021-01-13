package actionspackage;

import java.util.Scanner;

import org.openqa.selenium.chrome.ChromeDriver;

public class ActionsClassHorizontalSliders 
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter x offset value for forward slide");
		int xos=sc.nextInt();
		System.out.println("Enter y offset value for forward slide");
		
		
		//Launch browser
		System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		//maximize
		driver.manage().window().maximize();
		//open site
		driver.get("");
	}
}
