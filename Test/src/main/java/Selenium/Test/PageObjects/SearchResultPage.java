package Selenium.Test.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.Test.Base.BaseClass;
import Selenium.Test.ActionDriver.Action;


/**
 * @author kanwaljeetsingh PageFactory is used to initialize elements on pages
 */

public class SearchResultPage extends BaseClass {

	@FindBy(xpath = "//a[@class = 'product-name' and contains(text(),'Faded Short Sleeve T-shirts') and @itemprop='url']")
	WebElement resultTopSellers;

	@FindBy(xpath = "//*[@id=\"center_column\"]//img")
	WebElement resultTopSellersQuickView;

	@FindBy(xpath = "//div[@id='best-sellers_block_right']//ul[@class='block_content products-block']/li[3]/a/img")
	WebElement resultTopSellersBlouse;

	@FindBy(xpath = "//span[text()='Add to cart']")
	WebElement addToCartUnderResult;

	@FindBy(xpath = "//i[@class='icon-eye-open']")
	WebElement eyeIconOnResult;

	public SearchResultPage() {
		PageFactory.initElements(getDriver()
				, this);
	}

	// validate resultTopSellers element is displayed
	public boolean validateProductAvailability() throws Exception {
		return Action.isDisplayed(resultTopSellers);
	}

	// click on resultTopSellers element to load AddToCartPage
	public AddToCartPage clickOnProduct() throws Exception {
		Action.click(resultTopSellers);
		return new AddToCartPage();
	}

}
