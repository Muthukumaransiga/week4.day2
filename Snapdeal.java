package week44.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.OutputType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {

	private static final String FILE = null;

	public static void main(String[] args) throws IOException, InterruptedException {
		//1. Launch https://www.snapdeal.com/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//1. Launch https://www.snapdeal.com/
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Actions builder = new Actions(driver);

		//2. Go to Mens Fashion
		WebElement men = driver.findElement(By.linkText("Men's Fashion"));
		builder.moveToElement(men).perform();

		//3. Go to Sports Shoes
		driver.findElement(By.xpath("//span[contains(text(),'Sports Shoes')])[1]")).click();


		//4. Get the count of the sports shoes
		String shoeCount = driver.findElement(By.xpath("//div[text() = 'Sports Shoes for Men']//following-sibling::div[contains(@class, 'child-cat-count')]")).getText();
		System.out.println("count of Sports Shoe is "+shoeCount);
		
		//5. Click Training shoes
		driver.findElement(By.xpath("//div[text() = 'Training Shoes']")).click();
		
		//6. Sort by Low to High
		driver.findElement(By.xpath("//i[@class='sd-icon-expand-arrow sort-arrow']")).click();
		WebElement low = driver.findElement(By.xpath("//li[contains(@data-index,'1')])[2]"));
		builder.moveToElement(low).click().perform();
		Thread.sleep(6000);
		
		//7. Check if the items displayed are sorted correctly
		List<WebElement> Price = driver.findElements(By.xpath("//span[class= 'lfloat product-price')]"));
		List<Integer> shoe = new ArrayList<Integer>();
		
		for(int i=0;i<Price.size();i++)
		{
			String text2 =  Price.get(i).getText();
			System.out.println(text2);
			//shoe.addAll(text2);
			String replaceAll2 = text2.replaceAll("\\D","");
			int parseInt2 = Integer.parseInt(replaceAll2);
			System.out.println(parseInt2);
								
		}
		//8.Select the price range (900-1200)
		WebElement rate = driver.findElement(By.xpath("//input[@name='formVal']"));
		rate.clear();
		rate.sendKeys("900");
		WebElement torate = driver.findElement(By.xpath("//input[@name='toval']"));
		torate.clear();
		torate.sendKeys("1200");
		
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		Thread.sleep(6000);
		
		driver.findElement(By.xpath("//button[@class='view-more-button btn btn-line btn-theme-secondary viewMoreFilter']")).click();
		Thread.sleep(6000);
		
		
		//9.Filter with color Navy 
		driver.findElement(By.xpath("//button[@class='view-more-button btn btn-line btn-theme-secondary viewMoreFilter' and text]")).click();
		
		//10 verify the all applied filters
		driver.findElement(By.xpath("//input[@id='Color_s-Navy']/following-sibling::label")).click();
		Thread.sleep(6000);
		
		//11. Mouse Hover on first resulting Training shoes
		String Ptag = driver.findElement(By.xpath("//a[@class='clear-filter-pill'])[1]")).getText();
		String Ctag = driver.findElement(By.xpath("//a[contains(text),'Navy')])[2]")).getText();
		System.out.println(Ctag);
		if(Ctag.contains("Navy"))
		{
			System.out.println("Navy Colour");
			
		}
		else {
			System.out.println("Other Colour");
		}
		if(Ptag.contains("900"))
		{
			System.out.println("It is in Required price");
			
		}
		else {
			System.out.println("Other than required price");
			
		}
		//12. click QuickView button
		WebElement firstshoe = driver.findElement(By.xpath("//p[@class='product-title'])[1]"));
		builder.moveToElement(firstshoe).perform();
		
		//13. Print the cost and the discount percentage
		driver.findElement(By.xpath("//div[contains@class,'clearfix row-disc')]/div[1]")).click();
		Thread.sleep(5000);
		
		//14. Take the snapshot of the shoes.
		String rupees = driver.findElement(By.xpath("//span[@class=''payBlkBig']")).getText();
		System.out.println(rupees);
		String offer = driver.findElement(By.xpath("//span[contains(text(),'% off')])[1]")).getText();
		System.out.println(rupees);
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File targt = new File("./snps/img1.png");
		FileUtils.copyFile(src, targt);
		System.out.println("Clicked snapshot");
		//15. Close the current window
		driver.close();
		//16. Close the main window
		driver.quit();


	}

}
