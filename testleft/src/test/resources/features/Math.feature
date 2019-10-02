#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Operations (Más,Menos,Dividido_por,Multiplicar_por,Es_igual_a)
#Numbers (Uno, Dos, Tres, Cuatro, Cinco

@tag
Feature: using calculator for basic operations
  As a windows user
  I want to be able to sum 2 numbers
  using the windows calculator app

  @SmokeTest
  Scenario: Sum
    Given the windows calculator app
    When click on Numeric button Uno
    And click on Operation button Menos
    And click on Numeric button Siete
    And click on Operation button Es_igual_a
    Then print the result on the calculator
    Then I open application in Chrome browser



  
