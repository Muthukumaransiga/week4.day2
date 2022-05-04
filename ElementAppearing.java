package week44.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import io.cucumber.messages.types.Duration;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementAppearing {

	public static void main(String[] args) {
		//Load Browser
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				
				//Load URL
				driver.get("http://www.leafground.com/pages/appear.html"); 
				driver.manage().window().maximize();
				
				//Locate the element which is appearing after few minutes
				WebElement findElement = driver.findElement(By.xpath("//button[@id='btn']/b"));
				
				//get the text from that element
				WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
				
				//given Condition
				wait.until(ExpectedConditions.visibilityOf(findElement));
				//Now get the time from above element
				
				String text = findElement.getText();
				
				//Verify that after few second the element append in the web page
				
				if(text.equals("Voila! I'm here Guys")) {
					System.out.println(text+": appeared after some seconds");
				}
				else {
					System.out.println(text+": not appeared after some seconds");
				}
				//lets See what happend without web driver wait
				
				
	}
}
