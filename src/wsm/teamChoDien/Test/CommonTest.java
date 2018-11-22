package wsm.teamChoDien.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import wsm.teamChoDien.Utility.ConstantVariable;

public class CommonTest {
	public static WebDriver driver;

	@BeforeMethod
	public void beforeTest() {
		
		// Using Chrome browser
		System.setProperty("webdriver.chrome.driver", "E:\\Thuy\\Auto\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(ConstantVariable.URL);
	}

	@AfterMethod
	public void afterTest() {
		driver.quit();
	}

}
