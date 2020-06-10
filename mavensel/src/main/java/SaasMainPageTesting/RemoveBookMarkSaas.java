package SaasMainPageTesting;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RemoveBookMarkSaas {

	public static void main(String[] args) {
	    System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
    	WebDriver driver = new FirefoxDriver();
    	driver.get("https://www.saasworthy.com/");

		driver.findElement(By.partialLinkText("Smartsheet")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[11]/div[1]/div[2]/div[2]/i[1]")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[4]/input[1]")).sendKeys("yashwanth@saasworthy.com");							
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[4]/input[2]")).sendKeys("9!Mobiles");							
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[4]/button")).click();
        driver.findElement(By.xpath("//div[@class='usr_wrap']"));
        driver.findElement(By.partialLinkText("Shortlisted Softwares")).click();
    
	}

}