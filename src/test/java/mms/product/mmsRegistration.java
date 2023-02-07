package mms.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class mmsRegistration {
	static WebDriver driver;
	public static class ExcelUtils {
		private static HSSFWorkbook workbook;
		private static HSSFSheet sheet;
		private static HSSFRow row;
		private static HSSFCell cell;
		static ExcelUtils excelUtils = new ExcelUtils();
		public void setExcelFile(String excelFilePath,String sheetName) throws IOException {
			//Create an object of File class to open xls file
			File file =    new File(excelFilePath);

			//Create an object of FileInputStream class to read excel file
			FileInputStream inputStream = new FileInputStream(file);

			//creating workbook instance that refers to .xls file
			workbook=new HSSFWorkbook(inputStream);

			//creating a Sheet object
			sheet=workbook.getSheet(sheetName);

		}

		public String getCellData(int rowNumber,int cellNumber){
			//getting the cell value from rowNumber and cell Number
			cell =sheet.getRow(rowNumber).getCell(cellNumber);

			//returning the cell value as string
			return cell.getStringCellValue();
		}

		public int getRowCountInSheet(){
			int rowcount = sheet.getLastRowNum()-sheet.getFirstRowNum();
			return rowcount;
		}

		public void setCellValue(int rowNum,int cellNum,String cellValue,String excelFilePath) throws IOException {
			//creating a new cell in row and setting value to it      
			sheet.getRow(rowNum).createCell(cellNum).setCellValue(cellValue);

			FileOutputStream outputStream = new FileOutputStream(excelFilePath);
			workbook.write(outputStream);
		}
	}
	@SuppressWarnings("null")
	public static void main(String[] args) throws IOException  {
		driver = new ChromeDriver();
		 ExcelUtils excelUtils = null;
		String excelFilePath = null;
		excelUtils.setExcelFile(excelFilePath,"STUDENT_DATA");

	        //iterate over all the row to print the data present in each cell.
	        for(int i=1;i<=excelUtils.getRowCountInSheet();i++)
	        {
	        	//Enter the values read from Excel in firstname,lastname,mobile,email,address
//	        	firstName.sendKeys(excelUtils.getCellData(i,0));
		driver.get(excelUtils.getCellData(i,0));}
	        
	}
	@Test
	public void f() {
		//	  WebDriver driver = null;
		driver.get("youtube.com");
	}
}
