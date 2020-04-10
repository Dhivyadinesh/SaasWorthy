package mytestcase;

import java.sql.SQLException;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Data {
	public static void main(String[] args) throws SQLException, InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		String url ="https://www.saasworthy.com/";
		driver.get(url);
		driver.manage().window().maximize();
			List<WebElement> href = driver.findElements(By.xpath("/html/body/div[12]/div/div/div/div/div/div/div/div/div[2]/span[2]/center/a"));
			for(WebElement dat1: href) {
				dat1.click();
			}
			driver.findElement(By.xpath("/html/body/div[12]/div/div/div/div/div/button[2]")).click();

		}
}