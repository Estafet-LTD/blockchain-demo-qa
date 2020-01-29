Feature: Execute wallet to wallet transfer
  This is to test the wallet to wallet transfer process

  Scenario: Processing valid transaction from wallet to wallet
    Given A sender wallet exists with name Michael Ruse, balance of 100, bank currency USD and bank balance of 1000
#      | wallet name  | balance | bank currency | bank balance |
#      | Michael Ruse | 100     | USD           | 1000         |
    And A receiver wallet exists with name Dennis Williams, balance of 100, bank currency USD and bank balance of 2000
#      | wallet name     | balance | bank currency | bank balance |
#      | Dennis Williams | 100     | GBP           | 2000         |

    When Michael Ruse submits a transfer for 50 to client Dennis Williams
    Then After the wallet Michale Ruse is updated with its balance now equals 50
    And Dennis Williams balance is now 150
