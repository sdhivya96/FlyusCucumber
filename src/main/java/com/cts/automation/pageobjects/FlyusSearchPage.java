package com.cts.automation.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cts.automation.base.HelperClass;

public class FlyusSearchPage extends HelperClass{
	public FlyusSearchPage(WebDriver driver	) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='flys-dpt-0']")    
	public WebElement txtFrom;

	@FindBy(xpath="//input[@id='flys-arr-0']")
	public WebElement txtTo;
	
	@FindBy(xpath="//button[text()='Search']")
	WebElement btnSearch;
	
public void logIn(String source,String destination)
{   
	txtFrom.sendKeys(source);
	pressKey (1);
	txtTo.sendKeys(destination);
	pressKey (1);
	btnSearch.click();
	
	
	

}	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
