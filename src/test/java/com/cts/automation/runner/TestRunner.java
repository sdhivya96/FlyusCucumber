package com.cts.automation.runner;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features="src//test//resources"  , dryRun = false, monochrome=true,
tags="@FlyusSeatBooking",    glue ="com.cts.automation.stepdef")

public class TestRunner
{

}









