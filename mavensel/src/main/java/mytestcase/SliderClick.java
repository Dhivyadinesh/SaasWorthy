package mytestcase;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SliderClick {
	
	WebDriver driver;
	String url ="https://www.saasworthy.com/";
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test
	public void beforeScrolling() {
		List<WebElement> name = driver.findElements(By.xpath("/html/body/div[11]/div/div/div/div/div/div/div/div[2]/span[2]/center/a"));
		for(WebElement productLink : name ) {
			productLink.click();
		}
	}
	
	@Test
	public void scrol() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		driver.findElement(By.xpath("/html/body/div[11]/div/div/div/div/button[2]")).click();
	}
}
