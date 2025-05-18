package com.coverfox_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverfoxMemberDetailsPage {
	//Variables
	@FindBy(css = "select#Age-You")private WebElement ageDropDown;
	@FindBy(className ="next-btn")private WebElement NextButton;
	
	//constructor	
	public CoverfoxMemberDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	//method
	
	public void HandleDropDown(String age) {
		Reporter.log("Handling Age DropDown",true);
		Select selectAge=new Select(ageDropDown);
		selectAge.selectByValue(age+"y");
	}
	public void ClickonMemberdetailspage() {
		Reporter.log("clicking on ok",true);
		NextButton.click();
			
			
		}
	}

