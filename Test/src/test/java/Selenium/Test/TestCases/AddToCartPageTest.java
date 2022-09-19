package Selenium.Test.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Selenium.Test.Base.*;
import Selenium.Test.DataProvider.*;
import Selenium.Test.PageObjects.*;
import Selenium.Test.Utility.*;

/**
 * @author kanwaljeetsingh This test case validates the addToCartMessage on
 *         AddToCartPage
 */
public class AddToCartPageTest extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;

	@Test(groups = { "Regression", "Sanity" }, dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void addToCartTest(String productName, String qty, String size) throws Exception {
		Log.startTestCase("addToCartTest");
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
		boolean addedToCart = addToCartPage.validateAddToCart();
		Assert.assertTrue(addedToCart, "addToCartMessage_Not_Found");
		Log.info("addToCartMessage validated successfully");
		Log.endTestCase("addToCartTest");
	}

}
