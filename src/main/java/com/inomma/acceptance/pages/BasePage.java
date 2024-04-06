package com.inomma.acceptance.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

/**
 * Selenium commands
 */
public class BasePage {

    private static final Duration DURATION_FOR_WAIT_IN_SECONDS = Duration.ofSeconds(30);
    private static final long DURATION_FOR_POLLING_IN_MILLIS_SECONDS = 500;

    private final PageContext pageContext;
    private final WebDriverWait wait;

    public BasePage(PageContext pageContext) {
        this.pageContext = pageContext;
        wait = new WebDriverWait(pageContext.getWebDriver(), DURATION_FOR_WAIT_IN_SECONDS);
        wait.pollingEvery(Duration.ofMillis(DURATION_FOR_POLLING_IN_MILLIS_SECONDS));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(ElementNotVisibleException.class);
        wait.ignoring(NoSuchFrameException.class);
        PageFactory.initElements(pageContext.getWebDriver(), this);
    }

    public WebDriver driver() {
        return pageContext.getWebDriver();
    }

    protected void goPage() {
        driver().get(pageContext.getUrl().toString());
    }

    public void switchToDefaultContent() {
        driver().switchTo().defaultContent();
    }

    public void waitToFrame(String id) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id));
    }

    public WebElement waitToElementIsClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Cookie waitTo(String cookieName) {
        return wait.until(webDriver -> getCookie(cookieName, webDriver));
    }

    private Cookie getCookie(String cookieName, WebDriver webDriver) {
        return webDriver.manage().getCookieNamed(cookieName);
    }

    private Cookie getCookie(String cookieName) {
        return getCookie(cookieName, driver());
    }

    public String getCookieValue(String name, boolean shouldWait) {
        Cookie cookie = shouldWait ? waitTo(name) : getCookie(name);
        return cookie != null ? cookie.getValue() : null;
    }

    public String getAttributeValueByJS(WebElement element, String attributeName) {
        String js = String.format("return arguments[0].getAttribute('%s');", attributeName);
        return ((JavascriptExecutor) driver()).executeScript(js, element).toString();
    }

    public boolean titleIs(String title) {
        return wait.until(ExpectedConditions.titleIs(title));
    }

    public WebElement visibilityOf(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean inVisibilityOf(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public List<WebElement> visibilityOfAllElements(List<WebElement> element) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public boolean waitToText(WebElement webElement, String text) {
        return wait.until(webDriver -> webElement.getText().equals(text));
    }

    public boolean waitToWebElement(WebElement element) {
        return wait.until(webDriver -> isPresent(element));
    }

    public boolean isPresent(WebElement element) {
        return element.isDisplayed();
    }

    public void handleOtherWindowsOpenAlready(int windowHandlesSize) {
        wait.until(ExpectedConditions.numberOfWindowsToBe(windowHandlesSize));
        String originalWindow = driver().getWindowHandle();
        int size = 1;
        for (String windowHandle : driver().getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle) && size == windowHandlesSize) {
                driver().switchTo().window(windowHandle);
                break;
            }
            size++;
        }
    }

    public String redirectURL() {
        return driver().getCurrentUrl();
    }

    public void scrollIntoView(WebElement element) {
        scrollIntoView(element, -500, 0);
    }

    public void scrollIntoView(WebElement element, Integer scrollFromTopBy, Integer scrollFromLeftBy) {
        ((JavascriptExecutor) driver()).executeScript(
                "arguments[0].scrollIntoView(true); window.scrollBy(arguments[1], arguments[2]);", element,
                scrollFromLeftBy, scrollFromTopBy);
    }

    public String getTextOfWebElementInArrayWebElements(List<WebElement> elements, By element, int number) {
        Objects.requireNonNull(elements, "web element are invalid: " + elements);
        Objects.requireNonNull(element, "web element are invalid: " + element);
        final WebElement webElement = elements.get(number);
        final WebElement target = webElement.findElement(element);
        return target.getText();
    }

}