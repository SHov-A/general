package com.inomma.acceptance.steps;

import com.inomma.acceptance.pages.LeftSidebarPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class LeftSidebarPageSteps {

    @Autowired
    private LeftSidebarPage leftSidebarPage;

    // facebook button
    @Then("^In Left Sidebar - I click on facebook button$")
    public void In_Left_Sidebar_I_click_on_facebook_button() {
        leftSidebarPage.clickOnFacebookPage();
    }

    @Then("^In New Window - I should see  Facebook's \"([^\"]*)\" URL$")
    public void In_New_Window_I_should_see_Facebook_URL(String text) {
        Assert.assertEquals(text, leftSidebarPage.redirectURL());
    }

    // youtube button
    @Then("^In Left Sidebar - I click on Youtube button$")
    public void In_Left_Sidebar_I_click_on_Youtube_button() {
        leftSidebarPage.clickOnYouTube();
    }

    @Then("^In New Window - I should see Youtube's \"([^\"]*)\" URL$")
    public void In_New_Window_I_should_see_Youtube_URL(String text) {
        Assert.assertEquals(text, leftSidebarPage.redirectURL());
    }

    //twitter button
    @Then("^In Left Sidebar - I click on Twitter button$")
    public void In_LeftSidebar_I_click_on_Twitter_button() {
        leftSidebarPage.clickOnTwitter();
    }

    @Then("^In New Window - I should see Twitter's \"([^\"]*)\" URL$$")
    public void In_New_Window_I_should_see_Twitter_URL(String text) {
        Assert.assertEquals(text, leftSidebarPage.redirectURL());
    }

    // instagram button
    @Then("^In Left Sidebar - I click on Instagram button$")
    public void In_LeftSidebar_I_click_on_Instagram_button() {
        leftSidebarPage.clickOnInstagram();
    }

    @Then("^In New Window - I should see Instagram's \"([^\"]*)\" URL$$")
    public void In_New_Window_I_should_see_Instagram_URL(String text) {
        Assert.assertEquals(text, leftSidebarPage.redirectURL());
    }

    //discord button
    @Then("^In Left Sidebar - I click on Discord button$")
    public void In_LeftSidebar_I_click_on_Discord_button() {
        leftSidebarPage.clickOnDiscord();
    }

    @Then("^In New Window - I should see Discord's \"([^\"]*)\" URL$$")
    public void In_New_Window_I_should_see_Discord_URL(String text) {
        Assert.assertEquals(text, leftSidebarPage.redirectURL());
    }

    // terms of service button
    @Then("^In Left Sidebar - I click on Terms of Service button$")
    public void In_LeftSidebar_I_click_on_Terms_of_Service_button() {
        leftSidebarPage.clickOnTermsOfService();
    }

    @Then("^In New Window - I should see Terms of Service's \"([^\"]*)\" URL$$")
    public void In_New_Window_I_should_see_Terms_of_Service_URL(String text) {
        Assert.assertEquals(text, leftSidebarPage.redirectURL());
    }

    //privacy policy button
    @Then("^In Left Sidebar - I click on Privacy Policy button$")
    public void In_LeftSidebar_I_click_on_Privacy_Policy_button() {
        leftSidebarPage.clickOnPrivacyPolicy();
    }

    @Then("^In New Window - I should see Privacy Policy's \"([^\"]*)\" URL$$")
    public void In_New_Window_I_should_see_Privacy_Policy_URL(String text) {
        Assert.assertEquals(text, leftSidebarPage.redirectURL());
    }

    //appstore button
    @Then("^In Left Sidebar - I click on AppStore button$")
    public void In_LeftSidebar_I_click_on_AppStore_button() {
        leftSidebarPage.clickOnAppStore();
    }

    @Then("^In New Window - I should see AppStore's \"([^\"]*)\" URL$$")
    public void In_New_Window_I_should_see_AppStore_URL(String text) {
        Assert.assertEquals(text, leftSidebarPage.redirectURL());
    }

    //google play button
    @Then("^In Left Sidebar - I click on GooglePlay button$")
    public void In_LeftSidebar_I_click_on_GooglePlay_button() {
        leftSidebarPage.clickOnGooglePlay();
    }

    @Then("^In New Window - I should see GooglePlay's \"([^\"]*)\" URL$$")
    public void In_New_Window_I_should_see_GooglePlay_URL(String text) {
        Assert.assertEquals(text, leftSidebarPage.redirectURL());
    }

    // CopyrightTitle and CopyrightText
    @Then("^In Left Sidebar - I get CopyrightTitle \"([^\"]*)\"$")
    public void In_Left_Sidebar_I_get_CopyrightTitle(String text) {
        Assert.assertEquals(leftSidebarPage.getCopyrightTitle(), text);
    }

    @Then("^In Left Sidebar - I get CopyrightText \"([^\"]*)\"$")
    public void In_Left_Sidebar_I_get_CopyrightText(String text) {
        Assert.assertEquals(text, leftSidebarPage.getCopyrightText());
    }

    // Home button
    @Then("^In Left Sidebar - I click on Home page button$")
    public void In_Left_Sidebar_I_click_on_Home_page_button() {
        leftSidebarPage.clickOnHome();
    }

    @Then("^In Page - I see \"([^\"]*)\" button$")
    public void In_Page_I_see_button(String text) {
        Assert.assertEquals(text, leftSidebarPage.getHomePageExpectedText());
    }

    // Store button
    @Then("^In Left Sidebar - I click on Store page button$")
    public void In_Left_Sidebar_I_click_on_Store_page_button() {
        leftSidebarPage.clickOnStore();
    }

    @Then("^In Page - I see pop up \"([^\"]*)\"$")
    public void In_Page_I_see_pop_up(String text) {
        Assert.assertEquals(text, leftSidebarPage.getStorePageExpectedText());
    }

    //news page
    @Then("^In Left Sidebar - I click on News page button$")
    public void In_Left_Sidebar_I_click_on_News_page_button() {
        leftSidebarPage.clickOnNews();
    }

    @Then("^In Page - I see \"([^\"]*)\" URL$")
    public void In_Page_I_see_URL(String text) {
        Assert.assertEquals(text, leftSidebarPage.redirectURL());
    }

}
