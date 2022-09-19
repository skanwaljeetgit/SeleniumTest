package Selenium.Test.ActionDriver;

import java.io.File;
import java.time.Duration;
//import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Selenium.Test.Base.BaseClass;
import Selenium.Test.Utility.*;

/**
 * @author kanwaljeetsingh Action Class contains methods click, check,
 *         isDisplayed, type, selectByVisibleText, implicitWait,
 *         pageLoadTimeOut, screenShot These are used for various operations by
 *         page objects and are called in page classes
 *
 */

public class Action extends BaseClass {

	// click method used in AddressPage, AddToCartPage, IndexPage, LoginPage,
	// OrderPage, OrderSummary Page, PaymentPage,
	// SearchResultPage, ShippingPage
	public static void click(WebElement ele) throws Exception {
		try {
			// explicit wait implementation
			WebDriverWait wait = new WebDriverWait(getDriver()
					, Duration.ofSeconds(Integer.parseInt(prop.getProperty("explicitWait"))));
//			WebDriverWait wait = new WebDriverWait(driver//getDriver()
//					, Integer.parseInt(prop.getProperty("explicitWait")));
			wait.until(ExpectedConditions.visibilityOf(ele));
			// click on element passed in parameters
			ele.click();
		} catch (Exception e) {
			e.getStackTrace();
			Log.info("Element not found");
			Log.error(e.getMessage());
			throw new Exception(e.getMessage().replace(" ", "_"));
		}

	}

	// check method is used in ShippingPage
	public static void check(WebElement ele) throws Exception {
		try {
			// click on element passed in parameters
			ele.click();
		} catch (Exception e) {
			Log.info("Element not found");
			Log.error(e.getMessage());
			throw new Exception(e.getMessage().replace(" ", "_"));
		}
	}

	// isDisplayed method is used in AccountCreationPage, AddToCartPage, HomePage,
	// IndexPage, SearchResultPage
	public static boolean isDisplayed(WebElement ele) throws Exception {
		boolean flag = false;

		try {
			// explicit wait implementation
			WebDriverWait wait = new WebDriverWait(getDriver()
					, Duration.ofSeconds(Integer.parseInt(prop.getProperty("explicitWait")))); 
					//new WebDriverWait(driver//getDriver()
					//, Integer.parseInt(prop.getProperty("explicitWait")));
			wait.until(ExpectedConditions.visibilityOf(ele));
			flag = ele.isDisplayed();
			if (flag) {
				Log.info("Element displayed");
			} else {
				Log.info("Element not displayed");
			}
		} catch (Exception e) {
			Log.error(e.getMessage());
			throw new Exception(e.getMessage().replace(" ", "_"));
		}
		return flag;
	}

	// type method is used in AddToCartPage, IndexPage, LoginPage
	public static boolean type(WebElement ele, String text) throws Exception {
		boolean flag = false;
		try {
			flag = ele.isDisplayed();
			ele.clear();
			// type the text passed in parameters
			ele.sendKeys(text);
			flag = true;
		} catch (Exception e) {
			Log.info("Element not found");
			Log.error(e.getMessage());
			throw new Exception(e.getMessage().replace(" ", "_"));
		}
		return flag;
	}

	// selectByVisibleText method is used in AddToCartPage
	public static boolean selectByVisibleText(String visibletext, WebElement ele) throws Exception {
		boolean flag = false;
		try {
			// select the element with visible text, both passed in parameters
			Select s = new Select(ele);
			s.selectByVisibleText(visibletext);
			flag = true;
		} catch (Exception e) {
			Log.info("Element not found");
			Log.error(e.getMessage());
			throw new Exception(e.getMessage().replace(" ", "_"));
		}
		return flag;
	}

	// implicitWait method is used in BasePage
	public static void implicitWait(WebDriver driver, int timeOut) {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
	}

	// pageLoadTimeOut method used in BasePage
	public static void pageLoadTimeOut(WebDriver driver, int timeOut) {
		//driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
	}

	// screenShot method is used in ListenerClass
	public static String takeScreenShot(WebDriver driver, String filename, String throwable) throws Exception {

		int charAt = throwable.indexOf(" ");
		int charAt1 = throwable.indexOf(":");
		String destination;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
		LocalDateTime now = LocalDateTime.now();
		String s = "" + now.truncatedTo(ChronoUnit.MINUTES).format(dtf);
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		if (charAt != -1)
			destination = System.getProperty("user.dir") + "\\screenshots\\" + filename + "_" + s + "_"
					+ throwable.substring(0, charAt) + ".png";
		else
			destination = System.getProperty("user.dir") + "\\screenshots\\" + filename + "_" + s + "_"
					+ throwable.substring(0, charAt1) + ".png";
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
		return destination;
	}

	

}