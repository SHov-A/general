package com.inomma.acceptance.pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.springframework.beans.factory.DisposableBean;

import java.net.URL;

/**
 * Driver and configuration required actions.
 */
public class PageContext implements DisposableBean {

    private final WebDriver webDriver;
    private final URL url;

    public PageContext(WebDriver webDriver, URL url) {
        this.webDriver = webDriver;
        this.url = url;
    }

    public URL getUrl() {
        return url;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Takes screenshot when test fails.
     * @return - array of bytes
     */
    public byte[] getScreenShot() {
        byte[] screenshot;
        if (webDriver instanceof TakesScreenshot) {
            screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        } else {
            screenshot = ((TakesScreenshot) new Augmenter().augment(webDriver)).getScreenshotAs(OutputType.BYTES);
        }
        return screenshot;
    }

    @Override
    public void destroy() throws Exception {
        webDriver.quit();
    }

}
