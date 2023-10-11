package utils;

public class ExcelUtilsDemo {

	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		
		ExcelUtils excel = new ExcelUtils(projectPath+"/Excel/data.xlsx", "Sheet1");
		
		excel.getRowCount();
		excel.getColCount();
		excel.getCellData(0, 0);
		excel.getNumericCellData(1, 1);
	}
}
