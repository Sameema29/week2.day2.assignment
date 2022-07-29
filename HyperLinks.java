package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HyperLinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.findElement(By.linkText("Go to Home Page")).click();
		System.out.println("Its Home Page: "+driver.getCurrentUrl());
		
		driver.findElement(By.xpath("//h5[text()='HyperLink']")).click();
		String attribute = driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href");
		System.out.println("Link redirected to "+attribute);
		
		driver.findElement(By.linkText("Go to Home Page")).click();
		System.out.println("Again Its Home Page: "+driver.getCurrentUrl());
		driver.findElement(By.xpath("//h5[text()='HyperLink']")).click();
		
		int size = driver.findElements(By.tagName("a")).size();
		System.out.println("Number of links in this page: "+size);
		
		
	}

}
