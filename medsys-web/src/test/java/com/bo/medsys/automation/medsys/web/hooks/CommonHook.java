package com.bo.medsys.automation.medsys.web.hooks;

import com.bo.medsys.automation.medsys.core.ui.helpers.BrowserHelper;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriverException;

import java.io.ByteArrayInputStream;

public final class CommonHook {
    private static final Logger LOGGER = LogManager.getLogger(CommonHook.class.getSimpleName());

    @After(order = 1002)
    public void quitWebDriver() {
        BrowserHelper.closeBrowser();
    }

    @After(order = 1004)
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            LOGGER.info(String.format("Taking screenshot for %s scenario", scenario.getName()));
            try {
                byte[] screenshot = BrowserHelper.takeScreenshot();
                Allure.addAttachment(String.format("Take screenshot for %s scenario", scenario.getName()),
                        new ByteArrayInputStream(screenshot));
            } catch (WebDriverException e) {
                LOGGER.error(String.format("Error when taking screenshot for %s scenario", scenario.getName()));
            }
        }
    }
}
