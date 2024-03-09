package com.bo.medsys.automation.medsys.core.ui.pages.logins;

public enum PortalWeb {
    MEDSYS("MEDSYS");

    private final String word;

    /**
     * Initializes Reserved Words enum.
     *
     * @param word original word.
     */
    PortalWeb(final String word) {
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
