package com.inomma.acceptance.steps;

import com.inomma.acceptance.config.PageBeans;
import com.inomma.acceptance.pages.InitialPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

/**
 * Importing the spring context configuration and
 * actions related to initial page.
 */
@CucumberContextConfiguration
@ContextConfiguration(classes = PageBeans.class)
@TestPropertySource("classpath:gifts.properties")
public class InitialPageSteps {

    @Autowired
    private InitialPage initialPage;

    @Given("^I am in Initial Page$")
    public void I_am_in_Initial_Page() {
        initialPage.goFullScreenMode();
    }

    @And("^In Initial Page - I should see \"([^\"]*)\" title$")
    public void In_Initial_Page_I_should_see_title(String title) {
        Assert.assertTrue(initialPage.titleIs(title));
    }

    @Then("^In Initial Page - I click on login button$")
    public void In_Initial_Page_click_on_login_button() {
        initialPage.clickOnLoginButton();
    }

    @Then("^In Initial Page Opened Popup For No Connected User - I should see \"([^\"]*)\" text$")
    public void In_Initial_Page_Opened_Popup_For_noConnectedUser_I_should_see_text(String text) {
        Assert.assertEquals(initialPage.getPopUpTextForNoConnectedUser(), text);
    }

    @Then("^In Initial Page Opened Popup For No Connected User - I click on account linking guide button$")
    public void In_Initial_Page_Opened_Popup_For_noConnectedUser_I_click_on_account_linking_guide_button() {
        initialPage.clickNoConnectedAccountLinkingGuideButton();
    }

    @Then("^In Initial Page Opened Popup For Archived User - I should see \"([^\"]*)\" text$")
    public void In_Initial_Page_Opened_Popup_For_Archived_I_should_see_text(String text) {
        Assert.assertEquals(initialPage.getPopUpTextForArchivedUser(), text);
    }

    @Then("^In Initial Page Opened Popup For Archived User - I click on OK button$")
    public void In_Initial_Page_Opened_Popup_For_Archived_I_click_on_OK_button() {
        initialPage.clickOnArchivedUserButtonForLogIn();
    }

    @Then(("^I am in new opened (\\d+) window$"))
    public void I_am_in_new_opened_window(int windowHandles) {
        initialPage.handleOtherWindowsOpenAlready(windowHandles);
    }

    @Then("^In New Window Initial Page - I should see \"([^\"]*)\" text$")
    public void In_New_Window_Initial_Page_I_should_see_text(String text) {
        Assert.assertEquals(initialPage.textForNoConnectedUserIntroducingToLogin(), (text));
    }

    @Then("^In Initial Page - I should see \"([^\"]*)\" login button text$")
    public void In_Initial_Page_I_should_see_login_button_text(String text) {
        Assert.assertEquals(initialPage.getInitialLoginButtonText(), text);
    }

    @Then("^In Initial Page Opened Popup For Suspended User - I should see \"([^\"]*)\" text$")
    public void In_Initial_Page_Opened_Popup_For_Suspended_I_should_see_text(String text) {
        Assert.assertEquals(initialPage.getPopUpTextForSuspendedUser(), text);
    }

    @Then("^In Initial Page Opened Popup For Deleted User - I should see \"([^\"]*)\" text$")
    public void In_Initial_Page_Opened_Popup_For_Deleted_I_should_see_text(String text) {
        Assert.assertEquals(initialPage.getPopUpTextForDeletedUser(), text);
    }

    @Then("^In Initial Page After Logout - I should see null \"([^\"]*)\"$")
    public void In_Initial_Page_After_Logout_I_should_see_null_sessionID(String name) {
        Assert.assertNull(initialPage.getCookieValue(name, false));
    }

    @Then("^In Initial Page - I click on News section$")
    public void In_Initial_Page_I_click_on_News_section() {
        initialPage.clickOnNewsButton();
    }

}
