Feature: Home Page

@verifyCurrencyValueChange
Scenario:  User verify currency values change
		When User click on Currency 
		And User Chose Euro from dropdown 
		Then currency value should change to Euro

@emptyShoppingCartMessageDisplays
Scenario: User empty Shopping cart message displays 
		When User click on shopping cart 
		Then “Your shopping cart is empty!” message should display
