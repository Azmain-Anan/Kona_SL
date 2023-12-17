package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	 WebDriver driver;
	 
	 //Constructor
	 Base(WebDriver d){
		 driver = d;
	 }
	 
	 By searchbar = By.xpath("//*[@id=\"APjFqb\"]");
	 By srcbttn = By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]");
	 
	 public void search(String x) {
		 driver.findElement(searchbar).sendKeys(x);
	 }

	 public void clickbttn() {
		 driver.findElement(srcbttn).click();
	 }

}
