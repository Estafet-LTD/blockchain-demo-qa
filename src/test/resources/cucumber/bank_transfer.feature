Feature: Execute bank to wallet transfer
  This is to test the bank to wallet transfer process

  Scenario: Processing valid transaction from bank to wallet
    Given The rate for USD is 10
    And The following account exists:
      | account name     | account balance | currency |
      | Iryna Mihlyuzova | 1000            | USD      |
    When A transfer is submitted to wallet for 100
    Then The account balance gets updated to 900
    And The transaction in the account gets CLEARED
    And The wallet is updated with its balance now 1000

