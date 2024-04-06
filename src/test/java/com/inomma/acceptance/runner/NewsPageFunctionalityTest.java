package com.inomma.acceptance.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
        glue = "com/inomma/acceptance/steps",
        plugin = {"pretty", "html:target/cucumber-reports/news-featured.html",
                "json:target/cucumber-reports/news-featured.json"},
        tags = "@news_page",
        monochrome = true,
        dryRun = false)

public class NewsPageFunctionalityTest {
}
