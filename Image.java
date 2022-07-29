package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		driver.findElement(By.xpath("//label[text()='Click on this image to go home page']/following::img")).click();
		System.out.println("Its Home Page: "+driver.getCurrentUrl());

		driver.findElement(By.xpath("//h5[text()='Image']")).click();
		String url = driver.findElement(By.xpath("//label[text()='Am I Broken Image?']/following::img")).getAttribute("onclick");
		if(url=="")
		{
			System.out.println("The image is broken");
		}
		else
		{
			System.out.println("The image is not broken");
		}
		
		driver.findElement(By.xpath("//label[text()='Click me using Keyboard or Mouse']/following::img")).click();
		System.out.println(driver.getCurrentUrl());

	}

}
