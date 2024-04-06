package com.inomma.acceptance.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
        glue = "com/inomma/acceptance/steps",
        plugin = {"pretty", "html:target/cucumber-reports/login-with-normal-user.html",
                "json:target/cucumber-reports/login-with-normal-user.json"},
        tags = "@normal_user",
        monochrome = true,
        dryRun = false)
public class LoginWithNormalUserTest {
}
