package week44.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ElementDisappear {

	public static void main(String[] args) {
		//Load Browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Load URL
		driver.get("http://www.leafground.com/pages/disappear.html"); 
		driver.manage().window().maximize();
		
		//Locate the element which is appearing after few minutes
		WebElement findElement = driver.findElement(By.xpath("//button[@id='btn']/b"));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(findElement));
		String text = driver.findElement(By.xpath("//div[@class='disappear']//strong")).getText();
		
		if(text.contains("i know you can do it! Button is disappeared!")) {
			System.out.println(text+ "is appeared after applying webdriverwait");
		}
		else {
			System.out.println(text+ "is not appeared after applying webdriverwait");
		}
	}

}
