package com.coverfox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverfoxHomepage {
	// variables
	@FindBy(xpath = "//div[@class='w--radio__option radio_selected']")private WebElement gender;

	// constructor
	public CoverfoxHomepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// method
	public void ClickOnGender()
	{
		Reporter.log("clicking on gender",true);
		gender.click();
	}
}
