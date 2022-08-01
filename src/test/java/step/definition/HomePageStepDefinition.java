package step.definition;

import org.junit.Assert;
import core.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.objects.HomePageObject;

public class HomePageStepDefinition extends Base {

	HomePageObject homePageObj = new HomePageObject();

	//SCENARIO #1
	@When("User click on Currency")
	public void user_click_on_currency() {
		homePageObj.clickOnCurrencyButton();
		logger.info("User clicked on currency button successfully");
	}

	@When("User Chose Euro from dropdown")
	public void user_chose_euro_from_dropdown() {
		homePageObj.clickOnCurrencyEuro();
		logger.info("User clicked on Euro successfully");
	}

	@Then("currency value should change to Euro")
	public void currency_value_should_change_to_euro() {
		homePageObj.currencyValueChange();
		logger.info("Currency value was changed successfully");
	}

	
	//SCENARIO #2
	@When("User click on shopping cart")
	public void user_click_on_shopping_cart() {
		homePageObj.clickOnShoppingCartButton();
		logger.info("Shopping cart was clicked successfully");
	}

	@Then("“Your shopping cart is empty!” message should display")
	public void your_shopping_cart_is_empty_message_should_display() {
		homePageObj.shoppingCartEmptyMessageDisplayed();
		logger.info("Shopping cart empty message was displayed successfully");
	}

}
