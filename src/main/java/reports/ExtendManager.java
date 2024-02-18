package reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtendManager {

	private ExtendManager() {
	}

	private final static ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>();

	public static void setExtentTest(ExtentTest extentTest) {
		threadLocal.set(extentTest);
	}

	public static ExtentTest getExtentTest() {
		return threadLocal.get();
	}

}
