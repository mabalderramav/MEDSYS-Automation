package com.bo.medsys.automation.core.ui.browsers;

/**
 * Browser interface for supported web browsers.
 */
public interface Browser<T> {
    /**
     * Gets a Web Driver instance of a specific browser.
     *
     * @return Web Driver instance.
     */
    T getDriver();
}
