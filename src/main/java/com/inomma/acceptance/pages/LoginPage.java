package com.inomma.acceptance.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Login Page's related web elements and actions with them.
 */
public class LoginPage extends BasePage {

    @FindBy(id = "okta-signin-username")
    private WebElement username;

    @FindBy(id = "okta-signin-password")
    private WebElement password;

    @FindBy(id = "okta-signin-submit")
    private WebElement submit;

    @FindBy(xpath = "//p[contains(text(),'Unable to sign in')]")
    private WebElement validationMessageForWrongUsernamePassword;

    @FindBy(xpath = "//p[contains(text(),'Please enter a password')]")
    private WebElement validationMessageForEmptyPassword;

    @FindBy(xpath = "//p[contains(text(),'Please enter a username')]")
    private WebElement validationMessageForEmptyUserName;

    public LoginPage(PageContext pageContext) {
        super(pageContext);
    }

    public void fillUserNameField(String userName) {
        visibilityOf(username).sendKeys(userName);
    }

    public void fillPasswordField(String pass) {
        visibilityOf(password).sendKeys(pass);
    }

    public void clickOnSubmitButton() {
        waitToElementIsClickable(submit).click();
    }

    public String getValidationMessageForWrongUsernamePassword() {
        return visibilityOf(validationMessageForWrongUsernamePassword).getText();
    }

    public String getValidationMessageForEmptyPassword() {
        return visibilityOf(validationMessageForEmptyPassword).getText();
    }

    public String getValidationMessageForEmptyUserName() {
        return visibilityOf(validationMessageForEmptyUserName).getText();
    }
}
