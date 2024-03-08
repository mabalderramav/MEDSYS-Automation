package com.bo.medsys.automation.core.ui.environment;

/**
 * Custom reserved words enum.
 */
enum EnvironmentWords {
    ENVIRONMENT_PATH("src/test/resources/Environment.json");

    private final String word;

    /**
     * Initializes Reserved Words enum.
     *
     * @param word original word.
     */
    EnvironmentWords(final String word) {
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
