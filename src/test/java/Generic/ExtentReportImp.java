package Generic;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportImp {

	public static void extentReport() throws IOException {

		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it
		ExtentTest test = extent.createTest("How old are you home page",
				"This is a test to check all functionality on home page");

		test.log(Status.INFO, "This step shows the details");

		test.log(Status.PASS, "This step shows  pass test cases and details");

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");

		// calling flush writes everything to the log file
		extent.flush();

	}

}
