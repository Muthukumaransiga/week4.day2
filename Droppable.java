package week44.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Droppable {

	public static void main(String[] args) {
		//Load browser
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				//Step1 Launch the URL
				driver.get("https://jqueryui.com/droppable/");

				//Both are inside a frame
				driver.switchTo().frame(0);
								
				// Find Xpath for draggable
				WebElement findElement1 = driver.findElement(By.id("draggable"));
				
				//Find xpath drop table
				WebElement findElement2 = driver.findElement(By.id("draggable"));
				
				//Create object for Actions class
				Actions builder = new Actions(driver);
				
				builder.dragAndDrop(findElement1, findElement2).perform();
				
				//Close the window
				driver.close();
	}

}
