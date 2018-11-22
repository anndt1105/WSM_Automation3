package wsm.teamChoDien.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import wsm.teamChoDien.Action.LoginAction;
import wsm.teamChoDien.Action.TransitionPageAction;
import wsm.teamChoDien.PageObject.DashboardPageObject;
import wsm.teamChoDien.PageObject.WelcomePageObjects;
import wsm.teamChoDien.Utility.ConstantVariable;

public class LogOutTest extends CommonTest {

	// LOGOUT_001_Verify that user logs out successfully when click to Log out
	// button
	@Test
	public void LOGOUT_001() throws Exception {

		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Click on Avatar User
		DashboardPageObject.btn_avatar(driver).click();

		// Click on Avatar User
		DashboardPageObject.btn_logout(driver).click();

		// Actual message:
		String actual_message = WelcomePageObjects.mess_logoutsuccessfully(driver).getText();

		// Verify that user logs out successfully when click to Log out button
		Assert.assertEquals(actual_message, ConstantVariable.LOGOUT_SUCCESSFULY_MESSAGE);
	}

	// LOGOUT_002_Verify that system redirects to Login page when logged out
	// successfully
	@Test
	public void LOGOUT_002() throws Exception {

		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Click on Avatar User
		DashboardPageObject.btn_avatar(driver).click();

		// Click on Avatar User
		DashboardPageObject.btn_logout(driver).click();

		wait.until(ExpectedConditions.visibilityOf(WelcomePageObjects.btn_Login(driver)));

		// Actual result:
		boolean isLoginButtonDisplay = WelcomePageObjects.btn_Login(driver).isDisplayed();

		// Verify that system redirects to Login page when logged out
		// successfully
		Assert.assertTrue(isLoginButtonDisplay);
	}

	// LOGOUT_003_Verify that user session is cleared when user logged out
	// successfully
	@Test
	public void LOGOUT_003() throws Exception {

		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Click on Avatar User
		DashboardPageObject.btn_avatar(driver).click();

		// Click on Avatar User
		DashboardPageObject.btn_logout(driver).click();

		// Try to navigate to any screen
		driver.get("https://edev.framgia.vn/en/dashboard/user_settings/edit");

		wait.until(ExpectedConditions.visibilityOf(WelcomePageObjects.btn_Login(driver)));

		// Actual result:
		boolean isLoginButtonDisplay = WelcomePageObjects.btn_Login(driver).isDisplayed();

		// Verify that system redirects to Login page when logged out
		// successfully
		Assert.assertTrue(isLoginButtonDisplay);
	}

	// LOGOUT_004_Verify that system redirects to Login page when clicking Log out
	// button at any page of WSM application successfully
	@Test
	public void LOGOUT_004() throws Exception {

		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Click on Avatar User
		DashboardPageObject.btn_avatar(driver).click();

		// Go to Setting Account Page:
		DashboardPageObject.btn_SettingAccount(driver).click();

		// Click on Avatar User again
		DashboardPageObject.btn_avatar(driver).click();

		// Click on Avatar User
		DashboardPageObject.btn_logout(driver).click();
		wait.until(ExpectedConditions.visibilityOf(WelcomePageObjects.btn_Login(driver)));

		// Actual message:
		String actual_message = WelcomePageObjects.mess_logoutsuccessfully(driver).getText();

		// Verify that user logs out successfully when click to Log out button
		Assert.assertEquals(actual_message, ConstantVariable.LOGOUT_SUCCESSFULY_MESSAGE);

		// Actual result:
		boolean isLoginButtonDisplay = WelcomePageObjects.btn_Login(driver).isDisplayed();

		// Verify that system redirects to Login page when logged out
		// successfully
		Assert.assertTrue(isLoginButtonDisplay);

	}

	// LOGOUT_005_Verify that system does not redirect to any page when clicking on
	// Back button of browser after logged out successfully
	@Test
	public void LOGOUT_005() throws Exception {

		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Click on Avatar User
		DashboardPageObject.btn_avatar(driver).click();

		// Click on Avatar User
		DashboardPageObject.btn_logout(driver).click();

		// Click on Back button on browser
		driver.navigate().back();

		// Verify that system redirects to Login page when logged out
		// successfully
		Assert.assertEquals(driver.getTitle(), ConstantVariable.TITLE);

	}

}
