package com.bo.medsys.automation.medsys.api.steps.specialties;

import com.bo.medsys.automation.medsys.core.api.authentications.entities.AuthenticationResponseEntity;
import com.bo.medsys.automation.medsys.core.api.specialties.entities.SpecialtyResponseEntity;
import com.bo.medsys.automation.medsys.core.api.specialties.helpers.SpecialtyHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class SpecialtySteps {

    private SpecialtyResponseEntity specialtyResponseEntity;
    private final AuthenticationResponseEntity authenticationResponseEntity;

    public SpecialtySteps(final AuthenticationResponseEntity authenticationResponseEntity) {
        this.authenticationResponseEntity = authenticationResponseEntity;
        specialtyResponseEntity = new SpecialtyResponseEntity();
    }

    @When("I get the specialties with endpoint {string}")
    public void getTheSpecialtiesWithEndpoint(String endpoint) {
        specialtyResponseEntity = SpecialtyHelper.getSpecialties(endpoint, authenticationResponseEntity);
    }

    @Then("the specialties response status should be {int}")
    public void specialtiesResponseStatusShouldBe(final int statusCodeExpected) {
        var statusActual = specialtyResponseEntity.getStatusCode();
        Assertions.assertEquals(statusCodeExpected, statusActual);
    }

    @Then("the specialties response should have a list of specialties")
    public void specialtiesResponseShouldHaveAListOfSpecialties() {
        var specialties = specialtyResponseEntity.getSpecialties();
        Assertions.assertFalse(specialties.isEmpty());
    }
}
