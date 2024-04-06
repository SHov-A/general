package com.inomma.acceptance.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * LeftSidebar's related web elements and actions with them.
 */
public class LeftSidebarPage extends BasePage {

    @FindBy(id = "navigation-item-to-home")
    private WebElement navigationItemToHome;

    @FindBy(id = "navigation-item-to-store")
    private WebElement navigationItemToStore;

    @FindBy(id = "navigation-item-to-news")
    private WebElement navigationItemToNews;

    @FindBy(id = "play-on-pc-button")
    private WebElement playOnPC;

    @FindBy(id = "ios-market-link")
    private WebElement iosMarketLink;

    @FindBy(id = "android-market-link")
    private WebElement androidMarketLink;

    @FindBy(id = "terms-of-use-page-link")
    private WebElement termsOfService;

    @FindBy(id = "privacy-policy-page-link")
    private WebElement privacyPolicy;

    @FindBy(id = "fb-page-link")
    private WebElement facebookPage;

    @FindBy(id = "youtube-page-link")
    private WebElement youTubePage;

    @FindBy(id = "twitter-page-link")
    private WebElement twitterPage;

    @FindBy(id = "instagram-page-link")
    private WebElement instagramPage;

    @FindBy(id = "discord-page-link")
    private WebElement discordPage;

    @FindBy(id = "copyright-title-text")
    private WebElement copyrightTitle;

    @FindBy(id = "copyright-text-text")
    private WebElement copyrightText;

    @FindBy(id = "special-offer-button-undefined")
    private WebElement homePageExpectedText;

    @FindBy(xpath = "//h2[contains(text(),'Login With Your Scopely ID to Visit the Store')]")
    private WebElement storePageExpectedText;

    public LeftSidebarPage(PageContext pageContext) {
        super(pageContext);
    }

    public void clickOnFacebookPage() {
        waitToElementIsClickable(facebookPage).click();
    }

    public void clickOnYouTube() {
        waitToElementIsClickable(youTubePage).click();
    }

    public void clickOnTwitter() {
        waitToElementIsClickable(twitterPage).click();
    }

    public void clickOnInstagram() {
        waitToElementIsClickable(instagramPage).click();
    }

    public void clickOnDiscord() {
        waitToElementIsClickable(discordPage).click();
    }

    public void clickOnPlayOnPC() {
        waitToElementIsClickable(playOnPC).click();
    }

    public void clickOnAppStore() {
        waitToElementIsClickable(iosMarketLink).click();
    }

    public void clickOnGooglePlay() {
        waitToElementIsClickable(androidMarketLink).click();
    }

    public void clickOnTermsOfService() {
        waitToElementIsClickable(termsOfService).click();
    }

    public void clickOnPrivacyPolicy() {
        waitToElementIsClickable(privacyPolicy).click();
    }

    public String getCopyrightTitle() {
        return visibilityOf(copyrightTitle).getText();
    }

    public String getCopyrightText() {
        return visibilityOf(copyrightText).getText();
    }

    public void clickOnHome() {
        waitToElementIsClickable(navigationItemToHome).click();
    }

    public void clickOnStore() {
        waitToElementIsClickable(navigationItemToStore).click();
    }

    public void clickOnNews() {
        waitToElementIsClickable(navigationItemToNews).click();
    }

    public String getHomePageExpectedText() {
        return visibilityOf(homePageExpectedText).getText();
    }

    public String getStorePageExpectedText() {
        return visibilityOf(storePageExpectedText).getText();
    }

}

