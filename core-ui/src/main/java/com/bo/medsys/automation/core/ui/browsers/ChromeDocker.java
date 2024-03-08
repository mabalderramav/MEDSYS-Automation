package com.bo.medsys.automation.core.ui.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.Objects;

public class ChromeDocker extends Chrome implements Browser<WebDriverManager> {
    /**
     * Initializes an instance of {@link ChromeBrowser}.
     */
    public ChromeDocker() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriverManager getDriver() {
        WebDriverManager webDriverManager;
        if (Objects.nonNull(WEBDRIVER_VERSION) && !WEBDRIVER_VERSION.isEmpty()) {
            webDriverManager = WebDriverManager
                    .chromedriver()
                    .driverVersion(WEBDRIVER_VERSION)
                    .capabilities(getOptions())
                    .browserInDocker();
        } else {
            webDriverManager = WebDriverManager.chromedriver().capabilities(getOptions()).browserInDocker();
        }

        webDriverManager.create();
        return webDriverManager;
    }
}
