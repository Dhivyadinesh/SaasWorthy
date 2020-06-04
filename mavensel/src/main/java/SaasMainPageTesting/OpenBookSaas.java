package Saas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBookSaas {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url ="https://www.saasworthy.com/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[4]/input[1]")).sendKeys("yashwanth@saasworthy.com");							
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[4]/input[2]")).sendKeys("9!Mobiles");							
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[4]/button")).click();
		driver.navigate().refresh();
        driver.findElement(By.partialLinkText("Smartsheet")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[11]/div[1]/div[2]/div[2]/i")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div[4]/div/span[4]")).click();
        driver.findElement(By.partialLinkText("Shortlisted Softwares")).click();
        System.out.println("Login Finished");
       	}
}
