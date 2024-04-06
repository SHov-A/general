package com.inomma.acceptance.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inomma.acceptance.client.StarTrekClient;
import com.inomma.acceptance.client.StarTrekClientImpl;
import com.inomma.acceptance.client.StarTrekService;
import com.inomma.acceptance.client.parser.JsonParser;
import com.inomma.acceptance.client.parser.Parser;
import com.inomma.acceptance.client.parser.WebGiftsService;
import com.inomma.acceptance.pages.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * The configuration of spring beans.
 */
@Configuration
public class PageBeans {

    private static final String STAR_ACCEPTANCE_DRIVER = "star.acceptance.driver";
    private static final String STAR_ACCEPTANCE_URL = "star.acceptance.url";
    private static final String STAR_ACCEPTANCE_GRID_URL = "star.acceptance.grid.url";
    private static final String STAR_ACCEPTANCE_BROWSER = "star.acceptance.browser";
    private static final String STAR_ACCEPTANCE_BROWSER_NAME = "browserName";
    private static final String STAR_ACCEPTANCE_BROWSER_VERSION = "browserVersion";
    private static final String STAR_ACCEPTANCE_VERSION = "star.acceptance.version";
    private static final String STAR_ACCEPTANCE_SELENOID_OPTIONS = "selenoid:options";
    private static final String STAR_ACCEPTANCE_VNC = "enableVNC";
    private static final boolean ENABLE_VNC = true;
    private static final String TIME_ZONE = "timeZone";
    private static final String TIME_ZONE_OPTION = "Asia/Yerevan";
    private static final String SESSION_TIMEOUT = "sessionTimeout";
    private static final String SESSION_TIMEOUT_DURATION = "2m";
    private static final int WIDTH = 1920;
    private static final int HEIGHT = 1080;

    /**
     * Context: Driver and Url
     */
    @Bean
    public PageContext pageContext()
            throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        String driver = System.getProperty(STAR_ACCEPTANCE_DRIVER);
        URL url = new URL(System.getProperty(STAR_ACCEPTANCE_URL));
        if (driver == null) {
            String browser = System.getProperty(STAR_ACCEPTANCE_BROWSER);
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability(ChromeOptions.CAPABILITY, browserOptions().initCapabilities(browser));
            capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, browserOptions().initCapabilities(browser));
            capabilities.setCapability(STAR_ACCEPTANCE_BROWSER_NAME, browser);
            capabilities.setCapability(STAR_ACCEPTANCE_BROWSER_VERSION, System.getProperty(STAR_ACCEPTANCE_VERSION));
            capabilities.setCapability(TIME_ZONE, TIME_ZONE_OPTION);
            capabilities.setCapability(SESSION_TIMEOUT, SESSION_TIMEOUT_DURATION);
            capabilities.setCapability(STAR_ACCEPTANCE_SELENOID_OPTIONS, new HashMap<String, Object>() {{
                put(STAR_ACCEPTANCE_VNC, ENABLE_VNC);
            }});
            RemoteWebDriver remoteWebDriver = new RemoteWebDriver(
                    new URL(System.getProperty(STAR_ACCEPTANCE_GRID_URL)),
                    capabilities
            );
            remoteWebDriver.setFileDetector(new LocalFileDetector());
            remoteWebDriver.manage().window().setSize(new Dimension(WIDTH, HEIGHT));
            return new PageContext(remoteWebDriver, url);
        }
        return new PageContext(browserOptions().putCapabilities(driver), url);
    }

    @Bean
    public InitialPage initialPage() throws Exception {
        return new InitialPage(pageContext());
    }

    @Bean
    public LoginPage loginPage() throws Exception {
        return new LoginPage(pageContext());
    }

    @Bean
    public HomePage homePage() throws Exception {
        return new HomePage(pageContext());
    }

    @Bean
    public StorePage storePage() throws Exception {
        return new StorePage(pageContext());
    }

    @Bean
    public StarTrekService starTrekService() {
        return new StarTrekService();
    }

    @Bean
    public StarTrekClient starTrekClient() {
        return new StarTrekClientImpl();
    }

    @Bean
    public Parser parser() {
        return new JsonParser();
    }

    @Bean
    public WebGiftsService webGiftsService() {
        return new WebGiftsService();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public LeftSidebarPage leftSidebarPage() throws Exception {
        return new LeftSidebarPage(pageContext());
    }

    @Bean
    public NewsPage newsPage() throws Exception {
        return new NewsPage(pageContext());
    }

    @Bean
    public ChromeOptions chromeOptions() {
        return new ChromeOptions();
    }

    @Bean
    public FirefoxOptions firefoxOptions() {
        return new FirefoxOptions();
    }

    @Bean
    public BrowserOptions browserOptions() {
        return new BrowserOptions();
    }

}
