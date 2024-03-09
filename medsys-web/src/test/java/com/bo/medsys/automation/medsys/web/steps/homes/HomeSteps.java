package com.bo.medsys.automation.medsys.web.steps.homes;

import com.bo.medsys.automation.medsys.core.ui.pages.homes.HomePage;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class HomeSteps {

    @Then("I should see the MEDSYS portal home page")
    public void shouldSeeTheMEDSYSPortalHomePage() {
        var homePage = new HomePage();
        var isHomePageDisplayed = homePage.isDisplayed();
        Assertions.assertTrue(isHomePageDisplayed);
    }
}
