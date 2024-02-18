package com.chiacon.drivers;

import static com.chiacon.readPropertiesFiles.ReadProperties.prop;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import driverFactory.DriverFactory;
import driverManager.DriverManager;

public class DriverSetUp {

	private DriverSetUp() {
	}

	public static void initDriver(String browserName) {
		if (DriverManager.getDriver() == null) {
			WebDriver driver = DriverFactory.getDriver(browserName);
			DriverManager.setDriver(driver);
		}
		DriverManager.getDriver().get(prop.getProperty("url"));
		if (prop.getProperty("maxwindow").equalsIgnoreCase("true")) {
			DriverManager.getDriver().manage().window().maximize();
		}
		DriverManager.getDriver().manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("timeout"))));
	}

	public static void quitBrowser() {
		WebDriver driver = DriverManager.getDriver();
		if (driver != null) {
			DriverFactory.quitDriver();
			DriverManager.setDriver(null);
		}
	}

}
