package com.estafet.blockchain;

import com.estafet.blockchain.demo.data.lib.wallet.Wallet;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.estafet.blockchain.demo.data.lib.bank.Account;
import org.junit.Assert;

public class NewAccountSteps {
    String newAccountId;
    String walletAddress;

    @When("I submit name (.+), amount (.+) and currency in use (.+)")
    public void submitAccountData(String string, Double arg1, String string2) {
        newAccountId = Account.createCreditedAccount(string, string2, arg1).getId();
    }

    @Then("New bank account is created with account name (.+)")
    public void verifyNewAccount(String string) {
        String accountName = Account.getAccount(newAccountId).getAccountName();
        Assert.assertTrue(accountName.equals(string));
    }

    @Then("The starting balance is matching (.+)")
    public void veirfyStratingBalance(Double arg1) {
        Double accountBalance = Account.getAccount(newAccountId).getBalance(newAccountId);
        Assert.assertTrue(accountBalance.equals(arg1));

    }

    @Then("The currency matches (.+)")
    public void verifyCurrency(String string) {
        String accountCurrency = Account.getAccount(newAccountId).getCurrency();
        Assert.assertTrue(accountCurrency.equals(string));

    }

    @Then("Navigating from the bank account the user can go to the new wallet")
    public void loadNewWallet() {
    walletAddress = Account.getAccount(newAccountId).getWalletAddress();
    Assert.assertNotNull(walletAddress);
    }

    @Then("The wallet name matches the bank account name (.+)")
    public void verifyWalletName(String string) {
        String walletName = Wallet.getWallet(walletAddress).getWalletName();
        Assert.assertTrue(walletName.equals(string));

    }

    @Then("The wallet balance is (.+)")
    public void verifyWalletBalance(Integer arg1) {
        int walletBalance = Wallet.getWallet(walletAddress).getBalance();
        Assert.assertSame(walletBalance, arg1);
    }
}
