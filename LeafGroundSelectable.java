package week44.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundSelectable {

	public static void main(String[] args) {
		//Load browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Step1 Launch the URL
		driver.get("http://www.leafground.com/pages/selectable.html");
		
		//Step2 Create Action class	
		Actions builder = new Actions(driver);
		
		//step3 locate the elements to select
		WebElement  item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement  item4 = driver.findElement(By.xpath("//li[text()='Item 4']"));
		
		//step4 select the element
		builder.clickAndHold(item1).moveToElement(item4).release().perform();
		
		//Step5 Close the browser
		//driver.close();

	}

}
