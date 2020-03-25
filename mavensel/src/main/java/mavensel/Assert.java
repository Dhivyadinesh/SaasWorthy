package mavensel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Assert {
	@Test
	 void verifyTest(){
		 WebDriver driver;
		 System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
		 driver = new FirefoxDriver();
		 driver.manage().window().maximize();
         driver.get("https://www.amazon.com");
		 String ActualTitle = driver.getTitle();
		 String ExpectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel Computers, Books, DVDs & more";
	     assertEquals(ActualTitle,ExpectedTitle);
	     System.out.println(ActualTitle);
		 driver.close(); 
	}
}
