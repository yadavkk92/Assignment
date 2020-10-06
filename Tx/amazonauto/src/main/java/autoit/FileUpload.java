package autoit;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.text.StringContent;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUpload {

	
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {

	String uploadFile = System.getProperty("user.dir")+ "\\src\\test\\resources\\AutoITfiles\\Assignment-JAVA.pdf";
	System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
	driver = new ChromeDriver();
	//getUploader(uploadFile);
	//getConverter();
	getRConverter(uploadFile);
	//driver.close();
	}



	public static void getUploader(String uploadFile) throws InterruptedException, IOException {
	
	driver.get("https://www.ilovepdf.com/pdf_to_word");
	driver.findElement(By.xpath("//span[text()='Select PDF file']")).click();
	Thread.sleep(2000);
	Runtime.getRuntime().exec(new String[] {"C:/Users/YADAV/Desktop/pdfconvert.exe" ,"" , uploadFile});
	
}
	
	
	private static void getConverter() throws AWTException, InterruptedException {

		Robot r = new Robot();
		WebDriverWait wait = new WebDriverWait(driver,5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='processTaskTextBtn']")));
		
		for(int i=0;i<4;i++) {
			
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
					}
		
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("Enter pressed");

	}
	
	public static void getRConverter(String uploadFile) throws AWTException, InterruptedException {
		
		driver.get("https://www.ilovepdf.com/pdf_to_word");
		Robot r = new Robot();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Select PDF file']")).click();
	
		StringSelection ss = new StringSelection(uploadFile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);;
		Thread.sleep(2000);
		r.keyPress(KeyEvent.VK_CONTROL);
	    r.keyPress(KeyEvent.VK_V);
	    r.keyRelease(KeyEvent.VK_V);
	    r.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(2000);

	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);


	}
	
}
