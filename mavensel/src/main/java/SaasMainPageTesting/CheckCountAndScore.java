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

public class CheckCountAndScore {
	public static void main(String[] args) throws SQLException, InterruptedException {
		System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.saasworthy.com/");
		driver.manage().window().maximize();
		WebElement xpath = driver.findElement(By.xpath("/html/body/div[21]/div/div/div"));
		List<WebElement> tag = xpath.findElements(By.tagName("a"));
            for(WebElement link : tag) {
            String catlink = link.getAttribute("href");
		    System.out.println(catlink);
		    Scanner scan = new Scanner(catlink);
			while (scan.hasNextLine()) {
				String searchkey = scan.nextLine();
				driver.get(searchkey);
				int productCount = driver
						.findElements(By.xpath("//a[@class='fndr-title']")).size();
				System.out.println(productCount);
				String productName = null;
				List<WebElement> tag1 = driver.findElements(By.xpath("//a[@class='fndr-title']"));
				for(WebElement Name : tag1) {
					productName = Name.getText();
				}
			  System.out.println(productName);
			}
			}
            }
	}