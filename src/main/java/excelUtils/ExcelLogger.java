package excelUtils;

public class ExcelLogger {
/*
	private static XSSFWorkbook workbook;
	private static Sheet sheet;
	private static int rowNum = 0;

	static {
		initializeExcelWorkbook();
	}

	private ExcelLogger() {
	}

	private static void initializeExcelWorkbook() {
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("LogSheet");
		Row headerRow = sheet.createRow(rowNum++);
		headerRow.createCell(0).setCellValue("Timestamp");
		headerRow.createCell(1).setCellValue("Class");
		headerRow.createCell(2).setCellValue("Message");
	}

	public static void logToExcel(Class<?> clazz, String message) {
		Row row = sheet.createRow(rowNum++);
		row.createCell(0).setCellValue(new Date().toString());
		row.createCell(1).setCellValue(clazz.getName());
		row.createCell(2).setCellValue(message);
	}

	public static void closeExcelWorkbook() {
		try (FileOutputStream fileOut = new FileOutputStream(FrameworkConstant.getLoggerExcelPath())) {
			workbook.write(fileOut);
		} catch (IOException e) {
			//O Logs.consoleLogger.error("Error while writing to Excel file: {}",
			// e.getMessage());
		}
	}
	*/
}
