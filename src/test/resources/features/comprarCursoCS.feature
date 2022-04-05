Feature: Purchase Class CS
  Scenario: Search for Class and Add to Cart
    Given I access Iterasys website
    When I search for "CTFL" and click on search button
    Then I see the search results for "CTFL"
    When I click on class name
    Then I confirm the Class' name as "Exame da CTFL-AT - ISTQB" and it's price as "R$ 104,17"