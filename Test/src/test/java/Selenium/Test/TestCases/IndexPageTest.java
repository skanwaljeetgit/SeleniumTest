package Selenium.Test.TestCases;

import org.testng.Assert;

import org.testng.annotations.Test;
import Selenium.Test.Base.*;
import Selenium.Test.DataProvider.*;
import Selenium.Test.PageObjects.*;
import Selenium.Test.Utility.*;
/**
 * @author kanwaljeetsingh This test case validates the storeTitle
 */
public class IndexPageTest extends BaseClass {

	IndexPage indexPage;

	@Test(groups = "Smoke", dataProvider = "getStoreTitle", dataProviderClass = DataProviders.class)
	public void storeTitleTest(String storeTitle) throws Exception {
		Log.startTestCase("storeTitleTest");
		indexPage = new IndexPage();
		Log.info("Index Page load");
		String actualStoreTitle = indexPage.getStoreTitle();
		String expectedStoreTitle = storeTitle;
		Assert.assertEquals(actualStoreTitle, expectedStoreTitle, "storeTitle_Not_Found");
		Log.info("Store title: " + storeTitle + " validated successfully");
		Log.endTestCase("storeTitleTest");
	}

}
