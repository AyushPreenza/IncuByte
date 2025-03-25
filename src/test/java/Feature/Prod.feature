Feature: Prod Test cases

  @prod
  Scenario: Verify Parental control
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    And I click on User icon
    Then verify Parental control is present

  @prod
  Scenario: verify Ott Subscribed channel rail
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then I click on "Premium"
    Then verify Ott channels rail

  @prod
  Scenario: Verify Live News, Sports, Entertainment channels, Live Music, Regional, Spiritual on Live Tv
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then I click on "Live TV"
    And Verify Live News, Sports, Entertainment channels, Live Music, Regional, Spiritual on Live Tv

  @prod
  Scenario: Verify Live TV Tamil and Telugu
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    And enter "Tamil" in search box
    Then click on searchPage "Live TV"
    And Verify Live TV Tamil and Telugu

  @prod
  Scenario: Setting page should be checked
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then click on profile Icon
    And verify Settings are present