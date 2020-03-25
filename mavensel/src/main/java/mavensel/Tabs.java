package mavensel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Tabs {
	public static void main(String args[]) {
		 System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
		WebDriver driver = new FirefoxDriver();
	
		driver.get("https://www.91mobiles.com/");
        new Actions(driver).moveToElement(driver.findElement(By.linkText("Upcoming Mobiles"))).build().perform();
	    driver.findElement(By.linkText("Xiaomi Redmi K30")).click();
	    List<WebElement> Links1 = driver.findElements(By.xpath("//div[@class='price_div']"));
		for (WebElement url1 : Links1) {
			System.out.println(url1.getText());
		}
		driver.close();
	}
}