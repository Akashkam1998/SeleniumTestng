package TestCases;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PageObjectModel.HomePageObjects;
import Resources.BaseClass;
import Resources.constants;

public class AddToCartTestCases extends BaseClass {

	@Test
	public void VerifyCartPrice() throws InterruptedException {

		HomePageObjects hpo = new HomePageObjects(driver);
		hpo.SearchbarValue().sendKeys(constants.Searchbarvalueiphone);
		hpo.ClickonSearchButton().click();

		String iphoneprice = hpo.iphoneprice().getText();
		System.out.println(iphoneprice);

		String[] iphonearray = iphoneprice.split(" ");
		System.out.println(Arrays.toString(iphonearray));
		String iphoneammount = iphonearray[0];
		System.out.println(iphoneammount);

		String finalpriceofiphone = iphoneammount.replaceAll("[^\\d.]", "");
		System.out.println(finalpriceofiphone);

		double iphoneammountdouble = Double.parseDouble(finalpriceofiphone);

		Thread.sleep(2000);

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		hpo.ClickOnIphoneAddToCart().click();

		hpo.SearchbarValue().clear();
		hpo.SearchbarValue().sendKeys(constants.Searchbarvaluesamsung);
		hpo.ClickonSearchButton().click();

		List<WebElement> producttitle = hpo.samsungprice();

		for (int i = 0; i < producttitle.size(); i++) {
			if (producttitle.get(i).getText().equalsIgnoreCase("Samsung Galaxy Tab 10.1")) {

				String samsungCost = driver.findElement(By.xpath("(//p[@class='price']")).getText();
				System.out.println(samsungCost);

				Thread.sleep(2000);

				hpo.ClickOnSamsungAddToCart().click();

			}
		}
	}
}
