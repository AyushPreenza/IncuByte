Feature: OTT Play Functionalities

  @Func
  Scenario: Verify Next Page
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then I click on "Premium"
    And Select "SonyLIV"
    And click on first See all
#    Then select first show
    And Play the show "Charlie Chopra & The Mystery Of Solang Valley"
    And Play show
    And Get the title of show
    Then click on next episode
    Then verify user is on next page

  @Func
  Scenario: Verify OTT Play Brand logo
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then I click on "Premium"
    And Select "SonyLIV"
    Then select first show
    And Play show
    And verify ott play brand logo

  @Func
  Scenario: Verify Seek bar
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then I click on "Premium"
    And Select "SonyLIV"
    Then select first show
    And Play show
    And verify seek bar


  @Func
  Scenario: Verify Back button
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then I click on "Premium"
    And Select "SonyLIV"
    Then select first show
    And Play show
    Then verify back button

  @Func
  Scenario: Verify Full screen
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then I click on "Premium"
    And Select "SonyLIV"
    Then select first show
    And Play show
    Then click on fullscreen
    And verify show is in full screen

  @Func
  Scenario: Verify Audio language menu in the show settings
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then I click on "Premium"
    And Select "SonyLIV"
    Then select first show
    And Play show
    Then verify whether the episode is playing or not
    Then Pause episode
    Then click on Language Option
    And verify Audio options are present

  @Func
  Scenario: Verify subtitles menu in the show settings
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then I click on "Premium"
    And Select "LIONSGATE PLAY"
    Then select first show
    And Play show
    Then verify whether the episode is playing or not
    Then Pause episode
    Then click on Language Option
    And verify subtitles options are present

  @Func
  Scenario: Verify shows playing on different vendors
    Given I navigate to application
    When I click on Sign In button
    And I enter username and password
      | username   | password     |
      | 9100381062 | Password@123 |
    Then I click on "Premium"
    And Select "LIONSGATE PLAY"
    Then select first show
    And Play show
    Then verify whether the episode is playing or not
    Then Pause episode
    Then click on show back button
    Then I click on "Premium"
    And Select "SonyLIV"
    Then select first show
    And Play show
    Then verify whether the episode is playing or not