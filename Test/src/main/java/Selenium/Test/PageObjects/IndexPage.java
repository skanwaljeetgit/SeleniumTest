package Selenium.Test.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.Test.Base.BaseClass;
import Selenium.Test.ActionDriver.Action;


/**
 * @author kanwaljeetsingh PageFactory is used to initialize elements on pages
 */
public class IndexPage extends BaseClass {

	@FindBy(xpath = "//a[@class = 'login']")
	WebElement signInButton;
	
	@FindBy(xpath = "//img[@class ='logo img-responsive']")
	WebElement storeLogo;

	@FindBy(id = "search_query_top")
	WebElement searchBox;

	@FindBy(name = "submit_search")
	WebElement searchButton;

	public IndexPage() {

		PageFactory.initElements(getDriver()
				, this);
	}

	// click signInButton on IndexPage to load LoginPage
	public LoginPage clickOnSignIn() throws Exception {
		Action.click(signInButton);
		return new LoginPage();
	}

	// validate storeLogo
	public boolean validateLogo() throws Exception {
		return Action.isDisplayed(storeLogo);
	}

	// validate signInButton
	public boolean validateSignIn() throws InterruptedException {

		return signInButton.isEnabled();
	}

	// validate page title
	public String getStoreTitle() {

		String storeTitle = getDriver().getTitle();
		return storeTitle;
	}

	// click on searchButton on IndexPage to load SearchResultPage
	public SearchResultPage searchProduct(String productName) throws Exception {
		Action.type(searchBox, productName);
		Action.click(searchButton);
		return new SearchResultPage();
	}

}
