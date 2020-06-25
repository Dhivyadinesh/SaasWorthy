package SaasMainPageTesting;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ListPagecountSwcore {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.saasworthy.com/");
		driver.manage().window().maximize();
		WebElement xpath = driver.findElement(By.xpath("/html/body/div[21]/div/div/div"));
		List<WebElement> tag = xpath.findElements(By.tagName("a"));
		for (WebElement link : tag) {
			String catlink = link.getAttribute("href");
			System.out.println(catlink);
			driver.get(catlink);
			int productCount = driver.findElements(By.xpath("//a[@class='fndr-title']")).size();
			System.out.println(productCount);
			String productName = null;
			boolean productSwscore = false;
			WebElement tag1 = driver.findElement(By.xpath("//div[@class='fndr-right']"));
			List<WebElement> Name = tag1.findElements(By.xpath("//a[@class='fndr-title']"));
			for (WebElement name : Name) {
				productName = name.getText();
				System.out.println(productName);
			}
			List<WebElement> Swscore = tag1.findElements(By.xpath("//div[@class='rating_box']"));
			for (WebElement score : Swscore) {
				productSwscore = score.isDisplayed();
				System.out.println(productSwscore);

			}

		}
	}
}