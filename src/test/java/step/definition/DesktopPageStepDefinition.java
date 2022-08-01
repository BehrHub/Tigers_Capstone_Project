package step.definition;

import java.util.List;
import java.util.Map;
import org.junit.Assert;
import core.Base;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.DesktopPageObject;

public class DesktopPageStepDefinition extends Base {
	
	DesktopPageObject desktopPageObj = new DesktopPageObject();


	@When("User click on Desktop tab")
	public void user_click_on_desktop_tab() {
	desktopPageObj.clickonDesktopsTab();
	logger.info("Desktop Button was clicked successfully");  
	}

	@And("User click on Show all desktops")
	public void user_click_on_show_all_desktops() {
	desktopPageObj.clickOnShowAllDesktops();
	logger.info("Show All Desktops Button was clicked successfully");
	}

	@Then("User should see all Items are present in Desktop page")
	public void user_should_see_all_items_are_present_in_desktop_page() {
		int numElements = desktopPageObj.numElements();
		Assert.assertEquals(12, numElements);
		logger.info("All items were displayed successfully");
	}

	@And("User click ADD TO CART option on HP LP {int} item")
	public void user_click_add_to_cart_option_on_hp_lp_item(Integer int1) {
	desktopPageObj.clickOnHPLP3065Item();
	logger.info("Add to Cart Button was clicked successfully");  
	}

	@And("User select quantity {int}")
	public void user_select_quantity(int quantity) {
	desktopPageObj.selectQuantity(quantity);
	logger.info("User selected quantity " + quantity);
	}

	@And("User click Add to cart button")
	public void user_click_add_to_cart_button() {
	desktopPageObj.clickOnAddToCartButton();
	logger.info("User clicked add to cart button");
	}

//	@And("User should see a message {string}")
//	public void user_should_see_a_message(String expectedText) {
//		String actualText = desktopPageObj.successMessageHp();
//		Assert.assertEquals(expectedText, actualText);
//		logger.info("Added HP LP 3065 to shopping cart successfully");
//	}

	@And("User click ADD TO CART option on Canon EOS 5D item")
	public void user_click_add_to_cart_option_on_canon_eos_5d_item() {
	desktopPageObj.clickOnAddToCartOptionCanon();
	logger.info("User clicked add to cart option");
	}

	@And("User select color {string} from dropdown")
	public void user_select_color_from_dropdown(String string) {
	desktopPageObj.clickOnRed();
	logger.info("User clicked on Red");
	}

	@Then("User should see a messsage {string}")
	public void user_should_see_a_success_message(String expectedText) {
		String actualText = desktopPageObj.successMessageCanon();
		Assert.assertEquals(expectedText, actualText);
		logger.info("The message was displayed correctly");
	}

	@And("User click on CANON EOS 5D item")
	public void user_click_on_canon_eos_5d_item() {
	desktopPageObj.clickOnCanonEOS5DCItemLink();
	logger.info("User clicked on Canon EOS item");
	}

	@And("User click on Write a review link")
	public void user_click_on_write_a_review_link() {
	desktopPageObj.clickOnWriteAReviewLink();
	logger.info("User clicked on Write a Review link");
	}

	@And("User fill the review information with below information")
	public void user_fill_the_review_information_with_below_information(DataTable dataTable) {
		List<Map<String,String>> reviewInformation = dataTable.asMaps(String.class,String.class);
		desktopPageObj.writeYourNameReview(reviewInformation.get(0).get("yourName"));
		desktopPageObj.writeAReview(reviewInformation.get(0).get("yourReview"));
		desktopPageObj.selectRating(reviewInformation.get(0).get("Rating"));
	}

	@And("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		desktopPageObj.clickContinueButton();
		logger.info("User clicked on Continue button");
	}

	@Then("User should see a message with {string}")
	public void user_should_see_a_message_with(String reviewMessage) {
		String actualText = desktopPageObj.successMessageCanon();
		Assert.assertEquals(reviewMessage, actualText);
		logger.info("Review message was displayed successfully");
	}

}
