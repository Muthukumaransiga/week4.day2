package week44.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Resizable {

	public static void main(String[] args) {
		//Load browser
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				//Step1 Launch the URL
				driver.get("https://jqueryui.com/resizable/");
				
				driver.switchTo().frame(0);
				
				WebElement findelement = driver.findElement(By.xpath("//div[@id=''resizable']/div[3]"));
				
				Actions act = new Actions(driver);
				act.dragAndDropBy(findelement, 300, 0).perform();
				
				
				

	}

}
