package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

//DataProvider 1
public class DataProviders {

	@DataProvider(name="LoginData")
	 public String [][] getData() throws IOException
	{
		//taking xl file path from testData
		String path= "C:\\Automation\\Maven project\\Opencart_122\\testData\\logintestdata.xlsx"; //".\\testData\\logintestdata.xlsx";
		
		ExcelUtility xlutil=new ExcelUtility(path); //creating an object for xlutility
		
		int totalrow=xlutil.getRowCount("Sheet1");
		int totalcell=xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][]=new String[totalrow][totalcell]; //created for two dimensional array which can store
		
		for(int i=1; i<=totalrow; i++)  //i=1; bcz we are removing header section in 0^th row // read the data from xl storing in to two dimensional array
		{
			for(int j=0; j<totalcell; j++) //0 j=0; j is col
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j); //putting data in to two dimensional array here i=i-1=0; bcz we are not wasting 0 place in array
			}
			
		}
		return logindata;
		
	}
//DataProvider 2
//DataProvider 3	
	
}
