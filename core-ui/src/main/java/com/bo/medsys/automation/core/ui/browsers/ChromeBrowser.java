package com.bo.medsys.automation.core.ui.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Objects;

/**
 * Initializes an instance of a Chrome web driver.
 */
public class ChromeBrowser extends Chrome implements Browser<WebDriverManager> {

    /**
     * Initializes an instance of {@link ChromeBrowser}.
     */
    public ChromeBrowser() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriverManager getDriver() {
        WebDriverManager webDriverManager;
        if (Objects.nonNull(WEBDRIVER_VERSION) && !WEBDRIVER_VERSION.isEmpty()) {
            webDriverManager = WebDriverManager.chromedriver()
                    .driverVersion(WEBDRIVER_VERSION)
                    .capabilities(getOptions());
        } else {
            webDriverManager = WebDriverManager.chromedriver().capabilities(getOptions());
        }
        webDriverManager.create();
        return webDriverManager;
    }
}
