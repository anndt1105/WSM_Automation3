package wsm.teamChoDien.Action;

import org.openqa.selenium.WebDriver;

import wsm.teamChoDien.PageObject.DashboardPageObject;

public class ClosePopupDayOffAction {
	public static void closePopup(WebDriver driver) {
		DashboardPageObject.popup_CloseDayOff(driver).click();
	}
}
