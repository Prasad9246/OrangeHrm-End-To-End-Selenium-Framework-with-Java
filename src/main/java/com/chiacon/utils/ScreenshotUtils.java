package com.chiacon.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driverManager.DriverManager;

public class ScreenshotUtils {

	private ScreenshotUtils() {
	}

	public static String captureScreenshotAsBase64() {
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
	
}
