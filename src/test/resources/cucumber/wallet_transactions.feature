Feature: View wallet details and transactions

  Scenario Outline: Validate wallet details

    Given The following wallet exists: wallet name <wallet name>, bank balance <balance>, currency <currency> and transaction amount <wallet amount>
    When User selects wallet <wallet name> with balance <wallet amount>
    Then User can verify <wallet name>
    And  User can validate <wallet balance>
    And  User can see the balance status

    Examples:
      | wallet name | balance | currency | wallet amount | wallet balance |
      | Iryna       | 6000    | USD      | 100           |1000|
