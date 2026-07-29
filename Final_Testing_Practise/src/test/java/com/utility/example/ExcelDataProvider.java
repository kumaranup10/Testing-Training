package com.utility.example;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelDataProvider {
    XSSFWorkbook wb;
    XSSFSheet sheet;
    public ExcelDataProvider() {
        try {
            File src = new File("./Test Data/FinalTesting.xlsx");
            FileInputStream fis = new FileInputStream(src);
            wb = new XSSFWorkbook(fis);
        } catch (Exception e) {
            System.out.println("Unable to load Excel File : " + e.getMessage());
        }
    }
    public String getStringData(String sheetName, int row, int column) {
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(
                wb.getSheet(sheetName)
                  .getRow(row)
                  .getCell(column));
    }
    public double getNumericData(String sheetName, int row, int column) {
        return wb.getSheet(sheetName)
                 .getRow(row)
                 .getCell(column)
                 .getNumericCellValue();
    }
}