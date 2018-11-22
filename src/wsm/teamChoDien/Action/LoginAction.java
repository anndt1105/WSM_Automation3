package wsm.teamChoDien.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wsm.teamChoDien.PageObject.LoginPageObjects;

public class LoginAction {
	public static void login(WebDriver driver, String email, String password) throws InterruptedException {

		// Input data into user name field
		LoginPageObjects.txt_UserEmail(driver).sendKeys(email);

		// Input data into password field
		LoginPageObjects.txt_Password(driver).sendKeys(password);
		Thread.sleep(100);
		
		//WebDriverWait wait = new WebDriverWait(driver, 20); 
		//wait.until(ExpectedCondition.(LoginPageObjects.btn_Login(driver)))

		// Click button Login
		LoginPageObjects.btn_Login(driver).click();
	}

}
