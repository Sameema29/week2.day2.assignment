package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBook {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.linkText("Create New Account")).click();
		
		driver.findElement(By.name("firstname")).sendKeys("Sameema Rani");
		driver.findElement(By.name("lastname")).sendKeys("Rajkapoor");
		driver.findElement(By.name("reg_email__")).sendKeys("9994572095");
		driver.findElement(By.name("reg_passwd__")).sendKeys("Bishmillah@786");
		
		WebElement bdate = driver.findElement(By.name("birthday_day"));
		Select date = new Select(bdate);
		date.selectByVisibleText("25");
		
		WebElement bmonth = driver.findElement(By.name("birthday_month"));
		Select month = new Select(bmonth);
		month.selectByVisibleText("May");
		
		WebElement byear = driver.findElement(By.name("birthday_year"));
		Select year = new Select(byear);
		year.selectByValue("1987");
		
		driver.findElement(By.xpath("//label[text()='Female']/following-sibling::input")).click();
		
		}

}
