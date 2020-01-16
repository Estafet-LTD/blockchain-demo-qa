package com.estafet.blockchain;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewBankTransactionsSteps {
    @Given("This bank account exist:")
    public void setupAccount(io.cucumber.datatable.DataTable dataTable) {

    }

    @Given("The account has the following transactions:")
    public void setupTransactions(io.cucumber.datatable.DataTable dataTable) {

    }

    @When("The user selects the account {string}")
    public void selectAccount(String string) {

    }

    @Then("The account balance is {string}")
    public void verifyAccountBalance(String string) {

    }

    @Then("The account status will be {string}")
    public void verifyAccountStatus(String string) {

    }

    @Then("User can see the list of transactions")
    public void verifyTransactionsList() {

    }
}
