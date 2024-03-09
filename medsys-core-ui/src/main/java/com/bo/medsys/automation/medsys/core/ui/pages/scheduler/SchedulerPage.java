package com.bo.medsys.automation.medsys.core.ui.pages.scheduler;

import com.bo.medsys.automation.medsys.core.ui.pages.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;

public class SchedulerPage extends BasePage {

    @FindBy(css = "div[id='stepper-linear-specialty-language']")
    private WebElement specialtyDropdown;

    @FindBys({
            @FindBy(css = "li[class*='MuiButtonBase-root']"),
    })
    private List<WebElement> dropdownItems;

    @FindBy(css = "button[type='submit']")
    private WebElement nextButton;

    @FindBy(css = "div[id='stepper-linear-doctor']")
    private WebElement doctorDropdown;

    public SchedulerPage() {
        super();
    }

    public void clickOnSpecialtyDropdown() {
        action.click(specialtyDropdown);
    }

    public List<String> getSpecialties() {
        var specialities = new ArrayList<String>();
        dropdownItems.forEach(specialty -> {
            specialities.add(action.getText(specialty));
        });

        return specialities;
    }

    public void selectSpecialty(final String specialty) {
        dropdownItems.stream()
                .filter(specialtyItem -> action.getText(specialtyItem).equalsIgnoreCase(specialty))
                .findFirst()
                .ifPresent(action::click);
    }

    public void clickOnNextButton() {
        action.click(nextButton);
    }

    public void clickOnDoctorDropdown() {
        action.click(doctorDropdown);
    }

    public List<String> getDoctors() {
        var doctors = new ArrayList<String>();
        dropdownItems.forEach(doctor -> {
            doctors.add(action.getText(doctor));
        });

        return doctors;
    }
}
