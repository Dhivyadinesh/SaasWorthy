package BasicTestCase;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TextFieldLimitedValue {		

		public static void main(String[] args) throws Exception {
			System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.saasworthy.com/");
			driver.manage().window().maximize();
			//loginpageusername
			driver.findElement(By.partialLinkText("Login")).click();
			WebElement username = driver.findElement(By.xpath("/html/body/div[3]/div/div/div[4]/input[1]"));								        
		    username.sendKeys("dinesh@gmail.com");
		    String usernameStore =  username.getAttribute("value");  
	        int usernamesize = usernameStore.length();
			System.out.println(usernamesize);
			if(usernamesize < 256) {
				System.out.println("It has Limited Values");
			}else {
				System.out.println("It has Crossed The limited Values");
			}
			//loginpagepassword
			WebElement password = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]/div[4]/input[2]"));								        
		    password.sendKeys("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
		    String passwordStore =  password.getAttribute("value");  
	        int passwordsize = passwordStore.length();
			System.out.println(passwordsize);
			if(passwordsize < 256) {
				System.out.println("It has Limited Values");
			}else {
				System.out.println("It has Crossed The limited Values");
			}
			driver.findElement(By.xpath("//div[@id='loginpopup']//a[@class='close']")).click();
	        //listpage
			driver.findElement(By.partialLinkText("Web Analytics Software")).click();
			WebElement Email = driver.findElement(By.xpath("/html[1]/body[1]/div[12]/div[1]/div[4]/div[1]/div[2]/input[1]"));								        
		    Email.sendKeys("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
		    String EmailStore =  Email.getAttribute("value");  
	        int emailsize = EmailStore.length();
			System.out.println(emailsize);
			if(emailsize < 256) {
				System.out.println("It has Limited Values");
			}else {
				System.out.println("It has Crossed The limited Values");
			}
		}
		   
	}
