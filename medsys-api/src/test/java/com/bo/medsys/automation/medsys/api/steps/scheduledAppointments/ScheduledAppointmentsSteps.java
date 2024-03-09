package com.bo.medsys.automation.medsys.api.steps.scheduledAppointments;

import com.bo.medsys.automation.medsys.core.api.authentications.entities.AuthenticationResponseEntity;
import com.bo.medsys.automation.medsys.core.api.scheduledAppointments.entities.ScheduledAppointmentsResponseEntity;
import com.bo.medsys.automation.medsys.core.api.scheduledAppointments.helpers.ScheduledAppointmentsHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

public class ScheduledAppointmentsSteps {
    private final AuthenticationResponseEntity authenticationResponseEntity;
    private ScheduledAppointmentsResponseEntity scheduledAppointmentsResponseEntity;

    public ScheduledAppointmentsSteps(final AuthenticationResponseEntity authenticationResponseEntity) {
        this.authenticationResponseEntity = authenticationResponseEntity;
        scheduledAppointmentsResponseEntity = new ScheduledAppointmentsResponseEntity();
    }

    @When("I get the list of scheduled appointments with endpoint {string}")
    public void getTheListOfScheduledAppointmentsWithEndpoint(final String endpoint) {
        scheduledAppointmentsResponseEntity =
                ScheduledAppointmentsHelper.getScheduledAppointmentsByPatient(authenticationResponseEntity, endpoint);
    }

    @Then("the scheduled appointments response status code should be {int}")
    public void theScheduledAppointmentsResponseStatusCodeShouldBe(final int statusCodeExpected) {
        var statusCodeActual = scheduledAppointmentsResponseEntity.getStatusCode();
        Assertions.assertEquals(statusCodeExpected, statusCodeActual);
    }

    @Then("the scheduled appointments response should have a list of appointments with the following fields")
    public void theScheduledAppointmentsResponseShouldHaveAListOfAppointmentsWithTheFollowingFields(
            List<Map<String, String>> scheduledAppointmentsExpected) {
        var scheduledAppointmentsActual = scheduledAppointmentsResponseEntity.getScheduledAppointments();
        Assertions.assertFalse(scheduledAppointmentsActual.isEmpty());
        scheduledAppointmentsExpected.forEach(scheduledAppointmentExpected -> {
            var scheduledAppointmentActual = scheduledAppointmentsActual.stream()
                    .filter(scheduledAppointment -> scheduledAppointment.getAppointmentId() == Integer
                            .parseInt(scheduledAppointmentExpected.get("appointmentId")))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("The scheduled appointment does not exist."));
            Assertions.assertAll("The scheduled appointment does not match the expected one.",
                    () -> Assertions.assertEquals(scheduledAppointmentExpected.get("hour"),
                            String.valueOf(scheduledAppointmentActual.getHour())),
                    () -> Assertions.assertEquals(scheduledAppointmentExpected.get("doctorId"),
                            String.valueOf(scheduledAppointmentActual.getDoctorId())),
                    () -> Assertions.assertEquals(scheduledAppointmentExpected.get("fullname"),
                            scheduledAppointmentActual.getFullName()),
                    () -> Assertions.assertEquals(scheduledAppointmentExpected.get("specialty"),
                            scheduledAppointmentActual.getSpecialty()),
                    () -> Assertions.assertEquals(scheduledAppointmentExpected.get("patientId"),
                            String.valueOf(scheduledAppointmentActual.getPatientId())),
                    () -> Assertions.assertEquals(scheduledAppointmentExpected.get("dateRegisterPatient"),
                            String.valueOf(scheduledAppointmentActual.getDateRegisterPatient()))
            );
        });
    }
}
