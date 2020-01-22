Feature: Execute bank to wallet transfer
  This is to test the bank to wallet transfer process

  Scenario: Processing valid transaction from bank to wallet
    Given The following wallet exist:
      | balance | balance status | wallet name    |
      | 100     | "CLEARED"      | "Michael Ruse" |
    And The following bank account exists:
      | account name       | account balance | currency |
      | "Iryna Mihlyuzova" | 1000            | "GBP"    |
    And The rate for "GBP" is 250
    When "Iryna Mihlyuzova" submits a transfer for 500 to wallet "Michael Ruse"
    Then The transaction is in "PENDING" state
    And After a while the wallet "Michael Ruse" is updated with its balance now 102
    And The transaction in the "Irina Mihlyuzova" account gets "CLEARED"
    And The account balance of "Irina Mihlyuzova" is now 500

