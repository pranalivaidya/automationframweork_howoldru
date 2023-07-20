package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
	features = ("C:/Users/prana/git/repository/GG-Framework/src/test/resouces/feature"),
	glue = ("stepDefinition"),
	plugin = {"pretty" , "junit:target/junitReport/report.xml"},
	tags = ""
		
		
		)

public class testRunner {

}
