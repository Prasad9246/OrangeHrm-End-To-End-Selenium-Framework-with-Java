package pages;

import org.openqa.selenium.By;

import com.chiacon.utils.SeleniumUtils;

import logMassage.Logs;

public class AddEmployeePage {

	private static final By TXT_WELCOME = By.xpath("(//h6)[2]");
	private static final By FIRST_NAME = By.xpath("//input[@name='firstName']");
	private static final By MIDDLE_NAME = By.xpath("//input[@name='middleName']");
	private static final By LAST_NAME = By.xpath("//input[@name='lastName']");
	private static final By SUBMIT_BTN = By.xpath("//button[@type='submit']");

	private void clickElement(By by, String elementName) {
		Logs.logClickInfo(AddEmployeePage.class, elementName);
		SeleniumUtils.clickElement(by);
	}

	public String getWelcomeText() {
		Logs.logMessage(AddEmployeePage.class, "Get 'Add Employee' text");
		return SeleniumUtils.getVisibleText(TXT_WELCOME);
	}

	private void sendKeysToElement(String value, By by, String elementName) {
		Logs.logSendKeysInfo(AddEmployeePage.class, elementName);
		SeleniumUtils.sendKeysToElement(by, value);
	}

	public EmployeeDetailsPage addNewEmplyoee(String firstName, String middleName, String lastName) {
		sendKeysToElement(firstName, FIRST_NAME, "Emplyoee First Name");
		sendKeysToElement(middleName, MIDDLE_NAME, "Emplyoee Middle Name");
		sendKeysToElement(lastName, LAST_NAME, "Emplyoee Last Name");
		clickElement(SUBMIT_BTN, "Emplyoee Add Submit Button");
		return new EmployeeDetailsPage();
	}
}
