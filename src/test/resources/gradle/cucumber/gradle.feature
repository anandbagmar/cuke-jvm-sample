Feature: Gradle-Cucumber integration

  Scenario: Just a passing scenario
    Given I run a passing step

  Scenario: Just a failing scenario
    When I run a failing step

  Scenario: A passing and failing scenario
    Given I run a passing step
    When I run a failing step
