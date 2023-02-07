package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import resources.BaseUtility;

public class Registration extends BaseUtility{
	public WebDriver driver;
//	By club=(By.xpath("/html/body/div/div/div/main/div/div/div/div[2]/div[1]/div/div[4]/div/div[1]/div/div/div[1]/div[2]/div/section[1]/form/div[1]/div[4]/header/button"));
	@FindBy(name="email")
	 public static WebElement Email;
	// username entry
	@FindBy(name="password")
	public static WebElement Password;
	// password entry
	@FindBy(xpath="//span[text()='Sign In']")
	public static  WebElement Signin;
	
}
