package com.coverfox_listner;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.coverfox_Base.Base;
import com.coverfox_Utility.Utility;

public class Listner extends Base implements ITestListener {
	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test"+result.getName()+"is success",true);
	}
	@Override
	public void onTestFailure(ITestResult result) {
	Reporter.log("Test"+result.getName()+"is failed",true);	
	try {
		Utility.takeScreenshot(driver, result.getName()+"_failed");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
}