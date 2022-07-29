package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Button {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.findElement(By.xpath("//button[text()='Go to Home Page']")).click();
		System.out.println("Returned to home Page "+driver.getCurrentUrl());
		driver.findElement(By.xpath("//h5[text()='Button']/following::img[1]")).click();
		
		Point location = driver.findElement(By.xpath("//button[text()='Get Position']")).getLocation();
		System.out.println("Location: "+location);
		
		String cssValue = driver.findElement(By.xpath("//button[text()='What color am I?']")).getCssValue("background-color");
		System.out.println("Background color: "+cssValue);
		
		Dimension size = driver.findElement(By.xpath("//button[text()='What is my size?']")).getSize();
		System.out.println("Size is : "+size);




	}

}
