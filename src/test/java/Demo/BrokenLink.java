package Demo;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {

	public static void main(String[] args) {


//		WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.gecho.driver", "C:\\Users\\Asus\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.daraz.com.bd");
		System.out.println("Hello");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Number of links are: " + links.size());
		List<String> urlList = new ArrayList<String>();
		for(WebElement e : links) {
			String url = e.getAttribute("href");
//			urlList.add(url);
			checkBrokenLinks(url);
		}
		
		driver.close();
}
	
	public static void checkBrokenLinks(String linkUrl) {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setConnectTimeout(5000);
			httpUrlConnection.connect();
			
			if(httpUrlConnection.getResponseCode()>=400) {
				System.out.println(linkUrl + "--->" + httpUrlConnection.getResponseMessage() + " is a broken link");
			}
			else {
				System.out.println(linkUrl + "--->" + httpUrlConnection.getResponseMessage());
			}
		} catch (Exception e) {
		}
	}
}
