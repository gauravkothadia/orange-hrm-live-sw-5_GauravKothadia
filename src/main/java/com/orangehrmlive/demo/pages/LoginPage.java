package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;


public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(name = "username")
    WebElement userNameField;

    @CacheLookup
    @FindBy(name = "password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//h5[normalize-space()='Login']")
    WebElement loginPanelText;

    @CacheLookup
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    WebElement requiredErrorMessage;

    @CacheLookup
    @FindBy(xpath = "//i[@class='oxd-icon bi-exclamation-circle oxd-alert-content-icon']")
    WebElement alertIcon;

    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement invalidCredentialsErrorMessage;


    public void enterUserName(String uName) {
        sendTextToElement(userNameField, uName);
        Reporter.log("Enter username "+ userNameField.toString()+"  data: "+uName);
        CustomListeners.test.log(Status.PASS, "Enter username " + uName);
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        Reporter.log("Enter password "+ passwordField.toString()+"  data: "+password);
        CustomListeners.test.log(Status.PASS, "Enter Password " + password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
        Reporter.log("Clicking on Login link "+loginButton.toString());
        CustomListeners.test.log(Status.PASS, "Click on loginButton");
    }

    public void loginToTheApplication(String userName, String pwd){
        enterUserName(userName);
        enterPassword(pwd);
        clickOnLoginButton();
    }

    public String getLoginPanelText() {
        String message = getTextFromElement(loginPanelText);
        Reporter.log("Getting Login Panel Text "+ loginPanelText.toString());
        CustomListeners.test.log(Status.PASS, "Get Login Panel Text");
        return message;
    }

    public String getErrorMessage(){
        String errorMessage = "";
        if(requiredErrorMessage.isDisplayed()){
            errorMessage = getTextFromElement(requiredErrorMessage);
            Reporter.log("Getting Required message. "+requiredErrorMessage.toString());
            CustomListeners.test.log(Status.PASS,"Getting required message: "+errorMessage);
        }else if(waitForElementWithFluentWait(alertIcon,10,2).isDisplayed()){
            errorMessage = getTextFromElement(invalidCredentialsErrorMessage);
            Reporter.log("Getting Required message. "+invalidCredentialsErrorMessage.toString());
            CustomListeners.test.log(Status.PASS,"Getting required message: "+errorMessage);
        }else {
            errorMessage="";
        }
        return errorMessage;
    }
}
