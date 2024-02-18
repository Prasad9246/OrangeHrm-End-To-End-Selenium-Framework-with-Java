package pages;

import org.openqa.selenium.By;

import com.chiacon.utils.SeleniumUtils;

import logMassage.Logs;

public class HomePage {

	private static final By TXT_WELCOME = By.xpath("//h6");
	private static final By PIM_BTN = By.xpath("//span[text()='PIM']");

	private void clickElement(By by, String elementName) {
		Logs.logClickInfo(HomePage.class, elementName);
		SeleniumUtils.clickElement(by);
	}

	public String getDashboardText() {
		Logs.logMessage(HomePage.class, "Get 'Dashboard' text");
		return SeleniumUtils.getVisibleText(TXT_WELCOME);
	}

	public String getActualUrl() {
		Logs.logMessage(HomePage.class, "Get 'Home Page' URL");
		return SeleniumUtils.getPageUrl();
	}

	public String getActualTitle() {
		Logs.logMessage(HomePage.class, "Get 'Home Page' Title");
		return SeleniumUtils.getPageTitle();
	}

	public PIMPage clickPIMButton() {
		clickElement(PIM_BTN, "PIM Button");
		return new PIMPage();
	}
}
