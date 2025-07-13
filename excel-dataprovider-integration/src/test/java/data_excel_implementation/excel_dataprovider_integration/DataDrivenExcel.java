package data_excel_implementation.excel_dataprovider_integration;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenExcel {

	@Test(dataProvider = "driverData")
	public void excelDataImplementation(String Name, String place, String id) {
		System.out.println(Name + " " + place + " " + id);
	}

	@DataProvider(name = "driverData")
	public Object[][] getDataFromExcel() throws IOException {
		DataFormatter formatter = new DataFormatter();
		Object[][] data = { { "Satya", "Jajpur", "1" }, { "Sai", "Dhenkanal", "2" }, { "Soumya", "Bhubaneswar", "3" } };
		FileInputStream stream = new FileInputStream("C:\\Users\\satya\\Desktop\\TESTDATA.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(stream);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow headerRow = sheet.getRow(0);
		int columnCount = headerRow.getLastCellNum();
		Object excelData[][] = new Object[rowCount - 1][columnCount];
		for (int i = 0; i < rowCount - 1; i++) {
			Row row = sheet.getRow(i + 1);
			for (int j = 0; j < columnCount; j++) {
				excelData[i][j] = formatter.formatCellValue(row.getCell(j));
			}
		}
		return excelData;
	}

}
