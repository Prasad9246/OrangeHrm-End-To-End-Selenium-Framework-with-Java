package excelUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.chiacon.constant.FrameworkConstant;

public class ReadExcelData {

	private static XSSFWorkbook workbook = null;
	private static final String FILE_PATH = FrameworkConstant.getExcelPath();


	private ReadExcelData() {
	}

	public static void openWorkbook() {
		try {
			FileInputStream fis = new FileInputStream(FILE_PATH);
			workbook = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Unable to find Excel file " + FILE_PATH, e);
		} catch (IOException e) {
			throw new RuntimeException("Unable to read Excel file " + FILE_PATH, e);
		}
	}

	public static Object[] getSheetData(String sheetName) {
		XSSFSheet sheet = getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		int columns = sheet.getRow(0).getPhysicalNumberOfCells();
		Object[] data = new Object[rows];

		for (int r = 1; r <= rows; r++) {
			Map<String, String> map = new HashMap<>();

			for (int c = 0; c < columns; c++) {
				String columnName = sheet.getRow(0).getCell(c).getStringCellValue();
				String value = sheet.getRow(r).getCell(c).getStringCellValue();
				map.put(columnName, value);
			}

			data[r - 1] = map;
		}

		closeWorkbook();
		return data;
	}

	private static XSSFSheet getSheet(String sheetName) {
		XSSFSheet sheet = workbook.getSheet(sheetName);
		if (sheet == null) {
			closeWorkbook();
			throw new RuntimeException("Sheet with name '" + sheetName + "' not found in the Excel workbook.");
		}
		return sheet;
	}

	private static void closeWorkbook() {
		try {
			if (workbook != null) {
				workbook.close();
			}
		} catch (IOException e) {
			throw new RuntimeException("Error closing Excel workbook", e);
		}
	}
}
