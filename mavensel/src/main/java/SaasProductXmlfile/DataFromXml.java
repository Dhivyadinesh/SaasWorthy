package SaasDataExtractFromXmlFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DataFromXml {

	public static void main(String[] args)
			throws IOException, ParserConfigurationException, SAXException, SQLException, InterruptedException {
		String url = "jdbc:mysql://localhost:3306/saas";
		String username = "root";
		String password = "dineshdd";
		String productName, categoryName;
		boolean SWScore = false, Description = false, Awards = false, Features = false, TechnicalDetails = false,
				Pricing = false, FAQ = false, RelatedCategories = false, Alternatives = false, Reviews = false,
				Videos = false, Screenshots = false, Articles = false, Downloads = false, Customers = false,
				Integrations = false, PricingScrenshort = false;
		boolean linkedin = false, twitter = false, facebook = false, instagram = false, youtube = false;
		String linkedinCount = "0", twitterCount = "0", facebookCount = "0", instagramCount = "0", youtubeCount = "0";
		String linkedinUrl = "null", twitterUrl = "null", facebookUrl = "null", instagramUrl = "null",
				youtubeUrl = "null";
		String Url;

		String description;
		int countWorddescription = 0;
		String productUrl = "null";
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db
					.parse(new URL("https://www.saasworthy.com/sitemaps/product_sitemap_google.xml").openStream());
			NodeList nodeList = doc.getElementsByTagName("url");
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);
				Element eElement = (Element) node;
				productUrl = eElement.getElementsByTagName("loc").item(0).getTextContent();
				try {
				org.jsoup.nodes.Document docm = Jsoup.connect(productUrl).get();
				System.out.println(productUrl);
				description = docm.getElementById("sass-desc").text();
				System.out.println(description);
				String[] wordList = description.split("\\s+");
				countWorddescription = wordList.length;
				System.out.println(countWorddescription);
				productName = docm.getElementsByClass("h-title").text();
				System.out.println(productName);

				categoryName = docm.select(".breadcrum > span:nth-child(3) > a:nth-child(1)").text();
				System.out.println(categoryName);

				// checking SWScore is persent/not from productUrl
				try {
					SWScore = docm.getElementsByClass("pop_score_d").hasText();
					System.out.println("The product has SWScore topic found");
				} catch (Exception e) {
					System.out.println("The product has SWScore topic not found");
				}

				// checking Description is persent/not from productUrl
				try {
					Description = docm.getElementById("sass-desc").hasText();
					System.out.println("The product has Description topic found ");
				} catch (Exception e) {
					System.out.println("The product has Description topic not found");
				}

				// checking Awards is persent/not from productUrl
				try {
					Awards = docm.getElementById("awards").hasText();
					System.out.println("The product has Awards topic found");
					;
				} catch (Exception e) {
					System.out.println("The product has Awards topic not found");
				}

				// checking Features is persent/not from productUrl
				try {
					Features = docm.getElementById("features").hasText();
					System.out.println("The product has productVendorscreenshot topic found ");
				} catch (Exception e) {
					System.out.println("The product has Features topic not found");
				}

				// checking TechnicalDetails is persent/not from productUrl
				try {
					TechnicalDetails = docm.getElementById("technical-details").hasText();
					System.out.println("The product has TechnicalDetails topic found ");
				} catch (Exception e) {
					System.out.println("The product has TechnicalDetails topic not found");
				}

				// checking Pricing is persent/not from productUrl
				try {
					Pricing = docm.getElementById("pricing").hasText();
					System.out.println("The product has Pricing topic found ");
				} catch (Exception e) {
					System.out.println("The product has Pricing topic not found");
				}
				try {
					PricingScrenshort = docm.getElementsByClass("slider pricing-slider slick-initialized slick-slider")
							.hasText();
					System.out.println("The product has Pricing topic found ");
				} catch (Exception e) {
					System.out.println("The product has Pricing topic not found");
				}

				// checking FAQ is persent/not from productUrl
				try {
					FAQ = docm.getElementById("faq").hasText();
					System.out.println("The product has FAQ topic found ");
				} catch (Exception e) {
					System.out.println("The product has FAQ topic not found");
				}

				// checking RelatedCategories is persent/not from productUrl
				try {
					RelatedCategories = docm.getElementById("related").hasText();
					System.out.println("The product has RelatedCategories topic found ");
				} catch (Exception e) {
					System.out.println("The product has RelatedCategories topic not found");
				}

				// checking Alternatives is persent/not from productUrl
				try {
					Alternatives = docm.getElementById("alternatives").hasText();
					System.out.println("The product has Alternatives topic found ");
				} catch (Exception e) {
					System.out.println("The product has Alternatives topic not found");
				}

				// checking Reviews is persent/not from productUrl
				try {
					Reviews = docm.getElementById("reviews").hasText();
					System.out.println("The product has Reviews topic found ");
				} catch (Exception e) {
					System.out.println("The product has Reviews topic not found");
				}

				// checking Videos is persent/not from productUrl
				try {
					Videos = docm.getElementById("videos").hasText();
					System.out.println("The product has Videos topic found");
				} catch (Exception e) {
					System.out.println("The product has Videos topic not found");
				}

				// checking Screenshots is persent/not from productUrl
				try {
					Screenshots = docm.getElementById("screenshots").hasText();
					System.out.println("The product has Screenshots topic found ");
				} catch (Exception e) {
					System.out.println("The product has Screenshots topic not found");
				}

				// checking Articles is persent/not from productUrl
				try {
					Articles = docm.getElementById("reviews").hasText();
					System.out.println("The product has Articles topic found ");
				} catch (Exception e) {
					System.out.println("The product has Articles topic not found");
				}

				// checking Awards is persent/not from productUrl
				try {
					Downloads = docm.getElementById("downloads").hasText();
					System.out.println("The product has Downloads topic found");
				} catch (Exception e) {
					System.out.println("The product has Downloads topic not found");
				}

				// checking Customers is persent/not from productUrl
				try {
					Customers = docm.getElementById("customers").hasText();
					System.out.println("The product has Customers topic found");
				} catch (Exception e) {
					System.out.println("The product has Customers topic not found");
				}

				// checking Integrations is persent/not from productUrl
				try {
					Integrations = docm.getElementById("integration").hasText();
					System.out.println("The product has Integrations topic found ");
				} catch (Exception e) {
					System.out.println("The product has Integrations topic not found");
				}

				Elements followers = docm.getElementsByClass("right_followers").select("a");

				for (org.jsoup.nodes.Element element : followers) {
					Url = element.attr("abs:href");
					if (Url.contains("linkedin")) {
						linkedin = Url.contains("linkedin");
						linkedinUrl = element.attr("href");
						linkedinCount = element.getElementsByTag("span").text();
						System.out.println("Product has linkedin " + linkedin);
						System.out.println("linkedin url is" + linkedinUrl);
						System.out.println("linkedinCount" + linkedinCount);
					}

					if (Url.contains("twitter")) {
						twitter = Url.contains("twitter");
						twitterUrl = element.attr("href");
						twitterCount = element.getElementsByTag("span").text();
						System.out.println(twitter);
						System.out.println(twitterUrl);
						System.out.println(twitterCount);
					}

					if (Url.contains("facebook")) {
						facebook = Url.contains("facebook");
						facebookUrl = element.attr("href");
						facebookCount = element.getElementsByTag("span").text();
						System.out.println(facebook);
						System.out.println(facebookUrl);
						System.out.println(facebookCount);
					}

					if (Url.contains("instagram")) {
						instagram = Url.contains("instagram");
						instagramUrl = element.attr("href");
						instagramCount = element.getElementsByTag("span").text();
						System.out.println(instagram);
						System.out.println(instagramUrl);
						System.out.println(instagramCount);

					}

					if (Url.contains("youtube")) {
						youtube = Url.contains("youtube");
						youtubeUrl = element.attr("href");
						youtubeCount = element.getElementsByTag("span").text();
						System.out.println(youtube);
						System.out.println(youtubeUrl);
						System.out.println(youtubeCount);
					}
				}

				// establish connection with the Mysql database
				Connection conn = DriverManager.getConnection(url, username, password);
				String sql;
				// query for inserting data
				sql = "INSERT INTO 50product (productName, productUrl,categoryName, SWScore , Description , Awards ,"
						+ "Features, TechnicalDetails ,Pricing,PricingScrenshort, FAQ , RelatedCategories ,Alternatives ,"
						+ "Reviews ,Videos, Screenshots ,Articles ,Downloads ,Customers ,"
						+ "Integrations, linkedin, linkedinCount, linkedinUrl, twitter, twitterCount,"
						+ "twitterUrl, facebook, facebookCount, facebookUrl, instagram, instagramCount,"
						+ "instagramUrl, youtube, youtubeCount, youtubeUrl,countWorddescription)"
						+ " VALUES (?,?,?,?,?,?,?,?,?,?,?," + "?,?,?,?,?,?,?,?,?,?,?,"
						+ "?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
				// Create a statement
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, productName);
				statement.setString(2, productUrl);
				statement.setString(3, categoryName);
				statement.setBoolean(4, SWScore);
				statement.setBoolean(5, Description);
				statement.setBoolean(6, Awards);
				statement.setBoolean(7, Features);
				statement.setBoolean(8, TechnicalDetails);
				statement.setBoolean(9, Pricing);
				statement.setBoolean(10, PricingScrenshort);
				statement.setBoolean(11, FAQ);
				statement.setBoolean(12, RelatedCategories);
				statement.setBoolean(13, Alternatives);
				statement.setBoolean(14, Reviews);
				statement.setBoolean(15, Videos);
				statement.setBoolean(16, Screenshots);
				statement.setBoolean(17, Articles);
				statement.setBoolean(18, Downloads);
				statement.setBoolean(19, Customers);
				statement.setBoolean(20, Integrations);
				statement.setBoolean(21, linkedin);
				statement.setString(22, linkedinCount);
				statement.setString(23, linkedinUrl);
				statement.setBoolean(24, twitter);
				statement.setString(25, twitterCount);
				statement.setString(26, twitterUrl);
				statement.setBoolean(27, facebook);
				statement.setString(28, facebookCount);
				statement.setString(29, facebookUrl);
				statement.setBoolean(30, instagram);
				statement.setString(31, instagramCount);
				statement.setString(32, instagramUrl);
				statement.setBoolean(33, youtube);
				statement.setString(34, youtubeCount);
				statement.setString(35, youtubeUrl);
				statement.setInt(36, countWorddescription);
				// execute statement
				statement.executeUpdate();
				conn.close();
			}catch (Exception e) {
			    e.printStackTrace();
			}
		}
	}
}
