package com.cts.automation.stepdef;import java.util.List;
import java.util.Map;

import com.cts.automation.base.HelperClass;
import com.cts.automation.pageobjects.FlyusSearchPage;
import com.cts.automation.pageobjects.ItineraryDetails;
import com.cts.automation.pageobjects.PrintPrice;
import com.cts.automation.pageobjects.SelectFlight;
import com.cts.automation.pageobjects.Selectseat;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class FlyusStepDef extends HelperClass{
	
	@Given("User navigates to flyus")
	public void launchUrl()
	{
	    launchBrowser();
	    driver.get("https://www.flyus.com/");
	}

	@When("User enters {string} and {string} and clicks search")
	public void searchFlyus(String source, String destination)
	{
	     FlyusSearchPage search = new FlyusSearchPage(driver);
	     search.logIn(source, destination);
	}

	@When("User selects the flight")
	public void flightSelection() 
	{
		SelectFlight flight =new  SelectFlight(driver);
		flight.flightSelection();
		
		
	}

	@When("User enters the below passenger info")
	public void passengerInfo(DataTable dataTable) throws InterruptedException 
	{
		List<Map<String,String>>allData = dataTable.asMaps(String.class,String.class);
		String firstName = allData.get(0).get("firstName");
		String lastName = allData.get(0).get("lastName");
		String gender = allData.get(0).get("gender");
		String dob = allData.get(0).get("dob");
		ItineraryDetails details = new ItineraryDetails(driver);
		details.travelerDetails(firstName, lastName, gender,dob);
	}

	@When("User selects the seat")
	public void seatSelection() 
	{
	   Selectseat seat = new Selectseat(driver);
	   seat.seatSelection();
	}

	@Then("print the price")
	public void ticketPrice() 
	{
	    PrintPrice price = new  PrintPrice(driver);
	    price.priceValue();
	    driver.close();
	}


}
