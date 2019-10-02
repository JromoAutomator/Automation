#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.

@tag
Feature: Google Search
  As a web User i want to be able to perform a search on google page
  and retrive the first URL's result

  @RegressionTest
  Scenario: Google Search
    Given I open application in Chrome browser 
    When I navigate to URL https://www.google.com/
    And search for TestComplete keyword
    Then i click on images tab
    Then i Close the browser


