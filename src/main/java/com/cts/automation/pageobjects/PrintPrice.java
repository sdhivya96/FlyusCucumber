package com.cts.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrintPrice {
	public PrintPrice(WebDriver driver)
	{
		 PageFactory.initElements(driver, this);
		 
	}
	
	
	@FindBy(xpath="(//div[@class='panel-heading wrapper text-center hidden-sm hidden-xs'])[2]")
	public WebElement flightTotal;
	
	
	public void priceValue() 
	{
		
        System.out.println(flightTotal.getText());
	}
	
	
	
	
	
	
	
	

}
