package dataProviders;

import org.testng.annotations.DataProvider;

import excelUtils.ReadExcelData;

public class TestData {

	private static final String LOGIN_PAGE_SHEET = "LoginPage";
	private static final String HOME_PAGE_SHEET = "HomePage";
	private static final String PIM_PAGE_SHEET = "PIMPage";
	private static final String ADD_EMPLOYEE_SHEET = "AddEmployee";
	private static final String DELETE_EMPLOYEE_SHEET = "DeleteEmployee";

	@DataProvider(name = "LoginPage_Credentials")
	public Object[] getLoginPageData() {
		return ReadExcelData.getSheetData(LOGIN_PAGE_SHEET);
	}

	@DataProvider(name = "HomePage_Credentials")
	public Object[] getHomePageData() {
		return ReadExcelData.getSheetData(HOME_PAGE_SHEET);
	}

	@DataProvider(name = "PIMPage_Credentials")
	public Object[] getPIMPageData() {
		return ReadExcelData.getSheetData(PIM_PAGE_SHEET);
	}

	@DataProvider(name = "AddEmployee_Credentials")
	public Object[] getAddEmployeeData() {
		return ReadExcelData.getSheetData(ADD_EMPLOYEE_SHEET);
	}

	@DataProvider(name = "DeleteEmployee_Credentials")
	public Object[] getDeleteEmployeeData() {
		return ReadExcelData.getSheetData(DELETE_EMPLOYEE_SHEET);
	}
}
