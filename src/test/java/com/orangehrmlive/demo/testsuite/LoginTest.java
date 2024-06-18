package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.DashboardPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldLoginSuccessFully() {
        //   Enter username
        loginPage.enterUserName("Admin");
        //    Enter password
        loginPage.enterPassword("admin123");
        //    Click on Login Button
        loginPage.clickOnLoginButton();
        //    Verify "Dashboard" Message on Dashboard page
        Assert.assertEquals(dashboardPage.getDashboardHeading(), "Dashboard");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatTheLogoDisplayOnHomePage() {
        //    Login To The application
        loginPage.loginToTheApplication("Admin", "admin123");
        //    Verify Logo is Displayed
        Assert.assertTrue(dashboardPage.isLogoDisplayed(), "Logo not displayed.");
    }

    @Test(groups = {"regression"})
    public void verifyUserShouldLogOutSuccessFully() {
        //    Login To The application
        loginPage.loginToTheApplication("Admin", "admin123");
        //    Click on User Profile logo
        dashboardPage.clickOnUserProfile();
        //    Mouse hover on "Logout" and click
        dashboardPage.mouseHoverToLogOutLinkAndClick();
        //    Verify the text "Login Panel" is displayed
        Assert.assertEquals(loginPage.getLoginPanelText(), "Login");
    }


    @Test(groups = {"regression"}, dataProvider = "credentials",dataProviderClass = TestData.class)
    public void verifyErrorMessageWithInvalidCredentials(String userName, String pwd, String expectedErrorMessage) {
        //    Enter username <username>
        loginPage.enterUserName(userName);
        //    Enter password <password>
        loginPage.enterPassword(pwd);
        //    Click on Login Button
        loginPage.clickOnLoginButton();
        //    Verify Error message <errorMessage>
        Assert.assertEquals(loginPage.getErrorMessage(),expectedErrorMessage);
    }
}
