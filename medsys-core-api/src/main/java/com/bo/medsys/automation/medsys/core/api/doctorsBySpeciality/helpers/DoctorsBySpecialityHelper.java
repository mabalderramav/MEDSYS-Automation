package com.bo.medsys.automation.medsys.core.api.doctorsBySpeciality.helpers;

import com.bo.medsys.automation.core.api.client.ApiRequest;
import com.bo.medsys.automation.core.api.client.RequestManager;
import com.bo.medsys.automation.core.api.environment.EnvironmentManager;
import com.bo.medsys.automation.core.utils.json.JsonParser;
import com.bo.medsys.automation.medsys.core.api.authentications.entities.AuthenticationResponseEntity;
import com.bo.medsys.automation.medsys.core.api.doctorsBySpeciality.entities.DoctorsBySpecialityResponseEntity;

import java.util.HashMap;

public class DoctorsBySpecialityHelper {
    private DoctorsBySpecialityHelper() {
        // Default constructor.
    }

    /**
     * Get the doctors by speciality.
     *
     * @param endpoint                     The endpoint to send the request to.
     * @param authenticationResponseEntity The authentication response entity.
     * @return The doctors by speciality response entity.
     */
    public static DoctorsBySpecialityResponseEntity getToDoctorsBySpeciality(final String endpoint,
                                                                             final AuthenticationResponseEntity authenticationResponseEntity) {
        var url = EnvironmentManager.getInstance().getUrl().concat(endpoint);
        var token = authenticationResponseEntity.getToken();
        var headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");
        headers.put("Authorization", "Bearer ".concat(token));
        var apiRequest = new ApiRequest();
        apiRequest.setHeaders(headers);

        var response = RequestManager.get(apiRequest, url);
        var doctorsBySpecialityResponseEntity =
                JsonParser.fromJsonString(response.getBody(), DoctorsBySpecialityResponseEntity.class);
        doctorsBySpecialityResponseEntity.setStatusCode(response.getStatusCode());
        return doctorsBySpecialityResponseEntity;
    }
}
