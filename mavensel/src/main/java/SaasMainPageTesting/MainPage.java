package SaasMainPageTesting;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainPage {

	@Test
	public void verifyTitle() {

		System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.saasworthy.com/");
		driver.manage().window().maximize();
		
        //Popular Categories
		int orginalcount = driver
				.findElements(By.xpath("/html/body/div[9]/div/div[1]/div/ul/li/a")).size();
		String title = driver.findElement(By.xpath("/html/body/div[9]/div/div[1]/h2")).getText();
		System.out.println("The " + title + " contains " + orginalcount + "pages");
		int expectedcount = 6;
		Assert.assertEquals(orginalcount, expectedcount);
		System.out.println("Assert passed");
		
        //Trending Categories
		int orginalcount1 = driver
				.findElements(By.xpath("/html/body/div[9]/div/div[2]/div/ul/li/a")).size();
		String title1 = driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/h2")).getText();
		System.out.println("The " + title1 + " contains " + orginalcount1 + "pages");
		int expectedcount1 = 6;
		Assert.assertEquals(orginalcount1, expectedcount1);
		System.out.println("Assert passed");
		
        //Latest Categories
		int orginalcount2 = driver
				.findElements(By.xpath("/html/body/div[9]/div/div[3]/div/ul/li/a")).size();
		String title2 = driver.findElement(By.xpath("/html/body/div[9]/div/div[3]/h2")).getText();
		System.out.println("The " + title2 + " contains " + orginalcount2 + "pages");
		int expectedcount2 = 6;
		Assert.assertEquals(orginalcount2, expectedcount2);
		System.out.println("Assert passed");
		
		
        //Featured Softwares
		int orginalcount3 = driver
				.findElements(By.xpath("/html/body/div[11]/div/div/div/div/div/div/div/div/span/a")).size();
		String title3 = driver.findElement(By.xpath("/html/body/div[11]/div/div/h3")).getText();
		System.out.println("The " + title3 + " contains " + orginalcount3 + "pages");
		int expectedcount3 = 10;
		Assert.assertEquals(orginalcount3, expectedcount3);
		System.out.println("Assert passed");
	
		//Popular Softwares
		int orginalcount4 = driver
				.findElements(By.xpath("/html/body/div[12]/div/div/div/div/div/div/div/div/div/span/a")).size();
		String title4 = driver.findElement(By.xpath("/html/body/div[12]/div/div/h3")).getText();
		System.out.println("The " + title4 + " contains " + orginalcount4 + "pages");
		int expectedcount4 = 10;
		Assert.assertEquals(orginalcount4, expectedcount4);
		System.out.println("Assert passed");

		
		//Trending Softwares
		int orginalcount5 = driver
				.findElements(By.xpath("/html/body/div[14]/div/div/div/div/div/div/div/div/span/a")).size();
		String title5 = driver.findElement(By.xpath("/html/body/div[14]/div/div/h3")).getText();
		System.out.println("The " + title5 + " contains " + orginalcount5 + "pages");
		int expectedcount5 = 10;
		Assert.assertEquals(orginalcount5, expectedcount5);
		System.out.println("Assert passed");

		
		//New Softwares
		int orginalcount6 = driver
				.findElements(By.xpath("/html/body/div[16]/div/div/div/div/div/div/div/div/span/a")).size();
		String title6 = driver.findElement(By.xpath("/html/body/div[16]/div/div/h3")).getText();
		System.out.println("The " + title6 + " contains " + orginalcount6 + "pages");
		int expectedcount6 = 10;
		Assert.assertEquals(orginalcount6, expectedcount6);
		System.out.println("Assert passed");

		
		//Editor Picks 
		int orginalcount7= driver.findElements(By.xpath("/html/body/div[17]/div/div/div/div/div/div/div/div/a")).size();
		String title7 = driver.findElement(By.cssSelector("div.full_width:nth-child(18) > div:nth-child(1) > div:nth-child(1) > h2:nth-child(1)")).getText();
		System.out.println("The " + title7 + " contains " + orginalcount7 + "pages");
		int expectedcount7 = 10;
		Assert.assertEquals(orginalcount7, expectedcount7);
		System.out.println("Assert passed");

		
		//Latest Articles 
		int orginalcount8 = driver.findElements(By.xpath("/html/body/div[18]/div/div/div/div/div/div/div/div/a")).size();
		String title8 = driver.findElement(By.xpath("/html/body/div[18]/div/div/h2")).getText();
		System.out.println("The " + title8 + " contains " + orginalcount8 + "pages");
		int expectedcount8 = 10;
		Assert.assertEquals(orginalcount8, expectedcount8);
		System.out.println("Assert passed");
		
		
		//Questions
		int orginalcount9 = driver.findElements(By.xpath("/html/body/div[19]/div/div/div/div[2]/a")).size();
		String title9 = driver.findElement(By.xpath("/html/body/div[19]/div/h2")).getText();
		System.out.println("The " + title9 + " contains " + orginalcount9 + "pages");
		int expectedcount9 = 6;
		System.out.println("Assert passed");
		Assert.assertEquals(orginalcount9, expectedcount9);
		
		
		driver.close();
	}
}
