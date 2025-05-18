package com.coverfox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverfoxHealthplanPage {
	//variables
	@FindBy(xpath = "//div[@class='next-btn']")private WebElement NextButton;
	
	//constructor 
	public CoverfoxHealthplanPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	//method
	public void ClickOnNext() {
		NextButton.click();
	}

}
