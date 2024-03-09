package com.bo.medsys.automation.medsys.api.steps.doctorsBySpeciality;

import com.bo.medsys.automation.medsys.core.api.doctorsBySpeciality.entities.DoctorsBySpecialityResponseEntity;
import com.bo.medsys.automation.medsys.core.api.doctorsBySpeciality.helpers.DoctorsBySpecialityHelper;
import com.bo.medsys.automation.medsys.core.api.authentications.entities.AuthenticationResponseEntity;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class DoctorsBySpecialitySteps {
    private final AuthenticationResponseEntity authenticationResponseEntity;
    private DoctorsBySpecialityResponseEntity doctorsBySpecialityResponseEntity;

    public DoctorsBySpecialitySteps(final AuthenticationResponseEntity authenticationResponseEntity) {
        this.authenticationResponseEntity = authenticationResponseEntity;
        doctorsBySpecialityResponseEntity = new DoctorsBySpecialityResponseEntity();
    }

    @When("I send a GET request to search doctors by speciality endpoint {string}")
    public void sendAGETRequestToSearchDoctorsBySpecialityEndpoint(final String endpoint) {
        doctorsBySpecialityResponseEntity =
                DoctorsBySpecialityHelper.getToDoctorsBySpeciality(endpoint, authenticationResponseEntity);
    }

    @Then("the doctors by speciality response status should be {int}")
    public void theDoctorsBySpecialityResponseStatusShouldBe(final int statusCodeExpected) {
        var statusActual = doctorsBySpecialityResponseEntity.getStatusCode();
        Assertions.assertEquals(statusCodeExpected, statusActual);
    }

    @Then("the response should gets a list of doctors by speciality")
    public void theResponseShouldGetsAListOfDoctorsBySpeciality() {
        var doctors = doctorsBySpecialityResponseEntity.getDoctors();
        Assertions.assertFalse(doctors.isEmpty());
    }

    @Then("the response should gets an empty list of doctors by speciality")
    public void theResponseShouldGetsAnEmptyListOfDoctorsBySpeciality() {
        var doctors = doctorsBySpecialityResponseEntity.getDoctors();
        Assertions.assertTrue(doctors.isEmpty());
    }
}
