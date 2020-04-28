package com.estafet.blockchain;


import com.estafet.blockchain.demo.data.lib.bank.Account;
import com.estafet.blockchain.demo.data.lib.exchangerate.ExchangeRate;
import com.estafet.blockchain.demo.data.lib.wallet.Wallet;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;


public class BankTransferSteps {
    String walletAddress;
    Account account;
    String  accountId;

    @Given("The rate for (.+) is (.+)")
    public void setExchangeRate(String currency, Integer rate) {
        Account.deleteAccounts();
        ExchangeRate.setExchangeRate(currency, rate);
    }

    @Given("The following account exists:")
    public void createWallet(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        Account account = Account.createAccount(list.get(0).get("account name"), list.get(0).get("currency"));
        accountId = account.getId();
        Account.creditAccount(account, Double.parseDouble(list.get(0).get("account balance")), true);
        //Thread.sleep(30000);
        walletAddress = account.getWalletAddress();
    }

    @When("A transfer is submitted to wallet for (.+)$")
    public void submitBankTransfer(BigInteger arg1) throws InterruptedException {
        Wallet.banktoWalletTransfer(walletAddress, arg1, true);
       // Thread.sleep(60000);
    }

    @Then("^The account balance gets updated to (.+)$")
    public void newAccountBalance(Double balance) throws InterruptedException {
    	System.out.println("Mike: Waiting 50 seconds");
    	Thread.sleep(50000);
        Double accountBalance = Account.getAccount(accountId).getBalance(accountId);
        Assert.assertEquals(balance, accountBalance);
    }

    @Then("^The transaction in the account gets (.+)$")
    public void validateTransaction(String transactionStatus) {
        String status = Account.getLastTransaction(accountId).getStatus();
        Assert.assertEquals(transactionStatus, status);
    }

    @Then("The wallet is updated with its balance now (.+)$")
    public void transactionState(int balance) {
        int walletBalance = Wallet.getWallet(walletAddress).getBalance();
        Assert.assertEquals(balance, walletBalance);
    }
}



