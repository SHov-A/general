package com.inomma.acceptance.steps;

import com.inomma.acceptance.pages.HomePage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Home Page's related actions.
 */
public class HomePageSteps {

    @Autowired
    private HomePage homePage;

    @Then("^In Home Page - I should see \"([^\"]*)\" entered username$")
    public void In_Home_Page_I_should_see_entered_username(String username){
        Assert.assertEquals(homePage.getEnteredUserName(), username);
    }

    @Then("^In Home Page - I click on entered username$")
    public void In_Home_Page_I_click_on_entered_username(){
        homePage.clickOnEnteredUserName();
    }

    @Then("^In Home Page - I click on logout button$")
    public void In_Home_Page_I_click_on_logout() throws InterruptedException {
        homePage.clickOnLogOutButton();
        Thread.sleep(500);
    }

    @Then("^In Home Page Left Panel - I click on store item$")
    public void In_Home_Page_Left_Panel_I_click_on_store_item(){
        homePage.clickOnNavigationItemToStore();
    }
}
