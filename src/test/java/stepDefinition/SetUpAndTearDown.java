package stepDefinition;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class SetUpAndTearDown extends BaseClassImp{
	
	@Before
	public void setUp() {
		launchBrowser();
	}
	
	
	@After
	public void tearDown() throws IOException {
		extentReport();
		driver.quit();
	}

}
