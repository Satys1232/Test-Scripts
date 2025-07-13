package data_excel_implementation.excel_dataprovider_integration;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataTest {

	public static void main(String[] args) throws IOException {
		FileInputStream stream = new FileInputStream("C:\\Users\\satya\\Desktop\\Book1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(stream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow headerRow = sheet.getRow(0);
		int columnCount = headerRow.getLastCellNum();
		Object excelData[][] = new Object[rowCount - 1][columnCount];
		for (int i = 0; i < rowCount - 1; i++) {
			Row row = sheet.getRow(i + 1);
			System.out.println("------------------");
			for (int j = 0; j < columnCount; j++) {
				System.out.println(row.getCell(j));
			}
			System.out.println("------------------");	
		}
	}
}
