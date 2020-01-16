package com.estafet.blockchain;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BankTransferSteps {
    @Given("The following wallet exist:")
    public void createWallet(io.cucumber.datatable.DataTable dataTable) {

    }

    @Given("The following bank account exists:")
    public void createAccounts(io.cucumber.datatable.DataTable dataTable) {

    }

    @Given("The rate for {string} is {int}")
    public void setExchangeRate(String string, Integer int1) {

    }

    @When("{string} submits a transfer for {int} to wallet {string}")
    public void submitBankTransfer(String string, Integer int1, String string2) {

    }

    @Then("The transaction is in {string} state")
    public void transactionState(String string) {

    }

    @Then("After a while the wallet {string} is updated with its balance now {int}")
    public void balanceUpdate(String string, Integer int1) {

    }

    @Then("The transaction in the {string} account gets {string}")
    public void clearTransaction(String string, String string2) {

    }

    @Then("The account balance of {string} is now {int}")
    public void newAccountBalance(String string, Integer int1) {

    }

}

