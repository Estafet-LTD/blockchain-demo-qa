package com.estafet.blockchain;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewWalletTransactionsSteps {
    @Given("The following wallets exist: <wallet name>, balance and <balance status>")
    public void setupWallets(io.cucumber.datatable.DataTable dataTable) {

    }

    @When("User selects {string} from the list")
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
