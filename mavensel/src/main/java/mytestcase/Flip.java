package mytestcase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Flip {
	
	public static void main(String[] args) throws InterruptedException {

	System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
	WebDriver driver = new FirefoxDriver();
	driver.get("https://www.saasworthy.com/");
	driver.manage().window().maximize();
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,1400)");
	
	List<WebElement> name = driver.findElements(By.xpath("/html/body/div[14]/div/div/div/div/div/div/div/div[2]/span[1]/a"));
	for(WebElement productLink : name ) {
		productLink.click();
		driver.wait(1000);

		driver.findElement(By.xpath("/html/body/div[12]/div/div/div/div/div/button[2]")).click();
	   }
	}
}
