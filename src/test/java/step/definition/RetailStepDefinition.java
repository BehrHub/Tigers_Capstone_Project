package step.definition;

import java.util.List;
import java.util.Map;
import org.junit.Assert;
import core.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.RetailPageObject;
import utilities.Utils;

public class RetailStepDefinition extends Base {

	RetailPageObject retailPageObj = new RetailPageObject();

	@Given("User is on Retail website")
	public void user_is_on_Retail_website() {
		Assert.assertTrue(retailPageObj.isLogoPresent());
		Assert.assertEquals("TEK SCHOOL", retailPageObj.getTitle());
		logger.info("user is on Retail Website");
	}

	@When("User click on MyAccount")
	public void And_User_click_MyAccount() {
		retailPageObj.clickOnMyAccountButton();
		logger.info("My Account Button was clicked successfully");
	}

	@And("User click on Login")
	public void User_click_on_Login() {
		retailPageObj.clickOnLoginLink();
		logger.info("Login button is clicked.");
	}

	@And("User enter username {string} and password {string}")
	public void user_enter_username_and_password_password(String username, String password) {
		retailPageObj.enterEmail(username);
		retailPageObj.enterPassword(password);
		Utils.waitSomeTime(5000);
		logger.info("Email and password were entered successfully");
	}

	@And("User click on Login button")
	public void I_click_on_login_button() {
		retailPageObj.clickOnLoginButton();
		logger.info("Login button was clicked successfully");
	}

	@Then("User should be logged in to MyAccount dashboard")
	public void user_should_be_logged_in_to_my_account_dashboard() {
		String expectedText = "My Account";
		String ActualText = retailPageObj.getTextAfterLogin();
		Assert.assertEquals(expectedText, ActualText);
		logger.info("My Account text was verified successfully");
	}


	// SCENARIO #1
	@When("User click on 'Register for an Affiliate Account' link")
	public void user_click_on_register_for_an_affiliate_account_link() {
		retailPageObj.clickOnRegisterAffiliateLink();
		logger.info("User click on Register for an Affiliate Account link");
	}

	@And("User fill affiliate form with below information")
	public void user_fill_affiliate_form_with_below_information(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String,String>> affiliateInformation = dataTable.asMaps(String.class,String.class);
		retailPageObj.fillCompanyBox(affiliateInformation.get(0).get("company"));
		retailPageObj.fillWebsiteBox(affiliateInformation.get(0).get("website"));
		retailPageObj.fillTaxBox(affiliateInformation.get(0).get("taxID"));
		logger.info("User filled out Affiliate Form");
	}

	@And("User check on About us check box")
	public void user_check_on_about_us_check_box() {
		retailPageObj.aboutUsCheckBox();
		logger.info("user checked on About us check box");
	}

	@And("User click on Continue button")
	public void user_click_on_continue_button() {
		retailPageObj.clickContinueButton();
		logger.info("user clicked on Continue button");
	}

	@Then("User should see a success message")
	public void user_should_see_a_success_message(String expectedText) {
		String actualText = retailPageObj.registerAffiliateSuccessMessage();
		Assert.assertEquals(expectedText, actualText);
		logger.info("Success message is displayed successfully");
	}


	// Scenario #2
	@When("User click on 'Edit your affiliate information'")
	public void user_click_on_Edit_your_affiliate_information_link() {
		retailPageObj.clickOnEditAffiliateLink();
		logger.info("Register for an Affiliate Account link was clicked successfully");
	}

	@And("User_click_on_Bank_Transfer_radio_button")
	public void user_click_on_Bank_Transfer_radio_button() {
		retailPageObj.clickOnBankTransferButton();
		logger.info("user clicked on radio button");
	}
	@And ("User_fill_Bank_information_with_below_information")
	public void user_fill_Bank_information_with_below_information(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String,String>> affiliateInformation = dataTable.asMaps(String.class,String.class);
		retailPageObj.fillBankNameInput(affiliateInformation.get(0).get("bankName"));
		retailPageObj.fillAbaNumber(affiliateInformation.get(0).get("abaNumber"));
		retailPageObj.fillSwiftCodeInput(affiliateInformation.get(0).get("swiftCode"));
		retailPageObj.fillAccountName(affiliateInformation.get(0).get("accountName"));
		retailPageObj.fillAccountNumber(affiliateInformation.get(0).get("accountNumber"));
		logger.info("User filled out Affiliate Form");
	}


	// Scenario #3
	@When("User click on 'Edit your account information' link")
	public void user_click_on_Edit_your_account_information_link() {
		retailPageObj.clickOnEditAffiliateAccountLink();
		logger.info("Affiliate Account was edited");
	}
	@And("User modify below information")
	public void user_modify_below_information(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String,String>> affiliateInformation = dataTable.asMaps(String.class,String.class);
		retailPageObj.fillFirstNameInput(affiliateInformation.get(0).get("firstname"));
		retailPageObj.fillLastNameInput(affiliateInformation.get(0).get("lastName"));
		retailPageObj.fillEmailInput(affiliateInformation.get(0).get("email"));
		retailPageObj.fillTelephoneInput(affiliateInformation.get(0).get("telephone"));
		logger.info("User edited Affiliate Form");
	}

	@Then("User should see a message with ‘Success: Your account has been successfully updated.’")
	public void user_should_see_a_message_with(String reviewMessage) {
		String actualText = retailPageObj.editAffiliateSuccessMessage();
		Assert.assertEquals(reviewMessage, actualText);
		logger.info("Review message was displayed successfully");
	}
	
}
