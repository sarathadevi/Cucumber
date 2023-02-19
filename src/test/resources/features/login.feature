Feature:  Login

Background:
Given I launch application

@smoke @sanity @login
Scenario Outline: Login to Application Success


Given I enter the username as "<username>"
Then I enter the password as "<password>"
And I click on login button
And I check the login is valid

Examples:
|username | password |
|Admin | admin123 |

@login
Scenario Outline: Login to Application Not Success

Given I enter the username as "<username>"
Then I enter the password as "<password>"
And I click on login button
And I check the login is invalid

Examples:
|username | password |
|Admina | admin123a |




