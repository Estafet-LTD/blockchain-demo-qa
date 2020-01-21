Feature: Execute wallet to wallet transfer
  This is to test the wallet to wallet transfer process

  Scenario: Processing valid transaction from wallet to wallet
    Given The following wallets exist:
      | balance | balance status | wallet name    |
      | 100     | "CLEARED"      | "Michael Ruse" |
      | 100     | "CLEARED"      | "Dennis Williams" |
    When "Michael Ruse" submits a transfer for "50" to client "Dennis Williams"
    Then After the wallet "Michale Ruse" is updated with its balance now equals "50"
    And "Dennis Williams" balance is now "150"


