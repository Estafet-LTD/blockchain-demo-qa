package com.estafet.blockchain;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ViewWalletTransactionsSteps {
    @Given("The following wallets exist: <wallet name>, balance and <balance status>")
    public void the_following_wallets_exist_wallet_name_balance_and_balance_status(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new cucumber.api.PendingException();
    }

    @When("User selects {string} from the list")
    public void user_selects_from_the_list(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("User can see the wallet name")
    public void user_can_see_the_wallet_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("User can see the wallet balance")
    public void user_can_see_the_wallet_balance() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("User can see the balance status")
    public void user_can_see_the_balance_status() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }
}
