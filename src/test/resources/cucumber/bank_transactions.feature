Feature: Bank transactions and details

  Background: List accounts
    Given This bank account exist:
      | account name      | currency |
      | "Dennis Williams" | "USD"    |
    And The account has the following transactions:
      | transaction | amount | status    |
      | "deposit"   | 1000   | "CLEARED" |
      | "debit"     | 200    | "CLEARED" |
      | "debit"     | 300    | "PENDING" |
    When The user selects the account "Dennis Williams"

  Scenario: Validate account name
    Then The account balance is "500"
    Then The account status will be "PENDING"

  Scenario: Validate account transactions
    Then User can see the list of transactions

