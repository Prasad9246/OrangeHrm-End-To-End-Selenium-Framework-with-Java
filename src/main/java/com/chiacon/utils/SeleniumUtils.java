package com.chiacon.utils;

import static com.chiacon.readPropertiesFiles.ReadProperties.prop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverManager.DriverManager;

public class SeleniumUtils {

	private static final int TIMEOUT_SECONDS = Integer.parseInt(prop.getProperty("timeout"));

	private SeleniumUtils() {
	}

	private static WebDriverWait getWebDriverWait() {
		return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(TIMEOUT_SECONDS));
	}

	private static WebElement waitForVisibilityOfElement(By by) {
		return getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static void clickElement(By by) {
		WebElement element = getWebDriverWait().until(ExpectedConditions.elementToBeClickable(by));
		element.click();
	}

	public static void sendKeysToElement(By by, String value) {
		waitForVisibilityOfElement(by).sendKeys(value);
	}

	public static String getVisibleText(By by) {
		return waitForVisibilityOfElement(by).getText();
	}

	public static String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

	public static String getPageUrl() {
		return DriverManager.getDriver().getCurrentUrl();
	}

}
