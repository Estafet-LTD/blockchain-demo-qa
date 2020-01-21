package com.estafet.blockchain;


import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WalletTransferSteps {
    @Given("^The following wallets exist:$")
    public void setupWallets(DataTable dataTable) {

    }

    @When("(.+) submits a transfer for (.+) to client (.+)")
    public void submitTransfer(String string, String string2, String string3) {

    }

    @Then("After the wallet (.+) is updated with its balance now equals (.+)")
    public void verifySenderBalance(String string, String string2) {

    }

    @Then("(.+) balance is now (.+)")
    public void verifyReceiverBalance(String string, String string2) {

    }

}
