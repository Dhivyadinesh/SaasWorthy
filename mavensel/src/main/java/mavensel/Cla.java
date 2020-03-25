package mavensel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cla {
	@Test
public void dat() throws InterruptedException {		
	 WebDriver driver;
    
         System.setProperty("webdriver.chrome.driver", "/home/dinesh/Downloads/chromedriver");
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.get("https://www.snapdeal.com/products/mens-footwear-loafers?sort=plrty");
     
         JavascriptExecutor jse = (JavascriptExecutor)driver;
         jse.executeScript("window.scrollBy(0,200)", ""); 
         driver.findElement(By.xpath("//*[@id='products']/section")).click();
         System.out.println(driver.findElements(By.xpath("//p[@class='product-title']")));
         Thread.sleep(1000);
        
         driver.quit();
  }

}
