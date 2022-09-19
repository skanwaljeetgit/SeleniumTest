package Selenium.Test.Utility;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Selenium.Test.ActionDriver.Action;
import Selenium.Test.Base.BaseClass;

/**
 * @author kanwaljeetsingh Listener class is used to perform actions defined in
 *         onStart(), This uses ExtentHtmlReporter object to load the
 *         extent-config.xml located at src\test\resources folder
 * 
 */

public class ListenerClass extends ExtentManager implements ITestListener {

	Action action = new Action();

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}

	// moves the existing ExtentReport under
	// test-output\extentreport\CurrentTestResults folder
	// to test-output\extentreport\ArchivedTestResults folder organized by test runs
	
	@Override
	public void onStart(ITestContext result) {
		File sourceFile = new File(System.getProperty("user.dir") 
				+ "\\test-output\\extentreport\\CurrentTestResults\\"
				+ "ExtentReport.html");
		if (sourceFile.exists()) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmm");
			LocalDateTime now = LocalDateTime.now();
			String s = "" + now.truncatedTo(ChronoUnit.MINUTES).format(dtf);

			String foldername = "TestResults" + s;
			File dir = new File(
					System.getProperty("user.dir") 
					+ "\\test-output\\extentreport\\ArchivedTestResults\\" + foldername);
			dir.mkdir();
			File destFile = new File(System.getProperty("user.dir")
					+ "\\test-output\\extentreport\\ArchivedTestResults\\" + foldername + "\\ExtentReport.html");

			if (sourceFile.renameTo(destFile)) {
				System.out.println("Older extent reports archived");
			} else {
				System.out.println("Failed to move file");
			}
		}
	}

	// logs the passing test cases in extent report
	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS)
			test.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed: " + result.getName(), ExtentColor.GREEN));
		getExtent();
	}

	// logs the failing test cases in extent report with screenshots
	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			try {

				Log.error("Test Case Failed: " + result.getName() + " " + result.getThrowable().getMessage());
				test.log(Status.FAIL,
						MarkupHelper.createLabel(
								"Test Case Failed: " + result.getName() + " " + result.getThrowable().getMessage(),
								ExtentColor.RED));
				String imgPath = Action.takeScreenShot(BaseClass.getDriver()
						, result.getName().toString(),
						result.getThrowable().getMessage().toString());
				test.fail("Attachment: ", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
			} catch (Exception e) {
				Log.error(e.getMessage());
			}
		}
	}

	// logs the skipped test cases in extent report
	@Override
	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP,
					MarkupHelper.createLabel("Test Case Skipped: " + result.getName(), ExtentColor.ORANGE));
		}
	}

}