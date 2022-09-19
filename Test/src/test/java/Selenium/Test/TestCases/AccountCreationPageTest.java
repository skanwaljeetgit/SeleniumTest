package Selenium.Test.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Selenium.Test.Base.*;
import Selenium.Test.DataProvider.*;
import Selenium.Test.PageObjects.*;
import Selenium.Test.Utility.*;

/**
 * @author kanwaljeetsingh This test case validates the formHeader on
 *         AccountCreationPage
 */
public class AccountCreationPageTest extends BaseClass {

	LoginPage loginPage;
	IndexPage indexPage;
	HomePage homePage;
	AccountCreationPage accountCreationPage;

	@Test(groups = "Sanity", dataProvider = "accountCreationEmail", dataProviderClass = DataProviders.class)
	public void accountCreatePageTest(String accountCreationEmail) throws Exception {
		Log.startTestCase("accountCreatePageTest");
		indexPage = new IndexPage();
		Log.info("Index Page load");
		loginPage = indexPage.clickOnSignIn();
		Log.info("Clicked on Sign in button");
		accountCreationPage = loginPage.createNewAccount(accountCreationEmail);
		Log.info("Entered Email address for account creation: " + accountCreationEmail);
		boolean formHeader = accountCreationPage.validateAccountCreatePage();
		Assert.assertTrue(formHeader, "formHeader_Not_Found");
		Log.info("createAccountFormHeader validated successfully");
		Log.endTestCase("accountCreatePageTest");
	}
}