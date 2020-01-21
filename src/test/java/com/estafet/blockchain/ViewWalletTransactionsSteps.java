package com.estafet.blockchain;


import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ViewWalletTransactionsSteps {
    @Given("^The following wallets exist: <wallet name>, balance and <balance status>$")
    public void setupWallets(DataTable dataTable) {

    }

    @When("User selects (.+) from the list")
    public void selectWallet(String string) {

    }

    @Then("User can see the wallet name")
    public void verifyWalletName() {

    }

    @Then("User can see the wallet balance")
    public void verifyWalletBalance() {

    }

    @Then("User can see the balance status")
    public void verifyBalanceStatus() {

    }
}
