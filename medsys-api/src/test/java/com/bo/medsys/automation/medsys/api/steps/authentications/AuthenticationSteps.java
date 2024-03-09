package com.bo.medsys.automation.medsys.api.steps.authentications;

import com.bo.medsys.automation.medsys.core.api.authentications.entities.AuthenticationResponseEntity;
import com.bo.medsys.automation.medsys.core.api.authentications.helpers.AuthenticationHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.Map;

public class AuthenticationSteps {
    private AuthenticationResponseEntity authenticationResponse;
    private final AuthenticationResponseEntity authenticationResponseEntity;

    public AuthenticationSteps(final AuthenticationResponseEntity authenticationResponseEntity) {
        this.authenticationResponseEntity = authenticationResponseEntity;
        authenticationResponse = new AuthenticationResponseEntity();
    }

    @Given("I get a valid token with endpoint {string}")
    public void getAValidTokenWithEndpoint(final String endpoint) {
        authenticationResponse = AuthenticationHelper.sendPostRequestToAuthenticationEndpoint(endpoint);
        authenticationResponseEntity.setToken(authenticationResponse.getToken());
        authenticationResponseEntity.setFullName(authenticationResponse.getFullName());
        authenticationResponseEntity.setEmail(authenticationResponse.getEmail());
        authenticationResponseEntity.setErrorMessage(authenticationResponse.getErrorMessage());
        authenticationResponseEntity.setStatusCode(authenticationResponse.getStatusCode());
        authenticationResponseEntity.setId(authenticationResponse.getId());
    }

    @When("I send a request to POST authentication endpoint {string} with the following data")
    public void sendARequestToPOSTAuthenticationEndpointWithTheFollowingData(final String endpoint,
                                                                             final Map<String, String> data) {
        authenticationResponse = AuthenticationHelper.sendPostRequestToAuthenticationEndpoint(endpoint, data);
    }

    @Then("I should receive a response with status {int}")
    public void shouldReceiveAResponseWithStatus(int statusExpected) {
        var statusActual = authenticationResponse.getStatusCode();
        Assertions.assertEquals(statusExpected, statusActual);
    }

    @Then("I should receive a response with the following data")
    public void shouldReceiveAResponseWithTheFollowingData(final Map<String, String> data) {
        Assertions.assertAll(
                () -> Assertions.assertNotNull(authenticationResponse.getToken()),
                () -> Assertions.assertNotNull(authenticationResponse.getToken()),
                () -> Assertions.assertEquals(data.get("fullName"), authenticationResponse.getFullName()),
                () -> Assertions.assertEquals(data.get("email"), authenticationResponse.getEmail())
        );
    }

    @Then("I should receive a invalid response with the following message {string}")
    public void shouldReceiveAResponseWithTheFollowingMessage(final String errorMessage) {
        var message = authenticationResponse.getErrorMessage();
        Assertions.assertEquals(errorMessage, message);
    }
}
