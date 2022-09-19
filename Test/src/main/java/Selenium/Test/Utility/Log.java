package Selenium.Test.Utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author kanwaljeetsingh Log class is used to initialize Log4j2 logs
 * 
 */
public class Log {

	// Initialize Log4j logs
	public static Logger Log = LogManager.getLogger(Log.class.getName());

	public static void startTestCase(String testCaseName) {
		Log.info("********************************Started " + testCaseName
				+ "*****************************************");
	}

	public static void endTestCase(String testCaseName) {
		Log.info("*********************************Ended " + testCaseName
				+ "******************************************");
	}

	// Need to create below methods, so that they can be called
	public static void info(String message) {

		Log.info(message);

	}

	public static void warn(String message) {

		Log.warn(message);

	}

	public static void error(String testCaseName) {

		Log.error("*********************************" + testCaseName
				+ " Failed******************************************");

	}

	public static void fatal(String message) {

		Log.fatal(message);

	}

	public static void debug(String message) {

		Log.debug(message);

	}

}
