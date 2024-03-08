package com.bo.medsys.automation.core.api.client;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

/**
 * Defines methods to send requests.
 */
@Log4j2
public final class RequestManager {
    /**
     * Default constructor for utility class.
     */
    private RequestManager() {
        // Default constructor.
    }

    /**
     * Sends GET request.
     *
     * @param apiRequest request object.
     * @param endpoint   webservice endpoint.
     * @return response data.
     */
    public static ApiResponse get(final ApiRequest apiRequest, final String endpoint) {
        log.info("Sending GET request to '${endpoint}'\nBody: ${apiRequest.getBody()}");
        Response response = RestAssured.given()
                .when()
                .headers(apiRequest.getHeaders())
                .queryParams(apiRequest.getParams())
                .body(apiRequest.getBody())
                .get(endpoint);
        log.info("Response '${response.getStatusCode()}' status code.\nBody: ${response.getBody().asPrettyString()}");
        return new ApiResponse(response);
    }

    /**
     * Sends POST request.
     *
     * @param apiRequest request object.
     * @param endpoint   webservice endpoint.
     * @return response data.
     */
    public static ApiResponse post(final ApiRequest apiRequest, final String endpoint) {
        log.info("Sending POST request to '${endpoint}'\nBody: ${apiRequest.getBody()}");
        Response response = RestAssured.given()
                .when()
                .headers(apiRequest.getHeaders())
                .queryParams(apiRequest.getParams())
                .body(apiRequest.getBody())
                .post(endpoint);
        log.info("Response '${response.getStatusCode()}' status code.\nBody: ${response.getBody().asPrettyString()}");
        return new ApiResponse(response);
    }

    /**
     * Sends PUT request.
     *
     * @param apiRequest request object.
     * @param endpoint   webservice endpoint.
     * @return response data.
     */
    public static ApiResponse put(final ApiRequest apiRequest, final String endpoint) {
        log.info("Sending PUT request to '${endpoint}'\nBody: ${apiRequest.getBody()}");
        Response response = RestAssured.given()
                .when()
                .headers(apiRequest.getHeaders())
                .queryParams(apiRequest.getParams())
                .body(apiRequest.getBody())
                .put(endpoint);
        log.info("Response '${response.getStatusCode()}' status code.\nBody: ${response.getBody().asPrettyString()}");
        return new ApiResponse(response);
    }

    /**
     * Sends DELETE request.
     *
     * @param apiRequest request object.
     * @param endpoint   webservice endpoint.
     * @return response data.
     */
    public static ApiResponse delete(final ApiRequest apiRequest, final String endpoint) {
        log.info("Sending DELETE request to '${endpoint}'");
        Response response = RestAssured.given()
                .when()
                .headers(apiRequest.getHeaders())
                .queryParams(apiRequest.getParams())
                .delete(endpoint);
        log.info("Response '${response.getStatusCode()}' status code.\nBody: ${response.getBody().asPrettyString()}");
        return new ApiResponse(response);
    }
}
