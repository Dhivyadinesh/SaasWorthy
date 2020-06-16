package SaasMainPageTesting;

import java.time.Duration;
import java.util.function.Function;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class AddBookmarkSaas {
	public static void main(String[] args) {
    
		System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
    	WebDriver driver = new FirefoxDriver();
    	driver.get("https://www.saasworthy.com/");
    	driver.manage().window().maximize();
		driver.findElement(By.partialLinkText("Smartsheet")).click();
	    driver.findElement(By.xpath("//i[@class='saas_icn favrt_icn ']")).click();
		
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[4]/input[1]")).sendKeys("yashwanth@saasworthy.com");							
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[4]/input[2]")).sendKeys("9!Mobiles");							
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[4]/button")).click();
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
        		 .withTimeout(Duration.ofSeconds(30))
        	     .pollingEvery(Duration.ofSeconds(5))
        	     .ignoring(NoSuchElementException.class);
         WebElement element = wait.until(new Function<WebDriver, WebElement>() {
             public WebElement apply(WebDriver driver) {
               return driver.findElement(By.className("usr_dp"));
             }
           });
         Actions action = new Actions(driver);
         action.moveToElement(element).build().perform();
         WebElement shortlistElem = wait.until(new Function<WebDriver, WebElement>() {
             public WebElement apply(WebDriver driver) {
               return driver.findElement(By.partialLinkText("Shortlisted Softwares"));
             }
           });
         action.moveToElement(shortlistElem).click().perform();
         System.out.println("Product Added into Bookmark");
         System.exit(1);


	}
}
