package wsm.teamChoDien.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPageObjects {

	private static WebElement element = null;

	// Finding element UI of Title
	public static WebElement txt_Title(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/label"));
		return element;
	}

	// Finding element UI of user name field
	public static WebElement txt_UserEmail(WebDriver driver) {
		element = driver.findElement(By.xpath("(//input[@id='user_email'])[2]"));
		return element;
	}

	// Finding element UI of OK button
	public static WebElement btn_OK(WebDriver driver) {
		element = driver
				.findElement(By.xpath("(//button[@class='wsm-btn login-success'])[2]"));
		return element;
	}

	// Finding element UI of Cancel button
	public static WebElement btn_Cancel(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='devise-forgot-password-form']/div[2]/a"));
		return element;
	}

	// Finding element UI of Back to Login link
	public static WebElement link_BackToLogin(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@class='btn-back-login']"));
		return element;
	}

	// Finding element UI of Error message when Email is blank
	public static WebElement msg_ErrorMessageEmailBlank(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='devise-forgot-password-form']/div[1]/p"));
		return element;
	}

	// Finding element UI of Error message when Email does not exist
	public static WebElement msg_ErrorMessageEmailNotExist(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/div[2]/div[2]/section/div/p"));
		return element;
	}

	// Finding element UI of Error message when Email does not exist
	public static WebElement msg_ErrorMessageEmailNotValid(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id='devise-forgot-password-form']/div[1]/p"));
		return element;
	}

	// Finding element UI of Message sensd mail succesfull
	public static WebElement msg_MessageSendSuccessfull(WebDriver driver) {
		element = driver.findElement(By.xpath(
				"//p[contains(text(),'You will receive an email with instructions on how to reset your password in a few minutes')]"));
		return element;
	}

	// Finding element UI of Message sensd mail succesfull
	public static WebElement msg_emailNotFound(WebDriver driver) {
		element = driver.findElement(By.xpath("//p[contains(text(),'Email not found')]"));
		return element;
	}

	// Finding element UI of Message sensd mail succesfull
	public static WebElement btn_submitPassword(WebDriver driver) {
		element = driver.findElement(By.name("button"));
		return element;
	}

	// Finding element UI of field new password
	public static WebElement txt_NewPassword(WebDriver driver) {
		element = driver.findElement(By.id("user_password"));
		return element;
	}

	// Finding element UI of field confirm password
	public static WebElement txt_ConfirmPassword(WebDriver driver) {
		element = driver.findElement(By.id("user_password_confirmation"));
		return element;
	}

	// Finding element UI of message confirm password is required
	public static WebElement mess_PasswordError(WebDriver driver) {
		element = driver.findElement(By.id("user_password_confirmation-error"));
		return element;
	}
	
	// Finding element UI of message change password successfully
	public static WebElement mess_ChangePassSuccess(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[1]"));
		return element;
	}
	
	
}
