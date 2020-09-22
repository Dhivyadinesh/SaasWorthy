package BasicTestCase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Mandatoryfieldinlistpage {
public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		String url = "https://www.saasworthy.com/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.partialLinkText("Web Analytics Software")).click();
	    String CatgyName = driver.findElement(By.xpath("//h1[@class='list_titl titl_width']")).getText();
		String totalCount = driver.findElement(By.xpath("//span[@id='totallistCount']")).getText();
		System.out.println("The total count of "+CatgyName+" is "+totalCount);
		String pagination=driver.findElement(By.xpath("//ul[@class='pagination']/li[last()]")).getText();
		System.out.println("The "+CatgyName+" has contains "+pagination+" number of pages");
		int paginationCount=Integer.parseInt(pagination);  
		String currentURL;
		int ProductCount = 0;
		boolean description,allsoftware,mostworthy,fastestgrowing,mostpopular,
		features,swscore,deployment,customertypes,pricingmodel,
		integrated,listtable,guide,relatedcategories,ebooks;
		currentURL = driver.getCurrentUrl();
		for(int i=1;i<=paginationCount;i++) {
			String ListPaginationUrl =  currentURL+"?page="+i;
			System.out.println(ListPaginationUrl);
			driver.get(ListPaginationUrl);
			description = driver.findElement(By.xpath("/html[1]/body[1]/div[10]/div[1]/div[2]/p[1]")).isDisplayed();
			allsoftware = driver.findElement(By.xpath("/html[1]/body[1]/div[11]/ul[1]/li[1]/a[1]")).isDisplayed();
			mostworthy= driver.findElement(By.xpath("/html[1]/body[1]/div[11]/ul[1]/li[2]/a[1]")).isDisplayed();
			fastestgrowing = driver.findElement(By.xpath("/html[1]/body[1]/div[11]/ul[1]/li[3]/a[1]")).isDisplayed();
			mostpopular = driver.findElement(By.xpath("/html[1]/body[1]/div[11]/ul[1]/li[4]/a[1]")).isDisplayed();
			features = driver.findElement(By.xpath("/html[1]/body[1]/div[12]/div[2]/div[2]/span[2]/div[1]/span[1]")).isDisplayed();
			swscore = driver.findElement(By.xpath("/html[1]/body[1]/div[12]/div[2]/div[2]/span[2]/div[2]/span[1]")).isDisplayed();
			deployment = driver.findElement(By.xpath("/html[1]/body[1]/div[12]/div[2]/div[2]/span[2]/div[3]/span[1]")).isDisplayed();
			customertypes = driver.findElement(By.xpath("/html[1]/body[1]/div[12]/div[2]/div[2]/span[2]/div[4]/span[1]")).isDisplayed();
			pricingmodel = driver.findElement(By.xpath("/html[1]/body[1]/div[12]/div[2]/div[2]/span[2]/div[5]/span[1]")).isDisplayed();
			integrated = driver.findElement(By.xpath("/html[1]/body[1]/div[12]/div[2]/div[2]/span[2]/div[6]/span[1]")).isDisplayed();
			ProductCount = driver.findElements(By.xpath("//a[@class='fndr-title']")).size();
			listtable = driver.findElement(By.xpath("//span[@id='list-summary']")).isDisplayed();
			guide = driver.findElement(By.xpath("/html[1]/body[1]/div[18]/div[1]/h3[1]")).isDisplayed();
			relatedcategories = driver.findElement(By.xpath("//h3[contains(text(),'Related Categories')]")).isDisplayed();
			ebooks=driver.findElement(By.xpath("//h3[contains(text(),'Download white papers and ebooks on Web Analytics')]")).isDisplayed();
            System.out.println("description = "+description+","+"allsoftware ="+allsoftware+","
            		+"mostworthy="+mostworthy+","+"fastestgrowing = "+fastestgrowing+","+
            		"mostpopular ="+mostpopular+","+"features =" +features+","+
            		"swscore = "+swscore+","+"deployment ="+deployment+","+
            		"customertypes ="+customertypes+","+"pricingmodel ="+pricingmodel+","+
		            "integrated ="+integrated+","+"listtable = "+listtable+","+
            		"guide ="+guide+","+"relatedcategories ="+relatedcategories+","+"ebooks="+ebooks);			
		}
		}
   }
