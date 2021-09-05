package com.workOrder.step_defination;

import com.workOrder.pages.Catalog;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CatalogSteps {

    Catalog catalog;

    @Given("^user is on catalog list page$")
    public void userIsOnCatalogListPage() {
        catalog.userOnCatalogPage();
    }

    @Then("^user tap on Alert View$")
    public void userTapOnAlertView() {
        catalog.clickOnAlertViews();
    }

    @Then("^user tap on Simple Alert$")
    public void userTapOnSimpleAlert() {
        catalog.clickOnSimple();
    }

    @Then("^verify Simple Alert$")
    public void verifySimpleAlert() {
        catalog.verifyPopUp();
    }

    @Then("^click on alert ok button$")
    public void clickOnAlertOkButton() {
        catalog.clickOnOk();
    }

    @Then("^verify Okay and Cancel Alert$")
    public void verifyOkayAndCancelAlert() {
        catalog.verifyOkAndCancelAlert();
    }

    @Then("^user tap on Okay and Cancel Alert$")
    public void userTapOnOkayAndCancelAlert() {
        catalog.clickOnOkAndCancel();
    }

    @And("^user tap on text enter alert$")
    public void userTapOnTextEnterAlert() {
        catalog.clickOnTextEnterAlert();
    }

    @Then("^verify text enter alert$")
    public void verifyTextEnterAlert() {
        catalog.verifyTextEnterAlert();
    }

    @And("^Type in it$")
    public void typeInIt() {
        catalog.typeInAlert();
    }

    @And("^user tap on Activity indicator$")
    public void userTapOnActivityIndicator() {
        catalog.TapOnActivityIndicator();
    }

    @Then("^verify Activity indicator page and loader$")
    public void verifyActivityIndicatorPageAndLoader() {
        catalog.verifyActivityIndicatorPage();
    }
}

