package com.bo.medsys.automation.medsys.core.ui.helpers;

import com.bo.medsys.automation.core.ui.environment.EnvironmentManager;
import com.bo.medsys.automation.medsys.core.ui.pages.logins.LoginFactory;
import com.bo.medsys.automation.medsys.core.ui.pages.logins.LoginPage;
import com.bo.medsys.automation.medsys.core.ui.pages.logins.PortalWeb;
import com.bo.medsys.automation.medsys.core.ui.pages.logins.UserTypes;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Login helper class.
 */
public final class LoginHelper {
    private LoginHelper() {
    }

    /**
     * Login user in portal.
     *
     * @param portalWeb portal web.
     * @param userType  user type.
     */
    public static void loginUserInPortal(final PortalWeb portalWeb, final UserTypes userType) {
        EnvironmentManager environmentManager = EnvironmentManager.getInstance();
        environmentManager.setPortalWeb(portalWeb.val());
        environmentManager.setUserType(userType.val());

        LoginPage loginUserPasswordPage = LoginFactory.createLoginPage(portalWeb, userType);
        loginUserPasswordPage.loginUserInPortal();
    }

    /**
     * Login user in portal.
     *
     * @param portalWeb portal web.
     * @param userType  user type.
     */
    public static void loginUserInPortal(final String portalWeb, final String userType) {
        var index = 0;
        Stream<PortalWeb> portalWebStream =
                Arrays.stream(PortalWeb.values()).filter(pw -> pw.val().equalsIgnoreCase(portalWeb));
        Stream<UserTypes> userTypes = Arrays.stream(UserTypes.values()).filter(u -> u.val().equalsIgnoreCase(userType));
        loginUserInPortal(portalWebStream.toList().get(index), userTypes.toList().get(index));
    }
}
