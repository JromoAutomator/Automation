#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.

@tag
Feature: using calculator for basic operations
  As a windows user
  I want to be able to sum 2 numbers
  using the windows calculator app

  @SmokeTest
  Scenario: Sum
    Given the windows calculator app
    When I click on number 5
    And click on SUM button
    And click on number 7
    And click on = button
    Then the value on the calculator shows 12


  
