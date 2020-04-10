package mytestcase;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Another {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		
		File xmlFile = new File("/home/dinesh/Downloads/product_sitemap_google.xml");
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
		DocumentBuilder db = dbf.newDocumentBuilder();  
		Document doc = db.parse(xmlFile);  
		doc.getDocumentElement().normalize();  
		NodeList nodeList = doc.getElementsByTagName("url");
		for (int i = 0; i < nodeList.getLength(); i++)  {
			Node node = nodeList.item(i);  
			Element eElement = (Element) node;  
			String urlName = eElement.getElementsByTagName("loc").item(0).getTextContent();
            System.out.println("Url "+ urlName);

    }
  }
}
