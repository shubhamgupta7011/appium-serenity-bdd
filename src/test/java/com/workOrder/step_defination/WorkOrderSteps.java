package com.workOrder.step_defination;

import com.workOrder.pages.WorkOrderPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;


public class WorkOrderSteps {

    private WorkOrderPage workOrderPage;
    private String name,number;


    @When("^User enter credentials and tap on the sign in button$")
    public void userEnterCredentialsAndTapOnTheSignInButton(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        String userEmail = list.get(0).get("userEmail");
        String pwd = list.get(0).get("password");
        workOrderPage.enterCredentials(userEmail, pwd);

    }

    @Then("^User successfully logged in and Dashboard page displayed$")
    public void userSuccessfullyLoggedInAndDashboardPageDisplayed() throws Throwable {
        workOrderPage.verifyWorkOrderDashboard();
    }

    @Given("^User sign in with valid credential of client user$")
    public void userSignInWithValidCredentialOfClientUser() {
        workOrderPage.enterCredentials("shubhamgupta@mailinator.com", "1234567890");
    }

    @When("^User reaches to the edit profile screen$")
    public void userReachesToTheEditProfileScreen() throws Throwable {
        try {
            workOrderPage.userGoToProfilePage();
            workOrderPage.tapOnEditButton();
        }catch (Exception e){}
    }

    @And("^User tap on the save button$")
    public void userTapOnTheSaveButton() throws Throwable {
        workOrderPage.clickOnSaveButton();
    }

    @And("^User enters the data in inbox field to edit$")
    public void userEntersTheDataInInboxFieldToEdit(DataTable dataTable) throws Throwable {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
         name = list.get(0).get("Name");
         number = list.get(0).get("Number");
        workOrderPage.editProfile(name,number);
    }

    @Then("^verify changes$")
    public void verifyChanges() throws Throwable {
        workOrderPage.verifyEditDetails(name,number);
    }

    @Then("^Error message \"([^\"]*)\" is displayed$")
    public void errorMessageIsDisplayed(String arg0) throws Throwable {
        workOrderPage.verifyValidationMessage(arg0);
        workOrderPage.tapOnOkButtonOnPopup();
    }


}

