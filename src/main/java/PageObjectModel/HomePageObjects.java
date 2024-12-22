package PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects {

	public WebDriver driver;

	private By MyAccount = By.xpath("//a[@title='My Account']");
	private By Register = By.xpath("//a[text()='Register']");
	private By Login = By.xpath("//a[text()='Login']");

	private By Searchbar = By.xpath("//input[@name='search']");
	private By SearchButton = By.xpath("//span[@class='input-group-btn']");
	private By IphonePrice = By.xpath("//p[@class='price']");
	private By IphoneAddToCart = By.xpath("//h4//a[text()='iPhone']/following::i[1]");
	private By SamsungPrice = By.xpath("//a[text()='Samsung Galaxy Tab 10.1']/following::p[@class='price']");
	private By SamsungAddToCart = By.xpath("//h4//a[text()='Samsung Galaxy Tab 10.1']/following::i[1]");
	private By TotalAddToCartButton = By.xpath("//div[@class='btn-group btn-block']");

	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement ClickOnMyAccount() {

		return driver.findElement(MyAccount);
	}

	public WebElement ClickOnRegister() {

		return driver.findElement(Register);

	}

	public WebElement ClickOnLogin() {

		return driver.findElement(Login);

	}
	
	public WebElement SearchbarValue() {
		
		return driver.findElement(Searchbar);
	}
	
	public WebElement ClickonSearchButton() {
		
		return driver.findElement(SearchButton);
	}
	
	public WebElement iphoneprice() {
		
		return driver.findElement(IphonePrice);
	}
	
	public WebElement ClickOnIphoneAddToCart() {
		
		return driver.findElement(IphoneAddToCart);
	}
	
public List<WebElement> samsungprice() {
		
		return driver.findElements(SamsungPrice);
	}


public WebElement ClickOnSamsungAddToCart() {
	
	return driver.findElement(SamsungAddToCart);
}
	public WebElement ClickOnTotalAddToCartButton() {
		
		return driver.findElement(TotalAddToCartButton);
	}

}
