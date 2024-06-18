package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ViewSystemUsersPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
    WebElement successToastMessage;

    public String getSuccessToastMessage(){
        Reporter.log("Getting success message "+successToastMessage.toString());
        CustomListeners.test.log(Status.PASS,"Getting success message");
        return getTextFromElement(waitForElementWithFluentWait(successToastMessage,10,2));
    }
}
