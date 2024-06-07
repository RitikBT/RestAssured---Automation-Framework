package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {

	String path;

	public FileInputStream fileInput;
	public FileOutputStream fileOutput;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	

	public XLUtility(String path) {
		this.path = path;
	}

	
	/**
	 * Method to count number of row from Sheet
	 * @param sheetName - Enter sheet name
	 * @return - returning number of row
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws IOException {

		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fileInput.close();
		return rowCount;

	}
	
	/**
	 * Method to count cell number as per row
	 * @param sheetName
	 * @param rowNum
	 * @return number of cell
	 * @throws IOException
	 */
	public int getCellCount(String sheetName, int rowNum) throws IOException {
		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fileInput.close();
				return cellCount;
		
	}
	
	
	/**
	 * Method to get cell data
	 * @param sheetName - sheet name
	 * @param rowNum - row number
	 * @param column - column number
	 * @return - returning cell data
	 * @throws IOException
	 */
	public String getCellData(String sheetName, int rowNum, int column) throws IOException {
		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(column);
		
		DataFormatter formatter =  new DataFormatter();
		String data;
		
		try {
			data = formatter.formatCellValue(cell);
		}
		catch (Exception e) {
			data = "";
		}
		
		workbook.close();
		fileInput.close();
		
		return data;	
	}
	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param column
	 * @param data
	 * @throws IOException
	 */
	
	public void setCellData(String sheetName, int rowNum, int column, String data) throws IOException {
		File file = new File(path);
		if(!file.exists()) {
			workbook = new XSSFWorkbook(fileInput);
			fileOutput = new FileOutputStream(path);
			workbook.write(fileOutput);
		}
		
		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);
		
		if(workbook.getSheetIndex(sheet)== -1)  // If sheet not exists then create new sheet
				workbook.createSheet(sheetName);
		sheet = workbook.getSheet(sheetName);
		
		
		if(sheet.getRow(rowNum) == null)
			sheet.createRow(rowNum);
		row = sheet.getRow(rowNum);
		
		cell = row.createCell(column);
		cell.setCellValue(data);
		fileOutput = new FileOutputStream(path);
		workbook.write(fileOutput);
		workbook.close();
		fileInput.close();
		fileOutput.close();
		
		
			
			
		

		
		
	}
	
	
	
}
