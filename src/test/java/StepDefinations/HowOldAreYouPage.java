package StepDefinations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic.BaseClassImp;
import Generic.SetUpAndTearDown;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HowOldAreYouPage extends BaseClassImp {

	// Elements for HowOldAreYouPage
	@FindBy(xpath = "//h1[@class='logo cursive']")
	private WebElement headerText;

	@FindBy(xpath = "//input[@name='name']")
	private WebElement yourName;

	@FindBy(xpath = "//input[@name='birthday']")
	private WebElement yourBirthday;

	@FindBy(xpath = "//button[@id='submitButton']")
	private WebElement submitButton;

	@FindBy(xpath = "//span[@id='help_name']")
	private WebElement errorForName;

	@FindBy(xpath = "//span[@id='help_birthday']")
	private WebElement errorForBirthday;

	@FindBy(xpath = "//div[@id='resultDiv']//h1[2]")
	private WebElement CalculatedAge;

	@FindBy(xpath = "//div[@id='resultDiv']//h1[1]")
	private WebElement helloText;

	public HowOldAreYouPage() {
		PageFactory.initElements(driver, this);
	}

	@Given("user navigate to home page")
	public void user_navigate_to_home_page() {
		// Launch application
		launchApplication();
	}

	@Then("I validate the page title")
	public void i_validate_the_page_Title(String title) {
		assertEquals(BaseClassImp.driver.getTitle(), title);

	}

	@Then("I validate the header text")
	public void i_validate_the_header_text(String header) {
		assertEquals(headerText.getText(), header);

	}

	@Then("I verify yourName is by default empty")
	public void i_verify_your_name_is_by_default_empty() {
		assertTrue(yourName.getAttribute("value").isEmpty());

	}

	@Then("your birthday field is by default empty")
	public void your_birthday_field_is_in_dob_formate() {
		assertTrue(yourBirthday.getAttribute("value").isEmpty());

	}

	@When("user keeps your name as blank {string}")
	public void user_keeps_pranali_as_blank(String name) {
		BaseClassImp.waitFor(2);
		yourName.sendKeys(name);
		BaseClassImp.waitFor(2);

	}

	@When("user clicks on submit button")
	public void user_clicks_on_submit_button() {
		BaseClassImp.waitFor(2);
		submitButton.click();

	}

	@Then("user verify error for your name as {word}")
	public void user_verify_error_for_your_name(String error) {
		BaseClassImp.waitFor(6);
		String actualError = errorForName.getText();
		System.out.println("error : " + actualError);
		assertEquals(actualError, error);

	}

	@When("user enters correct your name field as {word}")
	public void user_enters_correct_yourName(String name) {
		BaseClassImp.waitFor(2);
		yourName.sendKeys(name);
		BaseClassImp.waitFor(1);
	}

	@When("user enters correct your birthday field as {word}")
	public void user_enters_correct_yourBrithday(String birthday) {
		BaseClassImp.waitFor(2);
		yourBirthday.sendKeys(birthday);
		BaseClassImp.waitFor(2);

	}

	@Then("user verify error {string} for birthday field")
	public void user_verify_error_for_your_birthday_field(String error) {
		BaseClassImp.waitForEC(errorForBirthday, 30);
		assertTrue(errorForBirthday.isDisplayed());
		assertEquals(errorForBirthday.getAttribute("textContent"), error);

	}

	@Then("user verify error {string} for name field")
	public void user_verify_error_for_name_field(String error) {
		assertEquals(errorForName.getAttribute("textContent"), error);

	}

	@Then("user verify age is displayed as {string}")
	public void response_code_for_request(String  yourBirthday) {
		BaseClassImp.waitFor(10);
		BaseClassImp.waitForEC(CalculatedAge, 30);
		assertTrue(CalculatedAge.isDisplayed());
		
		LocalDate current_date = LocalDate.now();
        
        int current_Year = current_date.getYear();
        
        String enteredYear=yourBirthday.substring(6, 10);
        
        int enteredYearInt=Integer.parseInt(enteredYear);
        int calculatedAge=current_Year-enteredYearInt;
        
		String ageIs = CalculatedAge.getAttribute("textContent");
		SetUpAndTearDown.scenario.log("Calculated Age Is : "+String.valueOf(calculatedAge));
		assertEquals(ageIs, "Your age is " + String.valueOf(calculatedAge));

	}

	@Then("user verify hello text is displayed {word}")
	public void helloText(String name) {
		BaseClassImp.waitFor(10);
		System.out.println("Calculated Age is : " + helloText.getAttribute("textContent"));
		SetUpAndTearDown.scenario.log("Your Name : "+helloText.getAttribute("textContent"));
		assertEquals(helloText.getAttribute("textContent"), "Hello " + name + "!");

	}

}
