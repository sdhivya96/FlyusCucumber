package com.cts.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cts.automation.base.HelperClass;

public class ItineraryDetails extends HelperClass{
	public ItineraryDetails(WebDriver driver)
	{
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//input[@name='paxes[ADULT-0][firstName]']")
	public WebElement txtFirstName;
	
	@FindBy (xpath="//input[@name='paxes[ADULT-0][lastName]']")
	public WebElement txtLastName;
	
	@FindBy (xpath="//select[@id='gender-pax-0']")
	public WebElement ddnGender;
	
	@FindBy (xpath="//input[@id='paxes-ADULT-0-dob']")
	public WebElement txtDob;
	
	@FindBy (xpath="//a[text()='1996']")
	public WebElement txtYear;
	
	@FindBy (xpath="//a[text()='December']")
	public WebElement txtMonth;
	
	@FindBy (xpath="//a[text()='07']")
	public WebElement txtDate;
	
	@FindBy (xpath="(//div[@class='panel-heading wrapper text-center hidden-sm hidden-xs'])[2]")
	public WebElement txtHeadingTripCost;
	
	
		
	
	public void travelerDetails(String firstName,String lastName,String gender,String dob) throws InterruptedException
	{
		txtFirstName.sendKeys(firstName);
		txtLastName.sendKeys(lastName);
		selectByText(ddnGender,gender);
		txtDob.click();
		txtDob.sendKeys(dob);
		txtHeadingTripCost.click();

}}
