package com.inomma.acceptance.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
        glue = "com/inomma/acceptance/steps",
        plugin = {"pretty", "html:target/cucumber-reports/store-multiple-purchase-functionality.html",
                "json:target/cucumber-reports/store-multiple-purchase-functionality.json"},
        tags = "@multiple_purchase",
        monochrome = true,
        dryRun = false)
public class StoreMultiplePurchaseFunctionalityTest {
}
