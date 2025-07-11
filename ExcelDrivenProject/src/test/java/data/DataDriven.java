package data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public static void main(String[] args) throws IOException {

	}

	public ArrayList<String> getData(String testCase) throws IOException {
		DataFormatter formatter = new DataFormatter();
		FileInputStream stream = new FileInputStream("C:\\Users\\satya\\Desktop\\TEST.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(stream);
		ArrayList<String> list = new ArrayList<String>();
		int sheetNumber = workbook.getNumberOfSheets();
		for (int i = 0; i < sheetNumber; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("TestData")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> cells = firstRow.cellIterator();
				int k = 0, columnIndex = 0;
				while (cells.hasNext()) {
					Cell firstCellValue = cells.next();
					if (firstCellValue.getStringCellValue().equalsIgnoreCase("TESTCASE")) {
						columnIndex = k;
					}
					k++;
				}
				System.out.println(columnIndex);
				while (rows.hasNext()) {
					Row row = rows.next();
					if (row.getCell(columnIndex).getStringCellValue().trim().equalsIgnoreCase(testCase)) {
						Iterator<Cell> cell = row.cellIterator();
						while (cell.hasNext()) {
							Cell data = cell.next();
							list.add(formatter.formatCellValue(data));
						}
					}

				}

			}
			workbook.close();
			stream.close();
		}
		return list;
	}
}
