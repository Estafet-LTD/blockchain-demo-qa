package com.estafet.blockchain;

import com.estafet.blockchain.demo.data.lib.exchangerate.ExchangeRate;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import com.estafet.blockchain.demo.pages.lib.home.HomePage;
import com.estafet.blockchain.demo.pages.lib.rate.*;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ExchangeRateSteps {

    HomePage homePage;
    ExchangeRate exchangeRate;
    NewExchangeRatePage newExchangeRate;
    ExchangeRateListPage exchangeRateList;
    ExchangeRateItem exchangeRateItem;
    List existingRatesList = new ArrayList();


    @Before
    public void before() {
        homePage = new HomePage();
        ExchangeRate.deleteExchangeRates();
    }

    @After
    public void after() {
        homePage.close();
    }

    @Given("The following exchange rates exist: <currency> and <rate>")
    public void setRates(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);

        for(int i=0; i<list.size(); i++) {
            ExchangeRate.setExchangeRate(list.get(i).get("currency"), Double.valueOf(list.get(i).get("rate")));
        }
    }

        @When("New exchange rate is created with currency <currency> and rate <rate>")
    public void addNewRate(io.cucumber.datatable.DataTable dataTable) {
            List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
            existingRatesList = ExchangeRate.getExchangeRates();
            homePage.clickExchangeRatesMenuItem();
            Assert.assertTrue(exchangeRateList.isLoaded());
            exchangeRateItem.clickNewExchangeRateLink();
            Assert.assertTrue(newExchangeRate.isLoaded());
            newExchangeRate.setCurrency(list.get(0).get("currency"));
            newExchangeRate.setRate(Double.valueOf(list.get(0).get("rate")));
            newExchangeRate.clickCreateRateButton();
            Assert.assertTrue(exchangeRateList.isLoaded());
    }

    @Then("The new exchange rate is added to the existing list:")
    public void verifyNewRate(DataTable dataTable) {
//        Map<String, Double> list = dataTable.asMap(String.class, Double.class);
//        for (int i = 0; i < list.size(); i++) {
//        Assert.assertThat(existingRatesList.);        }

    }
    @When("The user updates the rate for {string} to <rate>")
    public void updateRate(String string, io.cucumber.datatable.DataTable dataTable) {
        homePage.clickExchangeRatesMenuItem();
        Assert.assertTrue(exchangeRateList.isLoaded());

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
