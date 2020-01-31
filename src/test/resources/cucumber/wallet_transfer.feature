Feature: Execute wallet to wallet transfer
  This is to test the wallet to wallet transfer process

  Scenario Outline: Processing valid transaction from wallet to wallet
    Given A sender account and wallet exist with name <sender name>, bank currency <sender currency> and bank balance of <sender bank balance>
    Given A receiver account and wallet exist with name <receiver name>, bank currency <receiver currency> and bank balance of <receiver bank balance>
    When The sender submits a transfer for 50 to the receiver
    Then Sender's wallet is updated with its balance now equals 950
    And The receiver's balance is now 1050

    Examples:
      | sender name   | sender currency | sender bank balance | receiver name   | receiver currency | receiver bank balance |
      | Desi Hristova | USD             | 1000                | Shukri Shukriev | USD               | 2000                  |
