package page.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import core.Base;

public class HomePageObject extends Base {

	public HomePageObject() {
		PageFactory.initElements(driver,  this);
	}


	//SCENARIO #1 XPATH
	//User verify currency values change
	@FindBy(xpath = "//*[@id=\"form-currency\"]/div/button")
	private WebElement currencyButton;
	
	@FindBy(xpath = "//div/ul/li[1]/button[text()='€ Euro']")
	private WebElement currencyEuro;
	
	@FindBy(xpath = "//div/button/strong[text()='€']")
	private WebElement currencyChangeValidate;
	

	//SCENARIO #2 XPATH	
	//User empty Shopping cart message displays
	@FindBy(xpath = "//ul/li[4]/a")
	private WebElement shoppingCartButton;
	
	@FindBy(xpath = "//p[text()='Your shopping cart is empty!']")
	private WebElement shoppingCartEmptyMessage;
	
	
	
	//		
	//		M	E	T	H	O	D	S
	//
	
	
	
	//SCENARIO #1 METHODS
	public void clickOnCurrencyButton() {
		currencyButton.click();
	}
	public void clickOnCurrencyEuro() {
		currencyEuro.click();
	}
	public String currencyValueChange() {
		String homePageCurrencyChangeText = currencyChangeValidate.getText();
		return homePageCurrencyChangeText;
	}
	
	
	//SCENARIO #2 METHODS
	public void clickOnShoppingCartButton() {
		shoppingCartButton.click();
	}
	public String shoppingCartEmptyMessageDisplayed() {
		String shoppingCartEmptyMessageText = shoppingCartEmptyMessage.getText();
		return shoppingCartEmptyMessageText;
	}
	
}
