package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.findElement(By.xpath("//label[text()='Select the languages that you know?']/following::input[1]")).click();
		driver.findElement(By.xpath("//label[text()='Select the languages that you know?']/following::input[3]")).click();
		
		boolean selected = driver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']/following::input[1]")).isSelected();
	if(selected)
	{
		System.out.println("Its selected already");
	}
	else
	{
		System.out.println("Its not selected");
	}
	
	driver.findElement(By.xpath("//label[text()='DeSelect only checked']/following::input[2]")).click();
	
	driver.findElement(By.xpath("//label[contains(text(),'Select all below checkboxes')]/following::input[1]")).click();
	driver.findElement(By.xpath("//label[contains(text(),'Select all below checkboxes')]/following::input[2]")).click();
	driver.findElement(By.xpath("//label[contains(text(),'Select all below checkboxes')]/following::input[3]")).click();
	driver.findElement(By.xpath("//label[contains(text(),'Select all below checkboxes')]/following::input[4]")).click();
	driver.findElement(By.xpath("//label[contains(text(),'Select all below checkboxes')]/following::input[5]")).click();
	driver.findElement(By.xpath("//label[contains(text(),'Select all below checkboxes')]/following::input[6]")).click();
	}

}
