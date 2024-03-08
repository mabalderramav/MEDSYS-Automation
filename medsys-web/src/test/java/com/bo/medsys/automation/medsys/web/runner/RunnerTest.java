package com.bo.medsys.automation.medsys.web.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "com.bo.medsys.automation.medsys.web",
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class RunnerTest extends AbstractTestNGCucumberTests {
}
