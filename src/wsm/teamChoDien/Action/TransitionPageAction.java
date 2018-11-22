package wsm.teamChoDien.Action;
import wsm.teamChoDien.Utility.ConstantVariable; import wsm.teamChoDien.PageObject.YopMailPageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import wsm.teamChoDien.PageObject.LoginPageObjects;
import wsm.teamChoDien.PageObject.DashboardPageObject;
import wsm.teamChoDien.PageObject.PersonalRequestsOTPageObject;
import wsm.teamChoDien.PageObject.WelcomePageObjects;
import wsm.teamChoDien.PageObject.ForgotPasswordPageObjects;
public class TransitionPageAction {
	public static void gotoLoginPage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(WelcomePageObjects.btn_Login(driver)));

		WelcomePageObjects.btn_Login(driver).click();
	}
	public static void gotoOvertimePage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.btn_personalRequest(driver)));
		
		DashboardPageObject.btn_personalRequest(driver).click();
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.btn_overtime(driver)));
		DashboardPageObject.btn_overtime(driver).click();
	}
	
	public static void gotoRequestOTPage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.btn_createRequest(driver)));

		PersonalRequestsOTPageObject.btn_createRequest(driver).click();
	}
	
	public static void gotoChangePasswordPage(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		// go to Login page
		gotoLoginPage(driver);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.link_ForgotPass(driver)));

		// go to Forgot password page
		LoginPageObjects.link_ForgotPass(driver).click();
		wait.until(ExpectedConditions.visibilityOf(ForgotPasswordPageObjects.btn_OK(driver)));

		// input mail then click OK
		ForgotPasswordPageObjects.txt_UserEmail(driver).sendKeys(ConstantVariable.USERNAME);
		ForgotPasswordPageObjects.btn_OK(driver).click();

		// go to yopmail
		driver.get(ConstantVariable.YOP_MAIL_URL);
		driver.switchTo().frame("ifmail");
		wait.until(ExpectedConditions.visibilityOf(YopMailPageObject.title_mail(driver)));

		// Click on link_changepassword
		YopMailPageObject.lnk_ChangePassword(driver).click();
	}

}
