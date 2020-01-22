Feature: Execute wallet to wallet transfer
  This is to test the wallet to wallet transfer process

  Scenario: Processing valid transaction from wallet to wallet
    Given The following wallets exist:
      | wallet name     | balance |
      | Michael Ruse    | 100     |
      | Dennis Williams | 100     |
    When Michael Ruse submits a transfer for 50 to client Dennis Williams
    Then After the wallet Michale Ruse is updated with its balance now equals 50
    And Dennis Williams balance is now 150
