Feature: In Order to travel to a place in Pune by car
         As a commuter
         I want to calculate the distance to my destination

  @sikuli
  Scenario: View distance between two places
    Given I am on google maps home page
    When I search for "Pune, Maharashtra, India" on map
    And I locate Camp and get direction
    Then I should see that Camp is "4.4 km" from Pune