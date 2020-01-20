Feature: Currency Converter
  This is to test the exchange rates functionality

  Background: Exchange rates
    Given The following exchange rates exist: <currency> and <rate>
      | currency | rate |
      | "USD"    | 200  |
      | "GBP"    | 250  |
      | "CAD"    | 300  |

  Scenario: Create new exchange rates
    When New exchange rate is created with currency <currency> and rate <rate>
      | currency | rate |
      | "BGN"    | 150  |
    Then The new exchange rate is added to the existing list:
      | currency | rate |
      | "USD"    | 200  |
      | "GBP"    | 250  |
      | "CAD"    | 300  |
      | "BGN"    | 150  |

  Scenario: Update existing exchange rate
    When The user updates the rate for "GBP" to <rate>
      | rate |
      | 280  |
    Then The rate will be successfully updated

  Scenario: View exchange rate details
    When The user loads the home page
    And Clicks on the the exchange rates link
    And User selects "USD" from the currencies list
    Then They can view the exchange rate details:
      | currency | rate |
      | "USD"    | 200  |

  Scenario: List all rates
    When The user loads the home page
    And Clicks on the the exchange rates link
    Then They will see the list will all rates existing:
      | currency | rate |
      | "USD"    | 200  |
      | "GBP"    | 250  |
      | "CAD"    | 300  |
