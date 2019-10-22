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
@Web
Feature: Login
  Verify tenants can be added, read, updated and deleted
  
  
@Web @HTC-3668454 @RegressionTest
  Scenario: Login 3
	Given user is on sitelink login page
	When user enters login info and presses submit
	Then success message is displayed
	
@Web @HTC-3668455 @SmokeTest
Scenario: Login 4
	Given user is on sitelink login page
	When user enters login info and presses submit
	Then success message is displayed
	Given user navigates to the Tenants page
	When User expands the tab and clicks Add 
	And User enters tenant details
	Then Tenant is added to the Tenant grid