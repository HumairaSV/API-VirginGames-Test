Feature: Test assignment

  Scenario: I want to test the data accuracy of the virgin games bingo api
    Given   I am on the Virgin games bingo api
    When    I send Get request to the Lobby feed endpoint
    Then    I must get back a valid status code "200"
    And     I verify that the database has stream name "Voyage" in streams at index 1