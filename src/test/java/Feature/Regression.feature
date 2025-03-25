Feature: Regression test cases

  @Reg
  Scenario:  Login with password
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    And verify user is logged in

  @Reg
  Scenario: Login/Logout
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    And I click on User icon
    And verify user able to logout

  @Reg
  Scenario: Check all pages are opening in header and bottom
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then I click on "Live TV"
    Then I click on "Premium"
    Then I click on "Streaming Now"
    Then I click on "News"
    Then I click on "Reviews"
    Then I click on "Web Stories"
    Then I click on "Photos"
    Then I click on "More"

  @Reg
  Scenario: Check homepage and premium page till end , no widget missing issue and loading issue should be there
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    And I click on "Premium"
    And scroll to bottom of page
    Then verify no loader issue

  @Reg
  Scenario: Check filter on streaming now page>>more filter
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    And I click on "Streaming Now"
    Then verify streaming now filters

  @Reg
  Scenario: Verify no duplicate content is displaying on home and premium page
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    And I click on "Premium"
    Then scroll to bottom of page
    And verify no duplicate widgets

  @Reg
  Scenario: play a  movie
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    And I click on User icon
    Then click on "hallmarkmoviesnow" vendor
    Then select first show
    And Play show
    Then verify whether the episode is playing or not

  @Reg
  Scenario: Play live show on fancode provider
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    And I click on User icon
    Then click on "fan-61" vendor
    Then click live show
    And Play show
    Then verify whether the episode is playing or not

  @Reg
  Scenario: Check login with all social media redirection is working
    Given I navigate to application
    When I click on Sign In button
    Then click sign in with "Google"
    And verify redirected to "Google"
    Then click sign in with "Apple"
    And verify redirected to "Apple"
    Then click sign in with "Facebook"
    Then verify redirected to "Facebook"

  @Reg
  Scenario: Verify free content is played with unsubscribed user
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password    |
      | 8652259082 | Neosoft@123 |
    And enter "Expose" in search box
#    Then click on see all result
    Then select first show after search
    And Play show
    Then verify whether the episode is playing or not

  @Reg
  Scenario: Verify free content is played with subscribed user
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password    |
      | 9628750203 | Ottplay@123 |
    And enter "Expose" in search box
#    Then click on see all result
    Then select first show after search
    And Play show
    Then verify whether the episode is playing or not

  @Reg
  Scenario: Verify ads for unsubscribed users on all pages in web
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password    |
      | 8652259082 | Neosoft@123 |
#      And I click on "Home"
    Then I click on "Premium"
    And I click on "Home"
    And scroll to bottom of page
    And verify ads are displaying

  @Reg
  Scenario: Verify on home page widgets are opening like in photos
    Given I navigate to application
    Then I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then click see all in photos widgets and verify
    And I click on "Home"
    Then click on content if it opens



