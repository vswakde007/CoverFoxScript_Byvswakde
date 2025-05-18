package com.coverfox_POM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverfoxResultpage {
	@FindBy(xpath = "//div[contains(text(),'matching H')]")private WebElement planresult;
	@FindBy(className = "plan-card-container")private List<WebElement> plancards;
	public CoverfoxResultpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void getplanresultText() throws InterruptedException
	{
		String result = planresult.getText();
		String[] result1   = result.split(" ");
		//48 matching result
		int resultInNumber = Integer.parseInt(result1[0]);
		Thread.sleep(8000);
		int totalplancards = plancards.size();
		
		if(totalplancards==resultInNumber)
		{
			System.out.println("TC is passed");
		}else
		{
			System.out.println("TC is Failed");
		}
	}
	
public int getPlanNumberFromText() {
	Reporter.log("getting plan number from text",true);
	String result = planresult.getText();
	String[] result1   = result.split(" ");
	//48 matching result
	int planNumber = Integer.parseInt(result1[0]);
	return planNumber;
}

public int getPlanNumberFromPlanCards() {
	Reporter.log("getting plan numbers from Plan Cards");
	int planNumberFromCards = plancards.size();
	return planNumberFromCards;
}


}
