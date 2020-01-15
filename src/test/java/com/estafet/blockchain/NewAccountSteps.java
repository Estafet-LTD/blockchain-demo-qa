package com.estafet.blockchain;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewAccountSteps {
    @When("I submit name {string}, amount {int} and currency in use {string}")
    public void i_submit_name_amount_and_currency_in_use(String string, Integer int1, String string2) {

    }

    @Then("New bank account is created")
    public void new_bank_account_is_created() {

    }

    @Then("The starting balance is matching {int}")
    public void the_starting_balance_is_matching(Integer int1) {

    }

    @Then("The currency matches {string}")
    public void the_currency_matches(String string) {

    }

    @Then("Navigating from the bank account the user can go to the new wallet")
    public void navigating_from_the_bank_account_the_user_can_go_to_the_new_wallet() {

    }

    @Then("The wallet name matches the bank account name {string}")
    public void the_wallet_name_matches_the_bank_account_name(String string) {

    }

    @Then("The wallet balance is {int}")
    public void the_wallet_balance_is(Integer int1) {

    }
}
