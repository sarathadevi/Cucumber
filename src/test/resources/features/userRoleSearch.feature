Feature: User Role Search
Background:
Given I launch application
@sanity @smoke
  Scenario Outline: Search the user role
    Given I enter the username as "<username>"
    Then I enter the password as "<password>"
    And I click on login button
    And I check the login is valid
    Then I navigate to admins page
    And I search userrole as "<userrole>"

    Examples: 
      | username | password | userrole |
      | Admin    | admin123 | Admin      |
