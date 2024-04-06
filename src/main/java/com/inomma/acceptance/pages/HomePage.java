package com.inomma.acceptance.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Home Page's related web elements and actions with them.
 */
public class HomePage extends BasePage {

    @FindBy(id = "navigation-item-to-store")
    private WebElement navigationItemToStore;

    @FindBy(id = "user-name")
    private WebElement enteredUserName;

    @FindBy(id = "log-out-button")
    private WebElement logOutButton;

    public HomePage(PageContext pageContext) {
        super(pageContext);
    }

    public String getEnteredUserName() {
        return visibilityOf(enteredUserName).getText();
    }

    public void clickOnNavigationItemToStore() {
        waitToElementIsClickable(navigationItemToStore).click();
    }

    public void clickOnEnteredUserName() {
        waitToElementIsClickable(enteredUserName).click();
    }

    public void clickOnLogOutButton() {
        waitToElementIsClickable(logOutButton).click();
    }
}
