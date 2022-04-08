Feature: Purchase Class CS PO
  Scenario: Search for Class and Add to Cart PO
    Given I access Iterasys website PO
    When I search for "CTFL" and click on search button PO
    Then I see the search results for "CTFL" PO
    When I click on class name PO
    Then I confirm the Class' name as "Exame da CTFL-AT - ISTQB" and it's price as "R$ 104,17" PO