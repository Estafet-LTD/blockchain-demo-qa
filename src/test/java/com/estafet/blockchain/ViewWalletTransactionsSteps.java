package com.estafet.blockchain;


import com.estafet.blockchain.demo.data.lib.bank.Account;
import com.estafet.blockchain.demo.data.lib.wallet.Wallet;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Da;
import org.junit.Assert;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public class ViewWalletTransactionsSteps {

    String walletName;
    int  walletBalance;
    String walletStatus;

    @Given("^The following wallet exists: wallet name (.+) and balance (.+)$")
    public void walletSetup(String string, int arg1) throws Throwable {
        Wallet.createCreditedWallet(string, BigInteger.valueOf(arg1));
    }

    @When("^User selects wallet (.+)$")
    public void selectWallet(String string) {
        String walletAddress = Account.getAccountByName(string).getWalletAddress();
        System.out.println(walletAddress);
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
        Assert.assertSame(walletBalance,arg1);

        }

        @Then("User can see the balance status")
        public void verifyBalanceStatus () {
        Assert.assertTrue(walletStatus.equals("CLEARED"));
        }


    }
