package mytestcase;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Acdf {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		String url = "https://www.saasworthy.com/";
		driver.get(url);
		int dat = driver.findElements(By.xpath("/html/body/div[21]/div/div/div/div/ul/li/a")).size();
		System.out.println(dat);
		List<WebElement> dat1 = driver.findElements(By.xpath("/html/body/div[21]/div/div/div/div/ul/li/a"));
		for (WebElement da : dat1) {
			da.click();
			String CatgyName = driver.findElement(By.xpath("//h1[@class='list_titl titl_width']")).getText();
			String totalCount = driver.findElement(By.xpath("//span[@id='totallistCount']")).getText();
			System.out.println("The total count of " + CatgyName + " is " + totalCount);

			List<WebElement> pagination = driver.findElements(By.xpath("//ul[@class='pagination']/li/a"));
			int paginationcount = pagination.size();
			System.out.println("The " + CatgyName + " has contains " + paginationcount + " number of pages");

			String url1 = driver.getCurrentUrl();
			String url2 = url1 + "?page=";
			for (int i = 1; i <= paginationcount; i++) {
				String url3 = url2 + i;
				driver.get(url3);
				List<WebElement> paginationList = driver.findElements(By.className("fndr-title"));
				int Count = paginationList.size();
				String pageCount = driver.findElement(By.tagName("b")).getText();

				System.out.println(
						"Page " + i + " has " + "[" + pageCount + "]" + Count + " Number of software in the page");
			}
			driver.get(url);
		}
	}

}
