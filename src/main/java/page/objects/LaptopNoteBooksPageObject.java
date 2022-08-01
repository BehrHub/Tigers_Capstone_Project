package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import core.Base;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Utils;

public class LaptopNoteBooksPageObject extends Base {

	public LaptopNoteBooksPageObject() {
		PageFactory.initElements(driver,  this);
		wait = new WebDriverWait(driver, 5);
	}

	private final WebDriverWait wait;


	//BACKGROUND XPATH
	@FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[2]/a")
	private WebElement laptopNotebookTab;

	@FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[2]/div/a")
	private WebElement showAllLaptopNotebook;
	

	//SCENARIO #1 XPATH
	//Add and Remove a MacBook from Cart
	@FindBy(xpath = "//*[@id=\"content\"]/div[4]/div[2]/div/div[2]/div[1]/h4/a")
	private WebElement macbookItem;

	@FindBy(xpath = "//*[@id=\"button-cart\"]")
	private WebElement addToCart;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement laptopNotebookSuccessMessage;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement messageElement;

	@FindBy(xpath = "xpath =\"//*[@id=\"cart-total\"]")
	private WebElement cartItems;
	
	@FindBy(xpath = "//*[@id=\"cart\"]/button")
	private WebElement cartOption;
	
	@FindBy(xpath = "//*[@id=\"cart\"]/ul/li[1]/table/tbody/tr/td[5]/button")
	private WebElement redXRemove;
	
	@FindBy(xpath = "//*[@id=\"cart-total\"]")
	private WebElement updatedCart;


	//SCENARIO #2 XPATH
	@FindBy(xpath = "//*[@id=\"content\"]/div[4]/div[2]/div/div[2]/div[2]/button[3]")
	private WebElement macBookProdCompButton;

	@FindBy(xpath = "//*[@id=\"content\"]/div[4]/div[3]/div/div[2]/div[2]/button[3]")
	private WebElement macBookAirProdCompButton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement macBookAirSuccessfullyAddedToComp;

//	@FindBy(xpath = "//*[@id=\"product-product\"]/div[1]/a[2]")
	@FindBy(xpath = "//div[1]/i")
	private WebElement productComparisonLink;

	@FindBy(xpath = "//a[text()='product comparison']")
	private WebElement productComparisonChart;


	//SCENARIO #3 XPATH
	@FindBy(xpath = "//*[@id=\"content\"]/div[4]/div[5]/div/div[2]/div[2]/button[2]")
	private WebElement heartIcon;

	@FindBy(xpath = "//*[@id=\"product-category\"]/div[1]")
	private WebElement userNeedsAccountMessage;

	
	//SCENARIO #4 XPATH
	@FindBy(xpath = "//*[@id=\"content\"]/div[4]/div[4]/div/div[1]/a")
	private WebElement macBookProItem;
	
	@FindBy(xpath = "//h2[text()='$2,000.00']")
	private WebElement macBookProPriceTag;

	final private String comparisonAddedMsgXpath = "//div[@class='alert alert-success alert-dismissible']";

	
	
	//		
	//		M	E	T	H	O	D	S
	//

	
	
	//BACKGROUND METHODS
	public void clickOnLaptopNotebookTab() {
		laptopNotebookTab.click();
	}
	public void clickOnShowAllLaptopNotebookOption() {
		showAllLaptopNotebook.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ById("content")));
	}


	//SCENARIO #1 METHODS
	public void clickOnMacbookItem() {
		macbookItem.click();
		Utils.waitSomeTime(2000);
	}
	public void clickOnAddToCart() {
		addToCart.click();
		Utils.waitSomeTime(2000);
	}
//	public String addToCartSuccessMessage() {
//		String laptopNotebookSuccessMessageText = laptopNotebookSuccessMessage.getText().split("\n")[0];
//		return laptopNotebookSuccessMessageText;
//	}
	public String getMessage() {
		return messageElement.getText().split("\n")[0];
	}
	public String itemsInCart() {
		return cartOption.getText();
	}
	public void cartOption() {
		cartOption.click();
	}
	public void redXRemove() {
		redXRemove.click();
	}

	//SCENARIO #2 METHODS
	public void clickOnMacBookProdCompButton() {
		macBookProdCompButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(comparisonAddedMsgXpath)));
		Utils.waitSomeTime(1000);
	}
	public void clickOnMacBookAirProdCompButton() {
		macBookAirProdCompButton.click();
		Utils.waitSomeTime(1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath(comparisonAddedMsgXpath)));
	}
//	public String productComparisonSuccessMessage(String msg) {
//		wait.until(ExpectedConditions.textToBe(new By.ByXPath(comparisonAddedMsgXpath), msg));
//		return macBookAirSuccessfullyAddedToComp.getText();
//	}
	public void clickOnProductComparisonLink() {
		productComparisonLink.click();
	}
	public String productComparisonChartDisplayed() {
		return productComparisonChart.getText();
	}


	//SCENARIO #3 METHODS
	public void clickOnHeartIcon() {
		heartIcon.click();
	}
	public String userNeedsAccountMessage() {
		return userNeedsAccountMessage.getText().split("\n")[0];
	}

	
	//SCENARIO #4 METHODS
	public void clickMacBookProItem() {
		macBookProItem.click();
	}
	public String macBookProPriceTagText() {
		return macBookProPriceTag.getText();
	}
	
}
