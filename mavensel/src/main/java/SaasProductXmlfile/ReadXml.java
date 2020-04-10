package SaasProductXmlfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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

public class ReadXml {
	
	public static void main(String[] args) throws SQLException, InterruptedException, ParserConfigurationException, SAXException, IOException {

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
			}
			
		}catch(FileNotFoundException e){
		e.printStackTrace();
	  }
   }


}
