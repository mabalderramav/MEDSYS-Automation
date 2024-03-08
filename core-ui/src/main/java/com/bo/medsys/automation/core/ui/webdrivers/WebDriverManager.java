package com.bo.medsys.automation.core.ui.webdrivers;

import com.bo.medsys.automation.core.ui.browsers.BrowserTypes;
import com.bo.medsys.automation.core.ui.config.UiConfig;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public final class WebDriverManager {
    private static WebDriverManager instance;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private io.github.bonigarcia.wdm.WebDriverManager webDriverManager;

    /**
     * Initializes an instance of {@link WebDriverManager}.
     */
    private WebDriverManager() {
        initializeDriver();
    }

    /**
     * Initializes the Singleton Driver Manager instance.
     *
     * @return singleton instance.
     */
    public static WebDriverManager getInstance() {
        if (Objects.isNull(instance)) {
            instance = new WebDriverManager();
        }
        return instance;
    }

    /**
     * Initializes the Web Driver instance.
     */
    private void initializeDriver() {
        var uiConfig = UiConfig.getInstance();
        BrowserTypes webDriverType = BrowserTypes.valueOf(uiConfig.getBrowser());
        webDriverManager = WebDriverFactory.getWebDriverManager(webDriverType);
        webDriver = webDriverManager.getWebDriver();
        webDriver.manage().window().setSize(new Dimension(uiConfig.getWidthOfBrowser(), uiConfig.getHeightOfBrowser()));
        setDefaultTimeWaits();
    }

    /**
     * {@inheritDoc}
     */
    public void setDefaultTimeWaits() {
        UiConfig uiConfig = UiConfig.getInstance();
        setImplicitTimeWait(uiConfig.getImplicitTime());
        setExplicitTimeWait(uiConfig.getExplicitTime(), uiConfig.getSleepTime());
        setPageLoadTimeWait(uiConfig.getPageLoadTime());
    }

    /**
     * Sets implicit time wait.
     *
     * @param implicitTimeWait implicit time wait in seconds.
     */
    private void setImplicitTimeWait(final int implicitTimeWait) {
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitTimeWait));
    }

    /**
     * Sets explicit time wait.
     *
     * @param explicitTimeWait explicit time wait in seconds.
     * @param sleepTimeWait    sleep time wait in seconds.
     */
    private void setExplicitTimeWait(final int explicitTimeWait, final int sleepTimeWait) {

        webDriverWait = new WebDriverWait(
                webDriver, Duration.ofSeconds(explicitTimeWait), Duration.ofSeconds(sleepTimeWait));
    }

    /**
     * Sets page load time wait.
     *
     * @param pageLoadTimeWait page load time wait in seconds.
     */
    private void setPageLoadTimeWait(final long pageLoadTimeWait) {
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeWait));
    }

    /**
     * Quits the Web Driver instance.
     */
    public void quitWebDriver() {
        webDriver.quit();
        webDriverManager.quit();
        webDriver = null;
        webDriverManager = null;
        webDriverWait = null;
        instance = null;
    }

    /**
     * Gets the Web Driver instance.
     *
     * @return Web Driver instance.
     */
    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    /**
     * Gets the Web Driver Wait instance.
     *
     * @return Web Driver Wait instance.
     */
    public WebDriverWait getWebDriverWait() {
        return this.webDriverWait;
    }
}
