package GenericUtitlity;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	Workbook workbook;

    // Open Excel file
    public void openExcel() throws IOException {

        FileInputStream f = new FileInputStream(
                "./src/main/resources/Test_data/test_data.xlsx");

        workbook = WorkbookFactory.create(f);
    }

    // Get data from Excel
    public String getData(String sheetName, int rowNum, int cellNum) {

        Sheet sheet = workbook.getSheet(sheetName);

        Row row = sheet.getRow(rowNum);

        Cell cell = row.getCell(cellNum);
        DataFormatter df=new DataFormatter();
        return df.formatCellValue(cell);
    }

    // Get number of rows
    public int getRowCount(String sheetName) {

        Sheet sheet = workbook.getSheet(sheetName);

        return sheet.getLastRowNum();
    }

    // Close Excel
    public void closeExcel() throws IOException {

        workbook.close();
    }
    public void openExcelForLogin() throws IOException {

        FileInputStream f = new FileInputStream(
                "./src/main/resources/Test_data/Login_test_data.xlsx");

        workbook = WorkbookFactory.create(f);
    }
    
	
	
}
