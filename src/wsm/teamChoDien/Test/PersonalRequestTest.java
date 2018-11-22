package wsm.teamChoDien.Test;

import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import wsm.teamChoDien.Action.LoginAction;
import wsm.teamChoDien.Action.RequestOTAction;
import wsm.teamChoDien.Action.TransitionPageAction;
import wsm.teamChoDien.PageObject.DashboardPageObject;
import wsm.teamChoDien.PageObject.PersonalRequestsOTPageObject;
import wsm.teamChoDien.PageObject.RequestOvertimePageObject;
import wsm.teamChoDien.Utility.ConstantVariable;

public class PersonalRequestTest extends CommonTest {
	// PER_REQ_OT_018
	@Test
	public void TC18_invalid_requestInThePast() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/"
				+ (LocalDate.now().getMonthValue() - 1);
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";

		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		// Get message when system validate on this case
		boolean messDisplay = PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).isDisplayed();

		// Verify Result message successfully
		if (messDisplay = true) {
			Assert.assertEquals(messDisplay, ConstantVariable.REQUEST_OT_DATE_IN_PAST_MESS);
		} else {
			Assert.fail("Error message does not display");
		}

	}

	// PER_REQ_OT_019
	@Test
	public void TC19_invalid_requestProjectBlank() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + LocalDate.now().getMonthValue();
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";

		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID, " ",
				requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		// Get message
		boolean messDisplay = PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).isDisplayed();

		// Verify Result message successfully
		if (messDisplay = true) {
			Assert.assertEquals(PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).getText(),
					ConstantVariable.PROJECT_BLANK_MESS);
		} else {
			Assert.fail("Error message does not display");
		}
	}

	// PER_REQ_OT_020
	@Test
	public void TC20_invalid_requestFromDateBlank() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + LocalDate.now().getMonthValue();
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";

		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, " ", requestDateTo, ConstantVariable.REASON_OT);

		// Get message
		boolean messDisplay = PersonalRequestsOTPageObject.mess_fromDATEBlank(driver).isDisplayed();

		// Verify Result message successfully
		if (messDisplay = true) {
			Assert.assertEquals(PersonalRequestsOTPageObject.mess_fromDATEBlank(driver).getText(),
					ConstantVariable.FROM_DATE_BLANK_MESS);
		} else {
			Assert.fail("Error message does not display");
		}
	}

	// PER_REQ_OT_021
	@Test
	public void TC21_invalid_requestToDateBlank() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + (LocalDate.now().getMonthValue());
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";

		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, "", ConstantVariable.REASON_OT);
		PersonalRequestsOTPageObject.txb_to(driver).clear();

		// Get message
		boolean messDisplay = PersonalRequestsOTPageObject.mess_toDATEBlank(driver).isDisplayed();

		// Verify Result message successfully
		if (messDisplay = true) {
			Assert.assertEquals(PersonalRequestsOTPageObject.mess_toDATEBlank(driver).getText(),
					ConstantVariable.TO_DATE_BLANK_MESS);
		} else {
			Assert.fail("Error message does not display");
		}

	}

	// PER_REQ_OT_022
	@Test
	public void TC22_invalid_requestReasonBlank() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/"
				+ (LocalDate.now().getMonthValue() - 1);
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";

		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, "");

		// Get message
		boolean messDisplay = PersonalRequestsOTPageObject.mess_reasonBlank(driver).isDisplayed();

		// Verify Result message
		if (messDisplay = true) {
			Assert.assertEquals(PersonalRequestsOTPageObject.mess_reasonBlank(driver).getText(),
					ConstantVariable.REASON_BLANK_MESS);
		} else {
			Assert.fail("Error message does not display");
		}
	}

	// PER_REQ_OT_023
	@Test
	public void TC23_invalid_duplicateRequest() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Create request OT in the first time
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + (LocalDate.now().getMonthValue());
		ConstantVariable.REQUEST_OT_DATE = "/" + (LocalDate.now().getDayOfMonth() - 2);
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		// Create request OT in the second time
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);
		Thread.sleep(1000);
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		// Get message
		boolean messDisplay = PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).isDisplayed();

		// Verify Result message
		if (messDisplay = true) {
			Assert.assertEquals(PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).getText(),
					ConstantVariable.DUPLICATE_REQUEST_MESS);
		} else {
			Assert.fail("Error message does not display");
		}
	}

	// PER_REQ_OT_024
	@Test
	public void TC24_invalid_workingTimeRequest() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Create request OT in the first time
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + (LocalDate.now().getMonthValue());
		ConstantVariable.REQUEST_OT_DATE = "/" + (LocalDate.now().getDayOfMonth());
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 13:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 16:00";
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		// Get message when system validate this case
		boolean messDisplay = PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).isDisplayed();

		// Verify Result message
		if (messDisplay = true) {
			Assert.assertEquals(PersonalRequestsOTPageObject.mess_requestOTUnsuccessfully(driver).getText(),
					ConstantVariable.WORKINGTIME_REQUEST_MESS);
		} else {
			Assert.fail("Error message does not display");
		}
	}

	// PER_REQ_OT_011
	@Test
	public void TC11_valid_NotCheckedOTGroup() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + (LocalDate.now().getMonthValue());
		ConstantVariable.REQUEST_OT_DATE = "/" + (LocalDate.now().getDayOfMonth() - 3);
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";
		RequestOTAction.requestOTGroup(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.OT_GROUP_VALID, ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo,
				ConstantVariable.REASON_OT);

		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver)));

		// Get message
		String[] actual_message = PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver).getText().split("\n");

		// Verify Result message successfully
		Assert.assertEquals(actual_message[actual_message.length - 1],
				ConstantVariable.CREATE_REQUEST_OT_SUCCESSFULY_MESSAGE);
	}

	// PER_REQ_OT_012
	@Test
	public void TC12_valid_CheckedOTGroup() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + LocalDate.now().getMonthValue();
		ConstantVariable.REQUEST_OT_DATE = "/" + (LocalDate.now().getDayOfMonth() - 4);
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		// WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver)));

		// Get message
		String[] actual_message = PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver).getText().split("\n");

		// Verify Result message successfully
		Assert.assertEquals(actual_message[actual_message.length - 1],
				ConstantVariable.CREATE_REQUEST_OT_SUCCESSFULY_MESSAGE);
	}

	// PER_REQ_OT_013
	@Test
	public void TC13_valid_CurrentMonth() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);
		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + (LocalDate.now().getMonthValue());
		ConstantVariable.REQUEST_OT_DATE = "/" + (LocalDate.now().getDayOfMonth() - 5);
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		// WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver)));

		// Get message
		String[] actual_message = PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver).getText().split("\n");

		// Verify Result message successfully
		Assert.assertEquals(actual_message[actual_message.length - 1],
				ConstantVariable.CREATE_REQUEST_OT_SUCCESSFULY_MESSAGE);
	}

	// PER_REQ_OT_014
	@Test
	public void TC14_valid_FutureMonth() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/"
				+ (LocalDate.now().getMonthValue() + 1);
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		// WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver)));

		// Get message
		String[] actual_message = PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver).getText().split("\n");

		// Verify Result message successfully
		Assert.assertEquals(actual_message[actual_message.length - 1],
				ConstantVariable.CREATE_REQUEST_OT_SUCCESSFULY_MESSAGE);
	}

	// PER_REQ_OT_015
	@Test
	public void TC15_valid_RequestOTScreenDisplay() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + (LocalDate.now().getMonthValue());
		ConstantVariable.REQUEST_OT_DATE = "/" + (LocalDate.now().getDayOfMonth() - 6);
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";
		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, ConstantVariable.REASON_OT);

		// Close day off popup
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		wait.until(ExpectedConditions.visibilityOf(RequestOvertimePageObject.lb_title(driver)));

		// Verify that Request OT screen is displayed
		String actual_title = RequestOvertimePageObject.lb_title(driver).getText();
		String expected_title = ConstantVariable.REQUEST_OT_SCREEN_TITLE;
		Assert.assertEquals(actual_title, expected_title);
	}

	// PERSONAL_REQUEST_001
	@Test
	public void TC1_loginSessionOTPage() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Verify that Request OT screen is displayed
		wait.until(ExpectedConditions.visibilityOf(RequestOvertimePageObject.lb_title(driver)));
		String actual_title = RequestOvertimePageObject.lb_title(driver).getText();
		String expected_title = ConstantVariable.REQUEST_OT_SCREEN_TITLE;
		Assert.assertEquals(actual_title, expected_title);
	}

	// PERSONAL_REQUEST_002
	@Test
	public void TC2_noLoginSessionOTPage() throws Exception {
		// Go to request OT page by direct URL
		// driver.get(ConstantVariable.OT_URL);
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);
		driver.navigate().to(ConstantVariable.OT_URL);

		// Verify Login page displays

		// Check Title
		// String title = LoginPageObjects.txt_title(driver).getText();
		Assert.assertEquals(driver.getTitle(), ConstantVariable.TITLE);
	}

	// PERSONAL_REQUEST_003
	@Test
	public void TC3_requestOTPagedisplays() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Check title
		String title = PersonalRequestsOTPageObject.txt_titleNewRequest(driver).getText();
		Assert.assertEquals(title, ConstantVariable.OT_title);
	}

	// PERSONAL_REQUEST_004
	// Check label Staff name
	@Test
	public void checkLabelstaffName() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.label_staffName(driver)));

		// Verify Result
		Assert.assertEquals(PersonalRequestsOTPageObject.label_staffName(driver).getText(),
				ConstantVariable.LABEL_STAFF_NAME);
	}

	// Check textbox Staff name
	@Test
	public void checkTextboxstaffName() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_staffName(driver)));

		// Verify Result
		Assert.assertTrue(PersonalRequestsOTPageObject.txb_staffName(driver).isDisplayed());
	}

	// Check label Staff code
	@Test
	public void checkLabelstaffCode() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.label_staffCode(driver)));

		// Verify Result
		Assert.assertEquals(PersonalRequestsOTPageObject.label_staffCode(driver).getText(),
				ConstantVariable.LABEL_STAFF_CODE);
	}

	// Check textbox Staff code
	@Test
	public void checkTextboxstaffCode() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_staffCode(driver)));

		// Verify Result
		Assert.assertTrue(PersonalRequestsOTPageObject.txb_staffCode(driver).isDisplayed());
	}

	// Check label Branch
	@Test
	public void checkLabelBranch() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.label_branch(driver)));

		// Verify Result
		Assert.assertEquals(PersonalRequestsOTPageObject.label_branch(driver).getText(), ConstantVariable.LABEL_BRANCH);
	}

	// Check textbox Branch
	@Test
	public void checkTextboxBranch() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_branch(driver)));

		// Verify Result
		Assert.assertTrue(PersonalRequestsOTPageObject.txb_branch(driver).isDisplayed());
	}

	// Check label Group
	@Test
	public void checkLabelGroup() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.label_group(driver)));

		// Verify Result
		Assert.assertEquals(PersonalRequestsOTPageObject.label_group(driver).getText(), ConstantVariable.LABEL_GROUP);
	}

	// Check textbox Group
	@Test
	public void checkTextboxGroup() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_group(driver)));

		// Verify Result
		Assert.assertTrue(PersonalRequestsOTPageObject.txb_group(driver).isDisplayed());
	}

	// Check label Group
	@Test
	public void checkLabelDoYouOT() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.label_doYouOT(driver)));

		// Verify Result
		Assert.assertEquals(PersonalRequestsOTPageObject.label_doYouOT(driver).getText(),
				ConstantVariable.LABEL_DO_YOU_OT);
	}

	// Check label Project
	@Test
	public void checkLabelProject() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.label_project(driver)));

		// Verify Result
		Assert.assertEquals(PersonalRequestsOTPageObject.label_project(driver).getText(),
				ConstantVariable.LABEL_PROJECT);
	}

	// Check textbox Project
	@Test
	public void checkTextboxProject() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_project(driver)));

		// Verify Result
		Assert.assertTrue(PersonalRequestsOTPageObject.txb_project(driver).isDisplayed());
	}

	// Check label From
	@Test
	public void checkLabelFrom() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.label_from(driver)));

		// Verify Result
		Assert.assertEquals(PersonalRequestsOTPageObject.label_from(driver).getText(), ConstantVariable.LABEL_FROM);
	}

	// Check textbox From
	@Test
	public void checkTextboxFrom() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_from(driver)));

		// Verify Result
		Assert.assertTrue(PersonalRequestsOTPageObject.txb_from(driver).isDisplayed());
	}

	// Check label To
	@Test
	public void checkLabelTo() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.label_to(driver)));

		// Verify Result
		Assert.assertEquals(PersonalRequestsOTPageObject.label_to(driver).getText(), ConstantVariable.LABEL_TO);
	}

	// Check textbox To
	@Test
	public void checkTextboxTo() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_to(driver)));

		// Verify Result
		Assert.assertTrue(PersonalRequestsOTPageObject.txb_to(driver).isDisplayed());
	}

	// Check label Reason
	@Test
	public void checkLabelReason() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.label_reason(driver)));

		// Verify Result
		Assert.assertEquals(PersonalRequestsOTPageObject.label_reason(driver).getText(), ConstantVariable.LABEL_REASON);
	}

	// Check textbox Reason
	@Test
	public void checkTextboxReason() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_reason(driver)));

		// Verify Result
		Assert.assertTrue(PersonalRequestsOTPageObject.txb_reason(driver).isDisplayed());
	}

	// PER_REQ_OT_005
	@Test
	public void TC5_checkboxDefault() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.chb_OTGroup(driver)));

		// Verify that Do you OT for other group? checkbox is unselected by
		// default
		Assert.assertFalse(PersonalRequestsOTPageObject.chb_OTGroup(driver).isSelected());
	}

	// PER_REQ_OT_006
	// Check data staff Name
	@Test
	public void TC6_staffNameCorrect() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_staffName(driver)));

		// Verify that "Staff name" data is correct
		Assert.assertEquals(PersonalRequestsOTPageObject.txb_staffName(driver).getAttribute("value"),
				ConstantVariable.STAFF_NAME);
	}

	// PER_REQ_OT_007
	// Check data staff code
	@Test
	public void TC7_staffCodeCorrect() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_staffCode(driver)));

		// Verify that "Staff code" data is correct
		Assert.assertEquals(PersonalRequestsOTPageObject.txb_staffCode(driver).getAttribute("value"),
				ConstantVariable.STAFF_CODE);
	}

	// PER_REQ_OT_008
	// Check data Branch
	@Test
	public void TC8_checkBranch() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.txb_branch(driver)));

		// Verify that "Branch" data is correct
		Assert.assertEquals(PersonalRequestsOTPageObject.txb_branch(driver).getAttribute("value"),
				ConstantVariable.BRANCH_VALID);
	}

	// PER_REQ_OT_009
	@Test
	public void TC9_clickOTForOtherGroupCheckbox() throws Exception {

		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);

		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.chb_OTGroup(driver)));

		// Click on Do you OT for other group checkbox
		PersonalRequestsOTPageObject.chb_OTGroup(driver).click();

		// Verify the displaying of Group other drop down
		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.drd_OTGroup(driver)));
		Assert.assertTrue(PersonalRequestsOTPageObject.drd_OTGroup(driver).isDisplayed());
	}

	// PER_REQ_OT_010
	// @Test
	public void TC10_checkGroup() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();

		// Go to request OT page
		Thread.sleep(1000);
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Verify that "Group" dropdown list displays with correct data when
		// clicking on "Group" dropdown list
		Assert.assertEquals(PersonalRequestsOTPageObject.txb_group(driver).getAttribute("value"),
				ConstantVariable.GROUP_VALID);
	}

	// PERSONAL_REQUEST_025
	@Test
	public void personal_requestTC025() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/"
				+ (LocalDate.now().getMonthValue() - 1);
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";

		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, "");

		// Get message
		boolean messDisplay = PersonalRequestsOTPageObject.mess_reasonBlank(driver).isDisplayed();

		// Verify Result message
		if (messDisplay = true) {
			Assert.assertEquals(PersonalRequestsOTPageObject.mess_reasonBlank(driver).getText(),
					ConstantVariable.REASON_BLANK_MESS);
		} else {
			Assert.fail("Error message does not display");
		}

		// Verify user still in current page
		Assert.assertEquals(driver.getTitle(), ConstantVariable.TITLE_TAB_OT);

	}

	// PERSONAL_REQUEST_026
	@Test
	public void personal_requestTC026() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + (LocalDate.now().getMonthValue());
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 19:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";

		RequestOTAction.requestOT(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo, "");

		// Back to OT list page
		driver.navigate().back();
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		// Check failed OT form does not displays
		String OTList_From = "19:00 " + LocalDate.now().getMonthValue() + "-" + LocalDate.now().getDayOfMonth() + "-"
				+ +LocalDate.now().getYear();
		Assert.assertNotSame(RequestOvertimePageObject.col_From(driver).getText(), OTList_From);
	}

	// PERSONAL_REQUEST_016/17
	@Test
	public void personal_requestTC016_TC017() throws Exception {
		// Go to Login Page
		TransitionPageAction.gotoLoginPage(driver);

		// Doing Login action with valid User name and password
		LoginAction.login(driver, ConstantVariable.USERNAME, ConstantVariable.PASSWORD);

		// Close popup day of
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);

		// Go to request OT page
		TransitionPageAction.gotoOvertimePage(driver);
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObject.popup_CloseDayOff(driver)));
		DashboardPageObject.popup_CloseDayOff(driver).click();
		Thread.sleep(1000);
		TransitionPageAction.gotoRequestOTPage(driver);

		// Input request OT
		ConstantVariable.REQUEST_OT_YEAR_MONTH = LocalDate.now().getYear() + "/" + (LocalDate.now().getMonthValue());
		ConstantVariable.REQUEST_OT_DATE = "/" + LocalDate.now().getDayOfMonth();
		String requestDateFrom = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 18:00";
		String requestDateTo = ConstantVariable.REQUEST_OT_YEAR_MONTH + ConstantVariable.REQUEST_OT_DATE + " 21:00";
		RequestOTAction.requestOTGroup(driver, ConstantVariable.BRANCH_VALID, ConstantVariable.GROUP_VALID,
				ConstantVariable.OT_GROUP_VALID, ConstantVariable.PROJECT_VALID, requestDateFrom, requestDateTo,
				ConstantVariable.REASON_OT);

		wait.until(ExpectedConditions.visibilityOf(PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver)));

		// Get message
		String[] actual_message = PersonalRequestsOTPageObject.mess_requestOTSuccessfully(driver).getText().split("\n");

		// Verify Result message successfully
		Assert.assertEquals(actual_message[actual_message.length - 1],
				ConstantVariable.CREATE_REQUEST_OT_SUCCESSFULY_MESSAGE);

		// Check data in OT list displays correctly after create OT request
		// Check Staff code
		assertEquals(RequestOvertimePageObject.col_EmployeeCode(driver).getText(), ConstantVariable.STAFF_CODE);
		// Check Staff name
		assertEquals(RequestOvertimePageObject.col_StaffName(driver).getText(), ConstantVariable.STAFF_NAME);
		// Check Creation Date
		String creationDate = LocalDate.now().getMonthValue() + "-" + LocalDate.now().getDayOfMonth() + "-"
				+ +LocalDate.now().getYear();
		assertEquals(RequestOvertimePageObject.col_CreationDay(driver).getText(), creationDate);
		// Check From
		String OTList_From = "18:00 " + LocalDate.now().getMonthValue() + "-" + LocalDate.now().getDayOfMonth() + "-"
				+ +LocalDate.now().getYear();
		assertEquals(RequestOvertimePageObject.col_From(driver).getText(), OTList_From);
		// Check To
		String OTList_To = "21:00 " + LocalDate.now().getMonthValue() + "-" + LocalDate.now().getDayOfMonth() + "-"
				+ +LocalDate.now().getYear();
		assertEquals(RequestOvertimePageObject.col_To(driver).getText(), OTList_To);
		// Check Project
		assertEquals(RequestOvertimePageObject.col_Project(driver).getText(), ConstantVariable.PROJECT_VALID);
		// Check Reason
		assertEquals(RequestOvertimePageObject.col_Reason(driver).getText(), ConstantVariable.REASON_OT);
	}
}
