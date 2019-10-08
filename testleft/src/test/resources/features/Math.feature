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
  Scenario: Math Operators
    Given the windows calculator app
    When click on Numeric button Uno
    And click on Operation button Menos
    And click on Numeric button Siete
    And click on Operation button Es_igual_a
    Then print the result on the calculator
 
    
 	@Outline
  Scenario Outline: Multuple Operators
  	Given the windows calculator app
    When click on Numeric button <number1>
    And click on Operation button <operator>
    And click on Numeric button <number2>
    And click on Operation button Es_igual_a
    Then print the result on the calculator


    Examples: 
      | number1  | operator           | number2  |
      | Cinco    |   Más              | Tres     |
      | Siete    |   Menos            | Dos      |
      | Ocho     |   Dividido_por     | Cuatro   |
      | Uno      |   Multiplicar_por  | Nueve    |
    




  
