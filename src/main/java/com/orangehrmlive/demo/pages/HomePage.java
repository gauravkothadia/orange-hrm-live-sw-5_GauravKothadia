package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @CacheLookup
    @FindBy(linkText = "Register")
    WebElement registerLink;

    public void clickOnLoginLink() {
        clickOnElement(loginLink);
        Reporter.log("Clicking on Login Link " + loginLink.toString());
        CustomListeners.test.log(Status.PASS, "Clicking on Login Link");
    }

    public void clickOnRegisterLink() {
        clickOnElement(registerLink);
        Reporter.log("Clicking on Register link "+ registerLink.toString());
        CustomListeners.test.log(Status.PASS, "Clicking on Register Link");
    }
}
