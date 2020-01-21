package com.estafet.blockchain;


import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WalletTransferSteps {
    @Given("The following wallets exist:")
    public void setupWallets(DataTable dataTable) {

    }

    @When("{string} submits a transfer for {string} to {string}")
    public void submitTransfer(String string, String string2, String string3) {

    }

    @Then("After the wallet {string} is updated with its balance now equals {string}")
    public void verifySenderBalance(String string, String string2) {

    }

    @Then("{string} balance is now {string}")
    public void verifyReceiverBalance(String string, String string2) {

    }

}
