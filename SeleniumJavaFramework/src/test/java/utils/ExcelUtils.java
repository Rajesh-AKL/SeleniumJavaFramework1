package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public ExcelUtils(String excelPath, String sheetName) {
		try {
			
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet(sheetName);

		} catch (Exception exp) {

			System.out.println(exp.getMessage());
			exp.getCause();
			exp.printStackTrace();

		}
	}

	public static void main(String[] args) {

		getRowCount();
		getColCount();
		getCellData(0,0);
		getNumericCellData(1,1);
	}



	public static int getRowCount() {
		
		int rowCount = 0;
		try {

			rowCount = sheet.getPhysicalNumberOfRows();
			System.out.println("No. of Rows : "+rowCount);
		}

		catch (Exception exp) {

			System.out.println(exp.getMessage());
			exp.getCause();
			exp.printStackTrace();
		}
		
		return rowCount;

	}
	
	
	public static int getColCount() {
		
		int colCount = 0;
		try {

			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("No. of Columns : "+colCount);
		}

		catch (Exception exp) {

			System.out.println(exp.getMessage());
			exp.getCause();
			exp.printStackTrace();
		}
		
		return colCount;

	}

	public static String getCellData(int rowNum, int colNum) {
		
		String cellData = null;
		try {
			
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println(cellData);


		}
		catch (Exception exp) {

			System.out.println(exp.getMessage());
			exp.getCause();
			exp.printStackTrace();
		}
		
		return cellData;
	}

	public static void getNumericCellData(int rowNum, int colNum) {
		
		
		try {
			
			double NumericCellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println(NumericCellData);


		}
		catch (Exception exp) {

			System.out.println(exp.getMessage());
			exp.getCause();
			exp.printStackTrace();
		}
		
		
	}

}