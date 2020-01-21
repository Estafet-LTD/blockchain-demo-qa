package com.estafet.blockchain;

import com.estafet.blockchain.demo.data.lib.exchangerate.ExchangeRate;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.estafet.blockchain.demo.pages.lib.home.HomePage;
import com.estafet.blockchain.demo.pages.lib.rate.*;
import org.junit.Assert;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import io.cucumber.datatable.DataTable;

public class ExchangeRateSteps {

    HomePage homePage;
    ExchangeRate exchangeRate;
    NewExchangeRatePage newExchangeRate;
    ExchangeRateListPage exchangeRateList;
    ExchangeRateItem exchangeRateItem;
    List existingRatesList = new ArrayList();


    @Before
    public void before() {
        ExchangeRate.deleteExchangeRates();
    }

    @Given("The following exchange rates exist: <currency> and <rate>")
    public void setRates(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {
            ExchangeRate.setExchangeRate(list.get(i).get("currency"), Double.valueOf(list.get(i).get("rate")));
        }
    }

    @When("New exchange rate is created with currency <currency> and rate <rate>")
    public void addNewRate(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        ExchangeRate.setExchangeRate(list.get(0).get("currency"), Double.valueOf(list.get(0).get("rate")));
        List<ExchangeRate> ExchangeRates = ExchangeRate.getExchangeRates();

    }

    @Then("The currency <currency> exists with rate <rate>")
    public void verifyNewRate(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        ExchangeRate exchangeRate = ExchangeRate.getExchangeRate(list.get(0).get("currency"));
        Assert.assertEquals(Double.valueOf(exchangeRate.getRate()), Double.valueOf(list.get(0).get("rate")));
    }

    @When("The user updates the rate for \"([^\"]*)\" to <rate>")
    public void updateRate(String string, DataTable dataTable) {

    }

    @Then("The rate will be successfully updated")
    public void verifyUpdatedRate() {

    }


    @When("User selects \"([^\"]*)\" from the currencies list")
    public void selectRate(String string) {

    }

    @Then("They can view the exchange rate details:")
    public void verifyRateDetails(DataTable dataTable) {

    }
    @When("^Clicks on the the exchange rates link$")
    public void loadExchangeRatesList() throws Throwable {

    }
    @Then("They will see the list will all rates existing:")
    public void verifyRatesList(DataTable dataTable) {

    }
}
