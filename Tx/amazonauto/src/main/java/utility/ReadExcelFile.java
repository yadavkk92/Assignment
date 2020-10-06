package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static List<String> excelData(String excelFile,String sheetName) throws IOException {
		
		List<String> a = new ArrayList<String>(); 
		String filePath = System.getProperty("user.dir")+"//src/test/resources/excelData/searchData.xlsx";
		File file =new File(filePath);
		FileInputStream fis = new FileInputStream(file);
	
		Workbook excelBook = new XSSFWorkbook(fis);
		Sheet searchSheet = excelBook.getSheet(sheetName);
  
        Iterator<Row> row = searchSheet.iterator();
        while(row.hasNext()) {
        	Row r = row.next();
        	Iterator<Cell> cell = r.cellIterator();
        	cell.next();
        	while(cell.hasNext()) {
        		Cell s = cell.next();
        		a.add(s.getStringCellValue());
        	}
		}
        excelBook.close();
		return a;

	}
	
	public static List<String> getSheetData(String excelFile,String sheetName) throws IOException{
		return excelData(excelFile,sheetName);
	}
}
