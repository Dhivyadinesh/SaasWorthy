package mytestcase;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Pagination {
	
	public static void main(String[] args){
		
		System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.saasworthy.com/list/api-management-software");
		driver.manage().window().maximize();
		List<WebElement> pagination = driver.findElements(By.xpath("//ul[@class='pagination']/li/a"));

        if(pagination .size()>0){
        	System.out.println(" pagination exits");
        	
        	for(int i = 0; i<pagination.size() ; i++) {
        		 pagination.get(i).click(); 
        	}
            }
        	else {
        		System.out.println("pagination not exits");
        	}
        }
	}
