package week4.day2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomCar {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.zoomcar.com/chennai");
		
		driver.findElementByClassName("search").click();
		driver.findElementByXPath("//div[contains(text(),'Nelson Manickam Road')]").click();
		driver.findElementByClassName("proceed").click();
		
		Date date = new Date (); // to get the current date
		System.out.println("Today's date is :" + date);
		DateFormat dateFormat = new SimpleDateFormat("dd");
		String today =dateFormat.format(date);
		System.out.println(today);
		int tomorrow = Integer.parseInt(today)+1; // Convert to integer and add 1 to it
		System.out.println("Tomorrow's date: " +tomorrow);
		
		driver.findElementByXPath("//div[contains(text(),'"+tomorrow+"')]").click();	
		driver.findElementByClassName("proceed").click(); //Next Button
		driver.findElement(By.className("proceed")).click();    // Done Button
		
		List<WebElement> cars = driver.findElementsByClassName("car-listing");
		int size = cars.size();
		System.out.println(size);
		
		Map <String , String > map = new LinkedHashMap  < String , String>();
		List<WebElement> carNames = driver.findElements(By.tagName("h3"));
		List<WebElement> carPrice = driver.findElementsByClassName("price");
		for (int i = 0; i < carNames.size(); i++) {
	    	String carlist = carNames.get(i).getText();
	   		System.out.println(carlist);
	   		
	   		String pricelist = carPrice.get(i).getText().replaceAll("[^0-9]", "");
	   		System.out.println(pricelist);
	      
	   		map.put(carlist,pricelist);
	   		
	        }
	        System.out.println("ok");
	      
	        String maxvalue = Collections.max(map.values());
	        System.out.println("Maximum value is "  +maxvalue);
			

			driver.close();
	
	
	}

}
