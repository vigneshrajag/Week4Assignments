package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/frame.html");
		//WebElement webFrame = driver.findElementByXPath("//iframe[@src='default.html']");
		driver.switchTo().frame(0);
		driver.findElementById("Click").click();
		System.out.println(driver.findElementById("Click").getText());
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		List<WebElement> findiFrameElements = driver.findElements(By.tagName("iframe"));
		int size = findiFrameElements.size();
		System.out.println("Total No of frames available :"+size);
		WebElement webFrame2 = driver.findElementByXPath("//iframe[@src='page.html']");
		driver.switchTo().frame(webFrame2);
		WebElement nestedWebframe = driver.findElementById("frame2");
		driver.switchTo().frame(nestedWebframe);
		driver.findElementById("Click1").click();
		System.out.println(driver.findElementById("Click1").getText());
	}

}
