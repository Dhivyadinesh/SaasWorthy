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
		driver.get("https://www.saasworthy.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[4]/input[1]")).sendKeys("dd@gmail.com");							
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[4]/input[2]")).sendKeys("qazwsxedc");							
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[4]/button")).click();					
        System.out.println("Login Done");					
        }catch(Exception e) {
        	System.out.println("Unable to Login");
        }
	}
}
