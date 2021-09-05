package com.workOrder.pages;

import com.workOrder.utilities.MobilePageObject;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Catalog extends MobilePageObject {
    public Catalog(WebDriver driver) {
        super(driver);
    }

    @iOSFindBy(id = "Alert Views")
    private WebElement alertViews;

    @iOSFindBy(id = "Activity Indicators")
    private WebElement activityIndicators;

    @iOSFindBy(id = "Simple")
    private WebElement Simple;

    @iOSFindBy(id = "Text Entry")
    private WebElement textEntry;

    @iOSFindBy(id = "Okay / Cancel")
    private WebElement OkayAndCancel;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"UIKitCatalog\"]")
    private WebElement header;

    @iOSFindBy(id = "OK")
    private WebElement OK;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"A Short Title Is Best\"]")
    private WebElement popupTitle;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"A message should be a short, complete sentence.\"]")
    private WebElement popupSubTitle;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"A Short Title Is Best\"]")
    private WebElement okAndCancelPopupTitle;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"A message should be a short, complete sentence.\"]")
    private WebElement okAndCancelPopupSubTitle;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"A message should be a short, complete sentence.\"]")
    private WebElement textEnterPopupSubTitle;

    @iOSFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"A Short Title Is Best\"]")
    private WebElement aShortTitleIsBest;

    @iOSFindBy(xpath = "//XCUIElementTypeAlert[@name=\"A Short Title Is Best\"]/..//*//XCUIElementTypeTextField")
    private WebElement textAreaInAlert;

    @iOSFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Activity Indicators\"]")
    private WebElement activityIndicatorsHeader;

    public void clickOnAlertViews() {
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(alertViews).click();
    }

    public void clickOnSimple() {
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(Simple).click();
    }

    public void clickOnOk() {
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(OK).click();
    }

    public void verifyPopUp(){
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(popupTitle).shouldBeVisible();
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(popupSubTitle).shouldBeVisible();
    }

    public void userOnCatalogPage() {
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(header).shouldBeVisible();
    }

    public void clickOnOkAndCancel() {
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(OkayAndCancel).click();
    }

    public void verifyOkAndCancelAlert() {
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(okAndCancelPopupTitle).shouldBeVisible();
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(okAndCancelPopupSubTitle).shouldBeVisible();
    }

    public void clickOnTextEnterAlert() {
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(textEntry).click();
    }

    public void verifyTextEnterAlert() {
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(aShortTitleIsBest).shouldBeVisible();
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(textEnterPopupSubTitle).shouldBeVisible();
    }

    public void typeInAlert() {
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(textAreaInAlert).sendKeys("Shubham");
    }

    public void TapOnActivityIndicator() {
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(activityIndicators).click();
    }

    public void verifyActivityIndicatorPage() {
        withTimeoutOf(20,TimeUnit.SECONDS).waitFor(activityIndicatorsHeader).shouldBeVisible();
    }
}
