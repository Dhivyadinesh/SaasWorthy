package mytestcase;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyTestCase {

	@Test
	public void verifyTitle() {

		System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.saasworthy.com/");
		driver.manage().window().maximize();

		List<WebElement> pro = driver.findElements(By.className("cat_div"));
		for (WebElement data : pro) {
				List<WebElement> count1 = data.findElements(By.xpath("/html/body/div[9]/div/div[1]/div/ul/li/a"));
				int orginalcount = count1.size();
				List<WebElement> topic = data.findElements(By.xpath("//h2[@class='blu_titl orng_titl_brdr']"));
				for(WebElement data1:topic) {
					String topic1 = data1.getText();
			
			    System.out.println("The page Contains " + orginalcount + "topic is"+topic1);
				int expectedcount = 6;
				Assert.assertEquals(orginalcount, expectedcount);
			}
		}
		driver.close();
	}
}
