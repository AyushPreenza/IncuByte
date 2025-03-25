Feature: Incubyte assignment

  @Incubyte
  Scenario: Create new user and login again with same user
    Given I navigate to application
    Then I click on create account
    And Enter first name "Ayush" and last name "Preenza"
    Then I Enter email
    And I Enter password
    Then click Create and Account confirm button
    And I confirm Log in
    Then I sign out from account
    When I click on Sign In button
    And I enter email and password
    Then click Sign in
    And I confirm Log in



