package com.inomma.acceptance.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
        glue = "com/inomma/acceptance/steps",
        plugin = {"pretty", "html:target/cucumber-reports/left-sidebar.html",
                "json:target/cucumber-reports/left-sidebar.json"},
        tags = "@left_sidebar",
        monochrome = true,
        dryRun = false)

public class LeftSidebarFunctionalityTest {
}
