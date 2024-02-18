package reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.chiacon.utils.ScreenshotUtils;

public class ExtendLogger {

	private ExtendLogger() {
	}

	public static void pass(String message) {
		ExtendManager.getExtentTest().pass(message, MediaEntityBuilder
				.createScreenCaptureFromBase64String(ScreenshotUtils.captureScreenshotAsBase64()).build());
	}

	public static void fail(String message) {
		ExtendManager.getExtentTest().fail(message, MediaEntityBuilder
				.createScreenCaptureFromBase64String(ScreenshotUtils.captureScreenshotAsBase64()).build());
	}

	public static void info(String message) {
		ExtendManager.getExtentTest().info(message, MediaEntityBuilder
				.createScreenCaptureFromBase64String(ScreenshotUtils.captureScreenshotAsBase64()).build());
	}

}
