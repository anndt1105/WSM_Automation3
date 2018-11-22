package wsm.teamChoDien.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PersonalRequestsOTPageObject {
	private static WebElement element = null;

	// Find title page Request Overtime
	public static WebElement txt_titleOT(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/h1"));
		return element;
	}

	// Find button Create Request Overtime
	public static WebElement btn_createRequest(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[3]/a"));
		return element;
	}

	// Find button New request overtime
	public static WebElement txt_titleNewRequest(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div[2]/div/div/div[1]/h3"));
		return element;
	}

	// Find field StaffName
	public static WebElement txb_staffName(WebDriver driver) {
		element = driver.findElement(By.id("employee_name"));
		return element;
	}

	// Find field Staff Code
	public static WebElement txb_staffCode(WebDriver driver) {
		element = driver.findElement(By.id("employee_code"));
		return element;
	}

	// Find field branch
	public static WebElement txb_branch(WebDriver driver) {
		element = driver.findElement(By.id("request_ot_workspace_id"));
		return element;
	}

	// Find field Group
	public static WebElement txb_group(WebDriver driver) {
		element = driver.findElement(By.id("group-selection"));
		return element;
	}

	// Find OT Group checkbox
	public static WebElement chb_OTGroup(WebDriver driver) {
		element = driver.findElement(By.xpath("//span[contains(text(),'Do you OT for other group?')]"));
		return element;
	}

	// Find field OTGroup
	public static WebElement drd_OTGroup(WebDriver driver) {
		element = driver.findElement(By.id("request_ot_other_group_id"));
		return element;
	}

	// Find field Project
	public static WebElement txb_project(WebDriver driver) {
		element = driver.findElement(By.id("request_ot_project_name"));
		return element;
	}

	// Find field From
	public static WebElement txb_from(WebDriver driver) {
		element = driver.findElement(By.id("request_ot_from_time"));
		return element;
	}

	// Find field To
	public static WebElement txb_to(WebDriver driver) {
		element = driver.findElement(By.id("request_ot_end_time"));
		return element;
	}

	// Find field Reason
	public static WebElement txb_reason(WebDriver driver) {
		element = driver.findElement(By.id("request_ot_reason"));
		return element;
	}

	// Find field Reason
	public static WebElement btn_saveRequest(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"new_request_ot\"]/input[3]"));
		return element;
	}

	// Find message create OT unsuccessfully
	public static WebElement mess_requestOTUnsuccessfully(WebDriver driver) {
		element = driver.findElement(By.className("text-danger"));
		return element;
	}
  
	//Find message validate create OT when project field is blank
	public static WebElement mess_projectBlank(WebDriver driver) {
		element = driver.findElement(By.id("request_ot_project_name-error"));
		return element;
	}
	
	//Find message validate create OT when FROM DATE field is blank
	public static WebElement mess_fromDATEBlank(WebDriver driver) {
		element = driver.findElement(By.id("request_ot_from_time-error"));
		return element;
	}
	
	//Find message validate create OT when TO DATE field is blank
	public static WebElement mess_toDATEBlank(WebDriver driver) {
		element = driver.findElement(By.id("request_ot_end_time-error"));
		return element;
	}
	
	//Find message validate create OT when REASON field is blank
	public static WebElement mess_reasonBlank(WebDriver driver) {
		element = driver.findElement(By.id("request_ot_reason-error"));
		return element;
	}
	
	// Find message create OT successfully
	public static WebElement mess_requestOTSuccessfully(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"flash-message\"]"));
		return element;
	}
	
	//Find label Staff name
	public static WebElement label_staffName(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"new_request_ot\"]/div[1]/div[1]/label"));
		return element;
	}
	
	//Find label Staff code
	public static WebElement label_staffCode(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"new_request_ot\"]/div[1]/div[2]/label"));
		return element;
	}
	
	//Find label Branch
	public static WebElement label_branch(WebDriver driver) {
	element = driver.findElement(By.xpath("//*[@id=\"new_request_ot\"]/div[2]/div[1]/div/label"));
	return element;
	}
	
	//Find label Group
	public static WebElement label_group(WebDriver driver) {
	element = driver.findElement(By.xpath("//*[@id=\"new_request_ot\"]/div[2]/div[2]/div/label"));
	return element;
	}

	// Find label Do you OT for other group
	public static WebElement label_doYouOT(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"new_request_ot\"]/div[3]/label/span"));
		return element;
	}

	// Find label Project
	public static WebElement label_project(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"new_request_ot\"]/div[5]/label"));
		return element;
	}

	// Find label From
	public static WebElement label_from(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"new_request_ot\"]/div[6]/div[1]/label"));
		return element;
	}
	
	//Find label To
	public static WebElement label_to(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"new_request_ot\"]/div[6]/div[2]/label"));
		return element;
	}
	
	//Find label Reason
	public static WebElement label_reason(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"new_request_ot\"]/div[7]/label"));
		return element;
	}
	
}
