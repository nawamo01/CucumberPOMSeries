Feature: Log in page feature

Scenario: Login page title
Given user is on login page
When user gets the title of the page
Then page title should be "Login - My Store"

Scenario: Forgot Password Link
Given user is on login page
Then forgot your password link should be displayed

Scenario: Login with correct credentials 
Given user is on login page
When user enters the username "dec2020secondbatch@gmail.com"
And user enters the passowrd "Selenium@12345"
And user clicks on login button
When user gets the title of the page
And page title should be "My account - My Store"