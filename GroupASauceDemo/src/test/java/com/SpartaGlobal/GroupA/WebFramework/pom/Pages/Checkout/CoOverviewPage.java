package com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoOverviewPage {
    private WebDriver webDriver;
// private By CancelBtn = By.xpath("//*[@id=\"cancel\"]");
// private By CancelBtn = By.xpath("//*[@id=\"cancel\"]");


    public CoOverviewPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getURL() {
        return webDriver.getCurrentUrl();
    }
}
