package week44.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWebTable {

	public static void main(String[] args) {
		//Load Browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Load URL
		driver.get("http://www.leafground.com/pages/table.html"); 
		driver.manage().window().maximize();
		
		//1. Get the count of number of columns
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='table_id']//tr[2]/td"));
		int totalColumn = columns.size();
		System.out.println("Total colum count"+totalColumn);
		
		//2. Get the count of number of rows
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table_id']//tr"));
		int totalRows = rows.size();
		System.out.println("Total colum count"+totalRows);
		
		// 3. Get the progress value of 'Learn to interact with elements'
		String value = driver.findElement(By.xpath("//table[@id='table_id']//tr[3]/td[2]")).getText();
		System.out.println("Progress value of 'Learn to interact with elements'"+value);
		
		//4. check the vital
		List<String> progress = new ArrayList<String>();
		for(int i=2; i <= totalRows; i++) {
			String progressValue = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]/td[2]")).getText();
			String newValue = progressValue.replaceAll("[%]","");
			progress.add(newValue);
		}
		List<Integer> newList = new ArrayList<Integer>(progress.size());
		for(String myInt : progress) {
			newList.add(Integer.valueOf(myInt));
		}
		//Sort the element
		Collections.sort(newList);
		System.out.println(newList);
		
		//Click the vital
		Integer input = newList.get(0);
		driver.findElement(By.xpath("//td[contains(text(),'"+input+"')]/following::input")).click();
	
		
	}

}
