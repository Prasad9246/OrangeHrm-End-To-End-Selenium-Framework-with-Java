package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.chiacon.annotations.FrameworkAnnotations;

import baseTests.BaseTest;
import dataProviders.TestData;
import pages.LoginPage;

public class HomeTest extends BaseTest {

	@FrameworkAnnotations(author = "Prasad", category = "smoke")
	@Test(priority = 1, dataProviderClass = TestData.class, dataProvider = "HomePage_Credentials",
	description = "Verify HomePage Title")
	public void verifyHomePageTitle(Map<String, String> map) {
		LoginPage loginPage = new LoginPage();
		String actualTitle = loginPage.loginApplication(map.get("username"), map.get("password")).getActualTitle();
		String expectedTitle = "OrangeHRM";
		Assert.assertEquals(expectedTitle, actualTitle,
				"Actual Text : " + actualTitle + " does not match the Expected Text : " + expectedTitle);
	}

	@FrameworkAnnotations(author = "Prasad", category = "smoke")
	@Test(priority = 2, dataProviderClass = TestData.class, dataProvider = "HomePage_Credentials", 
	description = "Verify Homepage URL")
	public void verifyHomePageUrl(Map<String, String> map) {
		LoginPage loginPage = new LoginPage();
		String actualUrl = loginPage.loginApplication(map.get("username"), map.get("password")).getActualUrl();
		String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(expectedUrl, actualUrl,
				"Actual Text : " + actualUrl + " does not match the Expected Text : " + expectedUrl);
	}

	@FrameworkAnnotations(author = "Prasad", category = "smoke")
	@Test(priority = 3, dataProviderClass = TestData.class, dataProvider = "HomePage_Credentials", 
	description = "Verify PIM Button")
	public void verifyPIMButton(Map<String, String> map) {
		LoginPage loginPage = new LoginPage();
		String actualText = loginPage.loginApplication(map.get("username"), map.get("password")).
				clickPIMButton().getWelcomeText();
		String expectedText = "PIM";
		Assert.assertEquals(expectedText, actualText,
				"Actual Text : " + actualText + " does not match the Expected Text : " + expectedText);
	}
}
