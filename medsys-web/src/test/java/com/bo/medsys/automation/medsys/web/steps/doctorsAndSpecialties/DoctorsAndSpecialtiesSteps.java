package com.bo.medsys.automation.medsys.web.steps.doctorsAndSpecialties;

import com.bo.medsys.automation.medsys.core.ui.pages.scheduler.SchedulerPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class DoctorsAndSpecialtiesSteps {

    @When("I click on 'Especialidad' dropdown")
    public void clickOnSpecialtyDropdown() {
        var schedulerPage = new SchedulerPage();
        schedulerPage.clickOnSpecialtyDropdown();
    }

    @Then("I should see a list of specialties")
    public void iShouldSeeAListOfSpecialties(List<String> specialtiesExpected) {
        var schedulerPage = new SchedulerPage();
        var specialtiesActual = schedulerPage.getSpecialties();
        specialtiesExpected.forEach(specialtyExpected -> {
            Assertions.assertTrue(specialtiesActual.contains(specialtyExpected),
                    "Specialty not found: ".concat(specialtyExpected));
        });
    }
}
