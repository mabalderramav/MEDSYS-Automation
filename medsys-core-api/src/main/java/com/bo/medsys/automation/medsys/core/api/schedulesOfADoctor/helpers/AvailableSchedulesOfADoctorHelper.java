package com.bo.medsys.automation.medsys.core.api.schedulesOfADoctor.helpers;

import com.bo.medsys.automation.core.api.client.ApiRequest;
import com.bo.medsys.automation.core.api.client.RequestManager;
import com.bo.medsys.automation.core.api.environment.EnvironmentManager;
import com.bo.medsys.automation.core.utils.json.JsonParser;
import com.bo.medsys.automation.medsys.core.api.authentications.entities.AuthenticationResponseEntity;
import com.bo.medsys.automation.medsys.core.api.schedulesOfADoctor.entities.AvailableSchedulesOfADoctorResponseEntity;

import java.util.HashMap;

public final class AvailableSchedulesOfADoctorHelper {
    private AvailableSchedulesOfADoctorHelper() {
        // Private constructor to hide the implicit public one.
    }

    /**
     * Get the available schedules of a doctor.
     *
     * @param endpoint                     The endpoint to send the request to.
     * @param authenticationResponseEntity The authentication response entity.
     * @return The available schedules of a doctor response entity.
     */
    public static AvailableSchedulesOfADoctorResponseEntity getAvailableSchedulesOfADoctor(
            final String endpoint, final AuthenticationResponseEntity authenticationResponseEntity) {
        var url = EnvironmentManager.getInstance().getUrl().concat(endpoint);
        var token = authenticationResponseEntity.getToken();
        var headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer ".concat(token));
        var apiRequest = new ApiRequest();
        apiRequest.setHeaders(headers);

        var response = RequestManager.get(apiRequest, url);
        var availableSchedulesOfADoctorResponseEntity =
                JsonParser.fromJsonString(response.getBody(), AvailableSchedulesOfADoctorResponseEntity.class);
        availableSchedulesOfADoctorResponseEntity.setStatusCode(response.getStatusCode());
        return availableSchedulesOfADoctorResponseEntity;
    }
}
