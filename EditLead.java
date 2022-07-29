package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("(//div[@class='x-form-element'])[3]/following::input[@name='firstName'][2]")).sendKeys("Sameema Rani");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[text()='Lead ID']/following::table[1]//td[1]//a")).click();
		
		String expectedTitle = "View Lead | opentaps CRM";
		String pageTitle = driver.getTitle();
		if(expectedTitle.equalsIgnoreCase(pageTitle))
		{
			System.out.println("Title verified Successfully. "+pageTitle);
		}
		else
		{
			System.out.println("Page Title is wrong. "+pageTitle);
		}
		
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("TCS");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		Thread.sleep(3000);
		
		String actualCompany = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String expectedCompany = "TCS";
		if(actualCompany.contains(expectedCompany))
		{
			System.out.println("Company name updated successfully. "+actualCompany);
		}
		else
		{
			System.out.println("Company name not updated. "+actualCompany);
		}
		
		driver.close();
	}

}
