Feature: Purchase Class CS
  Scenario: Search for Class and Add to Cart
    Given I access Iterasys website
    When I search for "CTFL" and click on search button
    Then I see the search results for "CTFL"
    When I click on class name
    Then I confirm the Class' name as "Exame da CTFL-AT - ISTQB" and it's price as "R$ 104,17"

  Scenario Outline: Search for Classes and Add to Cart
    Given I access Iterasys website
    When I search for <curso> and click on search button
    Then I see the search results for <curso>
    When I click on class name
    Then I confirm the Class' name as <curso> and it's price as <preco>
    Examples:
      | curso   | preco       |
      | "CTFL"  | "R$ 104,17" |
      | "Java"  | "R$ 24,83"  |


  Scenario: