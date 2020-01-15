Feature: Create new bank account
  This is to test the new account and wallet creation feature

  Scenario Outline: Create new account and wallet
    When I submit name <account name>, amount <starting deposit> and currency in use <currency>
    Then New bank account is created
    And The starting balance is matching <starting deposit>
    And The currency matches <currency>
    And Navigating from the bank account the user can go to the new wallet
    And The wallet name matches the bank account name <account name>
    And The wallet balance is 0

    Examples:
      | account name       | starting deposit | currency |
      | "Dennis Williams"  | 5000             | "USD"    |
      | "Iryna Mihlyuzova" | 7000             | "GBP"    |
      | "Michael Ruse"     | 9000             | "CAD"    |
