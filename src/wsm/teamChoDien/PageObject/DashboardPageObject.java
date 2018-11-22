package wsm.teamChoDien.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPageObject {
	private static WebElement element = null;

	public static WebElement popup_CloseDayOff(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"register-modal\"]/div/div/div[1]/button/i"));
		return element;
	}

	// Find flash message login successfully
	public static WebElement mess_loginSuccess(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"flash-message\"]"));
		return element;
	}

	// Find Element of Personal Request
	// Find button Personal request
	public static WebElement btn_personalRequest(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"sidebar-scroll\"]/div/ul/li[4]/a/span"));
		return element;
	}

	// Find button Overtime
	public static WebElement btn_overtime(WebDriver driver) {
		element = driver.findElement(By.linkText("Overtime"));
		return element;
	}

	// Find button Avatar User
	public static WebElement btn_avatar(WebDriver driver) {
		element = driver.findElement(By.xpath("//img[@class='avatar']"));
		return element;
	}

	// Find button Logout
	public static WebElement btn_logout(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@class='button-logout']"));
		return element;
	}
	
	// Find button Setting Account
	public static WebElement btn_SettingAccount(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='/en/dashboard/user_settings/edit']"));
		return element;
	}

}
