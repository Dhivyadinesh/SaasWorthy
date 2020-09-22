package BasicTestCase;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckPaginationinlistpage {

	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		String url = "https://www.saasworthy.com/";
		driver.get(url);
		driver.manage().window().maximize();
		   driver.findElement(By.partialLinkText("Time Tracking Software")).click();
		   String CatgyName = driver.findElement(By.xpath("//h1[@class='list_titl titl_width']")).getText();
		String totalCount = driver.findElement(By.xpath("//span[@id='totallistCount']")).getText();
		System.out.println("The total count of "+CatgyName+" is "+totalCount);
		String pagination=driver.findElement(By.xpath("//ul[@class='pagination']/li[last()]")).getText();
		System.out.println("The "+CatgyName+" has contains "+pagination+" number of pages");
		int paginationCount=Integer.parseInt(pagination);  
		String currentURL;
		currentURL = driver.getCurrentUrl();
		for(int i=1;i<=paginationCount;i++) {
		String ListPaginationUrl =  currentURL+"?page="+i;
		System.out.println(ListPaginationUrl);
		driver.get(ListPaginationUrl);
		int ProductCount;
		ProductCount = driver.findElements(By.xpath("//a[@class='fndr-title']")).size();
		System.out.println(ProductCount);
		}
   }
}
