package com.bo.medsys.automation.medsys.web.steps.logins;

import com.bo.medsys.automation.medsys.core.ui.helpers.LoginHelper;
import com.bo.medsys.automation.medsys.core.ui.pages.logins.LoginUserPasswordPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class LoginSteps {

    @Given("I login to {string} portal web with {string} credentials")
    public void iLoginToPortalWebWithCredentials(String portalWeb, String userType) {
        LoginHelper.loginUserInPortal(portalWeb, userType);
    }

    @Then("I should see the login page with error message {string}")
    public void iShouldSeeTheLoginPageWithErrorMessage(final String errorMessageExpected) {
        // TODO: improve login page to include error message
        var loginPage = new LoginUserPasswordPage();
        var errorMessageActual = loginPage.getErrorMessage();
        Assertions.assertEquals(errorMessageExpected, errorMessageActual);
    }
}
