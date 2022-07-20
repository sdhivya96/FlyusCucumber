package com.cts.automation.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cts.automation.base.HelperClass;

public class Selectseat extends HelperClass
{

	public Selectseat(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="(//tfoot//tr//td)[3]//child::a")
	public WebElement selectServices;
	
	@FindBy (xpath="(//input[@type='radio'])[2]")
	public WebElement flexibleBooking;
	
	@FindBy (xpath="(//input[@type='radio'])[4]")
	public WebElement smsUpdates;
	
	@FindBy (xpath="(//input[@type='radio'])[6]")
	public WebElement refundableBooking;
	
	@FindBy (xpath="(//img[@src='img/sm/seat-premium.svg'])[1]")
	public WebElement premiumSeat;
	
	@FindBy (xpath="(//a[text()='Select seat'])[1]")
	public WebElement selectSeat;

public void seatSelection() 
{
//	JavascriptExecutor js = ( JavascriptExecutor)driver;
//	js.executeScript("arguments[0].scrollIntoView();",selectServices );
//	js.executeScript("arguments[0].click();",selectServices );
//	js.executeScript("arguments[0].scrollIntoView();",flexibleBooking );
//	js.executeScript("arguments[0].click();",flexibleBooking );
//	js.executeScript("arguments[0].scrollIntoView();",smsUpdates );
//	js.executeScript("arguments[0].click();",smsUpdates );
//	js.executeScript("arguments[0].scrollIntoView();",refundableBooking );
//	js.executeScript("arguments[0].click();",refundableBooking );
//	js.executeScript("arguments[0].click();",premiumSeat);
//	js.executeScript("arguments[0].click();",selectSeat);
	
	scrollIntoView (selectServices);
	elementClick (selectServices);
	
	
	
	
	
	
	
}
	
	
	
	
}
