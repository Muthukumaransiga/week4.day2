package week44.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TextChange {

	public static void main(String[] args) {
		//Load Browser
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				
				//Load URL
				driver.get("http://www.leafground.com/pages/TextChange.html"); 
				driver.manage().window().maximize();
				
				//Locate the Element 
				WebElement findElement = driver.findElement(By.xpath("//button[@class='btn']"));
				
				//add web driver wait
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
				wait.until(ExpectedConditions.textToBePresentInElement(findElement,"Click Me!"));
				
				findElement.click();
				
	}

}
