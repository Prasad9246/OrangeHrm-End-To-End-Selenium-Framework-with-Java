package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.chiacon.annotations.FrameworkAnnotations;

import baseTests.BaseTest;
import dataProviders.TestData;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	@FrameworkAnnotations(author = "Prasad", category = "smoke")
	@Test(priority = 1, description = "Verify Login Title", enabled = false)
	public void verifyLoginPageTitle() {
		LoginPage loginPage = new LoginPage();
		String actualTitle = loginPage.getActualTitle();
		String expectedTitle = "OrangeHRM";
		Assert.assertEquals(expectedTitle, actualTitle,
				"Actual Text : " + actualTitle + " does not match the Expected Text : " + expectedTitle);
	}

	@FrameworkAnnotations(author = "Prasad", category = "smoke")
	@Test(priority = 2, description = "Verify Login URL", enabled = false)
	public void verifyLoginPageUrl() {
		LoginPage loginPage = new LoginPage();
		String actualUrl = loginPage.getActualUrl();
		String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		Assert.assertEquals(expectedUrl, actualUrl,
				"Actual Text : " + actualUrl + " does not match the Expected Text : " + expectedUrl);
	}

	@FrameworkAnnotations(author = "Prasad", category = "smoke")
	@Test(priority = 3, dataProviderClass = TestData.class, dataProvider = "LoginPage_Credentials", description = "Verify Login with Valid Credentials", enabled = false)
	public void verifyLoginButton(Map<String, String> map) {
		LoginPage loginPage = new LoginPage();
		String actualText = loginPage.loginApplication(map.get("username"), map.get("password")).getDashboardText();
		String expectedText = "Dashboard";
		Assert.assertEquals(expectedText, actualText,
				"Actual Text : " + actualText + " does not match the Expected Text : " + expectedText);
	}

}
