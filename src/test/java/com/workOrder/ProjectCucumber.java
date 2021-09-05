package com.workOrder;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static com.workOrder.utilities.AppiumServerController.startAppiumServer;
import static com.workOrder.utilities.AppiumServerController.stopAppiumServer;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/catalog.feature")


public class ProjectCucumber {
    @BeforeClass
    public static void startAppium() {
        startAppiumServer();
    }

    @AfterClass
    public static void stopAppium() {
        stopAppiumServer();
    }
}
