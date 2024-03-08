package com.bo.medsys.automation.core.ui.config;

/**
 * Custom reserved words enum.
 */
enum UiConfigWords {
    BROWSER("browser"),
    ENVIRONMENT_NAME("environmentName"),
    EXPLICIT_TIME("explicitTimeWait"),
    IMPLICIT_TIME("implicitTimeWait"),
    PAGE_LOAD_TIME("pageLoadTimeWait"),
    SLEEP_TIME("sleepWaitTime"),
    CHROME_DRIVER_VERSION("chromeDriverVersion"),
    WIDTH("width"),
    HEIGHT("height"),
    HEADLESS_MODE("headlessMode"),
    DOWNLOADS("downloads");

    private final String word;

    /**
     * Initializes Reserved Words enum.
     *
     * @param word original word.
     */
    UiConfigWords(final String word) {
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
