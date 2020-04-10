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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadSaasProductListXmlFileAndUploadInDB {
	public static void main(String[] args) throws SQLException, InterruptedException, ParserConfigurationException, SAXException, IOException {
		String url = "jdbc:mysql://localhost:3306/datafromfile";
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
				String urlName = eElement.getElementsByTagName("loc").item(0).getTextContent();

				
				System.setProperty("webdriver.gecko.driver", "/home/dinesh/Downloads/driver/geckodriver");
				WebDriver driver = new FirefoxDriver();
				driver.get(urlName);
				System.out.println(urlName);
				String title = driver.findElement(By.xpath("/html/body/div[11]/div/div[2]/div[2]/h1")).getText();
				System.out.println(title);
				Connection conn = DriverManager.getConnection(url, username, password);
				String sql;
				sql = "INSERT INTO text(title,review,awards,screenshot,vendorscreenshot) VALUES (?,?,?,?,?) ";
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, title);

				try {
					boolean review = driver.findElement(By.xpath("/html/body/div[11]/div/div[2]/div[6]/div/p")).isDisplayed(); 
					if(review == true ) {
						System.out.println(1);
						PreparedStatement statement1 = conn.prepareStatement(sql);
						statement1.setBoolean(2,review );
						statement1.executeUpdate();

					}
				}catch(Exception e) {
					System.out.println(0);
				}
				
				try {
	                boolean awards = driver.findElement(By.xpath("/html/body/div[12]/div[2]/div/div")).isDisplayed();
	                if(awards == true ) {
						System.out.println(1);
						PreparedStatement statement2 = conn.prepareStatement(sql);
						statement2.setBoolean(3,awards );
						statement2.executeUpdate();
					}					

				}catch(Exception e) {
					System.out.println(0);
				}
				
				try {
					boolean screenshot = driver.findElement(By.xpath("//div[@class='container_wrpr brd-bot slid-bx-height']")).isDisplayed();
					if(screenshot == true ) {
						System.out.println(1);
						PreparedStatement statement3 = conn.prepareStatement(sql);
						statement3.setBoolean(4,screenshot );
						statement3.executeUpdate();
					}				   
				
				}catch(Exception e) {
					System.out.println(0);
				}
				
				try {
					boolean vendorscreenshot = driver.findElement(By.xpath("//div[@id='pricing_screenshot']//img")).isDisplayed();
					if(vendorscreenshot == true ) {
						System.out.println(1);
						PreparedStatement statement4 = conn.prepareStatement(sql);
						statement4.setBoolean(5, vendorscreenshot);
						statement4.executeUpdate();
					}			

				}catch(Exception e) {
					System.out.println(0);
				}		
				statement.executeUpdate();
		         conn.close();


			}
			
		}catch(FileNotFoundException e){
		e.printStackTrace();
	  }
   }

}
