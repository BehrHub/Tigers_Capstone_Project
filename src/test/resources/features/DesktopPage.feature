Feature: Desktops Tab

Background:
When User click on Desktop tab
And User click on Show all desktops


Scenario: User verify all items are present in Desktops tab
Then User should see all Items are present in Desktop page


Scenario: User add HP LP 3065 from Desktop tab to the cart
When User click ADD TO CART option on HP LP 3065 item
And User select quantity 1
And User click Add to cart button
Then User should see a message "Success: You have added HP LP3065 to your shopping cart!"


Scenario: User add Canon EOS 5D from Desktops tab to the cart
When User click ADD TO CART option on Canon EOS 5D item
And User select color 'RED' from dropdown
And User select quantity 1
And User click Add to cart button
Then User should see a messsage "Success: You have added Canon EOS 5D Camera to your shopping cart!"


Scenario: User add a review to CANON EOS 5D item in Desktop tab
When User click on CANON EOS 5D item
And User click on Write a review link
And User fill the review information with below information
|yourName|yourReview|Rating|
|Behrang Eini|I'm a big fan of the Canon product line, the EOS 5D camera takes it to a whole new level!|good|
And User clicks on continue button
Then User should see a message with "Thank you for your review. It has been submitted to the webmaster for approval."
