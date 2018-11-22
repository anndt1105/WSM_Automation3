package wsm.teamChoDien.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {

	private static WebElement element = null;

	// Finding element UI of User name field
	public static WebElement txt_UserEmail(WebDriver driver) {
		element = driver.findElement(By.id("user_email"));
		return element;
	}

	// Finding element UI of Password field
	public static WebElement txt_Password(WebDriver driver) {
		element = driver.findElement(By.id("user_password"));
		return element;
	}

	// Finding element UI of Remember checkbox
	public static WebElement txt_RememberLogin(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[@class='span-remember']"));
		return element;
	}

	// Finding element UI of Login button
	public static WebElement btn_Login(WebDriver driver) {
		element = driver.findElement(By.name("button"));
		return element;
	}

	// Finding element UI of Cancel button
	public static WebElement btn_Cancel(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@class='wsm-btn login-cancel']"));
		return element;
	}

	// Finding element UI of Error message when user name is not exits
	public static WebElement msg_ErrorLoginMessage(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div[2]/div[1]/section/div/p"));
		return element;
	}
	
	// Finding element UI of Error message when user name is invalid format email
	public static WebElement msg_ErrorInvalidFormatEmail(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"devise-login-form\"]/div[1]/p"));
		return element;
	}

	// Finding element UI of Error message when user name is blank
	public static WebElement msg_ErrorMessageUserNameBlank(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"devise-login-form\"]/div[1]/p"));
		return element;
	}

	// Finding element UI of Error message when user name is blank
	public static WebElement msg_ErrorMessagePasswordBlank(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"devise-login-form\"]/div[2]/p"));
		return element;
	}

	// Finding element UI of forgot password link
	public static WebElement link_ForgotPass(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@class='btn-forgot-password']"));
		return element;
	}

	// Finding element UI of forgot password link
	public static WebElement txt_title(WebDriver driver) {
		element = driver.findElement(By.xpath("//label[@class='login-title']"));
		return element;
	}

}
