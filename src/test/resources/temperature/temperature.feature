Feature: Temperature convert using web service

  Scenario: Temperature convert from Celsius To Fahrenheit
    When I convert "14" degree Fahrenheit to Celsius
    Then I should get result as "-10"