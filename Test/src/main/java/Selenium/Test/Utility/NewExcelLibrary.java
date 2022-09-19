package Selenium.Test.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author kanwaljeetsingh NewExcelLibrary class is used to get data from
 *         TestData.xlsx located in src\test\resources\testdata folder
 * 
 */
public class NewExcelLibrary {

	public String[][] getData(String excelSheetname) throws EncryptedDocumentException, IOException {

		File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		// get the number of rows in the sheet
		Sheet sheetName = wb.getSheet(excelSheetname);

		// total number of rows to get column count, count the number of cells in the
		// rows. 0 represents 0th
		// row being captured
		int totalRows = sheetName.getLastRowNum();
		Row rowCells = sheetName.getRow(0);
		// total number of columns
		int totalColumns = rowCells.getLastCellNum();

		DataFormatter format = new DataFormatter();
		String testData[][] = new String[totalRows][totalColumns];

		// Start reading, iterate the sheet, nested loops required
		// first loop for rows, second loop for columns
		for (int i = 1; i <= totalRows; i++) {
			for (int j = 0; j < totalColumns; j++) {
				// index 0 would return 1st column, 1 would return 2nd column, so on
				testData[i - 1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
			}
		}
		return testData;
	}

}
