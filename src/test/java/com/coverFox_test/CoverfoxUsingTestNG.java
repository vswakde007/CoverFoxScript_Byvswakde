package com.coverFox_test;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.coverfox_Base.Base;
import com.coverfox_POM.CoverfoxAddressDetailsPage;
import com.coverfox_POM.CoverfoxHealthplanPage;
import com.coverfox_POM.CoverfoxHomepage;
import com.coverfox_POM.CoverfoxMemberDetailsPage;
import com.coverfox_POM.CoverfoxResultpage;
import com.coverfox_Utility.Utility;

public class CoverfoxUsingTestNG extends Base {
	
	public static Logger logger;
	Sheet mysheet;
	CoverfoxHomepage coverfoxhomepage;
	CoverfoxMemberDetailsPage coverfoxmemberdetailpage;
	CoverfoxAddressDetailsPage coverfoxaddressdetailspage;
	CoverfoxHealthplanPage coverfoxhealthplanpage;
	CoverfoxResultpage coverfoxresultpage;
	@BeforeClass
	  public void launchBrowser() throws EncryptedDocumentException, IOException {
		logger= Logger.getLogger("23rdNov24_Coverfox");
		  PropertyConfigurator.configure("log4j.properties");
		  logger.info("Hello");

		
		OpenBrowser();
		logger.warn("Opening Browser");
	
	//excelData 
		
		 coverfoxhomepage =new CoverfoxHomepage(driver);
		 coverfoxmemberdetailpage =new CoverfoxMemberDetailsPage(driver);
		 coverfoxaddressdetailspage=new CoverfoxAddressDetailsPage(driver);
		 coverfoxhealthplanpage =new CoverfoxHealthplanPage(driver);
		 coverfoxresultpage=new CoverfoxResultpage(driver);
//		String age = mysheet.getRow(2).getCell(0).getStringCellValue();
//		String pincode = mysheet.getRow(3).getCell(1).getStringCellValue();
//		String mobile = mysheet.getRow(1).getCell(2).getStringCellValue();
	}
	
	@BeforeMethod
	public void coverfoxPreconditions() throws InterruptedException, EncryptedDocumentException, IOException {
		coverfoxhomepage.ClickOnGender();
		coverfoxhealthplanpage.ClickOnNext();
		coverfoxmemberdetailpage.HandleDropDown(Utility.readDataFromExcel("sheet7", 4, 0));
		coverfoxmemberdetailpage.ClickonMemberdetailspage();	
		coverfoxaddressdetailspage.Enterpincode(Utility.readDataFromExcel("sheet7", 4, 1));
		coverfoxaddressdetailspage.SendMobileNum(Utility.readDataFromExcel("sheet7", 4, 2));
		coverfoxaddressdetailspage.ClickOnContinue();
		Thread.sleep(3000);
	}
	
	//excelData
	
	@Test
  public void CoverfoxPlans() throws InterruptedException, IOException {
		

		int plannumberfromtext = coverfoxresultpage.getPlanNumberFromText();
		int plannumberfromcards = coverfoxresultpage.getPlanNumberFromPlanCards();
		Thread.sleep(5000);
	//	Assert.fail();
		Assert.assertEquals(plannumberfromtext,plannumberfromcards,"Test case failed, NUmber not Matching");
		Reporter.log("Plan number matching TC passed",true);
		Thread.sleep(8000);
		//Utility.takeScreenshot(driver,"");
	}
	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		CloseBrowserWindow();
		logger.info("Closing Browser");
	}
	
	
}
