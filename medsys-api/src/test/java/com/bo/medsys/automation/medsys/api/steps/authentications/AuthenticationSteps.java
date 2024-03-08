package com.bo.medsys.automation.medsys.api.steps.authentications;

import com.bo.medsys.automation.medsys.core.api.authentications.entities.AuthenticationResponseEntity;
import com.bo.medsys.automation.medsys.core.api.authentications.helpers.AuthenticationHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.Map;

public class AuthenticationSteps {
    private AuthenticationResponseEntity userAuthenticated;

    public AuthenticationSteps() {
        userAuthenticated = new AuthenticationResponseEntity();
    }

    @When("I send a request to POST authentication endpoint {string} with the following data")
    public void sendARequestToPOSTAuthenticationEndpointWithTheFollowingData(final String endpoint,
                                                                             final Map<String, String> data) {
        userAuthenticated = AuthenticationHelper.sendPostRequestToAuthenticationEndpoint(endpoint, data);
    }

    @Then("I should receive a response with status {int}")
    public void shouldReceiveAResponseWithStatus(int statusExpected) {
        var statusActual = userAuthenticated.getStatusCode();
        Assertions.assertEquals(statusExpected, statusActual);
    }

    @Then("I should receive a response with the following data")
    public void shouldReceiveAResponseWithTheFollowingData(final Map<String, String> data) {
        Assertions.assertAll(
                () -> Assertions.assertNotNull(userAuthenticated.getToken()),
                () -> Assertions.assertNotNull(userAuthenticated.getToken()),
                () -> Assertions.assertEquals(data.get("fullName"), userAuthenticated.getFullName()),
                () -> Assertions.assertEquals(data.get("email"), userAuthenticated.getEmail())
        );
    }

    @Then("I should receive a invalid response with the following message {string}")
    public void shouldReceiveAResponseWithTheFollowingMessage(String errorMessage) {
        var message = userAuthenticated.getErrorMessage();
        Assertions.assertEquals(errorMessage, message);
    }
}
