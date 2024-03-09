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
    private List<WebElement> specialtiesDropdownItems;

    public SchedulerPage() {
        super();
    }

    public void clickOnSpecialtyDropdown() {
        action.click(specialtyDropdown);
    }

    public List<String> getSpecialties() {
        var specialities = new ArrayList<String>();
        specialtiesDropdownItems.forEach(specialty -> {
            specialities.add(action.getText(specialty));
        });

        return specialities;
    }
}
