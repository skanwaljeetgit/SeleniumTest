package Selenium.Test.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * @author kanwaljeetsingh ExtentManager class is used for Extent Reports This
 *         uses ExtentHtmlReporter object to load the extent-config.xml located
 *         at src\test\resources folder
 * 
 */
public class ExtentManager {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	//public static String dateName;

	public static void getExtent() {
		extent.getClass();
	}

	public static void startReport() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")
				+ "\\test-output\\extentreport\\CurrentTestResults\\"
				+ "ExtentReport.html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")
				+ "\\src\\test\\resources\\extent-config.xml"); //

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("HostName", "Localhost");
		extent.setSystemInfo("ProjectName", "eStoreProject");
		extent.setSystemInfo("Tester", "Kanwaljeet Singh");

	}

	public static void endReport() {
		extent.flush();
	}
}