package utility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
@DataProvider	

public Object[][] logindata() throws EncryptedDocumentException, IOException{
	
	int rowCount = ExcelReader.getRowCount("Login");
    int colCount = ExcelReader.getColumnCount("Login");

	Object[][] logindata= new Object[rowCount-1][colCount];
	
	
	
	for(int row=1;row<rowCount;row++) 
	{
	
		for(int col=0;col<colCount;col++)  
		{
			
			
		logindata[row-1][col]	= ExcelReader.getExcelData("Login", row, col);
		 
	
		}
	}

	return logindata;
	
}
	
	
@DataProvider
public Object[][] searchproductsdata() throws EncryptedDocumentException, IOException{
	
	int rowCount = ExcelReader.getRowCount("SearchProduct");
    int colCount = ExcelReader.getColumnCount("SearchProduct");
	
	Object[][] searchData= new Object[rowCount-1][colCount];
	
	for(int row=1;row<rowCount;row++) 
	{
	
		for(int col=0;col< colCount;col++)  
		{
			
			
			searchData[row-1][col]	= ExcelReader.getExcelData("SearchProduct", row, col);
		 
	
		}
	}
	return searchData;
	
	
	
}

@DataProvider
public Object[][] addToCartData() throws EncryptedDocumentException, IOException{
	
	int rowCount = ExcelReader.getRowCount("AddtoCard");
    int colCount = ExcelReader.getColumnCount("AddtoCard");
	
	Object[][] addtocard= new Object[rowCount-1][colCount];
	
	for(int row=1;row<rowCount;row++) 
	{
	
		for(int col=0;col< colCount;col++)  
		{
			
			
			addtocard[row-1][col]	= ExcelReader.getExcelData("AddtoCard", row, col);
		 
	
		}
	}
	return addtocard;
	
	
	
}


@DataProvider
public Object[][] ProductsData() throws EncryptedDocumentException, IOException{
	
	int rowCount = ExcelReader.getRowCount("Products");
    int colCount = ExcelReader.getColumnCount("Products");
	
	Object[][] addtocard= new Object[rowCount-1][colCount];
	
	for(int row=1;row<rowCount;row++) 
	{
	
		for(int col=0;col< colCount;col++)  
		{
			
			
			addtocard[row-1][col]	= ExcelReader.getExcelData("Products", row, col);
		 
	
		}
	}
	return addtocard;
	
	
	
}

@DataProvider
public Object[][] paymentData() throws EncryptedDocumentException, IOException{
	
	int rowCount = ExcelReader.getRowCount("Payments");
    int colCount = ExcelReader.getColumnCount("Payments");
	
	Object[][] addtocard= new Object[rowCount-1][colCount];
	
	for(int row=1;row<rowCount;row++) 
	{
	
		for(int col=0;col< colCount;col++)  
		{
			
			
			addtocard[row-1][col]	= ExcelReader.getExcelData("Payments", row, col);
		 
	
		}
	}
	return addtocard;
	
	
	
}


}
