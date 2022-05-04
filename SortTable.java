package week44.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortTable {

	public static void main(String[] args) throws InterruptedException {
		
		//Load Browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Load URL
		driver.get("http://www.leafground.com/pages/sorttable.html"); 
		driver.manage().window().maximize();
		
		
		//Inspects names
		//Locate the elements and store it in lists
		List<WebElement> findElements = driver.findElements(By.xpath("//table[@id='table_id']//td[2]"));
		//create a empty list of string to store names
		List<String> names1 = new ArrayList<String>();
		for(int i=0; i <findElements.size();i++) {
			names1.add(findElements.get(i).getText());
		}
		//Now name1 contains all names
		// Sort name1 using collection
		Collections.sort(names1);
		
		//add thread.sleep
		//add click on the name header
		Thread.sleep(5);
		driver.findElements(By.xpath("//th[text()='Name']"));
		//Now again inspect the name of the webelement and store in it in another list
		List<WebElement> findElements2 = driver.findElements(By.xpath("//table[@id='table_id']//td[2]"));
		// Create a empty list of string to store name
		List<String> names2 = new ArrayList<String>();
		for(int i=0; i <findElements2.size();i++) {
			names2.add(findElements2.get(i).getText());
		}
		
		// To check wheather it is sorter or not
		// Now condition to check both
		if(names1.equals(names2)) {
			System.out.println("Passed");		
			}
		else {
			System.out.println("Failed");
		}
		
		
		
		
		

	}

}
