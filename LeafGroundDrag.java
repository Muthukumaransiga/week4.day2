package week44.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundDrag {

	public static void main(String[] args) {
		
		//Download the Chrome driver
		WebDriverManager.chromedriver().setup();

		//Launch the browser
		ChromeDriver driver = new ChromeDriver();

		//Maximize the window
		driver.manage().window().maximize();

		//time wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		//1. Launch the URL
		driver.get("http://leafground.com/pages/drag.html");

		//2.Create Action class
		Actions builder = new Actions(driver);

		// 3. locate the dragable element
		WebElement drag = driver.findElement(By.id("draggable"));
		builder.dragAndDropBy(drag,100,75).perform();
		System.out.println("Element Dragged");

		//4. close the browser.
		driver.quit();
	}

}
