package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.chiacon.constant.FrameworkConstant;

public class ExtendReports {

	private static ExtentReports extent;
	private static ExtentTest extentTest;

	private ExtendReports() {
	}


	public static void initReports() {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstant.getReportPath());
		extent.attachReporter(spark);
	}

	public static void flushReport() {
		extent.flush();
	}

	public static void createTest(String testCaseName) {
		extentTest = extent.createTest(testCaseName);
		ExtendManager.setExtentTest(extentTest);
	}

	public static void assignCategory(String category) {
		ExtendManager.getExtentTest().assignCategory(category);
	}

	public static void assignAuthor(String author) {
		ExtendManager.getExtentTest().assignAuthor(author);
	}

}
