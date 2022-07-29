package week2.day2.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		List<WebElement> columnCount = driver.findElements(By.tagName("th"));
		System.out.println("No. of Columns: "+columnCount.size());

		List<WebElement> rowCount = driver.findElements(By.tagName("tr"));
		System.out.println("No. of Rows: "+rowCount.size());

		String text = driver.findElement(By.xpath("(//font[contains(text(),'Learn to interact with')])[1]/following::font[1]")).getText();
		System.out.println("Progress Value of Learn to interact with "+text);
		driver.findElement(By.xpath("//font[contains(text(),'20%')]/following::input[1]")).click();


	}
}

