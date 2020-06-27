package com.test.utility;

import java.util.ArrayList;


public class TestUtil {
			
		static Xls_Reader reader;
		
		public static ArrayList<Object[]> getDataFromExcel(){
			
			ArrayList<Object[]> myData = new ArrayList<Object[]>();
			try{
			reader = new Xsl_Reader("C:/Users/ravind.nayar/workspace/ReadExcelFile/src/com/test/data/testngdatasheet.xlsx");
			}catch(Exception e){
				e.printStackTrace();
			}
			
			for(int rowcount=2; rowcount <= reader.getRowCount("Sheet1"); rowcount++){
				
				String FirstName = reader.getCellData("Sheet1","FirstName", rowcount);
				String LastName = reader.getCellData("Sheet1", "LastName", rowcount);
				String Email = reader.getCellData("Sheet1","Email", rowcount);
				String Password = reader.getCellData("Sheet1", "Password", rowcount);
				
				Object obj[] = {FirstName,LastName,Email,Password};
				myData.add(obj);
			}
			return myData;
			
		}
		


	}


}
