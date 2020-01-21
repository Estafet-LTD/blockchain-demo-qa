package com.estafet.blockchain;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.estafet.blockchain.demo.data.lib.bank.Account;


public class NewAccountSteps {
    @When("I submit name (.+), amount (.+) and currency in use (.+)")
    public void submitAccountData(String string, Integer int1, String string2) {

    }

    @Then("New bank account is created")
    public void verifyNewAccount() {

    }

    @Then("The starting balance is matching (.+)")
    public void veirfyStratingBalance(Integer int1) {

    }

    @Then("The currency matches (.+)")
    public void verifyCurrency(String string) {

    }

    @Then("Navigating from the bank account the user can go to the new wallet")
    public void loadNewWallet() {

    }

    @Then("The wallet name matches the bank account name (.+)")
    public void verifyWalletName(String string) {

    }

    @Then("The wallet balance is (.+)")
    public void verifyWalletBalance(Integer int1) {

    }
}
