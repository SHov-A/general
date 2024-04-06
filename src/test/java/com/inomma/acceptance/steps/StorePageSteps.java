package com.inomma.acceptance.steps;

import com.inomma.acceptance.client.StarTrekService;
import com.inomma.acceptance.client.parser.WebGiftsService;
import com.inomma.acceptance.helper.TestUtil;
import com.inomma.acceptance.pages.StorePage;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

/**
 * Store Page's related actions.
 */
public class StorePageSteps {

    private static String textOfWebElementInArrayWebElements;
    private static List<WebElement> featureOfferItemDiv;
    private static List<WebElement> offerQuantityButtonList;
    private static String purchasedItemLeftId;
    private static int randomNumberFeatured;
    private static int randomNumberPurchase;
    private static WebElement targetOffer;
    private static WebElement offerQuantity;
    private static By offerLeftIcon;
    private static String initialOfferQuantityPriceText;
    private static double totalOfferQuantityPrice;
    private static final int RANDOM_COUNT_SIZE = 21;
    private static String randomCountInBasket;
    private static final String IFRAME_ID = "xsolla-lightbox-iframe";
    private static final String INNER_TEXT = "innerText";
    private static final String OUTER_TEXT = "outerText";
    private static final String CLASS_NAME = "className";
    private static final String VALUE = "value";
    private static final Logger logger = Logger.getLogger(StorePageSteps.class);

    @Autowired
    private StorePage storePage;

    @Autowired
    private StarTrekService startrekService;

    @Autowired
    private WebGiftsService webGiftsService;

    @Then("^In Store Page Featured Section - I click on load more feature button$")
    public void In_Store_Page_Featured_Section_I_click_on_load_more_feature_button() {
        try {
            if (storePage.getLoadMoreFeatures()) storePage.clickOnLoadMoreFeaturesButton();
        } catch (TimeoutException e) {
            DOMConfigurator.configure("log4j.xml");
            logger.info("In store aren't load button");
        }
    }

    @Then("^In Store Page Featured Section - I get left text that feature which must buy$")
    public void In_Store_Page_Featured_Section_I_get_left_text_that_feature_which_must_buy() {
        featureOfferItemDiv = storePage.getFeatureOfferItemDiv();
        offerLeftIcon = storePage.getOfferLeftIcon();
        int arrayFeaturedOfferSize = featureOfferItemDiv.size();
        randomNumberFeatured = TestUtil.randomNumberGenerator(arrayFeaturedOfferSize);
        textOfWebElementInArrayWebElements = storePage.getTextOfWebElementInArrayWebElements(featureOfferItemDiv, offerLeftIcon, randomNumberFeatured);
    }

    @Then("^In Store Page Featured Section - I buy feature$")
    public void In_Store_Page_Featured_Section_I_buy_feature() {
        targetOffer = featureOfferItemDiv.get(randomNumberFeatured);
        purchasedItemLeftId = targetOffer.getAttribute("id");
        storePage.clickOnBuyButton(targetOffer);
    }

    @Then("^In Store Page Opened Popup For Payment - I navigate to popup$")
    public void In_Store_Page_Opened_Popup_For_Payment_I_navigate_to_popup() {
        storePage.waitToFrame(IFRAME_ID);
    }

    @Then("^In Store Page Opened Popup For Payment - I should see \"([^\"]*)\" username$")
    public void In_Store_Page_Opened_Popup_For_Payment_I_should_see_username(String userName) {
        Assert.assertEquals(storePage.getHeaderInfoUserName(), userName);
    }

    @Then("^In Store Page Opened Popup For Payment - I click on PayPal button$")
    public void In_Store_Page_Opened_Popup_For_Payment_I_click_on_PayPal_button() {
        storePage.clickOnPayPalButton();
    }

    @Then("^In Store Page Opened Popup For Payment - I click on Pay Now button$")
    public void In_Store_Page_Opened_Popup_For_Payment_I_click_on_Pay_Now_button() {
        storePage.clickOnSecondPayNowButton();
        storePage.clickOnSecondPayNowButton();
    }

