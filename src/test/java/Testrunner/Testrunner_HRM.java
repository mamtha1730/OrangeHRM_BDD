package Testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class) 
@CucumberOptions
( 
		features=".//Features/HRMLogin.feature", 
		glue= {"Stepdefinitions"},
		monochrome = true,
		publish=true,
		dryRun= false,
		
	plugin= {"pretty","html:reports/myreport.html","rerun:target/rerun.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		//plugin = {"pretty","html:reports/myreport.html"}
)
public class Testrunner_HRM {

}
