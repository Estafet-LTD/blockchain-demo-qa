package com.estafet.blockchain;


import com.estafet.blockchain.demo.data.lib.bank.Account;
import com.estafet.blockchain.demo.data.lib.exchangerate.ExchangeRate;
import com.estafet.blockchain.demo.data.lib.wallet.Wallet;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.eo.Do;
import org.junit.Assert;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;


public class BankTransferSteps {
    @Given("The following wallet exist:")
    public void createWallet(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        Wallet wallet = Wallet.createCreditedWallet(list.get(0).get("wallet name"), BigInteger.valueOf(Long.parseLong(list.get(0).get("balance"))));
        wallet.setWalletName(list.get(0).get("wallet name"));
        Assert.assertEquals(wallet.getStatus(),list.get(0).get("balance status"));
    }

    @Given("The following bank account exists:")
    public void createAccounts(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        Account.createCreditedAccount(list.get(0).get("account name"),list.get(0).get("currency"),Double.parseDouble(list.get(0).get("account balance")));
    }

    @Given("The rate for (.+) is (.+)")
    public void setExchangeRate(String currency, Integer rate) {
        ExchangeRate.setExchangeRate(currency,rate);
    }

    @When("(.+) submits a transfer for (.+) to wallet (.+)")
    public void submitBankTransfer(String from, Integer sum, String to)  throws Exception{
        Wallet.wallettoWalletTransfer(Account.getAccountByName(from).getWalletAddress(),Account.getAccountByName(to).getWalletAddress(),BigInteger.valueOf(sum),false);
        Thread.sleep(1000);
    }

    @Then("The transaction is in (.+) state")
    public void transactionState(String string) {

    }

    @Then("After a while the wallet (.+) is updated with its balance now (.+)")
    public void balanceUpdate(String name, Integer balance) {
        Assert.assertEquals(Wallet.getWallet(Account.getAccountByName(name).getWalletAddress()).getBalance(),(double)balance);
    }

    @Then("The transaction in the (.+) account gets (.+)")
    public void clearTransaction(String string, String string2) {

    }

    @Then("The account balance of (.+) is now (.+)")
    public void newAccountBalance(String name, Integer balance) {
        Assert.assertEquals(Wallet.getWallet(Account.getAccountByName(name).getWalletAddress()).getBalance(),(double)balance);
    }

}

