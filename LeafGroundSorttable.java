package week44.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundSorttable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Step1 Launch the URL
		driver.get("http://www.leafground.com/pages/sortable.html");
		
		//Step2 Create the Action clss
		Actions builder = new Actions(driver);
		
		//Step3 locate the sortable elements
		WebElement  item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement  item4 = driver.findElement(By.xpath("//li[text()='Item 4']"));
		builder.clickAndHold(item1).moveToElement(item4).release().perform();
		System.out.println("Sorted");
		driver.close();
		

		
		
		
		
		
	}

}
