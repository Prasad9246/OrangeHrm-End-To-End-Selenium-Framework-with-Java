package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.chiacon.annotations.FrameworkAnnotations;

import baseTests.BaseTest;
import dataProviders.TestData;
import pages.LoginPage;

public class AddEmployeeTest extends BaseTest {

	@FrameworkAnnotations(author = "Prasad", category = "smoke")
	@Test(dataProviderClass = TestData.class, dataProvider = "AddEmployee_Credentials", 
	description = "Verify New Employee Add Save Button")
	public void verifySaveButton(Map<String, String> map) {
		LoginPage loginPage = new LoginPage();
		String actualText = loginPage.loginApplication(map.get("username"), map.get("password")).clickPIMButton()
				.clickAddNewEmployeeButton()
				.addNewEmplyoee(map.get("firstName"), map.get("middleName"), map.get("lastName")).getSuccessfulMessage();
		String expectedText = "Successfully Saved";
		Assert.assertEquals(expectedText, actualText,
				"Actual Text : " + actualText + " does not match the Expected Text : " + expectedText);
	}

}
