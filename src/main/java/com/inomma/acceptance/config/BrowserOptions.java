package com.inomma.acceptance.config;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BrowserOptions {

    private static final String CLASS_PATH_CHROME_DRIVER = "org.openqa.selenium.chrome.ChromeDriver";
    private static final String CHROME = "chrome";
    private static final String CLASS_PATH_FIREFOX_DRIVER = "org.openqa.selenium.firefox.FirefoxDriver";
    private static final String FIREFOX = "firefox";
    private static final String CHROME_OPTIONS = "org.openqa.selenium.chrome.ChromeOptions";
    private static final String FIREFOX_OPTIONS = "org.openqa.selenium.firefox.FirefoxOptions";

    @Autowired
    private ChromeOptions chromeOptions;

    @Autowired
    private FirefoxOptions firefoxOptions;

    public Capabilities initCapabilities(String driver) {
        if (driver.equals(CLASS_PATH_CHROME_DRIVER) || driver.equals(CHROME)) {
            return chromeOptions.addArguments("--disable-notifications", "--no-sandbox", "--test-type=browser",
                    "--disable-dev-shm-usage", "--disable-gpu", "--ignore-ssl-errors=yes", "--ignore-certificate-errors");
        } else if (driver.equals(CLASS_PATH_FIREFOX_DRIVER) || driver.equals(FIREFOX)) {
            return firefoxOptions
                    .addPreference("dom.webnotifications.enabled", false)
                    .addPreference(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        } else {
            return null;
        }
    }

    public WebDriver putCapabilities(String driver) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> constructor = null;
        Constructor<?>[] array = Class.forName(driver).asSubclass(WebDriver.class).getConstructors();
        for (Constructor<?> constr : array) {
            Class<?>[] parameterTypes = constr.getParameterTypes();
            if (driver.equals(CLASS_PATH_CHROME_DRIVER)) {
                if (parameterTypes.length == 1 && parameterTypes[0].getName().equals(CHROME_OPTIONS)) {
                    constructor = constr;
                }
            } else if (driver.equals(CLASS_PATH_FIREFOX_DRIVER)) {
                if (parameterTypes.length == 1 && parameterTypes[0].getName().equals(FIREFOX_OPTIONS)) {
                    constructor = constr;
                }
            }
        }
        assert constructor != null;
        return (WebDriver) constructor.newInstance(initCapabilities(driver));
    }
}
