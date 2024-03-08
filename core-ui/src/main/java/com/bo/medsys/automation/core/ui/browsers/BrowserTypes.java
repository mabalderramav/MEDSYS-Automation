package com.bo.medsys.automation.core.ui.browsers;

/**
 * Driver types enum.
 */
public enum BrowserTypes {
    CHROME("CHROME"),
    CHROME_DOCKER("CHROME_DOCKER");

    private final String word;

    /**
     * Initializes WebDriver types enum.
     *
     * @param word original word.
     */
    BrowserTypes(final String word) {
        this.word = word;
    }

    /**
     * Gets the enum word value.
     *
     * @return original word.
     */
    public String val() {
        return word;
    }
}
