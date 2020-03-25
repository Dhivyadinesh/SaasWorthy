package mytestcase;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainPage {

	@Test
	public void verifyTitle() {

		System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.saasworthy.com/");
		driver.manage().window().maximize();
		
		
        //Featured Softwares
		List<WebElement> count = driver
				.findElements(By.xpath("/html/body/div[11]/div/div/div/div/div/div/div/div/span/a"));
		String title = driver.findElement(By.xpath("/html/body/div[11]/div/div/h3")).getText();
		int orginalcount = count.size();
		System.out.println("The " + title + " contains " + orginalcount + "pages");
		int expectedcount = 10;
		Assert.assertEquals(orginalcount, expectedcount);

		
		//Popular Softwares
		List<WebElement> count1 = driver
				.findElements(By.xpath("/html/body/div[12]/div/div/div/div/div/div/div/div/div/span/a"));
		String title1 = driver.findElement(By.xpath("/html/body/div[12]/div/div/h3")).getText();
		int orginalcount1 = count1.size();
		System.out.println("The " + title1 + " contains " + orginalcount1 + "pages");
		int expectedcount1 = 10;
		Assert.assertEquals(orginalcount1, expectedcount1);

		
		//Trending Softwares
		List<WebElement> count2 = driver
				.findElements(By.xpath("/html/body/div[14]/div/div/div/div/div/div/div/div/span/a"));
		String title2 = driver.findElement(By.xpath("/html/body/div[14]/div/div/h3")).getText();
		int orginalcount2 = count2.size();
		System.out.println("The " + title2 + " contains " + orginalcount2 + "pages");
		int expectedcount2 = 10;
		Assert.assertEquals(orginalcount2, expectedcount2);

		
		//New Softwares
		List<WebElement> count3 = driver
				.findElements(By.xpath("/html/body/div[16]/div/div/div/div/div/div/div/div/span/a"));
		String title3 = driver.findElement(By.xpath("/html/body/div[16]/div/div/h3")).getText();
		int orginalcount3 = count3.size();
		System.out.println("The " + title3 + " contains " + orginalcount3 + "pages");
		int expectedcount3 = 10;
		Assert.assertEquals(orginalcount3, expectedcount3);

		
		//Editor Picks 
		List<WebElement> count4 = driver.findElements(By.xpath("/html/body/div[17]/div/div/div/div/div/div/div/div/a"));
		String title4 = driver.findElement(By.xpath("/html/body/div[17]/div/div/h2")).getText();
		int orginalcount4 = count4.size();
		System.out.println("The " + title4 + " contains " + orginalcount4 + "pages");
		int expectedcount4 = 10;
		Assert.assertEquals(orginalcount4, expectedcount4);

		
		//Latest Articles 
		List<WebElement> count5 = driver.findElements(By.xpath("/html/body/div[18]/div/div/div/div/div/div/div/div/a"));
		String title5 = driver.findElement(By.xpath("/html/body/div[18]/div/div/h2")).getText();
		int orginalcount5 = count5.size();
		System.out.println("The " + title5 + " contains " + orginalcount5 + "pages");
		int expectedcount5 = 10;
		Assert.assertEquals(orginalcount5, expectedcount5);
		
		
		//Questions
		List<WebElement> count6 = driver.findElements(By.xpath("/html/body/div[19]/div/div/div/div[2]/a"));
		String title6 = driver.findElement(By.xpath("/html/body/div[19]/div/h2")).getText();
		int orginalcount6 = count6.size();
		System.out.println("The " + title6 + " contains " + orginalcount6 + "pages");
		int expectedcount6 = 6;
		Assert.assertEquals(orginalcount6, expectedcount6);
		
		List<WebElement> count7 = driver.findElements(By.xpath("/html/body/div[21]/div/div/div"));
		String title7 = driver.findElement(By.xpath("//h3[@id='all_categories']")).getText();
		int count56 = count7.size();
		System.out.println("The Total number of "+title7+"count"+count56);

		driver.close();
	}
}
