#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@SiteLinkWebEdition
Feature: Merchandise Purchase
  
@SiteLinkWebEdition
Scenario:  Walk-in POS Purchase of Merchandise
    Given SLWE is running and logged in as a valid user with sufficient privileges
    And the Operations screen is visible
    When I click Merchandise Purchase
    Then the Add Merchandise screen is visible
    And I click add to cart->OK
    And finish with cash payment
    
@SiteLinkWebEdition
    Scenario:  Walk-in POS Purchase with discount
    Given SLWE is running and logged in as a valid user with sufficient privileges
    And the Operations screen is visible
    When I click Merchandise Purchase
    Then the Add Merchandise screen is visible
    And I click add to cart
    And Set discount percent to 5% and apply using the checkbox
    And I click OK
    And finish with cash payment

 #Scenario:  Walk-in POS Setup
 #   Given SLWE is running and logged in as a valid user with sufficient privileges
 #   And the Operations screen is visible
 #   When I click Setup

 
  