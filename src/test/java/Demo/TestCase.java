package Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();		
		Base bs = new Base(driver);
		
		driver.get("https://www.google.com/");
		bs.search("https://konasl.com/");
		bs.clickbttn();
		
	}

}
