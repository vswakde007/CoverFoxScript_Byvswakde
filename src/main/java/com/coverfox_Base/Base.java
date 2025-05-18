package com.coverfox_Base;

import java.io.IOException;
import java.lang.classfile.ClassFile.Option;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import com.coverfox_Utility.Utility;

public class Base {
	
	protected static WebDriver driver;
	public void OpenBrowser() throws IOException {
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
	driver =new ChromeDriver(options);
	driver.get(Utility.readDataFromPropertiesFile("url"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
	Reporter.log("Launching a Browser",true);
	}
	
	public void CloseBrowserWindow() {
		Reporter.log("Closing a Browser",true);
		driver.quit();
	}

}
