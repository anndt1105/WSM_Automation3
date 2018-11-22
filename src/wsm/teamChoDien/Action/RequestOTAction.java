package wsm.teamChoDien.Action;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import wsm.teamChoDien.PageObject.PersonalRequestsOTPageObject;

public class RequestOTAction {
	public static void requestOT(WebDriver driver, String branch, String group, String project, String fromDate,
			String toDate, String reason) throws InterruptedException {

		// Input data into branch field
		Select branchSelete = new Select(PersonalRequestsOTPageObject.txb_branch(driver));
		branchSelete.selectByValue(branch);

		// Input data into group field
		Select groupSelete = new Select(PersonalRequestsOTPageObject.txb_group(driver));
		groupSelete.selectByValue(group);

		// Input data into project field
		PersonalRequestsOTPageObject.txb_project(driver).sendKeys(project);

		// Input data into From date field
		PersonalRequestsOTPageObject.txb_from(driver).sendKeys(fromDate);
		Thread.sleep(300);

		// Input data into To date field
		PersonalRequestsOTPageObject.txb_to(driver).sendKeys(toDate);
		Thread.sleep(300);
		PersonalRequestsOTPageObject.txb_to(driver).clear();
		PersonalRequestsOTPageObject.txb_to(driver).sendKeys(toDate);
		Thread.sleep(300);

		// Input data into Reason field
		PersonalRequestsOTPageObject.txb_reason(driver).sendKeys(reason);

		// Save request
		PersonalRequestsOTPageObject.btn_saveRequest(driver).click();
	}

	public static void requestOTGroup(WebDriver driver, String branch, String group, String OTGroup, String project,
			String fromDate, String toDate, String reason) throws InterruptedException {

		// Input data into branch field
		Select branchSelete = new Select(PersonalRequestsOTPageObject.txb_branch(driver));
		branchSelete.selectByValue(branch);

		// Input data into group field
		Select groupSelete = new Select(PersonalRequestsOTPageObject.txb_group(driver));
		groupSelete.selectByValue(group);

		// Selected checkbox OT group
		PersonalRequestsOTPageObject.chb_OTGroup(driver).click();

		// Selected group OT
		Select OTGroupSelete = new Select(PersonalRequestsOTPageObject.drd_OTGroup(driver));
		OTGroupSelete.selectByValue(OTGroup);

		// Input data into project field
		PersonalRequestsOTPageObject.txb_project(driver).sendKeys(project);

		// Input data into From date field
		PersonalRequestsOTPageObject.txb_from(driver).sendKeys(fromDate);
		Thread.sleep(300);

		// Input data into To date field
		PersonalRequestsOTPageObject.txb_to(driver).sendKeys(toDate);
		Thread.sleep(300);
		PersonalRequestsOTPageObject.txb_to(driver).clear();
		PersonalRequestsOTPageObject.txb_to(driver).sendKeys(toDate);
		Thread.sleep(300);

		// Input data into Reason field
		PersonalRequestsOTPageObject.txb_reason(driver).sendKeys(reason);

		// Save request
		PersonalRequestsOTPageObject.btn_saveRequest(driver).click();
	}

}
