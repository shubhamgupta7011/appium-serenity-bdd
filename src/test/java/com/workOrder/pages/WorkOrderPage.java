package com.workOrder.pages;

import com.workOrder.utilities.MobilePageObject;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class WorkOrderPage extends MobilePageObject {

    public WorkOrderPage(WebDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "extends MobilePageObject")
    private WebElement userName;

    @AndroidFindBy(id = "com.workorder.mobile:id/edittext_password")
    private WebElement password;

    @AndroidFindBy(id = "com.workorder.mobile:id/button_login")
    private WebElement signinButton;

    @AndroidFindBy(id = "com.workorder.mobile:id/imageview_navigation_menu")
    private WebElement menuIcon;

    @AndroidFindBy(id = "com.workorder.mobile:id/button_edit_profile")
    private WebElement editProfileButton;

    @AndroidFindBy(id = "com.workorder.mobile:id/button_change_password")
    private WebElement chnagePswdButton;

    @AndroidFindBy(id = "com.workorder.mobile:id/editText_edit_profile_name")
    private WebElement nameField;

    @AndroidFindBy(id = "com.workorder.mobile:id/editText_edit_profile_contact_number")
    private WebElement contactNoField;

    @AndroidFindBy(id = "com.workorder.mobile:id/button_edit_profile_save")
    private WebElement saveButton;

    @AndroidFindBy(id = "com.workorder.mobile:id/button_logout_my_profile")
    private WebElement logoutButton;

    @AndroidFindBy(id = "com.workorder.mobile:id/editText_my_profile_name")
    private WebElement myProfileName;

    @AndroidFindBy(id = "com.workorder.mobile:id/editText_profile_contact_number")
    private WebElement myProfileContact;

    @AndroidFindBy(id = "android:id/message")
    private WebElement validationMessage;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement okButtonPopup;



    public void enterCredentials(String userEmail, String pwd) {
        try {
            withTimeoutOf(20,TimeUnit.SECONDS).waitFor(userName).clear();
            userName.sendKeys(userEmail);
            password.clear();
            password.sendKeys(pwd);
            signinButton.click();
            waitABit(2000);
        } catch (Exception ignored) {

        }
    }

    public void verifyWorkOrderDashboard() {
        this.userGoToProfilePage();
        withTimeoutOf(80,TimeUnit.SECONDS).waitFor(logoutButton).click();
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(userName).shouldBeVisible();
    }

    public void userGoToProfilePage() {
        withTimeoutOf(40,TimeUnit.SECONDS).waitFor(menuIcon).shouldBeVisible();
        menuIcon.click();
    }

    public void tapOnEditButton() {
        withTimeoutOf(40,TimeUnit.SECONDS).waitFor(editProfileButton).click();
    }

    public void clickOnSaveButton() {
        withTimeoutOf(40,TimeUnit.SECONDS).waitFor(saveButton).click();
    }

    public void editProfile(String name, String number) {
        waitFor(nameField).clear();
        waitFor(nameField).sendKeys(name);
        waitFor(contactNoField).clear();
        waitFor(contactNoField).sendKeys(number);
    }

    public void verifyEditDetails(String name,String number) {
        Assert.assertEquals(withTimeoutOf(20,TimeUnit.SECONDS).waitFor(myProfileName).getText(),name);
        Assert.assertEquals(waitFor(myProfileContact).getText(),number);
    }

    public void verifyValidationMessage(String arg0) {
        Assert.assertEquals(arg0,waitFor(validationMessage).getText());
    }

    public void tapOnOkButtonOnPopup() {
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(okButtonPopup).click();
    }


}
