package driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import driverManager.DriverManager;

public class DriverFactory {

	private DriverFactory() {
	}

	public static WebDriver getDriver(String browser) {
		WebDriver driver;

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new IllegalArgumentException("Invalid Browser: " + browser);
		}

		return driver;
	}

	public static void quitDriver() {
		WebDriver driver = DriverManager.getDriver();
		if (driver != null) {
			driver.quit();
		}
	}

}
