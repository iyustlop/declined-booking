Feature: Calculator
  As a user
  I want to use a calculator
  So that I don't need to calculate myself

  Scenario: Add two numbers
    Given having "Mallorca" as destination
    And having "15-08-2017" as holiday start date
    And having "31-08-2017" as holiday finish date
    And having "xxxxx" as credit card
    When I connect to the url
    And I introduce the destination and dates
    Then the result should be 5