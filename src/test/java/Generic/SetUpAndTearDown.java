package Generic;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class SetUpAndTearDown extends BaseClassImp{
	
	public static  Scenario scenario;
	private static boolean flag;
	
	@Before
	public void setUp(Scenario scenario) {
		
		SetUpAndTearDown.scenario = scenario;
		flag=false;
		String scenarioName=scenario.getName();
		
		//Launch Browser
		launchBrowser();
	}
	
	
	@After
	public void tearDown() throws IOException {
		extentReport();
		driver.quit();
	}

}
