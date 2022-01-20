Feature: Application Login

  Scenario: Positive test validating login
    Given Initialize the browser with chrome
    And Navigate to "" site
    And Click on Login link in home page to land on Secure sign in page
    When User enters "test99@gmail.com" and "testing0000" and logs in
    Then Verify that user is successfully logged in
