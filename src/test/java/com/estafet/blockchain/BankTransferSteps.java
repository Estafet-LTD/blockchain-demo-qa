package com.estafet.blockchain;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BankTransferSteps {
    @Given("The following wallet exist:")
    public void the_following_wallet_exist(io.cucumber.datatable.DataTable dataTable) {

    }

    @Given("The following bank account exists:")
    public void the_following_bank_account_exists(io.cucumber.datatable.DataTable dataTable) {

    }

    @Given("The rate for {string} is {int}")
    public void the_rate_for_is(String string, Integer int1) {

    }

    @When("{string} submits a transfer for {int} to wallet {string}")
    public void submits_a_transfer_for_to_wallet(String string, Integer int1, String string2) {

    }

    @Then("The transaction is in {string} state")
    public void the_transaction_is_in_state(String string) {

    }

    @Then("After a while the wallet {string} is updated with its balance now {int}")
    public void after_a_while_the_wallet_is_updated_with_its_balance_now(String string, Integer int1) {

    }

    @Then("The transaction in the {string} account gets {string}")
    public void the_transaction_in_the_account_gets(String string, String string2) {

    }

    @Then("The account balance of {string} is now {int}")
    public void the_account_balance_of_is_now(String string, Integer int1) {

    }

}

