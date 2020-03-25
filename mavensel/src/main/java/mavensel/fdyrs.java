package mavensel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class fdyrs {
	public static void main(String args[]) throws InterruptedException{

	
		System.setProperty("webdriver.chrome.driver", "/home/dinesh/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.91mobiles.com/upcoming-mobiles-in-india");	
	    String oldTab = driver.getWindowHandle();
	    driver.findElements(By.xpath("//a[@data-type='name']"));
	   
	    ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
	    newTab.remove(oldTab);

	    driver.switchTo().window(newTab.get(0));
	    System.out.println("titele"+driver.getTitle());
	    driver.close();
	    
	    driver.switchTo().window(oldTab);
	    System.out.println("titele"+driver.getTitle());
	   	}

	
	}

		
