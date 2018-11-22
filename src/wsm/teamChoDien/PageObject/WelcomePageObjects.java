package wsm.teamChoDien.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePageObjects {

	private static WebElement element = null;

	// Finding element UI of Login button
	public static WebElement btn_Login(WebDriver driver) {	
		element = driver.findElement(By.xpath("//a[@class='wsm-btn btn-login']"));
		return element;
	}
	
	// Finding element UI of Log out successfully message
	public static WebElement mess_logoutsuccessfully(WebDriver driver) {	
		element = driver.findElement(By.xpath("//*[@id=\"flash-message\"]"));
		return element;
	}

}
