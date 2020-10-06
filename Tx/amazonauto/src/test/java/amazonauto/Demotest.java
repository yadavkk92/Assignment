package amazonauto;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import dataprovider.TestDataProvider;
import listeners.Listeners;
import pageObjects.AmazonPage;
import utility.ReadExcelFile;
import utility.Utility;

public class Demotest extends BaseTest{

	AmazonPage ap;
	List<String> l2 = null;
	String excelFile = "searchData";
	String sheetName = "SearchItems";
	String generalSearch = "Laptops";
	
	
	@BeforeMethod
	public void setUp() {
		initBrowser();
		ap= new AmazonPage(driver);
	}
	
	//@Test(enabled=true,dataProvider = "SearchData",dataProviderClass = TestDataProvider.class)
	@Test
	public void searchAccuracy() throws InterruptedException {
		//System.out.println(searchtext);
		ap.searchText("Laptop");
		
		ap.clickGoButton();
		List<WebElement> resultlist = ap.getItemlist();
		
		for(WebElement result : resultlist) {
			System.out.println(result.getText());
		Assert.assertTrue(result.getText().contains("Laptop"));
	}
	}
	
	@Test(enabled = false)
	public void searchAccuracyforHp() throws InterruptedException, IOException {
		l2  = ReadExcelFile.getSheetData(excelFile, sheetName);
		//test.log(Status.INFO,"excel data fetched successfully");
		for (String specificSearch : l2) {
		ap.searchText(specificSearch);
		ap.clickGoButton();
		List<WebElement> resultlist = ap.getItemlist();
		for(WebElement result : resultlist) {
		Assert.assertTrue(result.getText().contains("Laptop"));
			}
		}
	}

	
	@Test(enabled = false)
	public void verifyItemPrice() throws InterruptedException {
		ap.searchText(generalSearch);
		ap.clickGoButton();
		List<WebElement> resultlist = ap.getItemlist();
		List<WebElement> pricelist = ap.getItemsPrice();
		String s = pricelist.get(3).getText();
		resultlist.get(3).click();	
	     Utility.switchToTab(driver);
		WebElement price = ap.getItemPrice();
		Assert.assertTrue(price.getText().contains(s));
	}
	
	@Test(enabled=false)
	public void verifyFilterSearchApplied() throws InterruptedException {
		ap.searchText(generalSearch);
		ap.clickGoButton();
		ap.selectCpuType();
		List<WebElement>  resultlist =ap.getItemlist();
		for(WebElement result : resultlist) {
			Assert.assertTrue(result.getText().contains("i3"));
}
}
	
	@Test(enabled = false)
	public void verifyProductAddedToCart() throws InterruptedException {
		ap.searchText(generalSearch);
		ap.clickGoButton();
		List<WebElement> resultlist = ap.getItemlist();
		String cart = ap.getCartCount().getText();
		int a = 2;
		resultlist.get(a).click();	
		String parent=driver.getWindowHandle();
		Set<String> wh = driver.getWindowHandles();
		Iterator<String> itr = wh.iterator();
		while(itr.hasNext())
		{
		String child_window=itr.next();
		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		}
		}
		ap.clickAddToCartButton();
		Assert.assertFalse(ap.getCartCount().getText().equals(cart));

		/*driver.findElement(By.id("attach-close_sideSheet-link")).click();
		driver.findElement(By.id("nav-cart-text-container")).click();
		Assert.assertTrue(driver.findElement(By.className("a-size-medium a-color-base sc-price sc-white-space-nowrap")).getText().contains(s));
		*/
}
	
	@Test(enabled = false)
	public void verifyOrderTotalAmount() throws InterruptedException {
		ap.searchText(generalSearch);
		ap.clickGoButton();
		List<WebElement> resultlist = ap.getItemlist();
		List<WebElement> pricelist = ap.getItemsPrice();
		
		String price = pricelist.get(2).getText();
		resultlist.get(2).click();	 

		String parent=driver.getWindowHandle();
		Set<String> wh = driver.getWindowHandles();
		Iterator<String> itr = wh.iterator();
		while(itr.hasNext())
		{
		String child_window=itr.next();
		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		}
		}
		ap.clickAddToCartButton();
		ap.clickCartButton();
		String total = ap.getSubTotal().getText();

		Assert.assertTrue(Integer.parseInt(total)> Integer.parseInt(price));
	}
	
	public void clickById(String id) {
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(id)))).click();
		
	}
}

