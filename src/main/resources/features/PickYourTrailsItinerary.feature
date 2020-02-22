@Chrome @pytNavBarFunctionalities
Feature: Test Pick Your Trail  Gudies page

  Background: 
    Given I launch the PIckYourTrails homePage

  @pytGuides
  Scenario: I check the Guides for various destinations
    Given I click on the Guides button on the navigation bar at the top And click on the destination image in the Guide page
    When I click on the Planning tab image in the header And navigate to the Planning setion
    Then I must verify 'Best time to go'  And select 'Read more'
  
