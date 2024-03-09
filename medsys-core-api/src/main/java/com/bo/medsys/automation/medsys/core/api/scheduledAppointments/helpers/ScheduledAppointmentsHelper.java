package com.bo.medsys.automation.medsys.core.api.scheduledAppointments.helpers;

import com.bo.medsys.automation.core.api.client.ApiRequest;
import com.bo.medsys.automation.core.api.client.RequestManager;
import com.bo.medsys.automation.core.api.environment.EnvironmentManager;
import com.bo.medsys.automation.core.utils.json.JsonParser;
import com.bo.medsys.automation.medsys.core.api.authentications.entities.AuthenticationResponseEntity;
import com.bo.medsys.automation.medsys.core.api.scheduledAppointments.entities.ScheduledAppointmentsResponseEntity;

import java.util.HashMap;

public class ScheduledAppointmentsHelper {

    private ScheduledAppointmentsHelper() {
        // Private constructor to hide the implicit public one.
    }

    /**
     * Get the scheduled appointments by patient.
     *
     * @param authenticationResponseEntity The authentication response entity.
     * @param endpoint                     The endpoint to send the request to.
     * @return The scheduled appointments response entity.
     */
    public static ScheduledAppointmentsResponseEntity getScheduledAppointmentsByPatient(
            final AuthenticationResponseEntity authenticationResponseEntity, final String endpoint) {
        var url = EnvironmentManager.getInstance().getUrl().concat(endpoint);
        var token = authenticationResponseEntity.getToken();
        var headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer ".concat(token));
        var apiRequest = new ApiRequest();
        apiRequest.setHeaders(headers);

        var response = RequestManager.get(apiRequest, url);
        var scheduledAppointmentsResponseEntity =
                JsonParser.fromJsonString(response.getBody(), ScheduledAppointmentsResponseEntity.class);
        scheduledAppointmentsResponseEntity.setStatusCode(response.getStatusCode());
        return scheduledAppointmentsResponseEntity;
    }
}
