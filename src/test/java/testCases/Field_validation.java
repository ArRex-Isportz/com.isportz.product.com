package testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageObject.Registration;

public class Field_validation {
	WebDriver driver;
//	PageFactory.initElements( driver,Registration.class);

	@Test(priority=0)
	public  void aurllaunch() throws InterruptedException
	{
		//		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://stagingcamp.isportz.co/");
		Thread.sleep(3000);
		PageFactory.initElements( driver,Registration.class);
//		p.Email.sendKeys("clubadmin@isportz.co");
		Registration.Email.sendKeys("clubadmin@isportz.co");
		//synchronized( driver){
//			driver.wait(5000);
		//}
		Registration.Password.sendKeys("Camp#2022#");
		Registration.Signin.click();
		Thread.sleep(3000);
//		driver.close();

	}
	@Test(priority=2)
	public void takescreen() throws IOException {
		TakesScreenshot ss=(TakesScreenshot)driver;
		File temp = ss.getScreenshotAs(OutputType.FILE);
		File des=new File("F://Camp//Screenshots/camp1.png");
		FileUtils.copyFile (temp,des);	

	}

	@Test(enabled=false)
	public void testcase1() throws InterruptedException{

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://stagingcamp.isportz.co/");
		Thread.sleep(3000);

		PageFactory.initElements( driver,Registration.class);
		Registration.Email.sendKeys("enduser@isportz.co");
		Registration.Password.sendKeys("Camp#2022#");
		Registration.Signin.click();
		Thread.sleep(3000);
	}
}
