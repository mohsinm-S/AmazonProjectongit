package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;

public class ExcelReader {
	public static FileInputStream fis;
	public static Workbook wb;
	
  static {
		
		 try {
			 fis= new FileInputStream("C:\\Users\\Mohsin\\eclipse-workspace\\AmazonProject1\\ExcelFile\\MohsinDoc.xlsx");
			wb= WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String getExcelData(String sheetname,int i,int j) throws EncryptedDocumentException, IOException {
		
		
		//FileInputStream fis= new FileInputStream("./ExcelFile\\MohsinDoc.xlsx");
		// fis= new FileInputStream("C:\\Users\\Mohsin\\eclipse-workspace\\AmazonProject1\\ExcelFile\\MohsinDoc.xlsx");
		// wb= WorkbookFactory.create(fis);
		
		
		String data=null;
		
		
		try {
			
			
			
		data=wb.getSheet(sheetname).getRow(i).getCell(j).getStringCellValue();
		
		}catch(IllegalStateException e) {
			
			data=NumberToTextConverter.toText(wb.getSheet(sheetname).getRow(i).getCell(j).getNumericCellValue() );
			
		}catch (NullPointerException e) {
	        e.printStackTrace();
	    }
	
			
		
		return data;
		
		
		
	}

	public static int getRowCount(String sheetname) {
		
		int rowcount =wb.getSheet(sheetname).getPhysicalNumberOfRows();
		
		
		return rowcount;
	}

	public static int getColumnCount(String sheetname) {
		int colcount = wb.getSheet(sheetname).getRow(0).getPhysicalNumberOfCells();
		return colcount;
	}

	

	}
