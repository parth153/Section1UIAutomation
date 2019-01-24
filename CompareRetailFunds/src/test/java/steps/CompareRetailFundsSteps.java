package steps;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.FundsCompare;
import pages.HomePage;
import pages.InvestmentsPage;
import cucumber.api.java.en.Then;


//Step Definition File for the Feature File - CompareRetailFunds.feature
public class CompareRetailFundsSteps {
	
	//Page Objects and WebDriver Instance
	public static WebDriver driver = null;
	HomePage home = null;
	InvestmentsPage invest = null;
	FundsCompare fundsCmp = null;
	
	//Given Step mapping for Scenario
	@Given("^I am a Vanguard User and on HomePage$")
	public void i_am_a_Vanguard_User_and_on_HomePage() throws Throwable {
		home = new HomePage(driver);		
	}

	//When Step mapping for Scenario
	@When("^I Navigate to Individual & SMSF Investors$")
	public void i_Navigate_to_Individual_SMSF_Investors() throws Throwable {
	    invest = home.clickIndividualAndSMSFInverstorsLink();		
	}

	//And (When) Step mapping for Scenario
	@When("^Click on Fund Compare$")
	public void click_on_Fund_Compare() throws Throwable {
		fundsCmp = invest.clickFundsCompare();
		
	}

	//Then Step mapping for Scenario
	@Then("^I should be able to compare 4 Retail funds by clicking one Add Funds button$")
	public void i_should_be_able_to_compare_4_Retail_funds_clicking_one_Add_Funds_button() throws Throwable {
	    
		//Performing all the operations here
		fundsCmp.addFundsFirstButtonClick();
		fundsCmp.selectRetailRadioButtonClick();
		fundsCmp.selectFourFundsFromList();
		fundsCmp.compareFundsButtonClick();
		
		//Asserting that the displayed table has all the fields populated
		assertEquals(fundsCmp.verifyResult(),true);		
	}

	@Then("^I should be able to compare 4 Retail funds by clicking all Add Funds buttons$")
	public void i_should_be_able_to_compare_4_Retail_funds_by_clicing_all_add_funds_buttons() throws Throwable {
		
		//Performing all the operations in the relevant Page Object Class
		fundsCmp.PerformScenarioStep();
		
		//Asserting that the displayed table has all the fields populated
		assertEquals(fundsCmp.verifyResult(),true);		
	}
}
