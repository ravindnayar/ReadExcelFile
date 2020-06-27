package lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	XSSFWorkbook wb;
	XSSFSheet sheet1;

	public ExcelDataConfig(String excelPath) throws IOException{

		try{
		File src = new File("D:\\Selenium\\ExcelData\\testdata.xlsx");
		
		FileInputStream fls = new FileInputStream(src);
		
		//load workbook in wb
		XSSFWorkbook wb = new XSSFWorkbook(fls);
		
		//load sheet1
		XSSFSheet sheet1 = wb.getSheetAt(0);
		
		int rowcount = sheet1.getLastRowNum();
		
		for(int i=0; i<rowcount; i++)
		{
		String data0 = sheet1.getRow(i).getCell(0).getStringCellValue();
		System.out.println("Data from Excel = " +data0);
		
		}
	
		
		wb.close();
	}



}
