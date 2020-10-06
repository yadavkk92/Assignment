package amazontest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazon {
	
	
	
	public static void main(String[] args) {
		
		WebDriver driver;
		List<WebElement> resultlist = null;

		System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Laptops");
			driver.findElement(By.className("nav-input")).click();
			resultlist = driver.findElements(By.className("a-link-normal a-text-normal"));
		
			for(WebElement result : resultlist)
			{
				if(!result.getText().contains("Laptop"))
					{
					System.out.println("Incorrect Result");
					}
					}
			
			//driver.close();
		}
		
	}
