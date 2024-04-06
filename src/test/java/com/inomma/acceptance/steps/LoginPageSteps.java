package com.inomma.acceptance.steps;

import com.inomma.acceptance.helper.TestUtil;
import com.inomma.acceptance.pages.LoginPage;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Login Page's related actions.
 */
public class LoginPageSteps {

    @Autowired
    private LoginPage loginPage;

    @And("^In Login Page - I fill \"([^\"]*)\" as username$")
    public void In_Login_Page_I_fill_username(String username) {
        loginPage.fillUserNameField(username);
    }

    @And("^In Login Page - I fill \"([^\"]*)\" as password")
    public void In_Login_Page_I_fill_password(String password) {
        loginPage.fillPasswordField(password);
    }

    @And("^In Login Page - I click on submit button$")
    public void In_Login_Page_I_click_on_submit_button() {
        loginPage.clickOnSubmitButton();
    }

    @And("^The failure message for wrong username or password should be$")
    public void The_failure_message_for_wrong_username_or_password_should_be(String validationMessage) {
        Assert.assertEquals(loginPage.getValidationMessageForWrongUsernamePassword(), validationMessage);
    }

    @And("^The failure message for empty password should be$")
    public void The_failure_message_for_empty_password_should_be(String validationMessage) {
        Assert.assertEquals(loginPage.getValidationMessageForEmptyPassword(), validationMessage);
    }

    @And("^The failure message for empty username should be$")
    public void The_failure_message_for_empty_username_should_be(String validationMessage) {
        Assert.assertEquals(loginPage.getValidationMessageForEmptyUserName(), validationMessage);
    }

    @And("^The failure message for empty username and empty password should be$")
    public void The_failure_message_for_empty_username_and_empty_password_should_be(String validationMessage) {
        List<String> list = TestUtil.splitString(validationMessage,"/");
        Assert.assertEquals(loginPage.getValidationMessageForEmptyUserName(), list.get(0));
        Assert.assertEquals(loginPage.getValidationMessageForEmptyPassword(), list.get(1));
    }
}

