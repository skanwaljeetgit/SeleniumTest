package Selenium.Test.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Selenium.Test.Base.*;
import Selenium.Test.DataProvider.*;
import Selenium.Test.PageObjects.*;
import Selenium.Test.Utility.*;

/**
 * @author kanwaljeetsingh This test case validates the end to end order
 *         functionality
 */
public class EndToEndTest extends BaseClass {

	AddressPage addressPage;
	LoginPage loginPage;
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderConfirmationPage;

	@Test(groups = "Regression", dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void endToEndTest(String productName, String qty, String size) throws Exception {
		Log.startTestCase("endToEndTest");
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
		loginPage = orderPage.clickProceedToCheckout();
		Log.info("Clicked on Proceed to Checkout button on Order page");
		addressPage = loginPage.userLoginToAddress(prop.getProperty("email"), prop.getProperty("password"));
		Log.info("User logged in");
		shippingPage = addressPage.clickProceedToCheckout();
		Log.info("Clicked on Proceed to Checkout button on Shipping Page");
		shippingPage.checkTermsCheckbox();
		Log.info("Checked Terms checkbox on Shipping Page");
		paymentPage = shippingPage.clickProceedToCheckout();
		Log.info("Clicked on Proceed to Checkout button on Payment Page");
		orderSummaryPage = paymentPage.clickOnPaymentMethod();
		Log.info("Clicked on Payment Method on Order Summary Page");
		orderConfirmationPage = orderSummaryPage.clickConfirmOrder();
		Log.info("Clicked on Confirm Order button on Order Summary Page");
		String actualConfirmOrderMessage = orderConfirmationPage.validateConfirmOrderMessage();
		String expectedConfirmOrderMessage = prop.getProperty("expectedMessage");
		Assert.assertEquals(actualConfirmOrderMessage, expectedConfirmOrderMessage, "confirmOrderMessage_Not_Found");
		Log.info("confirmOrderMessage validated successfully");
		Log.endTestCase("endToEndTest");

	}

}
