package com.inomma.acceptance.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
        glue = "com/inomma/acceptance/steps",
        plugin = {"pretty", "html:target/cucumber-reports/store-web-gifts-functionality.html",
                "json:target/cucumber-reports/store-web-gifts-functionality.json"},
        tags = "@web_gifts_left",
        monochrome = true,
        dryRun = false)
public class StoreWebGiftsFunctionalityTest {
}
