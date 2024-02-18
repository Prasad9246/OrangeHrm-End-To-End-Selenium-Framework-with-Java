package baseTests;

import java.lang.reflect.Method;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.chiacon.drivers.DriverSetUp;
import com.chiacon.readPropertiesFiles.ReadProperties;

import excelUtils.ReadExcelData;

public class BaseTest {

	static Properties prop = null;

	@BeforeSuite
	public void loadPropertyFile() {
		prop = ReadProperties.readPropertyFile();
		ReadExcelData.openWorkbook();
	}

	@Parameters("browser")
	@BeforeMethod
	public void setUp(Method method,String browser) {
		DriverSetUp.initDriver(browser);
	}

	@AfterMethod
	public void tearDown() {
		DriverSetUp.quitBrowser();
	}

}
