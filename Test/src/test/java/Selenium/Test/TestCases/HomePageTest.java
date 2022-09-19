package Selenium.Test.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Selenium.Test.Base.*;
import Selenium.Test.DataProvider.*;
import Selenium.Test.PageObjects.*;
import Selenium.Test.Utility.*;

/**
 * @author kanwaljeetsingh This test case validates the orderHistoryLabel on
 *         HomePage
 */

public class HomePageTest extends BaseClass {
	LoginPage loginPage;// = new IndexPage();;
	IndexPage indexPage;
	HomePage homePage;

	@Test(groups = "Smoke", dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void orderHistoryDetailLabelTest(String userName, String password) throws Exception {
		Log.startTestCase("orderHistoryDetailLabelTest");
		indexPage = new IndexPage();
		Log.info("Index Page load");
		loginPage = indexPage.clickOnSignIn();
		Log.info("Clicked on Sign in button");
		homePage = loginPage.userLogin(userName, password);
		Log.info("Entered Email address: " + userName + "and password: " + password + " for login");
		boolean orderHistory = homePage.validateOrderHistory();
		Assert.assertTrue(orderHistory, "orderHistoryLabel_Not_Found");
		Log.info("orderHistory label validated successfully");
		Log.endTestCase("orderHistoryDetailLabelTest");

	}

}
