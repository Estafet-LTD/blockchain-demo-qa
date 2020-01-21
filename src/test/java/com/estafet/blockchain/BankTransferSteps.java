package com.estafet.blockchain;


import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class BankTransferSteps {
    @Given("The following wallet exist:")
    public void createWallet(DataTable dataTable) {

    }

    @Given("The following bank account exists:")
    public void createAccounts(DataTable dataTable) {

    }

    @Given("The rate for (.+) is (.+)")
    public void setExchangeRate(String string, Integer int1) {

    }

    @When("(.+) submits a transfer for (.+) to wallet (.+)")
    public void submitBankTransfer(String string, Integer int1, String string2) {

    }

    @Then("The transaction is in (.+) state")
    public void transactionState(String string) {

    }

    @Then("After a while the wallet (.+) is updated with its balance now (.+)")
    public void balanceUpdate(String string, Integer int1) {

    }

    @Then("The transaction in the (.+) account gets (.+)")
    public void clearTransaction(String string, String string2) {

    }

    @Then("The account balance of (.+) is now (.+)")
    public void newAccountBalance(String string, Integer int1) {

    }

}

