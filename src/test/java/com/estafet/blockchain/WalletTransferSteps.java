package com.estafet.blockchain;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WalletTransferSteps {
    @Given("The following wallets exist:")
    public void the_following_wallets_exist(io.cucumber.datatable.DataTable dataTable) {

    }

    @When("{string} submits a transfer for {string} to {string}")
    public void submits_a_transfer_for_to(String string, String string2, String string3) {

    }

    @Then("After the wallet {string} is updated with its balance now equals {string}")
    public void after_the_wallet_is_updated_with_its_balance_now_equals(String string, String string2) {

    }

    @Then("{string} balance is now {string}")
    public void balance_is_now(String string, String string2) {

    }

}
