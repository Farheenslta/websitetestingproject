package jasonhuggs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MercuryToursDataDriverForRegistrationDataExcel
{
	public static void main(String[] args) throws Exception
	{
		//Declare Global Variable
		RemoteWebDriver driver=null;
		
		File f=new File("registrationdetails.xlsx");
		FileInputStream f1=new FileInputStream(f);
		Workbook wb= WorkbookFactory.create(f1);
		Sheet sh=wb.getSheet("Sheet1");
		int nour=sh.getPhysicalNumberOfRows();
		int nouc=sh.getRow(0).getLastCellNum();
		//Give heading to results in excel file
		SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
		Date dt=new Date();
		String result=sf.format(dt);
		sh.getRow(0).createCell(nouc).setCellValue("Result on" + result);
		//Data Driven from 2nd row(index=1)
		for(int i=1; i<nour;i++)
		{
				//Read data from excel
				DataFormatter df=new DataFormatter();
				String fn=df.formatCellValue(sh.getRow(i).getCell(0));
				String ln=df.formatCellValue(sh.getRow(i).getCell(1));
				String ph=df.formatCellValue(sh.getRow(i).getCell(2));
				String uname=df.formatCellValue(sh.getRow(i).getCell(3));
				String add=df.formatCellValue(sh.getRow(i).getCell(4));
				String city=df.formatCellValue(sh.getRow(i).getCell(5));
				String state=df.formatCellValue(sh.getRow(i).getCell(6));
				String pcode=df.formatCellValue(sh.getRow(i).getCell(7));
				String country=df.formatCellValue(sh.getRow(i).getCell(8));
				String email=df.formatCellValue(sh.getRow(i).getCell(9));
				String pass=df.formatCellValue(sh.getRow(i).getCell(10));
				String cpass=df.formatCellValue(sh.getRow(i).getCell(11));
				String bn=df.formatCellValue(sh.getRow(i).getCell(12));
				
				//Similar for all browsers
				//System.setProperty("webdriver.chrome.driver", "F:\\Automation_PracticePrograms\\jasonhuggs\\chromedriver_win32\\chromedriver.exe");
				//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				
				//Bonigarcia dependency code to get compatible browser driver s/w automatically wrt browser
				if(bn.equalsIgnoreCase("chrome"))
				{
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
				}
				else if(bn.equalsIgnoreCase("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
				}
				else
				{
					System.out.println("Enter correct browser name");
					System.exit(0);//Stop execution forcibly
				}
				
				//Maximize browser
				driver.manage().window().maximize();
				
				//Launch site
				driver.get("http://demo.guru99.com/test/newtours/");
				WebDriverWait w=new WebDriverWait(driver, 20);
				w.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("REGISTER")));
				try
				{
					driver.findElement(By.linkText("REGISTER")).click();
					w.until(ExpectedConditions.elementToBeClickable(By.name("firstName")));
					driver.findElement(By.name("firstName")).sendKeys(fn);
					driver.findElement(By.name("lastName")).sendKeys(ln);
					driver.findElement(By.name("phone")).sendKeys(ph);
					driver.findElement(By.name("userName")).sendKeys(email);
					driver.findElement(By.name("address1")).sendKeys(add);
					driver.findElement(By.name("city")).sendKeys(city);
					driver.findElement(By.name("state")).sendKeys(state);
					driver.findElement(By.name("postalCode")).sendKeys(pcode);
					driver.findElement(By.name("country")).sendKeys(country);
					driver.findElement(By.name("email")).sendKeys(email);
					driver.findElement(By.name("password")).sendKeys(pass);
					driver.findElement(By.name("confirmPassword")).sendKeys(cpass);
					driver.findElement(By.name("submit")).click();
					w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Your user name is "+email+"')]")));
					String text=driver.findElement(By.xpath("//*[contains(text(),'Your user name is "+email+"')])")).getText();
					if(text.contains(email))
					{
						sh.getRow(i).createCell(nouc).setCellValue("Registration test passed for " + email);
					}
					else
					{
						File src=driver.getScreenshotAs(OutputType.FILE);
						File dest=new File("resultss");
						FileHandler.copy(src, dest);
						sh.getRow(i).createCell(nouc).setCellValue("Registration test failed for " + email);
					}
				}
				catch(Exception ex)
				{
					File src=driver.getScreenshotAs(OutputType.FILE);
					File dest=new File("failedres");
					FileHandler.copy(src, dest);
					sh.getRow(i).createCell(nouc).setCellValue(ex.getMessage()+" and see " + dest.getAbsolutePath());
				}
		}
		//close site
		driver.close();
		sh.autoSizeColumn(nouc);
		
		//save data back to excel
		FileOutputStream fo=new FileOutputStream(f);
		wb.write(fo);
		f1.close();
		fo.close();
		wb.close();
	}
}
