package utility;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelDataProvider {

    public static XSSFWorkbook wb;

    ExcelDataProvider() throws IOException {
        File file = new File("./TestData/Input.xlsx");
        FileInputStream fis = new FileInputStream(file);
        wb = new XSSFWorkbook(fis);
    }

    public static String getStringValue(String sheetName, int row, int col){
        return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
    }

    public static int getIntegerValue(String sheetName, int row, int col){
        return (int) wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
    }


}
