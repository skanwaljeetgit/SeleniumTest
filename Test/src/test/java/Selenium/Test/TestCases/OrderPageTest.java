package Selenium.Test.TestCases;

import org.testng.Assert;

import org.testng.annotations.Test;
import Selenium.Test.Base.*;
import Selenium.Test.DataProvider.*;
import Selenium.Test.PageObjects.*;
import Selenium.Test.Utility.*;
/**
 * @author kanwaljeetsingh This test case validates the totalPrice on OrderPage
 */
public class OrderPageTest extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;

	@Test(groups = "Regression", dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void totalPriceTest(String productName, String qty, String size) throws Exception {
		Log.startTestCase("totalPriceTest");
		indexPage = new IndexPage();
		Log.info("Index Page load");
		searchResultPage = indexPage.searchProduct(productName);
		Log.info("Entered product name: " + productName);
		Log.info("Search Result Page loaded");
		addToCartPage = searchResultPage.clickOnProduct();
		Log.info("Clicked on product on Search Result Page");
		addToCartPage.enterQuantity(qty);
		Log.info("Entered quantity: " + qty);
		addToCartPage.selectSize(size);
		Log.info("Selected size: " + size);
		addToCartPage.clickAddToCart();
		Log.info("Clicked on Add to Cart button");
		orderPage = addToCartPage.clickProceedToCheckout();
		Log.info("Clicked on Proceed to Checkout button on Add to Cart page");
		Double unitPrice = orderPage.getUnitPrice();
		Double totalPrice = orderPage.getTotalPrice();
		Double totalExpectedPrice = (unitPrice * (Double.parseDouble(qty))) + 2;
		Assert.assertEquals(totalPrice, totalExpectedPrice, "totalExpectedPrice_Not_Found");
		Log.info("totalExpectedPrice validated successfully");
		Log.endTestCase("totalPriceTest");
	}

}
