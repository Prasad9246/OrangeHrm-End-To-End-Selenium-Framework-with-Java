package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.chiacon.annotations.FrameworkAnnotations;

import baseTests.BaseTest;
import dataProviders.TestData;
import pages.LoginPage;

public class PIMTest extends BaseTest {

	@FrameworkAnnotations(author = "Prasad", category = "smoke")
	@Test(dataProviderClass = TestData.class, dataProvider = "PIMPage_Credentials", description = "Verify Add Employee Button")
	public void verifyAddEmpButton(Map<String, String> map) {
		LoginPage loginPage = new LoginPage();
		String actualText = loginPage.loginApplication(map.get("username"), map.get("password")).clickPIMButton()
				.clickAddNewEmployeeButton().getWelcomeText();
		String expectedText = "Add Employee";
		Assert.assertEquals(expectedText, actualText,
				"Actual Text : " + actualText + " does not match the Expected Text : " + expectedText);
	}

}
