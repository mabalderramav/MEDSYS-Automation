package com.bo.medsys.automation.medsys.web.steps.doctorsAndSpecialties;

import com.bo.medsys.automation.medsys.core.ui.pages.scheduler.SchedulerPage;
import io.cucumber.java.en.And;
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
    public void shouldSeeAListOfSpecialties(List<String> specialtiesExpected) {
        var schedulerPage = new SchedulerPage();
        var specialtiesActual = schedulerPage.getSpecialties();
        specialtiesExpected.forEach(specialtyExpected -> {
            Assertions.assertTrue(specialtiesActual.contains(specialtyExpected),
                    "Specialty not found: ".concat(specialtyExpected));
        });
    }

    @When("I select {string} in dropdownItem")
    public void selectSpecialtyInDropdownItem(final String specialty) {
        var schedulerPage = new SchedulerPage();
        schedulerPage.selectSpecialty(specialty);
    }

    @When("I click on 'Siguiente' button")
    public void clickOnNextButton() {
        var schedulerPage = new SchedulerPage();
        schedulerPage.clickOnNextButton();
    }

    @When("I click on 'Medico' dropdown")
    public void clickOnDoctorDropdown() {
        var schedulerPage = new SchedulerPage();
        schedulerPage.clickOnDoctorDropdown();
    }

    @Then("I should see a list of doctors")
    public void shouldSeeAListOfDoctors(List<String> doctorsExpected) {
        var schedulerPage = new SchedulerPage();
        var doctorsActual = schedulerPage.getDoctors();
        doctorsExpected.forEach(doctorExpected -> {
            Assertions.assertTrue(doctorsActual.contains(doctorExpected),
                    "Doctor not found: ".concat(doctorExpected));
        });
    }
}
