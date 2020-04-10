package SaasProductXmlfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadSaasProductListXmlFileAndUploadInDB {
	public static void main(String[] args) throws SQLException, InterruptedException, ParserConfigurationException, SAXException, IOException {
		String url = "jdbc:mysql://localhost:3306/saas";
		String username = "root";
		String password = "dineshdd";
		File xmlFile = new File("/home/dinesh/Downloads/product_sitemap_google.xml");
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
			DocumentBuilder db = dbf.newDocumentBuilder();  
			Document doc = db.parse(xmlFile);  
			doc.getDocumentElement().normalize();  
			NodeList nodeList = doc.getElementsByTagName("url");
			for (int i = 0; i < nodeList.getLength(); i++)  {
				Node node = nodeList.item(i);  
				Element eElement = (Element) node;  
				String productUrl = eElement.getElementsByTagName("loc").item(0).getTextContent();

				
				System.setProperty("webdriver.chrome.driver", "/home/dinesh/Downloads/driver/chromedriver");
				WebDriver driver = new ChromeDriver();
				driver.get(productUrl);
				String productTitle;
				boolean productReview = false,productAwards = false,productScreenshot = false,productVendorscreenshot = false;
				productTitle = driver.findElement(By.xpath("/html/body/div[11]/div/div[2]/div[2]/h1")).getText();
				System.out.println("The product Title is "+productTitle);
				System.out.println("The product Url is "+productUrl);
				Connection conn = DriverManager.getConnection(url, username, password);
				String sql;
				sql = "INSERT INTO datafromxml (productTitle,productUrl,productReview,productAwards,productScreenshot,productVendorscreenshot) VALUES (?,?,?,?,?,?) ";
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, productTitle);
				statement.setString(2, productUrl);
				

				try {
				productReview = driver.findElement(By.xpath("//div[@id='reviews']")).isDisplayed(); 
						System.out.println("The product has review topic "+ productReview);
					
				}catch(Exception e) {
					System.out.println(0);
				}
				
				try {
	                 productAwards = driver.findElement(By.xpath("/html/body/div[12]/div[2]/div/div")).isDisplayed();
						System.out.println("The product has awards topic "+ productAwards);
								

				}catch(Exception e) {
					System.out.println(0);
				}
				
				try {
					 productScreenshot = driver.findElement(By.xpath("//div[@class='container_wrpr brd-bot slid-bx-height']")).isDisplayed();
						System.out.println("The product has Pricing Screenshot topic "+ productScreenshot);				   
				
				}catch(Exception e) {
					System.out.println(0);
				}
				
				try {
					 productVendorscreenshot = driver.findElement(By.xpath("//div[@id='pricing_screenshot']//img")).isDisplayed();
					 
						System.out.println("The product has vendor pricing screenshot topic "+productVendorscreenshot);
						

				}catch(Exception e) {
					System.out.println(0);
				}		
				statement.setBoolean(3, productReview);
				statement.setBoolean(4, productAwards);
				statement.setBoolean(5, productScreenshot);
				statement.setBoolean(6, productVendorscreenshot);
				statement.executeUpdate();
				driver.quit();

			}
			
		}catch(FileNotFoundException e){
		e.printStackTrace();
	  }
   }

}
