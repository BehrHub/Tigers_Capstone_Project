package page.objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import core.Base;
import utilities.Utils;

public class RetailPageObject extends Base {

	public RetailPageObject() {
		PageFactory.initElements(driver, this);

	}


	//BACKGROUND XPATH
	@FindBy(xpath = "//*[@id=\"logo\"]/h1/a")
	private WebElement testEnvironmentText;

	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement myAccountButton;

	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	private WebElement loginLink;

	@FindBy(id="input-email")
	private WebElement loginEmail;

	@FindBy(id="input-password")
	private WebElement loginPassword;
	
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement loginButton;

	@FindBy(xpath = "//h2[text()='Returning Customer']")
	private WebElement retailPageText;

	@FindBy(xpath = "//h2[text()='My Account']")
	private WebElement myAccountPage;


	//SCENARIO #1 XPATH
	@FindBy(xpath = "//a[text()='Register for an affiliate account']")
	private WebElement registerAffiliateAccount;

	@FindBy(xpath = "//*[@id='input-company']")
	private WebElement companyInput;

	@FindBy(xpath = "//*[@id='input-website']")
	private WebElement websiteInput;
	
	@FindBy(xpath = "//*[@id='input-tax']")
	private WebElement taxInput;

	@FindBy(xpath = "//input[@value='cheque']")
	private WebElement paymentCheque;

	@FindBy(xpath = "//*[@id='content']/form/div/div/input[1]")
	private WebElement aboutUsCheckBox;

	@FindBy(xpath = "//*[@id='content']/form/div/div/input[2]")
	private WebElement continueButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	private WebElement registerAffiliateSuccessMessage;


	//SCENARIO #2 XPATH
	@FindBy(xpath = "//a[text()='Edit your affiliate information']")
	private WebElement editAffiliateLink;

	@FindBy(xpath = "//*[@id='content']/form/fieldset[2]/div[2]/div/div[3]/label/input")
	private WebElement bankTransferButton;

	@FindBy(xpath = "//*[@id='input-bank-name']")
	private WebElement bankNameInput;

	@FindBy(xpath = "//*[@id='input-company']")
	private WebElement abaNumberInput;

	@FindBy(xpath = "//*[@id='input-bank-branch-number']")
	private WebElement swiftCodeInput;

	@FindBy(xpath = "//*[@id='input-bank-account-name']")
	private WebElement accountNameInput;

	@FindBy(xpath = "//*[@id='input-bank-account-number']")
	private WebElement accountNumberInput;

	@FindBy(xpath = "//*[@id='content']/form/div/div/input")
	private WebElement editAffiliateContinueButton;

	@FindBy(xpath = "//*[@id='account-account']/div[1]")
	private WebElement editAffiliateSuccessMessage;


	//SCENARIO #3 XPATH
	@FindBy(xpath = "//*[@id=\"content\"]/ul[1]/li[1]/a")
	private WebElement editAffiliateAccountLink;

	@FindBy(xpath = "//*[@id=\"input-firstname\"]")
	private WebElement firstNameInput;

	@FindBy(xpath = "//*[@id=\"input-lastname\"]")
	private WebElement lastNameInput;

	@FindBy(xpath = "//*[@id=\"input-email\"]")
	private WebElement emailInput;

	@FindBy(xpath = "//*[@id=\"input-telephone\"]")
	private WebElement telephoneInput;

	@FindBy(xpath = "//*[@id=\"content\"]/form/div/div[2]/input")
	private WebElement editAccountContinueButton;

	@FindBy(xpath = "//*[@id=\"account-account\"]/div[1]")
	private WebElement editAccountSuccessMessage;



	//		
	//		M	E	T	H	O	D	S
	//



	//BACKGROUND METHODS
	public void clickOnMyAccountButton() {
		myAccountButton.click();
	}
	public void clickOnLoginLink() {
		loginLink.click();
	}
	public boolean isLogoPresent() {
		if (testEnvironmentText.isDisplayed())
			return true;
		else
			return false;
	}
	public String getTitle() {
		return driver.getTitle();
	}
	public void enterEmail(String email) {
		loginEmail.sendKeys(email);
	}
	public void enterPassword(String password) {
		loginPassword.sendKeys(password);
	}
	public void clickOnLoginButton() {
		loginButton.sendKeys(Keys.RETURN);
	}
	public String getMyAccountText() {
		String textFromUI = retailPageText.getText();
		return textFromUI;
	}
	public String getTextAfterLogin() {
		String myAccountText = myAccountPage.getText();
		return myAccountText;
	}


	//SCENARIO #1 METHODS
	public void clickOnRegisterAffiliateLink() {
		registerAffiliateAccount.click();
	}
	public void fillCompanyBox(String company) {
		companyInput.sendKeys(company);
	}
	public void fillWebsiteBox(String website) {
		websiteInput.sendKeys(website);
	}
	public void fillTaxBox(String taxID) {
		taxInput.sendKeys(taxID);
	}
	public void fillPaymentBox(String paymentMethod) {
		paymentCheque.sendKeys(paymentMethod);
	}
	public void aboutUsCheckBox() {
		aboutUsCheckBox.click();
	}
	public void clickContinueButton() {
		continueButton.click();
	}
	public String registerAffiliateSuccessMessage() {
		Utils.waitSomeTime(500);
		String retailSuccessMessageText = registerAffiliateSuccessMessage.getText().split("\n")[0];
		return retailSuccessMessageText;
	}


	//SCENARIO #2 METHODS
	public void clickOnEditAffiliateLink() {
		editAffiliateLink.click();
	}
	public void clickOnBankTransferButton() {
		bankTransferButton.click();
	}
	public void fillBankNameInput(String bankName) {
		bankNameInput.sendKeys(bankName);
	}
	public void fillAbaNumber(String abaNumber) {
		abaNumberInput.sendKeys(abaNumber);
	}
	public void fillSwiftCodeInput(String swiftCode) {
		swiftCodeInput.sendKeys(swiftCode);
	}
	public void fillAccountName(String accountName) {
		accountNameInput.sendKeys(accountName);
	}
	public void fillAccountNumber(String accountNumber) {
		accountNumberInput.sendKeys(accountNumber);
	}
	public void editAffiliateContinueButton() {
		editAffiliateContinueButton.click();
	}
	public boolean isEditSuccessMessagePresent() {
		if(editAffiliateSuccessMessage.isDisplayed())
			return true;
		else
			return false;
	}


	//SCENARIO #3 METHODS
	public void clickOnEditAffiliateAccountLink() {
		editAffiliateAccountLink.click();
	}
	public void fillFirstNameInput(String firstname) {
		firstNameInput.sendKeys(firstname);
	}
	public void fillLastNameInput(String lastName) {
		lastNameInput.sendKeys(lastName);
	}
	public void fillEmailInput(String email) {
		emailInput.sendKeys(email);
	}
	public void fillTelephoneInput(String telephone) {
		telephoneInput.sendKeys(telephone);
	}
	public void clickOnEditAccountContinueButton() {
		editAccountContinueButton.click();
	}
	public String editAffiliateSuccessMessage() {
		Utils.waitSomeTime(500);
		String editAffiliateSuccessMessageText = editAccountSuccessMessage.getText().split("\n")[0];
		return editAffiliateSuccessMessageText;
	}

}
