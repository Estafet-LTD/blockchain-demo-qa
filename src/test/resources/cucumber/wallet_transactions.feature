Feature: View wallet details and transactions

  Scenario Outline: Validate wallet details

    Given The following wallet exists: wallet name <wallet name> and balance <balance>
    When User selects wallet <wallet name>
    Then User can verify <wallet name>
    And  User can validate  <balance>
    And  User can see the balance status

    Examples:
      | wallet name      | balance |
      | Iryna Mihlyuzova | 60      |


