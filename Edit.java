package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.findElement(By.id("email")).sendKeys("sameemrajkapoor@gmail.com");
		driver.findElement(By.xpath("//input[contains(@value,'Append ')]")).sendKeys("text", Keys.TAB);
		String defaultText = driver.findElement(By.xpath("//input[@name='username'][1]")).getAttribute("value");
        System.out.println("Default Text is "+defaultText);
        
        driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();
        boolean enabled = driver.findElement(By.xpath("//label[text()='Confirm that edit field is disabled']/following::input")).isEnabled();
        
        if(!enabled)
        {
        	System.out.println("The input is disabled");
        }
        
        else
        {
        	System.out.println("The input is enabled");
        }
	}

}
