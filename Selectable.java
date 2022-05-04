package week44.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selectable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Step1 Launch the URL
		driver.get("https://jqueryui.com/selectable/");
		
		//Step2 Create the Action class
		Actions builder = new Actions(driver);
		driver.switchTo().frame(0);
		WebElement  item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement  item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement  item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement  item4 = driver.findElement(By.xpath("//li[text()='Item 4']"));
		WebElement  item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		WebElement  item6 = driver.findElement(By.xpath("//li[text()='Item 6']"));
		WebElement  item7 = driver.findElement(By.xpath("//li[text()='Item 7']"));
		builder.clickAndHold(item1).moveToElement(item5).release().perform();
		builder.keyDown(Keys.CONTROL).click(item5).clickAndHold(item7).perform();
		
		 
		
		

	}

}
