package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonPage {
	
	public AmazonPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "twotabsearchtextbox") WebElement searchBox;
	
	@FindBy(xpath ="//input[@value='Go']") WebElement goButton;
	
	@FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']") List<WebElement> searchedItems;
	
	@FindBy(xpath = "//span[@class='a-price-whole']") List<WebElement> itemsPriceList ;
	
	@FindBy(xpath = "//span[@id='priceblock_ourprice']") WebElement itemPrice;
	
	@FindBy(xpath = "//span[text()='Intel Core i3']") WebElement cpuType;
	
	@FindBy(id = "nav-cart-count")  WebElement cartCount;
	
	@FindBy(id = "add-to-cart-button") WebElement addToCartButton;
	
	@FindBy(id = "nav-cart-count-container") WebElement cartButton;
	
	@FindBy(id = "a-size-medium a-color-base sc-price sc-white-space-nowrap") WebElement subTotal;
	
	public void searchText(String text) {
		searchBox.sendKeys(text);
	}
	public void clickGoButton() {
		goButton.click();
	}
	public List<WebElement> getItemlist() {
		return searchedItems;
	}
	public List<WebElement> getItemsPrice(){
		return itemsPriceList;
	}
	public WebElement getItemPrice() {
		return itemPrice;
	}
	public void selectCpuType() {
		cpuType.click();
	}
	public WebElement getCartCount() {
		return cartCount;
}
	public void clickAddToCartButton() {
		 addToCartButton.click();
}
	public void clickCartButton() {
		cartButton.click();
}
	public WebElement getSubTotal() {
		return subTotal;
	}
}
