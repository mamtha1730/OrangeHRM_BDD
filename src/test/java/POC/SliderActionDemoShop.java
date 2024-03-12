package POC;

import java.io.File;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SliderActionDemoShop {
	
	
	
	@Test
	void test_SliderActionDemo() throws InterruptedException 
	{
		ChromeOptions options=new ChromeOptions();
		options.addExtensions(new File("C:\\Users\\ics-guest\\Drivers\\crx files\\uBlock-Origin.crx"));
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("https://practice.automationtesting.in/shop/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		
		
		WebElement priceLowSlider = driver.findElement(By.xpath("//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[1]/span[1]"));
		
		
		WebElement priceHighSlider = driver.findElement(By.xpath("//div[@class='price_slider ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content']//span[2]"));

		int xCoord = priceLowSlider.getLocation().getX();
		int yCoord = priceHighSlider.getLocation().getY();
		System.out.println("xCoord value is: " + xCoord);
		System.out.println("yCoord value is: " + yCoord);
		
		Actions act= new Actions(driver);
		
		//moving low price slider
		act.moveToElement(priceLowSlider)
		   .click()
		   .dragAndDropBy(priceLowSlider,xCoord-330, yCoord)
		   .build()
		   .perform();
		
		
		act.moveToElement(priceHighSlider)
		   .click()
		   .dragAndDropBy(priceHighSlider,xCoord-450, yCoord)
		   .build()
		   .perform();
		
		driver.findElement(By.xpath("//button[normalize-space()='Filter']")).click();
		
		WebElement priceRange = driver.findElement(By.xpath("//*/form/div/div[2]/div[1]"));
		String priceFilterValue = priceRange.getText();
		String lowerPrice = priceFilterValue.substring(8,11);
		double lp = Double.parseDouble(lowerPrice);
		//System.out.println("lowerprice value is: " + lowerPrice);
		System.out.println("lowerprice value is after converted double: " + lp);
		
		String higherPrice = priceFilterValue.substring(15,18);
		double up = Double.parseDouble(higherPrice);
		//System.out.println("higherprice value is: " + higherPrice);
		System.out.println("higher value is after converted double: " + up);
		
		System.out.println("The price range values are:   " + priceFilterValue);
		
		List<WebElement> bookPrices = driver.findElements(By.xpath("//span[@class='price']"));
		
		for(WebElement bp: bookPrices) 
		{
			String price = bp.getText();
			
			System.out.print("book prices are :  " + price.substring(1,7));
			System.out.println("");
			
			double pr = Double.parseDouble(price.substring(1,7));
			System.out.println("pr value after converted double:  " + pr);
			
			if((pr>lp) && (pr<up))
			{
				Assert.assertTrue(true);
				System.out.println("passed");
			}
			else 
			{
				Assert.assertFalse(true);
				System.out.println("failed");
			}
			
		}
		
		
	}

}
