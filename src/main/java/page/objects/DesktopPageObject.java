package page.objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.Base;
import utilities.Utils;

public class DesktopPageObject extends Base {

	public DesktopPageObject() {
		PageFactory.initElements(driver,  this);
	}


	//BACKGROUND XPATH
	@FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[1]/a")
	private WebElement desktopsTab;

	@FindBy(xpath = "//*[@id=\"menu\"]/div[2]/ul/li[1]/div/a")
	private WebElement showAllDesktops;


	//SCENARIO #1 XPATH
	@FindBy(xpath = "//*[@id=\"content\"]/div[5]/div[2]")
	private WebElement showAllItems;


	//SCENARIO #2 XPATH
	@FindBy(xpath = "//*[@id=\"content\"]/div[4]/div[3]/div/div[1]")
	private WebElement clickHpLp3065;

	@FindBy(id ="input-quantity")
	private WebElement quantityInput;

	@FindBy(xpath = "//*[@id=\"button-cart\"]")
	private WebElement addToCartButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successMessageHpLp3065;

	
	//SCENARIO #3 XPATH
	@FindBy(xpath ="//a[text()='Canon EOS 5D Camera']")
	private WebElement addToCartCanonEOS5DCamera;

	@FindBy(xpath ="//*[@id=\"input-option226\"]")
	private WebElement colorSelectDropdown;

	@FindBy(xpath ="//*[@id=\"input-option226\"]/option[2]")
	private WebElement colorRed;

	@FindBy(id ="//*[@id=\"input-quantity\"]")
	private WebElement canonQuantityInput;

	@FindBy(xpath = "//*[@id=\"button-cart\"]")
	private WebElement canonAddToCartButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement successMessageCanonEOS5DC;

	
	//SCENARIO #4 XPATH
	@FindBy(xpath = "//*[@id=\"content\"]/div[4]/div[2]/div/div[1]")
	private WebElement clickOnEOS5DCamera;

	@FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div[3]/p/a[2]")
	private WebElement clickOnWriteAReview;

	@FindBy(xpath = "//*[@id=\"input-name\"]")
	private WebElement yourNameField;

	@FindBy(xpath = "//*[@id=\"input-review\"]")
	private WebElement yourReviewField;

	@FindBy(xpath ="//*[@id=\"form-review\"]/div[4]/div/input[5]")
	private WebElement ratingGood;

	@FindBy(xpath = "//*[@id=\"button-review\"]")
	private WebElement reviewContinueButton;

	@FindBy(xpath ="//*[@id=\"form-review\"]/div[2]")
	private WebElement reviewSubmissionMessage;


	
	//		
	//		M	E	T	H	O	D	S
	//



	//BACKGROUND METHODS
	public void clickonDesktopsTab() {
		desktopsTab.click();
	}

	public void clickOnShowAllDesktops() {
		showAllDesktops.click();
	}


	//SCENARIO #1 METHODS
	public int numElements() {
		WebElement itemsList = driver.findElement(new By.ByXPath("//*[@id=\"content\"]/div[4]"));
		List<WebElement> allChildren = itemsList.findElements(new By.ByClassName("product-thumb"));

		return allChildren.size();
	}


	//SCENARIO #2 METHODS
	public void clickOnHPLP3065Item() {
		clickHpLp3065.click();
	}

	public void selectQuantity(int quantity) {
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript(
				 String.format("arguments[0].value=%d;",
						 quantity), 
				 quantityInput);
	}

	public void clickOnAddToCartButton() {
		addToCartButton.click();
	}

	public String successMessageHp() {
		Utils.waitSomeTime(500);
		String desktopSuccessMessageText = successMessageHpLp3065.getText().split("\n")[0];
		return desktopSuccessMessageText;
	}


	//SCENARIO #3 METHODS
	public void clickOnAddToCartOptionCanon() {
		addToCartCanonEOS5DCamera.click();
	}
	public void clickOnColorSelect() {
		colorSelectDropdown.click();
	}
	public void clickOnRed() {
		colorRed.click();
	}
	public void selectQuantityCanon(String canonQuantity) {
		quantityInput.clear();
		quantityInput.sendKeys(canonQuantity);
	}
	public void addToCartCanon() {
		canonAddToCartButton.click();
	}
	public String successMessageCanon() {
		String desktopSuccessMessageText = successMessageCanonEOS5DC.getText().split("\n")[0];
		return desktopSuccessMessageText;
	}


	//SCENARIO #4 METHODS
	public void clickOnCanonEOS5DCItemLink() {
		clickOnEOS5DCamera.click();
	}
	public void clickOnWriteAReviewLink() {
		clickOnWriteAReview.click();
	}

	public void writeYourNameReview(String yourName) {
		yourNameField.sendKeys(yourName);
	}
	public void writeAReview(String yourReview) {
		yourReviewField.sendKeys(yourReview);
	}
	public void selectRating(String ratingValue) {
		ratingGood.click();
	}

	public void clickContinueButton() {
		reviewContinueButton.click();
	}
	public String reviewText() {
		String desktopSuccessMessageText = reviewSubmissionMessage.getText();
		return desktopSuccessMessageText;
	}
	
}
