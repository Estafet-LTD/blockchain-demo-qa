package com.estafet.blockchain;


import com.estafet.blockchain.demo.data.lib.exchangerate.ExchangeRate;
import com.estafet.blockchain.demo.data.lib.wallet.Wallet;
import com.estafet.blockchain.demo.data.lib.bank.Account;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.math.BigInteger;

public class WalletTransferSteps {
    String senderWalletAddress;
    String receiverWalletAddress;

//    @Before
//    public void before() {
//        Account.deleteAccounts();
//        System.out.println("TEST!");
//    }

//    @After
//    public void After() {
//        Account.deleteAccounts();
//    }
@Given("^A sender account and wallet exist with name (.+), bank currency (.+) and bank balance of (.+)$")
public void setupSenderWallet(String name, String currency, Double bankBalance) throws InterruptedException {
    Account.deleteAccounts();
    ExchangeRate.setExchangeRate("USD", 10);
    Account.createAccount(name, currency);
    Account account = Account.getAccountByName(name);
    senderWalletAddress = account.getWalletAddress();
    Account.creditAccount(account, bankBalance, true);
    System.out.println(senderWalletAddress);
    Wallet.banktoWalletTransfer(senderWalletAddress, BigInteger.valueOf(100), true);
   //Thread.sleep(30000);

}

    @Given("^A receiver account and wallet exist with name (.+), bank currency (.+) and bank balance of (.+)$")
    public void setupReceiverWallet(String name, String currency, Double bankBalance) throws InterruptedException {
    Account.createAccount(name, currency);
    Account account = Account.getAccountByName(name);
    receiverWalletAddress = account.getWalletAddress();
    Account.creditAccount(account, bankBalance, true);
    System.out.println(receiverWalletAddress);
    Wallet.banktoWalletTransfer(receiverWalletAddress, BigInteger.valueOf(100), true);
    //Thread.sleep(30000);
    }

    @When("The sender submits a transfer for (.+) to the receiver")
    public void submitTransfer(BigInteger arg1) {
      Wallet.wallettoWalletTransfer(senderWalletAddress, receiverWalletAddress, arg1, true);
      //Thread.sleep(30000);

    }

    @Then("Sender's wallet is updated with its balance now equals (.+)")
    public void verifySenderBalance(int arg1) {
        Integer senderWalletBalance = Wallet.getWallet(senderWalletAddress).getBalance();
        Assert.assertTrue(senderWalletBalance.equals(arg1));
        System.out.println(senderWalletBalance);
    }

    @Then("The receiver's balance is now (.+)")
    public void verifyReceiverBalance(int arg1) {
        Integer receiverWalletBalance = Wallet.getWallet(receiverWalletAddress).getBalance();
        Assert.assertTrue(receiverWalletBalance.equals(arg1));
        System.out.println(receiverWalletBalance);

    }

}
