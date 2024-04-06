package com.inomma.acceptance.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Initial Page's related web elements and actions with them.
 */
public class InitialPage extends BasePage {

    private JavascriptExecutor jsExecutor;

    @FindBy(id = "log-in-button")
    private WebElement initialLoginButton;

    @FindBy(xpath = "//img[@data-id='right-sidebar-button']")
    private WebElement initialLoginButtonInPartScreen;

    @FindBy(xpath = "//p[contains(text(),'Login via ScopelyID')]")
    private WebElement initialLoginButtonText;

    @FindBy(xpath = "//h2[contains(text(),'No Connected Account')]")
    private WebElement popUpTextForNoConnectedUser;

    @FindBy(xpath = "//h2[contains(text(),'Please Log In')]")
    private WebElement popUpTextForDeletedUser;

    @FindBy(xpath = "//span[contains(text(),'Account Linking Guide')]")
    private WebElement noConnectedAccountLinkingGuideButton;

    @FindBy(xpath = "//h1[contains(text(),'Introducing a new way to login')]")
    private WebElement textForNoConnectedUserIntroducingToLogin;

    @FindBy(xpath = "//h2[contains(text(),'Please Log In')]")
    private WebElement popUpTextForArchivedUser;

    @FindBy(xpath = "//span[contains(text(),'OK')]")
    private WebElement archivedUserButtonForLogIn;

    @FindBy(xpath = "//h2[contains(text(),'Account Suspended')]")
    private WebElement popUpTextForSuspendedUser;

    @FindBy(id = "navigation-item-to-news")
    private WebElement navigationToNews;

    public InitialPage(PageContext pageContext) {
        super(pageContext);
        jsExecutor = (JavascriptExecutor) driver();
    }

    public void goFullScreenMode() {
        driver().manage().window().maximize();
        goPage();
        jsExecutor.executeScript("window.localStorage.clear();");
        driver().manage().deleteAllCookies();
    }

    public void goPartScreenMode() {
        driver().manage().window().setSize(new Dimension(1024, 768));
        goPage();
        jsExecutor.executeScript("window.localStorage.clear();");
        driver().manage().deleteAllCookies();
    }

    public void clickOnInitialLoginButtonInPartScreen() {
        waitToElementIsClickable(initialLoginButtonInPartScreen).click();
    }

    public void clickOnLoginButton() {
        waitToElementIsClickable(initialLoginButton).click();
    }

    public String getInitialLoginButtonText() {
        return visibilityOf(initialLoginButtonText).getText();
    }

    public String getPopUpTextForNoConnectedUser() {
        return visibilityOf(popUpTextForNoConnectedUser).getText();
    }

    public String getPopUpTextForDeletedUser() {
        return visibilityOf(popUpTextForDeletedUser).getText();
    }

    public void clickNoConnectedAccountLinkingGuideButton() {
        waitToElementIsClickable(noConnectedAccountLinkingGuideButton).click();
    }

    public String textForNoConnectedUserIntroducingToLogin() {
        return visibilityOf(textForNoConnectedUserIntroducingToLogin).getText();
    }

    public String getPopUpTextForArchivedUser() {
        return visibilityOf(popUpTextForArchivedUser).getText();
    }

    public void clickOnArchivedUserButtonForLogIn() {
        waitToElementIsClickable(archivedUserButtonForLogIn).click();
    }

    public String getPopUpTextForSuspendedUser() {
        return visibilityOf(popUpTextForSuspendedUser).getText();
    }

    public void clickOnNewsButton() {
        waitToElementIsClickable(navigationToNews).click();
    }

}
