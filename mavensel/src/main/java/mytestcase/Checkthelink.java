package mytestcase;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Checkthelink {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.saasworthy.com/");
		driver.manage().window().maximize();
		List<WebElement> data = driver.findElements(By.className("item_blu_titl"));
		for (WebElement dat : data) {
			dat.click();
			System.out.println(" title is" + dat.getText());
		}	}

}
