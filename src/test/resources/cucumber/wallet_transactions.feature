Feature: View wallet details and transactions

  Background: List wallets
    Given The following wallets exist: <wallet name>, balance and <balance status>
      | wallet name        | balance | balance status |
      | "Dennis Williams"  | 50      | "CLEARED"      |
      | "Iryna Mihlyuzova" | 60      | "CLEARED"      |
      | "Michael Ruse"     | 70      | "PENDING"      |
    When User selects "Iryna Mihlyuzova" from the list

  Scenario: Validate wallet details
    Then User can see the wallet name
    And  User can see the wallet balance
    And  User can see the balance status



