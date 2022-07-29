package week2.day2.assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		WebElement drop1 = driver.findElement(By.id("dropdown1"));
		Select dropDown1 = new Select(drop1);
		dropDown1.selectByIndex(1);
		
		WebElement drop2 = driver.findElement(By.name("dropdown2"));
		Select dropDown2 = new Select(drop2);
		dropDown2.selectByVisibleText("Selenium");
		
		WebElement drop3 = driver.findElement(By.id("dropdown3"));
		Select dropDown3 = new Select(drop3);
		dropDown3.selectByValue("1");
		
		WebElement dropOptions = driver.findElement(By.className("dropdown"));
		Select dropDown4 = new Select(dropOptions);
		int totalDropDown = dropDown4.getOptions().size();
		System.out.println("Total Drop Down: "+totalDropDown);
		
		driver.findElement(By.xpath("(//div[@class='example'])[5]/select")).sendKeys("Selenium");

		WebElement selectMulti = driver.findElement(By.xpath("//option[text()='Select your programs']/.."));
		Select dropDown5=new Select(selectMulti);
		dropDown5.selectByVisibleText("Selenium");
		dropDown5.selectByValue("2");


		
		
		
		
	}
}

