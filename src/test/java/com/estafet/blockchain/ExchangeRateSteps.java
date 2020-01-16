package com.estafet.blockchain;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ExchangeRateSteps {
    @Given("The following values exchange rates exist: <currency> and <rate>")
    public void setRates(io.cucumber.datatable.DataTable dataTable) {

    }

    @When("New exchange rate is created with currency <currency> and rate <rate>")
    public void addNewRate(io.cucumber.datatable.DataTable dataTable) {

    }

    @Then("The new exchange rate is added to the existing list:")
    public void verifyNewRate(io.cucumber.datatable.DataTable dataTable) {

    }

    @When("The user updates the rate for {string} to <rate>")
    public void updateRate(String string, io.cucumber.datatable.DataTable dataTable) {

    }

    @Then("The rate will be successfully updated")
    public void verifyUpdatedRate() {

    }

    @When("The user loads the home page")
    public void homePage() {

    }

    @When("Clicks on the the exchange rates link")
    public void loadExchangeRates() {

    }

    @When("User selects {string} from the currencies list")
    public void selectRate(String string) {

    }

    @Then("They can view the exchange rate details:")
    public void verifyRateDetails(io.cucumber.datatable.DataTable dataTable) {

    }

    @Then("They will see the list will all rates existing:")
    public void verifyRatesList(io.cucumber.datatable.DataTable dataTable) {

    }
}
