package com.facebook.qa.util;



import java.io.File;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.facebook.qa.base.TestBase;



public class TestUtil extends TestBase{
	
	public static String TestDataFilePath="F:\\NaveenJavatraining\\ZohoCRMTest\\src\\main\\java\\com\\zohocrm\\qa\\TestData\\ZohoCRMTestdata.xlsx";
	public static String TestDataSheetName="Contact";
	public static Workbook book;
	public static Sheet sheet;
	public Object[][] getTestData(String sheetName){
		
		FileInputStream file= null;
		
		try {
			file= new FileInputStream(TestDataFilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet=book.getSheet(TestDataSheetName);
		
		Object[][]data =new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i <sheet.getLastRowNum(); i++) {
			for (int j = 0; j <sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
		}
		
		return data;
		
	}
	
	
	public String takeScreenshotAtEndOfTest(WebDriver driver,String TestCaseName) throws IOException {
		String Timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot) driver;	
		File src=ts.getScreenshotAs(OutputType.FILE);
		String DestinationPath=System.getProperty("user.dir")+"\\FailedTestScreenshot"+TestCaseName+Timestamp+".png";
		File destfile= new File(DestinationPath);
		
		
		FileUtils.copyFile(src,destfile );
		return DestinationPath;
		
	}


	
}
