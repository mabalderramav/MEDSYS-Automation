package com.bo.medsys.automation.medsys.api.steps.schedulesOfADoctor;

import com.bo.medsys.automation.medsys.core.api.authentications.entities.AuthenticationResponseEntity;
import com.bo.medsys.automation.medsys.core.api.schedulesOfADoctor.entities.AvailableSchedulesOfADoctorResponseEntity;
import com.bo.medsys.automation.medsys.core.api.schedulesOfADoctor.helpers.AvailableSchedulesOfADoctorHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class AvailableSchedulesOfADoctorSteps {
    private final AuthenticationResponseEntity authenticationResponseEntity;
    private AvailableSchedulesOfADoctorResponseEntity availableSchedulesOfADoctorResponseEntity;

    public AvailableSchedulesOfADoctorSteps(final AuthenticationResponseEntity authenticationResponseEntity) {
        this.authenticationResponseEntity = authenticationResponseEntity;
        availableSchedulesOfADoctorResponseEntity = new AvailableSchedulesOfADoctorResponseEntity();
    }

    @When("I get the available schedules of a doctor with endpoint {string}")
    public void getTheAvailableSchedulesOfADoctorWithEndpoint(String endpoint) {
        availableSchedulesOfADoctorResponseEntity =
                AvailableSchedulesOfADoctorHelper.getAvailableSchedulesOfADoctor(endpoint, authenticationResponseEntity);
    }

    @Then("the response status code should be {int}")
    public void responseStatusCodeShouldBe(int statusCodeExpected) {
        var statusCodeActual = availableSchedulesOfADoctorResponseEntity.getStatusCode();
        Assertions.assertEquals(statusCodeExpected, statusCodeActual);
    }

    @Then("the available schedules of a doctor should be returned")
    public void availableSchedulesOfADoctorShouldBeReturned() {
        var availableSchedules = availableSchedulesOfADoctorResponseEntity.getAvailableSchedulesOfADoctorEntities();
        var patientIdExpected = 0;
        Assertions.assertFalse(availableSchedules.isEmpty());
        availableSchedules.forEach(availableSchedule ->
                Assertions.assertEquals(patientIdExpected, availableSchedule.getPatientId(),
                        "The patient id is not 0 so the schedule is not available."));
    }
}
