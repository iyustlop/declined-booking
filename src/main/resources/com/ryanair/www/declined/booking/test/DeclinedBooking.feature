Feature: Declined Booking
  As a user I want to book a flight up to decline the payment.

  Scenario: Add two numbers
    Given having "Mallorca" as destination
    And having "14/08/2017" as holiday start date
    And having "21/08/2017" as holiday finish date
    And having "xxxxx" as credit card
    When I introduce the destination and dates
    And I add a passanger
    And I select a outbound flight 
    And I select a return flight
    And I select two seats
    Then decline the payment