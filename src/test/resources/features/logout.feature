Feature:  Logout
Background:
Given I launch application
@smoke @sanity
Scenario Outline: Logout from Application 

Given I enter the username as "<username>"
Then I enter the password as "<password>"
And I click on login button
And I check the login is valid
Then I logout from application

Examples:
|username | password |
|Admin | admin123 |