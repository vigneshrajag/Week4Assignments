package week4.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AssignmentACME {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://acme-test.uipath.com/account/login");
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com",Keys.TAB);
		driver.findElementById("password").sendKeys("leaf@12");
		driver.findElementById("buttonLogin").click();
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		WebElement mouseHover = driver.findElementByXPath("//button[text()=' Vendors']");
		action.moveToElement(mouseHover).perform();
		
		driver.findElementByXPath("//a[text()='Search for Vendor']").click();
		
		driver.findElementById("vendorName").sendKeys("Blue Lagoon");
		driver.findElementById("buttonSearch").click();
		
		WebElement table = driver.findElementByXPath("//table[@class='table']");
		
		List<WebElement> rowValue = table.findElements(By.tagName("tr"));
		int rowSize = rowValue.size();
		for (int i = 1; i < rowSize; i++) {
			String vendorName = rowValue.get(i).getText();
			if(vendorName.contains("Blue Lagoon")) {
				List<WebElement> columnValue = table.findElements(By.tagName("td"));
				String countryName = columnValue.get(4).getText();
				System.out.println("Country Name for given Vendor is :" +countryName);
			}
			
		}
		driver.findElementByXPath("//a[text()='Log Out']").click();
		driver.quit();
		
		
		
	}

}
