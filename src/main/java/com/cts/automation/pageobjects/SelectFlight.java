package com.cts.automation.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cts.automation.base.HelperClass;



public class SelectFlight extends HelperClass  {
	public SelectFlight(WebDriver driver) 
	{
	       PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//img[@class ='thumb'])[1]")
	public WebElement popUp;
	
	@FindBy(xpath="(//span[@class='h4 inline pull-left m-t-xs m-b-none m-l-md'])[10]")
	public WebElement btnSelect;
	
	
	
	public void flightSelection()
	{
		 WebDriverWait w = new WebDriverWait (driver,60);
		 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@class ='thumb'])[1]")));
     	 popUp.click();
		 JavascriptExecutor js = ( JavascriptExecutor)driver;
		 //js.executeScript("arguments[0].click();",popUp );
		 js.executeScript("arguments[0].click();",btnSelect );
	    // btnSelect.click();
		
		    
	}
	

}
