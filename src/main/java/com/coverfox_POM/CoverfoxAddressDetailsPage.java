package com.coverfox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverfoxAddressDetailsPage {
	// variable
	@FindBy(className="mp-input-text") WebElement pincodefield;
	@FindBy(id = "want-expert")
	private WebElement MobileNum;
	@FindBy(className = "next-btn")
	private WebElement Continue;

	// constructor
	public CoverfoxAddressDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// methods
	public void Enterpincode(String pincode) {
		Reporter.log("Entering Pincode",true);
		pincodefield.sendKeys(pincode);
	}

	public void SendMobileNum(String Mobile) {
		Reporter.log("Entering Mobile Number",true);
		MobileNum.sendKeys(Mobile);
	}

	public void ClickOnContinue() {
		Reporter.log("Clicking on Continue Button");
		Continue.click();
	}
}