    @Then("^In Store Page Opened Popup For Payment - I should see \"([^\"]*)\" title$")
    public void In_Store_Page_Opened_Popup_For_Payment_I_should_see_title(String title) {
        Assert.assertTrue(storePage.waitToText(storePage.getPaymentStatusHeaderTitle(), title));
    }

    @Then("^In Store Page Opened Popup For Payment - I click on close button$")
    public void In_Store_Page_Opened_Popup_For_Payment_I_click_on_close_button() {
        storePage.clickOnCloseThePaymentWindow();
        storePage.switchToDefaultContent();
    }

    @Then("^In Store Page Opened Popup For Successful Payment - I should see \"([^\"]*)\" text$")
    public void In_Store_Page_Opened_Popup_For_Successful_Payment_I_should_see_text(String text) {
        Assert.assertEquals(storePage.getPaymentSuccessfulPopupText(), (text));
    }

    @Then("^In Store Page Opened Popup For Successful Payment - I click on close button$")
    public void In_Store_Page_Opened_Popup_For_Successful_Payment_I_click_on_close_button() {
        storePage.clickOnPaymentSuccessfulPopupCloseButton();
    }

    @Then("^In Store Page Featured Section - I check bundle left count after bought$")
    public void In_Store_Page_Featured_Section_I_check_bundle_left_count_after_bought() {
        if (Objects.equals(textOfWebElementInArrayWebElements, "Unlimited")) {
            Assert.assertEquals(textOfWebElementInArrayWebElements, targetOffer.findElement(offerLeftIcon).getText());
        } else if (Objects.equals(textOfWebElementInArrayWebElements, "1 Left")) {
            Assert.assertThrows(
                    NoSuchElementException.class,
                    () -> storePage.waitToWebElement(storePage.driver().findElement(By.id(purchasedItemLeftId)))
            );
        } else if (!textOfWebElementInArrayWebElements.equals("Left") && !textOfWebElementInArrayWebElements.equals("1 Left")) {
            Assert.assertEquals(TestUtil.decrementTextFirstMember(textOfWebElementInArrayWebElements, " "),
                    targetOffer.findElement(offerLeftIcon).getText()
            );
        }
    }

    @Then("^I get \"([^\"]*)\" from cookie and do HttpGetRequest to get web gifts response body$")
    public void I_do_HttpGetRequest_to_get_web_gifts_response_body(String token) {
        startrekService.getGifts(token);
    }

    @Then("^I get \"([^\"]*)\" from cookie, do HttpPostRequest to claim web gift and response status code should be (\\d+)$")
    public void I_do_HttpPostRequest_to_claim_web_gift_and_response_status(String token, int statusCode) {
        List<Integer> list = webGiftsService.getValidBundleIdsFromGiftsJson();
        String id = TestUtil.getRandomIndex(list);
        Assert.assertEquals(startrekService.getStatusCode(token, id), statusCode);
    }

    @Then("^In Store Page - I click on Web Gifts button$")
    public void In_Store_Page_I_click_on_Web_Gifts_button() {
        storePage.clickOnStoreWebGiftTabButton();
    }

    @Then("^In Store Page Featured Section - I select multiple purchase feature$")
    public void In_Store_Page_Featured_Section_I_select_multiple_purchase_feature() {
        offerQuantityButtonList = storePage.getOfferQuantityButtonList();
        int arrayMultiplePurchaseSize = offerQuantityButtonList.size();
        randomNumberPurchase = TestUtil.randomNumberGenerator(arrayMultiplePurchaseSize);
        initialOfferQuantityPriceText = storePage.getOfferQuantityPriceXpath(randomNumberPurchase + 1).getAttribute(OUTER_TEXT);
        offerQuantity = offerQuantityButtonList.get(randomNumberPurchase);
    }

    @Then("^In Store Page Featured Section - I click on basket$")
    public void In_Store_Page_Featured_Section_I_click_on_basket() {
        storePage.clickOnOfferQuantityButton(offerQuantity);
    }

