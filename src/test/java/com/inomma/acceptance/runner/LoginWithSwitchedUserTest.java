package com.inomma.acceptance.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
        glue = "com/inomma/acceptance/steps",
        plugin = {"pretty", "html:target/cucumber-reports/login-with-switched-user.html",
                "json:target/cucumber-reports/login-with-switched-user.json"},
        tags = "@switched_user",
        monochrome = true,
        dryRun = false)
public class LoginWithSwitchedUserTest {
}
