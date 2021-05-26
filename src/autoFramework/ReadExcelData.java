package autoFramework;

import com.ReadExcelData.Xls_Reader;

public class ReadExcelData {

	public static void main(String[] args) {
		
		Xls_Reader reader = new Xls_Reader("C:\\Users\\Sandip\\ToolsQA\\DemoQA\\src\\autoFramework\\TestDataExcel.xlsx");
		int rowCount=reader.getRowCount("Sheet1");
		
		for (int rowNum=2; rowNum<=rowCount; rowNum++) {
		
		String fName=reader.getCellData("Sheet1", "FName", rowNum);
		
		System.out.println(fName);
		}

	}

}