    @Then("^In Store Page Basket Section - I check that (minus|plus) button is \"([^\"]*)\"$")
    public void In_Store_Page_Basket_Section_I_check_that_button_is_not_clickable(String button, String condition) {
        if (button.equals("minus")) {
            Assert.assertTrue(storePage.visibilityOfOfferQuantityDecrease().getAttribute(CLASS_NAME).contains(condition));
        } else if (button.equals("plus")) {
            Assert.assertTrue(storePage.visibilityOfOfferQuantityIncrease().getAttribute(CLASS_NAME).contains(condition));
        }

    }

    @Then("^In Store Page Basket Section - I put \"([^\"]*)\" count$")
    public void In_Store_Page_Basket_Section_I_put_count(String count) {
        TestUtil.deleteInputtedStringData(storePage.visibilityOfOfferQuantityValue().getAttribute(VALUE),
                storePage.visibilityOfOfferQuantityValue());
        storePage.visibilityOfOfferQuantityValue().sendKeys(count);
    }

    @Then("^In Store Page Basket Section - I put random count$")
    public void In_Store_Page_Basket_Section_I_put_random_count() {
        randomCountInBasket = String.valueOf(TestUtil.randomNumberGenerator(RANDOM_COUNT_SIZE));
        TestUtil.deleteInputtedStringData(storePage.visibilityOfOfferQuantityValue().getAttribute(VALUE),
                storePage.visibilityOfOfferQuantityValue());
        storePage.visibilityOfOfferQuantityValue().sendKeys(randomCountInBasket);
    }

    @Then("^In Store Page Basket Section - I should see purchase \"([^\"]*)\" count$")
    public void In_Store_Page_Basket_Section_I_should_see_purchase_count(String count) {
        Assert.assertEquals(offerQuantity.getAttribute(INNER_TEXT), count);
    }

    @Then("^In Store Page Basket Section - I should see purchase random count$")
    public void In_Store_Page_Basket_Section_I_should_see_purchase_random_count() {
        if (randomCountInBasket.equals("0") || randomCountInBasket.equals("1")) {
            Assert.assertEquals(offerQuantity.getAttribute(INNER_TEXT), "");
        } else {
            Assert.assertEquals(offerQuantity.getAttribute(INNER_TEXT), randomCountInBasket);
        }
    }

    @Then("^In Store Page Basket Section - I should see \"([^\"]*)\" text$")
    public void In_Store_Page_Basket_Section_I_should_see_text(String text) {
        Assert.assertEquals(storePage.getOfferQuantityHelperText(), text);
    }

    @Then("^In Store Page Basket Section - I should see \"([^\"]*)\" count$")
    public void In_Store_Page_Basket_Section_I_should_see_count(String count) {
        Assert.assertEquals(storePage.visibilityOfOfferQuantityValue().getAttribute(VALUE), count);
    }

    @Then("^In Store Page Bundle Section - I should see random updated price$")
    public void In_Store_Page_Bundle_Section_I_should_see_updated_price() {
        String outerText = storePage.getOfferQuantityPriceXpath(randomNumberPurchase + 1).getAttribute(OUTER_TEXT);
        totalOfferQuantityPrice = TestUtil.getMultiplePurchaseOuterTextLastMember(outerText);
        double initialOfferQuantityPrice = TestUtil.getMultiplePurchaseOuterTextLastMember(initialOfferQuantityPriceText);
        double countInBasket = Double.parseDouble(randomCountInBasket);
        Assert.assertEquals(countInBasket, totalOfferQuantityPrice / initialOfferQuantityPrice, 0.01);
    }

    @Then("^In Store Page Featured Section - I buy bundle feature$")
    public void In_Store_Page_Featured_Section_I_buy_bundle_feature() {
        storePage.getOfferQuantityPriceXpath(randomNumberPurchase + 1).findElement(storePage.getOfferPriceButton()).click();
    }

    @Then("In Store Page Opened Popup For Payment - I check total price")
    public void In_Store_Page_Opened_Popup_For_Payment_I_check_total_price() {
        Assert.assertEquals(TestUtil.getDigitsInString(storePage.getTotalQuantityAmountText()), totalOfferQuantityPrice, 0.01);
    }

}

