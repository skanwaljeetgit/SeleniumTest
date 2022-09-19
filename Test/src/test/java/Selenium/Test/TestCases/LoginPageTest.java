package Selenium.Test.TestCases;

import org.testng.Assert;

import org.testng.annotations.Test;
import Selenium.Test.Base.*;
import Selenium.Test.DataProvider.*;
import Selenium.Test.PageObjects.*;
import Selenium.Test.Utility.*;
/**
 * @author kanwaljeetsingh This test case validates the expectedURL of LoginPage
 */
public class LoginPageTest extends BaseClass {

	LoginPage loginPage;// = new IndexPage();;
	IndexPage indexPage;
	HomePage homePage;

	@Test(groups = { "Smoke", "Sanity" }, dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void loginTest(String userName, String password) throws Exception {
		Log.startTestCase("loginTest");
		indexPage = new IndexPage();
		Log.info("Index Page load");
		loginPage = indexPage.clickOnSignIn();
		Log.info("Click on SignIn");
		homePage = loginPage.userLogin(userName, password);
		Log.info("Entered Email address: " + userName + "and password: " + password + " for login");
		String actualURL = homePage.getCurrentUrl();
		String expectedURL = prop.getProperty("expectedUrl");
		Assert.assertEquals(actualURL, expectedURL, "expectedURL_Not_Found");
		Log.info("Log in validated successfully");
		Log.endTestCase("loginTest");
	}

}
