package step.definition;

import org.junit.Assert;
import core.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.LaptopNoteBooksPageObject;

public class LaptopNoteBooksStepDefinition extends Base {

	LaptopNoteBooksPageObject lapNotePageObj = new LaptopNoteBooksPageObject();
	
	
	//BACKGROUND
	@When("User click on Laptop &NoteBook tab")
	public void user_click_on_Laptop_Notebook_tab() {
		lapNotePageObj.clickOnLaptopNotebookTab();
		logger.info("Laptop &Notebook tab was clicked successfully");
	}
	
	@And("User click on Show all Laptop &NoteBook option")
	public void click_on_show_all_laptop_notebook_option() {
		lapNotePageObj.clickOnShowAllLaptopNotebookOption();
		logger.info("Show all Laptop &Notebook was displayed successfully");
	}


	//SCENARIO #1
	@When("User click on MacBook item")
	public void user_click_on_mac_book_item() {
		lapNotePageObj.clickOnMacbookItem();
		logger.info("MacBook item was clicked successfully");
	}

	@When("User click add to Cart button")
	public void user_click_add_to_cart_button() {
		lapNotePageObj.clickOnAddToCart();
		logger.info("Item was added to cart successfully");
	}

	private void userShouldSeeMessage(String msg){
		String actualText = lapNotePageObj.getMessage();
		Assert.assertEquals(msg, actualText);
		logger.info("Message shown successfully: " + msg);
	}

	@Then("User should see a message {string}")
//	@And("User should see a message {string}")
	public void user_should_see_message(String msg) {
		this.userShouldSeeMessage(msg);
	}

	@Then("User should see {int} item\\(s){double} showed to the cart")
	public void user_should_see_item_s_showed_to_the_cart(Integer numItems, Double price) {
		String actualText = lapNotePageObj.itemsInCart();
		Assert.assertEquals(String.format("%d item(s) - $%.2f", numItems, Math.abs(price)), actualText);
		logger.info("Success message was displayed");
	}

	@Then("User click on cart option")
	public void user_click_on_cart_option() {
		lapNotePageObj.cartOption();
		logger.info("User clicked on cart successfully");
	}

	@Then("user click on red X button to remove the item from cart")
	public void user_click_on_red_x_button_to_remove_the_item_from_cart() {
		lapNotePageObj.redXRemove();
		logger.info("The red X button was clicked successfully");
	}

	@Then("item should be removed and cart should show {int} item\\(s)")
	public void item_should_be_removed_and_cart_should_show_item_s(Integer int1) {
		String actualText = lapNotePageObj.itemsInCart();
		Assert.assertEquals(String.format("%d item(s) - $%.2f", int1, 0.0), actualText);
		logger.info("User clicked on cart successfully");
	}

	
	//SCENARIO #2
	@When("User click on product comparison icon on ‘MacBook’")
	public void user_click_on_product_comparison_icon_on_mac_book() {
		lapNotePageObj.clickOnMacBookProdCompButton();
		logger.info("User clicked on product comparison on the MackBook Pro successfully");
	}

	@When("User click on product comparison icon on ‘MacBook Air’")
	public void user_click_on_product_comparison_icon_on_mac_book_air() {
		lapNotePageObj.clickOnMacBookAirProdCompButton();
		logger.info("User clicked on product comparison on the MackBook Air successfully");
	}

//	@Then("User should see a message ‘Success: You have added MacBook Air to your product comparison!’")
//	public void user_should_see_a_message_success_you_have_added_mac_book_air_to_your_product_comparison() {
//		String expectedText = "Success: You have added MacBook Air to your product comparison!\n×";
//		String actualText = lapNotePageObj.productComparisonSuccessMessage(expectedText);
//		Assert.assertEquals(expectedText, actualText);
//		logger.info("Product comparison success messsage was verified");
//	}

	@Then("User click on Product comparison link")
	public void user_click_on_product_comparison_link() {
		lapNotePageObj.clickOnProductComparisonLink();
		logger.info("User clicked on product comparison link successfully");
	}

	@Then("User should see Product Comparison Chart")
	public void user_should_see_product_comparison_chart() {
		lapNotePageObj.productComparisonChartDisplayed();
		logger.info("The product comparison chart was displayed successfully");
	}


	//SCENARIO #3
	@When("User click on heart icon to add ‘Sony VaIO’ laptop to wish list")
	public void user_click_on_heart_icon_to_add_sony_va_io_laptop_to_wish_list() {
		lapNotePageObj.clickOnHeartIcon();
		logger.info("User clicked on the heart icon to add the Sony VAIO to the wish list");
	}

	@Then("User should get a message {string}")
	public void userGetMessage(String msg) {
		this.userShouldSeeMessage(msg);
	}

	
	//SCENARIO #4
	@When("User click on ‘MacBook Pro’ item")
	public void user_click_on_mac_book_pro_item() {
		lapNotePageObj.clickMacBookProItem();
		logger.info("User clicked on the MacBook Pro successfully");
	}

	@Then("^User should see ‘(.*)’ price tag is present on UI.$")
	public void userShouldSee$PriceTagIsPresentOnUI(String price) {
		String actualText = lapNotePageObj.macBookProPriceTagText();
		Assert.assertEquals(price, actualText);
		logger.info("MacBook Pro price displayed successfully");
	}
	
}
