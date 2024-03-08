package com.bo.medsys.automation.core.ui.config;

import com.bo.medsys.automation.core.utils.properties.PropertiesFileReader;

import java.util.Objects;

import static com.bo.medsys.automation.core.ui.config.UiConfigWords.BROWSER;
import static com.bo.medsys.automation.core.ui.config.UiConfigWords.CHROME_DRIVER_VERSION;
import static com.bo.medsys.automation.core.ui.config.UiConfigWords.DOWNLOADS;
import static com.bo.medsys.automation.core.ui.config.UiConfigWords.ENVIRONMENT_NAME;
import static com.bo.medsys.automation.core.ui.config.UiConfigWords.EXPLICIT_TIME;
import static com.bo.medsys.automation.core.ui.config.UiConfigWords.HEADLESS_MODE;
import static com.bo.medsys.automation.core.ui.config.UiConfigWords.HEIGHT;
import static com.bo.medsys.automation.core.ui.config.UiConfigWords.IMPLICIT_TIME;
import static com.bo.medsys.automation.core.ui.config.UiConfigWords.PAGE_LOAD_TIME;
import static com.bo.medsys.automation.core.ui.config.UiConfigWords.SLEEP_TIME;
import static com.bo.medsys.automation.core.ui.config.UiConfigWords.WIDTH;

public final class UiConfig {
    private static final String UI_PROP_FILE = "./gradle.properties";
    private static UiConfig instance;

    private final PropertiesFileReader propertiesFileReader;

    /**
     * Initializes an instance of {@link UiConfig}.
     */
    private UiConfig() {
        propertiesFileReader = new PropertiesFileReader(UI_PROP_FILE);
    }

    /**
     * Initializes the singleton UI Config instance.
     *
     * @return singleton instance.
     */
    public static synchronized UiConfig getInstance() {
        if (Objects.isNull(instance)) {
            instance = new UiConfig();
        }
        return instance;
    }

    /**
     * Gets the test execution environment name.
     *
     * @return execution environment name.
     */
    public String getEnvironment() {
        return propertiesFileReader.getPropertyValue(ENVIRONMENT_NAME.val());
    }

    /**
     * Gets the current Browser name.
     *
     * @return Browser value.
     */
    public String getBrowser() {
        return propertiesFileReader.getPropertyValue(BROWSER.val());
    }

    /**
     * Gets the implicit time wait for web driver default configuration.
     *
     * @return implicit time wait value.
     */
    public int getImplicitTime() {
        return Integer.parseInt(propertiesFileReader.getPropertyValue(IMPLICIT_TIME.val()));
    }

    /**
     * Gets the explicit time wait for web driver default configuration.
     *
     * @return explicit time wait value.
     */
    public int getExplicitTime() {
        return Integer.parseInt(propertiesFileReader.getPropertyValue(EXPLICIT_TIME.val()));
    }

    /**
     * Gets the sleep time wait for web driver default configuration.
     *
     * @return sleep time wait value.
     */
    public int getSleepTime() {
        return Integer.parseInt(propertiesFileReader.getPropertyValue(SLEEP_TIME.val()));
    }

    /**
     * Gets the page load time wait for WebDriver default configuration.
     *
     * @return page load time wait value.
     */
    public long getPageLoadTime() {
        return Long.parseLong(propertiesFileReader.getPropertyValue(PAGE_LOAD_TIME.val()));
    }

    /**
     * Gets the chrome driver version.
     *
     * @return chrome driver version.
     */
    public String getChromeDriverVersion() {
        return propertiesFileReader.getPropertyValue(CHROME_DRIVER_VERSION.val());
    }

    /**
     * Gets the download folder.
     *
     * @return folder path.
     */
    public String getDownloadsFolder() {
        return propertiesFileReader.getPropertyValue(DOWNLOADS.val());
    }

    /**
     * Gets width of browser.
     *
     * @return width of browser.
     */
    public int getWidthOfBrowser() {
        return Integer.parseInt(propertiesFileReader.getPropertyValue(WIDTH.val()));
    }

    /**
     * Gets height of browser.
     *
     * @return height of browser.
     */
    public int getHeightOfBrowser() {
        return Integer.parseInt(propertiesFileReader.getPropertyValue(HEIGHT.val()));
    }

    /**
     * Gets Headless mode.
     *
     * @return Headless mode.
     */
    public boolean isHeadlessMode() {
        return Boolean.parseBoolean(propertiesFileReader.getPropertyValue(HEADLESS_MODE.val()));
    }
}
