package com.inomma.acceptance.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
        glue = "com/inomma/acceptance/steps",
        plugin = {"pretty", "html:target/cucumber-reports/store-featured-functionality.html",
                "json:target/cucumber-reports/store-featured-functionality.json"},
        tags = "@featured_left",
        monochrome = true,
        dryRun = false)
public class StoreFeaturedFunctionalityTest {
}
