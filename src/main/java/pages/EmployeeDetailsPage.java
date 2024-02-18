package pages;

import org.openqa.selenium.By;

import com.chiacon.utils.SeleniumUtils;

import logMassage.Logs;

public class EmployeeDetailsPage {

	private static final By SUCCESSFUL_MSG = By
			.xpath("//p[@class ='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']");
	private static final By PIM_BTN = By.xpath("//span[text()='PIM']");

	public String getSuccessfulMessage() {
		Logs.logMessage(EmployeeDetailsPage.class, "Get 'Successfully Saved' text");
		return SeleniumUtils.getVisibleText(SUCCESSFUL_MSG);

	}

	private void clickElement(By by, String elementName) {
		Logs.logClickInfo(EmployeeDetailsPage.class, elementName);
		SeleniumUtils.clickElement(by);
	}

	public PIMPage clickOnPIMButton() {
		clickElement(PIM_BTN, "PIM Button");
		return new PIMPage();
	}

}