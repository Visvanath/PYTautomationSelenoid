@Chrome @pickyourtrailHome
Feature: Test Pick Your Trail homepage and various functionalities

  Background: 
    Given I launch the PIckYourTrails homePage

  @pytStartPlanning
  Scenario: I check the Create Itinerary and verify the typeahead results
    Given I enter text in 'Create Itinerary text box' in homepage
    When I select one of the options listed below
    Then the list of available dates with the heading 'when do you want to explore?' must be shown
    
