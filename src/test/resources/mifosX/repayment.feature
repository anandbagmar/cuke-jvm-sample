Feature: MifosX Repayment Feature

  @mifosx @browser
  Scenario: Regular repayment and loan closed (12357-10)
    Given I create a new client "Tania", "Biyani"
    And I activate the client today
    When I add "Bi-Weekly Loan" as a new loan application
    Then the loan is added and in "Pending" state
