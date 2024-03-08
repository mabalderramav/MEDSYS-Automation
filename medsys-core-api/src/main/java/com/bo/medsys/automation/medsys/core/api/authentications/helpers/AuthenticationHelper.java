package com.bo.medsys.automation.medsys.core.api.authentications.helpers;

import com.bo.medsys.automation.core.api.client.ApiRequest;
import com.bo.medsys.automation.core.api.client.RequestManager;
import com.bo.medsys.automation.core.api.environment.EnvironmentManager;
import com.bo.medsys.automation.core.utils.json.JsonParser;
import com.bo.medsys.automation.medsys.core.api.authentications.entities.AuthenticationResponseEntity;

import java.util.HashMap;
import java.util.Map;

public final class AuthenticationHelper {

    /**
     * Private constructor to hide the implicit public one.
     */
    private AuthenticationHelper() {
    }

    /**
     * Send a POST request to the authentication endpoint.
     *
     * @param endpoint The endpoint to send the request to.
     * @param data     The data to send in the body request.
     * @return The {@link AuthenticationResponseEntity} object.
     */
    public static AuthenticationResponseEntity sendPostRequestToAuthenticationEndpoint(final String endpoint,
                                                                                       final Map<String, String> data) {
        var url = EnvironmentManager.getInstance().getUrl().concat(endpoint);
        var username = data.get("email");
        var password = data.get("password").equalsIgnoreCase("{password}") ?
                EnvironmentManager.getInstance().getPassword() : data.get("password");
        var headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        var body = """
                {
                    "email": "%s",
                    "password": "%s"
                }
                """.formatted(username, password);
        var apiRequest = new ApiRequest();
        apiRequest.setHeaders(headers);
        apiRequest.setBody(body);

        var response = RequestManager.post(apiRequest, url);
        var authenticationResponseEntity = JsonParser.fromJsonString(response.getBody(), AuthenticationResponseEntity.class);
        authenticationResponseEntity.setStatusCode(response.getStatusCode());
        return authenticationResponseEntity;
    }
}
