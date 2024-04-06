package com.inomma.acceptance.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Store Page's related web elements and actions with them.
 */
public class StorePage extends BasePage {

    private final By offerPriceButton = By.name("offer-price-button");
    private final By offerLeftIcon = By.name("offer-left-icon");
    private final By offerPriceButtonWrapper = By.name("offer-price-button-wrapper");

    @FindBy(name = "feature-offer-item-div")
    private List<WebElement> featureOfferItemDiv;

    @FindBy(name = "offer-quantity-button")
    private List<WebElement> offerQuantityButtonList;

    @FindBy(name = "offer-quantity-decrease")
    private WebElement offerQuantityDecrease;

    @FindBy(name = "offer-quantity-increase")
    private WebElement offerQuantityIncrease;

    @FindBy(name = "offer-quantity-value")
    private WebElement offerQuantityValue;

    @FindBy(name = "offer-quantity-helper-text")
    private WebElement offerQuantityHelperText;

    @FindBy(name = "load-more-features")
    private WebElement loadMoreFeatures;

    @FindBy(className = "header-info-user-name-label")
    private WebElement headerInfoUserName;

    @FindBy(xpath = "//div[@title='PayPal']")
    private WebElement payPalButton;

    @FindBy(xpath = "//button[contains(text(),'Pay now')]")
    private WebElement secondPayNowButton;

    @FindBy(className = "status-header-title")
    private WebElement paymentStatusHeaderTitle;

    @FindBy(className = "total-quantity-amount")
    private WebElement totalQuantityAmount;

    @FindBy(xpath = "//a[@title='Close the window']")
    private WebElement closeThePaymentWindow;

    @FindBy(xpath = "//h2[contains(text(),'Payment successful...')]")
    private WebElement paymentSuccessfulPopup;

    @FindBy(id = "modal-close-button")
    private WebElement paymentSuccessfulPopupCloseButton;

    @FindBy(id = "store-web-gift-tab-button")
    private WebElement storeWebGiftTabButton;

    public StorePage(PageContext pageContext) {
        super(pageContext);
    }

    public void clickOnLoadMoreFeaturesButton() {
        waitToElementIsClickable(loadMoreFeatures).click();
    }

    public boolean getLoadMoreFeatures() {
        return waitToWebElement(loadMoreFeatures);
    }

    public List<WebElement> getFeatureOfferItemDiv() {
        return visibilityOfAllElements(featureOfferItemDiv);
    }

    public List<WebElement> getOfferQuantityButtonList() {
        return visibilityOfAllElements(offerQuantityButtonList);
    }

    public String getHeaderInfoUserName() {
        return visibilityOf(headerInfoUserName).getText();
    }

    public void clickOnPayPalButton() {
        waitToElementIsClickable(payPalButton).click();
    }

    public void clickOnSecondPayNowButton() {
        waitToElementIsClickable(secondPayNowButton).click();
    }

    public By getOfferLeftIcon() {
        return offerLeftIcon;
    }

    public By getOfferPriceButton() {
        return offerPriceButton;
    }

    public By getOfferPriceButtonWrapper() {
        return offerPriceButtonWrapper;
    }

    public WebElement getPaymentStatusHeaderTitle() {
        return visibilityOf(paymentStatusHeaderTitle);
    }

    public void clickOnCloseThePaymentWindow() {
        waitToElementIsClickable(closeThePaymentWindow).click();
    }

    public String getPaymentSuccessfulPopupText() {
        return visibilityOf(paymentSuccessfulPopup).getText();
    }

    public void clickOnPaymentSuccessfulPopupCloseButton() {
        waitToElementIsClickable(paymentSuccessfulPopupCloseButton).click();
    }

    public void clickOnBuyButton(WebElement webElement) {
        scrollIntoView(webElement.findElement(getOfferPriceButtonWrapper()));
        waitToElementIsClickable(webElement.findElement(getOfferPriceButtonWrapper())).click();
    }

    public void clickOnStoreWebGiftTabButton() {
        waitToElementIsClickable(storeWebGiftTabButton).click();
    }

    public void clickOnOfferQuantityButton(WebElement webElement) {
        scrollIntoView(webElement);
        waitToElementIsClickable(webElement).click();
    }

    public WebElement visibilityOfOfferQuantityDecrease() {
        return visibilityOf(offerQuantityDecrease);
    }

    public WebElement visibilityOfOfferQuantityIncrease() {
        return visibilityOf(offerQuantityIncrease);
    }

    public WebElement visibilityOfOfferQuantityValue() {
        return visibilityOf(offerQuantityValue);
    }

    public String getOfferQuantityHelperText() {
        return visibilityOf(offerQuantityHelperText).getText();
    }

    public WebElement getOfferQuantityPriceXpath(int number) {
        final String offerQuantityPriceXpath = "(//div[@name='offer-quantity-button'])[%s]//ancestor::div[@name='feature-offer-item-div']";
        return visibilityOf(super.driver().findElement(By.xpath(String.format(offerQuantityPriceXpath, number))));
    }

    public String getTotalQuantityAmountText() {
        return visibilityOf(totalQuantityAmount).getText();
    }

}
