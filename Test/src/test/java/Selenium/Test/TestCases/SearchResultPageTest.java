package Selenium.Test.TestCases;

import org.testng.Assert;

import org.testng.annotations.Test;
import Selenium.Test.Base.*;
import Selenium.Test.DataProvider.*;
import Selenium.Test.PageObjects.*;
import Selenium.Test.Utility.*;
/**
 * @author kanwaljeetsingh This test case validates the productAvailability on
 *         SearchResultPage
 */
public class SearchResultPageTest extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchResultPage;

	@Test(groups = "Smoke", dataProvider = "searchProduct", dataProviderClass = DataProviders.class)
	public void productAvailabilityTest(String productName) throws Exception {
		Log.startTestCase("productAvailabilityTest");
		indexPage = new IndexPage();
		Log.info("Index Page load");
		searchResultPage = indexPage.searchProduct(productName);
		Log.info("Entered product name: " + productName);
		Log.info("Search Result Page loaded");
		boolean productAvailable = searchResultPage.validateProductAvailability();
		Assert.assertTrue(productAvailable, "product_Not_Found");
		Log.info("productAvailability validated successfully");
		Log.endTestCase("productAvailabilityTest");
	}
}
