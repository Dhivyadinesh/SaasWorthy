package BasicTestCase;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchFieldinmainpage {

	public static void main(String[] args)throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
		String homePage = "https://www.saasworthy.com/search?";
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(homePage);
        driver.findElement(By.xpath("//input[@id='searchBox1']")).sendKeys("streamyard");
        driver.findElement(By.xpath("//input[@class='searchbtn']")).click();
        driver.findElement(By.linkText("streamyard")).click();
	    }
	}
