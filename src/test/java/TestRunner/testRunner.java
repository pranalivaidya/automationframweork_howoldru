package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
	features = ("src/test/resouces/feature"),
	glue = {"StepDefinations","Generic"},
	plugin = {"pretty" , "html:target/cucumber-reports/reports.html"},
	tags = ""
		
		
		)

public class testRunner {

}
