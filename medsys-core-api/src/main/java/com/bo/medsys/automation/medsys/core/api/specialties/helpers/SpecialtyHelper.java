package com.bo.medsys.automation.medsys.core.api.specialties.helpers;

import com.bo.medsys.automation.core.api.client.ApiRequest;
import com.bo.medsys.automation.core.api.client.RequestManager;
import com.bo.medsys.automation.core.api.environment.EnvironmentManager;
import com.bo.medsys.automation.core.utils.json.JsonParser;
import com.bo.medsys.automation.medsys.core.api.authentications.entities.AuthenticationResponseEntity;
import com.bo.medsys.automation.medsys.core.api.specialties.entities.SpecialtyResponseEntity;

import java.util.HashMap;

public final class SpecialtyHelper {
    private SpecialtyHelper() {
        // Private constructor to hide the implicit public one.
    }


    /**
     * Get the specialties.
     *
     * @param endpoint                     The endpoint to send the request to.
     * @param authenticationResponseEntity The authentication response entity.
     * @return The specialties response entity.
     */
    public static SpecialtyResponseEntity getSpecialties(final String endpoint,
                                                         final AuthenticationResponseEntity authenticationResponseEntity) {
        var url = EnvironmentManager.getInstance().getUrl().concat(endpoint);
        var token = authenticationResponseEntity.getToken();
        var headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer ".concat(token));
        var apiRequest = new ApiRequest();
        apiRequest.setHeaders(headers);

        var response = RequestManager.get(apiRequest, url);
        var specialityResponseEntity =
                JsonParser.fromJsonString(response.getBody(), SpecialtyResponseEntity.class);
        specialityResponseEntity.setStatusCode(response.getStatusCode());
        return specialityResponseEntity;
    }
}
