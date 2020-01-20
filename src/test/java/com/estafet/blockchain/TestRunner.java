package com.estafet.blockchain;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
plugin = {"pretty", "json:target/cucumber-report.json"},
glue = {"com.estafet.blockchain"},
features = {"src/test/resources/cucumber"})

public class TestRunner {
	
}
