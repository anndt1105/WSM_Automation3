package wsm.teamChoDien.Test;

import org.apache.commons.logging.Log;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import wsm.teamChoDien.Action.ClosePopupDayOffAction;
import wsm.teamChoDien.Action.LoginAction;
import wsm.teamChoDien.Action.TransitionPageAction;
import wsm.teamChoDien.PageObject.DashboardPageObject;
import wsm.teamChoDien.PageObject.LoginPageObjects;
import wsm.teamChoDien.Utility.ConstantVariable;

public class LoginTest extends CommonTest {
	// LOGIN_006
	@Test
	public void mess_loginWithValidAcount() throws Exception {

		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Get message
		String[] message = DashboardPageObject.mess_loginSuccess(driver).getText().split("\n");

		// Verify Result message successfully
		Assert.assertEquals(message[message.length - 1], ConstantVariable.LOGIN_SUCCESSFULY_MESSAGE);
	}

	// LOGIN_007
	@Test
	public void title_loginWithValidAcount() throws Exception {

		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		Thread.sleep(1000);
		// Verify title of Tab
		Assert.assertEquals(driver.getTitle(), ConstantVariable.TAB_TITLE);

	}

	// TC LOGIN_008
	@Test
	public void back_loginWithValidAcount() throws Exception {

		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Step 1+2: Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Step 3: Click Back on browser
		driver.navigate().back();
		Thread.sleep(1000);

		// Verify Result message successfully
		Assert.assertEquals(driver.getTitle(), ConstantVariable.TAB_TITLE);

	}

	// TC LOGIN_009
	@Test
	public void newTab_loginWithValidAcount() throws Exception {

		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Step 1+2: Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);
		Thread.sleep(1000);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Step 3+4+5:
		driver.navigate().to("https://www.google.com/");
		driver.navigate().to(ConstantVariable.URL);

		// Verify Result message successfully
		Assert.assertEquals(driver.getTitle(), ConstantVariable.TAB_TITLE);

	}

	// LOGIN_001 ~ 003
	@Test
	public void checkComponents() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.txt_title(driver)));

		// F001 check Title
		String title = LoginPageObjects.txt_title(driver).getText();
		Assert.assertEquals(title, "LOGIN");

		// F001 check Email textbox
		Assert.assertTrue(LoginPageObjects.txt_UserEmail(driver).isDisplayed(), "Email textbox failed");
		LoginPageObjects.txt_UserEmail(driver).sendKeys("123");

		// F001 check Pass textbox
		Assert.assertTrue(LoginPageObjects.txt_Password(driver).isDisplayed(), "Pass textbox Failed");

		// F001 check Remember checkbox
		Assert.assertTrue(LoginPageObjects.txt_RememberLogin(driver).isDisplayed(), "Remember checkbox Failed");

		// F001 check OK button
		Assert.assertTrue(LoginPageObjects.btn_Login(driver).isDisplayed(), "OK button failed");

		// F001 check Cancel button
		Assert.assertTrue(LoginPageObjects.btn_Cancel(driver).isDisplayed(), "Cancel button failed");

		// F001 check Forgot pass link
		Assert.assertTrue(LoginPageObjects.link_ForgotPass(driver).isDisplayed(), "Forgot pass link failed");

		// F002 check initial value of remember checkbox
		Assert.assertFalse(LoginPageObjects.txt_RememberLogin(driver).isSelected(), "Initial remember checkbox failed");

		// F003 check pass encrypted
		String type = LoginPageObjects.txt_Password(driver).getAttribute("type");
		Assert.assertEquals(type, "password", "password encrypted Failed");

	}

	// LOGIN_010 - Login unsuccessfully with blank Email or Password
	@Test
	public void mess_loginWithBlankEmail() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);
		LoginPageObjects.txt_UserEmail(driver).clear();

		// Doing Login action with valid User name and password
		String username = "";
		LoginAction.login(driver, username, ConstantVariable.PASSWORD);

		// Verify Result
		String expectedResult = LoginPageObjects.msg_ErrorMessageUserNameBlank(driver).getText();
		System.out.println(expectedResult);
		Assert.assertEquals(expectedResult, ConstantVariable.USERNAME_BLANK_MESSAGE);
	}

	@Test
	public void mess_loginWithBlankPassword() throws Exception {
		// Doing Login action with invalid info
		TransitionPageAction.gotoLoginPage(driver);
		String password = "";
		LoginAction.login(driver, ConstantVariable.USERNAME, password);

		// Verify Result
		String expectedResult = LoginPageObjects.msg_ErrorMessagePasswordBlank(driver).getText();
		System.out.println(expectedResult);
		Assert.assertEquals(expectedResult, ConstantVariable.PASSWORD_BLANK_MESSAGE);
	}

	// LOGIN_011 - Login unsuccessfully with invalid email and invalid password
	@Test
	public void mess_loginWithInvalidInfo() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);
		LoginAction.login(driver, ConstantVariable.USERNAME_NOT_EXIST, ConstantVariable.PASSWORD);

		// Verify Result
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.msg_ErrorLoginMessage(driver)));

		String expectedResult = LoginPageObjects.msg_ErrorLoginMessage(driver).getText();
		System.out.println(expectedResult);
		Assert.assertEquals(expectedResult, ConstantVariable.LOGIN_FAILED_MESSAGE);
	}

	// LOGIN_012 - Login unsuccessfully with valid email and invalid password
	@Test
	public void mess_loginWithInvalidPassword() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.OLD_PASSWORD);

		// Verify Result
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.msg_ErrorLoginMessage(driver)));

		String expectedResult = LoginPageObjects.msg_ErrorLoginMessage(driver).getText();
		System.out.println(expectedResult);
		Assert.assertEquals(expectedResult, ConstantVariable.LOGIN_FAILED_MESSAGE);
	}

	// LOGIN_013 - Login unsuccessfully with invalid email and valid password
	@Test
	public void mess_loginWithInvalidEmail() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);
		LoginAction.login(driver, ConstantVariable.USERNAME_INVALID, ConstantVariable.PASSWORD);

		// Verify Result
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(LoginPageObjects.msg_ErrorInvalidFormatEmail(driver)));

		String expectedResult = LoginPageObjects.msg_ErrorInvalidFormatEmail(driver).getText();
		System.out.println(expectedResult);
		Assert.assertEquals(expectedResult, ConstantVariable.USERNAME_INVALID_MESSAGE);
	}
}
