package com.estafet.blockchain;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ViewBankTransactionsSteps {
    @Given("This bank account exist:")
    public void setupAccount(DataTable dataTable) {

    }

    @Given("The account has the following transactions:")
    public void setupTransactions(DataTable dataTable) {

    }

    @When("The user selects the account (.+)")
    public void selectAccount(String string) {

    }

    @Then("The account balance is (.+)")
    public void verifyAccountBalance(String string) {

    }

    @Then("The account status will be (.+)")
    public void verifyAccountStatus(String string) {

    }

    @Then("User can see the list of transactions")
    public void verifyTransactionsList() {

    }
}
