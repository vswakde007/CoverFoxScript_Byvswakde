  package com.coverfox_Utility;

import java.io.File;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.random.RandomGeneratorFactory;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class Utility {
	//ReadData from Excel
	public static String readDataFromExcel(String sheetName, int row,int cell) throws EncryptedDocumentException, IOException
	{
		 FileInputStream myfile = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\Practice.xlsx");
		 Sheet mysheet = WorkbookFactory.create(myfile).getSheet(sheetName);
		String data = mysheet.getRow(row).getCell(cell).getStringCellValue();
		Reporter.log("Reading data from excel",true);
		return data;
	}
	
	
	//screenshot
	public static void takeScreenshot(WebDriver driver, String ScreenshotName) throws IOException {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"\\Screenshot"+ScreenshotName+".png");
		FileUtils.copyFile(src, dest);
		Reporter.log("Taking Screenshot, saved at"+dest,true);

	}
	
	//scroll into view	
	public static void ScrollIntoViews(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true)",element);
		Reporter.log("Scrolling on view",true);

	}
	
	public static String readDataFromPropertiesFile(String Key) throws IOException {
		Properties prop=new Properties();
		FileInputStream file1 =new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\Coverfox.properties");
		prop.load(file1);
		String value = prop.getProperty(Key);
	Reporter.log("Reading "+Key+"from Properties FIle",true);
	 return value;
	}		

}
