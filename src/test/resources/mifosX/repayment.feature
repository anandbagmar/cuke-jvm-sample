Feature: MifosX Repayment Feature

  @mifosx @browser
  Scenario: Regular repayment and loan closed (12357-10)
    Given I create a new client "Tania", "Biyani"
    When I add a new loan application
    Then the loan is added and in "Pending" state
