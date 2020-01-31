Feature: Bank transactions and details

  Background: List accounts
    Given This bank account exist:
      | account name      | currency |
      | Dennis Williams | USD    |
    And The account has the following transactions:
      | transaction | amount |
      | credit    | 1000   |
      | debit     | 200    |
      | debit     | 300    |
  Scenario: Validate account name
    Then The account balance is 1000
    #Then The account status will be CLEARED



