package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static XSSFWorkbook wb;

	public ExcelUtils() throws Throwable {
		File f = new File("src/test/resources/testData/AutoExcerciseDetails.xlsx");
		FileInputStream fis = new FileInputStream(f);
		wb = new XSSFWorkbook(fis);
	}

	public XSSFSheet readSheet(String sheetName) throws Throwable {

		XSSFSheet sheet = wb.getSheet(sheetName);

		return sheet;

	}

	public String readData(XSSFSheet sheet, int row, int column) {
		XSSFRow rows = sheet.getRow(row);
		String data = rows.getCell(column).getStringCellValue();
		return data;
	}

	public void writeData() {

	}

}
