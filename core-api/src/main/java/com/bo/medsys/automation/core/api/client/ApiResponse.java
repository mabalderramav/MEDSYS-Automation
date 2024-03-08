package com.bo.medsys.automation.core.api.client;

import io.restassured.response.Response;


/**
 * Defines Api response wrapper class.
 */
public class ApiResponse {

    private final Response response;

    /**
     * Initializes an instance of ApiResponse class.
     *
     * @param response Response object.
     */
    public ApiResponse(final Response response) {
        this.response = response;
    }

    /**
     * Gets status code from response.
     *
     * @return response status code.
     */
    public int getStatusCode() {
        return response.getStatusCode();
    }

    /**
     * Gets body as string.
     *
     * @return body as string.
     */
    public String getBody() {
        return response.getBody().asString();
    }

    public void prettyPrint() {
        response.prettyPrint();
    }
}
