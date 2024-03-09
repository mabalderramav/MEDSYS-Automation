package com.bo.medsys.automation.medsys.core.ui.pages.logins;

/**
 * Manages the login pages build.
 */
public final class LoginFactory {
    /**
     * Private constructor for {@link LoginFactory} utility class.
     */
    private LoginFactory() {
    }

    /**
     * Creates a new Login page according to the portal web.
     *
     * @param portalWeb the portal web name.
     * @param userType  the credential type.
     * @return an instance of portal login page.
     */
    public static LoginPage createLoginPage(PortalWeb portalWeb, UserTypes userType)
            throws IllegalArgumentException {
        if (portalWeb == PortalWeb.MEDSYS) {
            if (userType == UserTypes.USER_PASSWORD) {
                return new LoginUserPasswordPage();
            }
        }

        throw new IllegalArgumentException("Incorrect portal web or user Type.");
    }
}
