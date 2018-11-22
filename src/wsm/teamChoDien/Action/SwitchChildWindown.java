package wsm.teamChoDien.Action;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;

public class SwitchChildWindown {

	public static void switchChildWindown(WebDriver driver) {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		// iterate through your windows
		while (it.hasNext()) {
			String newwin = it.next();
			driver.switchTo().window(newwin);
		}
	}

}
