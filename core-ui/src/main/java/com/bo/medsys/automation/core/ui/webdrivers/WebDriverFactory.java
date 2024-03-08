package com.bo.medsys.automation.core.ui.webdrivers;

import com.bo.medsys.automation.core.ui.browsers.Browser;
import com.bo.medsys.automation.core.ui.browsers.ChromeBrowser;
import com.bo.medsys.automation.core.ui.browsers.ChromeDocker;
import com.bo.medsys.automation.core.ui.browsers.BrowserTypes;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.EnumMap;

/**
 * Creates the instance of a Web Driver.
 */
public final class WebDriverFactory {
    /**
     * Initializes an instance of {@link WebDriverFactory} utility class.
     */
    private WebDriverFactory() {
    }

    /**
     * Gets a Web Driver instances based in a Driver Type parameter.
     *
     * @param type Driver Type enum value.
     * @return Web Driver instance.
     */
    public static WebDriverManager getWebDriverManager(final BrowserTypes type) {
        Browser<WebDriverManager> browser = getStrategyBrowser().get(type).performStep();
        return browser.getDriver();
    }

    /**
     * Gets strategy browser map.
     *
     * @return browser map.
     */
    private static EnumMap<BrowserTypes, StrategyGetter<Browser<WebDriverManager>>> getStrategyBrowser() {
        EnumMap<BrowserTypes, StrategyGetter<Browser<WebDriverManager>>> driverMap = new EnumMap<>(BrowserTypes.class);
        driverMap.put(BrowserTypes.CHROME, ChromeBrowser::new);
        driverMap.put(BrowserTypes.CHROME_DOCKER, ChromeDocker::new);
        return driverMap;
    }
}
