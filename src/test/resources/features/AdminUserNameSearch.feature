Feature: User Name Search
Background:
Given I launch application
@smoke @regression
  Scenario Outline: Search the user name
    Given I enter the username as "<username>"
    Then I enter the password as "<password>"
    And I click on login button
    And I check the login is valid
    Then I navigate to admins page
    And I search username as "<searchusername>"

    Examples: 
      | username | password | searchusername |
      | Admin    | admin123 | admin          |
