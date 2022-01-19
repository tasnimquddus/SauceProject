package com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Checkout;

import org.openqa.selenium.WebDriver;

public class CoCompletePage {
    private WebDriver webDriver;

    public CoCompletePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getURL() {
        return webDriver.getCurrentUrl();
    }
}
