package Selenium.Test.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import Selenium.Test.Utility.ExtentManager;

/**
 * @author kanwaljeetsingh BaseClass contains methods used for various
 *         operations required to initialize test execution
 *
 */
public class BaseClass {

	public static Properties prop;
public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	public DesiredCapabilities cap = new DesiredCapabilities();
//	public static WebDriver driver;
	

	public static  WebDriver getDriver() {
		return driver.get();
	}

	public void openApplication(String browserName) throws IOException, InterruptedException {
		// select browser for execution based on parameters
		switch (browserName.toLowerCase()) 
		{
		case "chrome":
//			WebDriverManager.chromedriver().setup();
//			driver.set(new ChromeDriver());
			cap.setPlatform(Platform.ANY);
			cap.setBrowserName("chrome");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.merge(cap);
			break;
		case "firefox":
//			WebDriverManager.firefoxdriver().setup();
//			driver.set(new FirefoxDriver());
			cap.setPlatform(Platform.ANY);
			cap.setBrowserName("firefox");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.merge(cap);
			break;
		case "internetexplorer":
//			WebDriverManager.iedriver().setup();
//			driver.set(new InternetExplorerDriver());
			cap.setPlatform(Platform.ANY);
			cap.setBrowserName("internet explorer");
			InternetExplorerOptions ieOptions = new InternetExplorerOptions();
			ieOptions.merge(cap);
			break;
		case "edge":
//			WebDriverManager.edgedriver().setup();
//			driver.set(new EdgeDriver());
			cap.setPlatform(Platform.ANY);
			cap.setBrowserName("MicrosoftEdge");
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.merge(cap);
			break;
		}
		driver.set(new RemoteWebDriver(new URL("http://192.168.29.63:4444")
				, cap));
		//driver=new RemoteWebDriver(new URL("http://192.168.29.63:4444"), cap);
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		getDriver().manage().deleteAllCookies();
	
//		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWait")), 
//				TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTimeOut")), 
//				TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));
		// Maximize the screen
		//getDriver().manage().window().maximize();
		// Delete all the cookies
//		getDriver().manage().deleteAllCookies();
		
		// Implicit TimeOuts
		//getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWait")),
				//TimeUnit.SECONDS);
			// PageLoad TimeOuts
		//getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),
				//TimeUnit.SECONDS);
		// Launching the URL
		//getDriver().get(prop.getProperty("url"));
		
	}

	// startReport method of ExtentManager is called
	// config.properties file is loaded
	@BeforeSuite(groups = { "Smoke", "Sanity", "Regression" })
	public void beforeSuite() throws IOException {
		ExtentManager.startReport();

		prop = new Properties();
		FileInputStream fileInput = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\configuration\\config.properties");
		System.out.println(System.getProperty("user.dir"));
		prop.load(fileInput);
		
	}

	// browserName parameter passed to openApplication method above to select
	// browser for execution
	@Parameters("browserName")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setup(String browserName) throws IOException, InterruptedException {
		openApplication(browserName);
	}

	// quit all browser sessions
	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
		//driver.close();
	}
	
	// endReport method of ExtentManager is called
	@AfterSuite//(groups = { "Smoke", "Sanity", "Regression" })
	public void afterSuite() {
		//driver.close();
		ExtentManager.endReport();
	}
}
