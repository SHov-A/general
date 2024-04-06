package com.inomma.acceptance.steps;

import com.inomma.acceptance.pages.PageContext;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Required actions after all scenarios.
 */
public class Hooks {

    @Autowired
    private PageContext pageContext;

    @After()
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(pageContext.getScreenShot(), "image/png", "The Screenshot");
        }
    }

}
