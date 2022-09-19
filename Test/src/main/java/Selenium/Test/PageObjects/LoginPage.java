package Selenium.Test.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.Test.Base.BaseClass;
import Selenium.Test.ActionDriver.Action;


/**
 * @author kanwaljeetsingh PageFactory is used to initialize elements on pages
 */

public class LoginPage extends BaseClass {
	@FindBy(id = "email")
	WebElement emailAddress;

	@FindBy(name = "passwd")
	WebElement password;

	@FindBy(id = "SubmitLogin")
	WebElement signInButton;

	@FindBy(id = "email_create")
	WebElement emailAddressNewAcc;

	@FindBy(name = "SubmitCreate")
	WebElement createAccountButton;

	public LoginPage() {

		PageFactory.initElements(getDriver()
				, this);
	}

	// click on signInButton on LoginPage to load HomePage
	public HomePage userLogin(String emailAddress, String password) throws Exception {

		Action.type(this.emailAddress, emailAddress);
		Action.type(this.password, password);
		Action.click(signInButton);
		return new HomePage();

	}

	// click on signInButton on LoginPage to load AddressPage, might never be used
	public AddressPage userLoginToAddress(String emailAddress, String password) throws Exception {

		Action.type(this.emailAddress, emailAddress);
		Action.type(this.password, password);
		Action.click(signInButton);
		return new AddressPage();
	}

	// click on createAccountButton on LoginPage to load AccountCreationPage
	public AccountCreationPage createNewAccount(String emailAddressNewAcc) throws Exception {
		Action.type(this.emailAddressNewAcc, emailAddressNewAcc);
		Action.click(createAccountButton);
		return new AccountCreationPage();
	}

}
