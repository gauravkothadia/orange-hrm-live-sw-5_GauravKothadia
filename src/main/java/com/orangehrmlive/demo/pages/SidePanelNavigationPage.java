package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class SidePanelNavigationPage extends Utility {

    //
    @CacheLookup
    @FindBy(linkText = "Admin")
    WebElement adminTab;

    @CacheLookup
    @FindBy(linkText = "PIM")
    WebElement pimTab;

    @CacheLookup
    @FindBy(linkText = "Leave")
    WebElement leaveTab;

    @CacheLookup
    @FindBy(linkText = "Time")
    WebElement timeTab;

    @CacheLookup
    @FindBy(linkText = "Recruitment")
    WebElement recruitmentTab;

    @CacheLookup
    @FindBy(linkText = "My Info")
    WebElement myInfoTab;

    @CacheLookup
    @FindBy(linkText = "Performance")
    WebElement performanceTab;

    @CacheLookup
    @FindBy(linkText = "Dashboard")
    WebElement dashboardTab;

    @CacheLookup
    @FindBy(linkText = "Directory")
    WebElement directoryTab;

    @CacheLookup
    @FindBy(linkText = "Maintenance")
    WebElement maintenanceTab;

    @CacheLookup
    @FindBy(linkText = "Claim")
    WebElement claimTab;

    @CacheLookup
    @FindBy(linkText = "Buzz")
    WebElement buzzTab;

    public void clickOnMenuItemLink(String linkName) {
        switch (linkName) {
            case "Admin":
                clickOnElement(adminTab);
                break;
            case "PIM":
                clickOnElement(pimTab);
                break;
            case "Leave":
                clickOnElement(leaveTab);
                break;
            case "Time":
                clickOnElement(timeTab);
                break;
            case "Recruitment":
                clickOnElement(recruitmentTab);
                break;
            case "My Info":
                clickOnElement(myInfoTab);
                break;
            case "Performance":
                clickOnElement(performanceTab);
                break;
            case "Dashboard":
                clickOnElement(dashboardTab);
                break;
            case "Directory":
                clickOnElement(directoryTab);
                break;
            case "Maintenance":
                clickOnElement(maintenanceTab);
                break;
            case "Claim":
                clickOnElement(claimTab);
                break;
            case "Buzz":
                clickOnElement(buzzTab);
                break;
            default:
                new Exception ("Wrong selection");
                break;
        }
    }
}
