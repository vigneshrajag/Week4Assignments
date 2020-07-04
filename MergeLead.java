package week4.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class MergeLead {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElementById("username").sendKeys("Demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Contacts").click();
		driver.findElementByXPath("//a[text()='Merge Contacts']").click();
		
		driver.findElementByXPath("//table[@id='widget_ComboBox_partyIdFrom']/following-sibling::a").click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> Window = new ArrayList<String>(windowHandles);
		driver.switchTo().window(Window.get(1));
		
		driver.findElementByXPath("(//table[@class='x-grid3-row-table'])[1]/tbody/tr[1]/td[1]//a").click();
		
		driver.switchTo().window(Window.get(0));
		
		driver.findElementByXPath("//table[@id='widget_ComboBox_partyIdTo']/following-sibling::a").click();

		Set<String> towindowHandles = driver.getWindowHandles();
		List<String> toWindow = new ArrayList<String>(towindowHandles);
		driver.switchTo().window(toWindow.get(1));
		
		driver.findElementByXPath("(//table[@class='x-grid3-row-table'])[2]/tbody/tr[1]/td[1]//a").click();
		
		driver.switchTo().window(toWindow.get(0));
		
		driver.findElementByXPath("//a[@class='buttonDangerous']").click();
		
		driver.switchTo().alert().accept();
		
		System.out.println(driver.getTitle());
			
	}

}
