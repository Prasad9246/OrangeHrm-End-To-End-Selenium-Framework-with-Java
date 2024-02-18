package pages;

import org.openqa.selenium.By;

import com.chiacon.utils.SeleniumUtils;

import logMassage.Logs;

public class PIMPage {

	private static final By TXT_WELCOME = By.xpath("//h6");
	private static final By ADD_EMP_BTN = By.xpath("(//button[@type='button'])[4]");
	private static final By SEARCH_EMP_NAME = By.xpath("(//input[@placeholder='Type for hints...'])[1]");
	private static final By SEARCH_ID_BTN = By.xpath("//button[@type='submit']");
	private static final By EMP_DELETE_BTN = By.xpath("(//i[@class='oxd-icon bi-trash'])[1]");
	private static final By COMFIRM_DELTE_BTN = By.xpath("//i[@class='oxd-icon bi-trash oxd-button-icon']");
	private static final By DELETE_MSG = By
			.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']");

	private void clickElement(By by, String elementName) {
		Logs.logClickInfo(PIMPage.class, elementName);
		SeleniumUtils.clickElement(by);
	}

	private void sendKeysToElement(String value, By by, String elementName) {
		Logs.logSendKeysInfo(PIMPage.class, elementName);
		SeleniumUtils.sendKeysToElement(by, value);
	}

	public String getWelcomeText() {
		Logs.logMessage(PIMPage.class, "Get 'PIM' text");
		return SeleniumUtils.getVisibleText(TXT_WELCOME);
	}

	public String getEmpDeleteMsg() {
		Logs.logMessage(PIMPage.class, "Get 'Successfully Deleted' text");
		return SeleniumUtils.getVisibleText(DELETE_MSG);
	}

	public AddEmployeePage clickAddNewEmployeeButton() {
		clickElement(ADD_EMP_BTN, "Add Employee Button");
		return new AddEmployeePage();

	}

	public PIMPage clickDeleteEmplyoeeButton(String empName) {
		sendKeysToElement(empName, SEARCH_EMP_NAME, "Employee Name");
		clickElement(SEARCH_ID_BTN, "Employee Search Button");
		clickElement(EMP_DELETE_BTN, "Employee Delete Button");
		clickElement(COMFIRM_DELTE_BTN, "Employee Confirm Delete Button");
		return this;
	}

}
