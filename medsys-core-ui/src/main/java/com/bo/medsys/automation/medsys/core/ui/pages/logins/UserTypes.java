package com.bo.medsys.automation.medsys.core.ui.pages.logins;

public enum UserTypes {
    USER_PASSWORD("USER-PASSWORD");

    private final String word;

    /**
     * Initializes Reserved Words enum.
     *
     * @param word original word.
     */
    UserTypes(final String word) {
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
