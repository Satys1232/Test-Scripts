package data_excel_implementation.excel_dataprovider_integration;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class Assignment_9 {

    public static String fruit = "Mango";
    public static String header = "price";
    public static String updatedValue = "300";
    public static String filePath = "C:\\Users\\satya\\Desktop\\download.xlsx";
    public static FileInputStream instream;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static int fruitRowIndex;
    public static int headerColumnIndex;

    static {
        try {
            instream = new FileInputStream(filePath);
            workbook = new XSSFWorkbook(instream);
            sheet = workbook.getSheet("Fruits");
            fruitRowIndex = getFruitRowIndex(sheet, fruit);
            headerColumnIndex = getHeaderColumnNumber(sheet, header);
            instream.close();
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize static variables", e);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(fruit + " is present at " + fruitRowIndex + "nd index");
        System.out.println(header + " is present at " + headerColumnIndex + "th index");
        Assert.assertTrue(updateCell(sheet, fruitRowIndex, headerColumnIndex, updatedValue, filePath, workbook));
    }

    public static int getFruitRowIndex(XSSFSheet sheet, String fruit) throws IOException {
        DataFormatter formatter = new DataFormatter();
        Iterator<Row> rows = sheet.iterator();
        while (rows.hasNext()) {
            Row row = rows.next();
            String fruitName = formatter.formatCellValue(row.getCell(1));
            if (fruitName.equalsIgnoreCase(fruit)) {
                return row.getRowNum();
            }
        }
        return -1;
    }

    public static int getHeaderColumnNumber(XSSFSheet sheet, String headerName) throws IOException {
        Iterator<Row> rows = sheet.iterator();
        if (rows.hasNext()) {
            Row row = rows.next();
            Iterator<Cell> cells = row.cellIterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                if (cell.getStringCellValue().trim().equalsIgnoreCase(headerName)) {
                    return cell.getColumnIndex();
                }
            }
        }
        return -1;
    }

    public static boolean updateCell(XSSFSheet sheet, int appleRowIndex, int priceColumnIndex, String updatedValue,
            String filePath, XSSFWorkbook workbook) throws IOException {
        Row rowField = sheet.getRow(appleRowIndex);
        Cell cellField = rowField.getCell(priceColumnIndex);
        cellField.setCellValue(updatedValue);
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        return true;
    }
}
