package com.estafet.blockchain;


import com.estafet.blockchain.demo.data.lib.bank.Account;
import com.estafet.blockchain.demo.data.lib.exchangerate.ExchangeRate;
import com.estafet.blockchain.demo.data.lib.wallet.Wallet;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.math.BigInteger;

public class ViewWalletTransactionsSteps {

    String walletName;
    int  walletBalance;
    String walletStatus;
    String walletAddress;

    @Given("^The following wallet exists: wallet name (.+), bank balance (.+), currency (.+) and transaction amount (.+)$")
    public void walletSetup(String name, Double arg1, String currency, BigInteger arg2) throws InterruptedException {
        Account.deleteAccounts();
        ExchangeRate.setExchangeRate(currency, 10);
        Account.createAccount(name, currency);
        Account account = Account.getAccountByName(name);
        Account.creditAccount(account, arg1, true);
        walletAddress = account.getWalletAddress();
        System.out.println(walletAddress);
        Wallet.banktoWalletTransfer(walletAddress, arg2, false);
       Thread.sleep(30000);
    }

    @When("^User selects wallet (.+) with balance (.+)$")
    public void selectWallet(String name, BigInteger arg1) {
        walletName = Wallet.getWallet(walletAddress).getWalletName();
        walletBalance = Wallet.getWallet(walletAddress).getBalance();
        walletStatus = Wallet.getWallet(walletAddress).getStatus();
}

        @Then("User can verify (.+)")
        public void verifyWalletName (String string) {
            Assert.assertTrue(walletName.equals(string));
        }

        @Then("User can validate (.+)")
        public void verifyWalletBalance (Integer arg1) {
        Assert.assertTrue(arg1.equals(walletBalance));

        }

        @Then("User can see the balance status")
        public void verifyBalanceStatus () {
        Assert.assertTrue(walletStatus.equals("CLEARED"));
            System.out.println(walletStatus);
        }



    }
