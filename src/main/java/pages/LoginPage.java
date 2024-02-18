package pages;

import org.openqa.selenium.By;

import com.chiacon.utils.SeleniumUtils;

import logMassage.Logs;

public class LoginPage {

	private static final By TXT_USERNAME = By.xpath("//input[@name='username']");
	private static final By TXT_PASSWORD = By.xpath("//input[@name='password']");
	private static final By BTN_LOGIN = By.xpath("//button[@type='submit']");
	private static final By ERROR_MSG = By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");

	private void clickElement(By by, String elementName) {
		Logs.logClickInfo(LoginPage.class, elementName);
		SeleniumUtils.clickElement(by);
	}

	private void sendKeysToElement(String value, By by, String elementName) {
		Logs.logSendKeysInfo(LoginPage.class, elementName);
		SeleniumUtils.sendKeysToElement(by, value);
	}

	public String getActualUrl() {
		Logs.logMessage(LoginPage.class, "Get 'Login Page' URL");
		return SeleniumUtils.getPageUrl();
	}

	public String getActualTitle() {
		Logs.logMessage(LoginPage.class, "Get 'Login Page' Title");
		return SeleniumUtils.getPageTitle();
	}

	public String getErrorMsg() {
		return SeleniumUtils.getVisibleText(ERROR_MSG);
	}

	public HomePage loginApplication(String username, String password) {
		sendKeysToElement(username, TXT_USERNAME, "Username");
		sendKeysToElement(password, TXT_PASSWORD, "Password");
		clickElement(BTN_LOGIN, "Login Button");
		return new HomePage();
	}
}
