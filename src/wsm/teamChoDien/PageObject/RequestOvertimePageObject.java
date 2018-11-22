package wsm.teamChoDien.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RequestOvertimePageObject {

	private static WebElement element = null;

	// Finding element TITLE of Request Overtime button
	public static WebElement lb_title(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/h1"));
		return element;
	}

	// Finding element Delete button
	public static WebElement btn_deleteRequest(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[5]/div[1]/div[2]/div/table/tbody/tr/td[11]/a[2]"));
		return element;
	}
  
	// Finding element Employee code column
	public static WebElement col_EmployeeCode(WebDriver driver) {
		element = driver.findElement(
				By.xpath("//*[@id=\"main-container\"]/div[2]/div[5]/div[1]/div[2]/div/table/tbody/tr[1]/td[1]"));
		return element;
	}

	// Finding element Employee name column
	public static WebElement col_StaffName(WebDriver driver) {
		element = driver.findElement(
				By.xpath("//*[@id=\"main-container\"]/div[2]/div[5]/div[1]/div[2]/div/table/tbody/tr[1]/td[2]"));
		return element;
	}

	// Finding element Employee name column
	public static WebElement col_CreationDay(WebDriver driver) {
		element = driver.findElement(
				By.xpath("//*[@id=\"main-container\"]/div[2]/div[5]/div[1]/div[2]/div/table/tbody/tr[1]/td[3]"));
		return element;
	}

	// Finding element Employee name column
	public static WebElement col_From(WebDriver driver) {
		element = driver.findElement(
				By.xpath("//*[@id=\"main-container\"]/div[2]/div[5]/div[1]/div[2]/div/table/tbody/tr[1]/td[4]"));
		return element;
	}

	// Finding element Employee name column
	public static WebElement col_To(WebDriver driver) {
		element = driver.findElement(
				By.xpath("//*[@id=\"main-container\"]/div[2]/div[5]/div[1]/div[2]/div/table/tbody/tr[1]/td[5]"));
		return element;
	}

	// Finding element Employee name column
	public static WebElement col_Project(WebDriver driver) {
		element = driver.findElement(
				By.xpath("//*[@id=\"main-container\"]/div[2]/div[5]/div[1]/div[2]/div/table/tbody/tr[1]/td[6]"));
		return element;
	}

	// Finding element Reason column
	public static WebElement col_Reason(WebDriver driver) {
		element = driver.findElement(
				By.xpath("//*[@id=\"main-container\"]/div[2]/div[5]/div[1]/div[2]/div/table/tbody/tr[1]/td[7]"));
		return element;
	}
}
