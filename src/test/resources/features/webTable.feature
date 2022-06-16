Feature: User should be able to login using valid credentials


  Background: user is on the login page
    Given user is on the login page of web table app


  Scenario: Positive login scenario
    When user enters username "Test"
    And user enters password "Tester"
    And user clicks the login button
    Then user should see url contains "orders"


  Scenario: Positive login scenario
    When user enters username "Test" password "Tester" and logins
    Then user should see url contains "orders"


  Scenario: Positive login scenario
    When user enters username and password and logins
    Then user should see url contains "orders"


  Scenario: Positive login scenario
    When user enters below credentials
      | username | Test   |
      | password | Tester |
    Then user should see url contains "orders"







