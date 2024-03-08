package com.bo.medsys.automation.core.api.client;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * Models request data.
 */
@Getter
public class ApiRequest {

    private static final String EMPTY_STRING = "";
    private final Map<String, String> headers;
    private final Map<String, String> params;
    private final Map<String, String> formData;
    @Setter
    private String body;

    /**
     * Initializes an instance of {@link ApiRequest}.
     */
    public ApiRequest() {
        headers = new HashMap<>();
        params = new HashMap<>();
        formData = new HashMap<>();
        body = EMPTY_STRING;
    }

    /**
     * Adds headers to request.
     *
     * @param headers request headers.
     */
    public void setHeaders(final Map<String, String> headers) {
        this.headers.putAll(headers);
    }

    /**
     * Adds params to request.
     *
     * @param params request parameters.
     */
    public void setParams(final Map<String, String> params) {
        this.params.putAll(params);
    }

    /**
     * Adds form data to request.
     *
     * @param formData request form data.
     */
    public void setFormData(final Map<String, String> formData) {
        this.formData.putAll(formData);
    }
}
