Feature: Google search feature

  Scenario: Search for cucumber-jvm related posts
    Given I am on the google search page
    When I search for "cucumber-jvm"
    Then I see a list of related posts
