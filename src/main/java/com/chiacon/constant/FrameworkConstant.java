package com.chiacon.constant;

public class FrameworkConstant {

	private FrameworkConstant() {
	}

	private static final String REPORT_PATH = System.getProperty("user.dir") + "/src/test/resources/report/index_"
			+ System.currentTimeMillis() + ".html";
	private static final String FILE_PATH = System.getProperty("user.dir") + "/src/test/resources/fileReading.xlsx";
	private static final String CONFIG_FILE_PATH = System.getProperty("user.dir")
			+ "/src/test/resources/config/config.properties";

	public static String getReportPath() {
		return REPORT_PATH;
	}

	public static String getExcelPath() {
		return FILE_PATH;
	}

	public static String getConfigPath() {
		return CONFIG_FILE_PATH;
	}
	

}
