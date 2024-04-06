package com.inomma.acceptance.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
        glue = "com/inomma/acceptance/steps",
        plugin = {"pretty", "html:target/cucumber-reports/login-with-no-connected-user.html",
                "json:target/cucumber-reports/login-with-no-connected-user.json"},
        tags = "@no_connected_user",
        monochrome = true,
        dryRun = false)
public class LoginWithNoConnectedUserTest {
}
