Feature: Retail Page

Background:
		Given User is on Retail website
		And User click on MyAccount
		When User click on Login 
		And User enter username 'behrang.eini@tekschool.us' and password 'TEK!@#123'
		And User click on Login button
		Then User should be logged in to MyAccount dashboard

@registerAffiliate
Scenario: Register as an Affiliate user with Cheque Payment Method
		When User click on 'Register for an Affiliate Account' link
		And User fill affiliate form with below information
		|company|website|taxID|paymentMethod|
		|EiniEnterprise|www.einienterprise.com|E007|Cheque|
		And User check on About us check box
		And User click on Continue button
		Then User should see a success message

@editAffiliate
Scenario: Edit your affiliate information from Cheque payment method to Bank Transfer
		When User click on ‘Edit your affiliate information' link 
		And user click on Bank Transfer radio button
		And User fill Bank information with below information
		|bankName|abaNumber|swiftCode|accountName|accountNumber|
		|Capital One|888|101|Checking|007-24-0808|
		And User click on Continue button 
		Then User should see a success message 

@editAccountInfo
Scenario: Edit your account Information 
		When User click on ‘Edit your account information’ link 
		And User modify below information
		|firstname|lastName|email|telephone|
		|Behr|Eini|behr.e@gmail.com|240-372-1000|
		And User click on continue button 
		Then User should see a message ‘Success: Your account has been successfully updated.’
