package SaasMainPageTesting;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginSaasPage {
	
	@Test
	public void login() { 
        try {
		System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		String url ="https://www.saasworthy.com/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[4]/input[1]")).sendKeys("yashwanth@saasworthy.com");							
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[4]/input[2]")).sendKeys("9!Mobiles");							
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[4]/button")).click();
        driver.findElement(By.partialLinkText("Smartsheet")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[11]/div[1]/div[2]/div[2]/i[1]")).click();
        }catch(Exception e) {
        	System.out.println("Unable to Login");
        }
	}
}
