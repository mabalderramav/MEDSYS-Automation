package com.bo.medsys.automation.medsys.web.steps.logins;

import com.bo.medsys.automation.medsys.core.ui.helpers.LoginHelper;
import io.cucumber.java.en.Given;

public class LoginSteps {

    @Given("I login to {string} portal web with {string} credentials")
    public void iLoginToPortalWebWithCredentials(String portalWeb, String userType) {
        LoginHelper.loginUserInPortal(portalWeb, userType);
    }
}
