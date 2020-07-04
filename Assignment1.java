package week4.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/table.html");
		WebElement webTable = driver.findElementById("table_id");
		List<WebElement> eachRow = webTable.findElements(By.tagName("tr"));
		int rowSize = eachRow.size();
		System.out.println("The count of no of Rows in Web Table is : " + rowSize);
		for (int i = 1; i < eachRow.size(); i++) {
			List<WebElement> eachCell = eachRow.get(i).findElements(By.tagName("td"));

			int columnSize = eachCell.size();
			System.out.println("The count of no of Columns in Web Table is : " + columnSize);
		}
		String text2 = eachRow.get(2).findElements(By.tagName("td")).get(1).getText();
		System.out.println("progress value of 'Learn to interact with Elements  :" + text2);

		boolean selected = eachRow.get(3).findElements(By.tagName("td")).get(2).isSelected();
		
		if(selected==true) {
			System.out.println("Vital task checkbox is selected");
		}
		else {
			System.out.println("Vital task checkbox is not selected");
		}
	}
}
