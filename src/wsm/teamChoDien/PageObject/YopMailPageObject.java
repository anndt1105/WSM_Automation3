package wsm.teamChoDien.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YopMailPageObject {

	private static WebElement element = null;

	// Find element for title email
	public static WebElement title_mail(WebDriver driver) {
		element = driver.findElement(By.xpath("//div[@class='f16']"));
		return element;
	}

	// Find element link change password
	public static WebElement lnk_ChangePassword(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@class='link-website']"));
		return element;
	}
}