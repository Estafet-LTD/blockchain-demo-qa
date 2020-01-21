package com.estafet.blockchain;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class NewAccountSteps {
    @When("I submit name {string}, amount {int} and currency in use {string}")
    public void submitAccountData(String string, Integer int1, String string2) {

    }

    @Then("New bank account is created")
    public void verifyNewAccount() {

    }

    @Then("The starting balance is matching {int}")
    public void veirfyStratingBalance(Integer int1) {

    }

    @Then("The currency matches {string}")
    public void verifyCurrency(String string) {

    }

    @Then("Navigating from the bank account the user can go to the new wallet")
    public void loadNewWallet() {

    }

    @Then("The wallet name matches the bank account name {string}")
    public void verifyWalletName(String string) {

    }

    @Then("The wallet balance is {int}")
    public void verifyWalletBalance(Integer int1) {

    }
}
