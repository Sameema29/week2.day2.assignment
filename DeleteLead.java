package week2.day2.assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		//driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).sendKeys("+91");
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9994572095");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		
		String leadId = driver.findElement(By.xpath("//div[text()='Lead ID']/following::div[@class='x-grid3-cell-inner x-grid3-col-partyId']")).getText();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		driver.findElement(By.xpath("//div/a[text()='Delete']")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.xpath("//label[text()='Lead ID:']/following::input[1]")).sendKeys(leadId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		String expectedMessage = "No records to display";
		String actualMessage = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		
		if(actualMessage.contains(expectedMessage))
		{
			System.out.println("Actual Message is: "+actualMessage);
			System.out.println("Lead ID is successfully deleted");
		}
		else
		{
			System.out.println("Actual Message is: "+actualMessage);
			System.out.println("Lead ID is not deleted");
		}
		
		
		driver.close();
	}

}
