package wsm.teamChoDien.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChangePasswordPageObject {

	private static WebElement element = null;

	// Find element for title email
	public static WebElement lb_ChangePassword(WebDriver driver) {
		element = driver.findElement(By.xpath("//label[@class='login-title']"));
		return element;
	}

	// Find element for New password label
	public static WebElement lb_NewPassword(WebDriver driver) {
		element = driver.findElement(By.xpath("(//label[@class='field-title'])[1]"));
		return element;
	}

	// Find element for New password textbox
	public static WebElement txb_NewPassword(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='user_password']"));
		return element;
	}

	// Find element for Confirm New password label
	public static WebElement lb_ComfirmNewPassword(WebDriver driver) {
		element = driver.findElement(By.xpath("(//label[@class='field-title'])[2]"));
		return element;
	}

	// Find element for Confirm New password textbox
	public static WebElement txb_ConfirmNewPassword(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='user_password_confirmation']"));
		return element;
	}

	// Find element for OK button
	public static WebElement btn_OK(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@class='wsm-btn login-success']"));
		return element;
	}

}
