package com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Checkout;

import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class CoCartPage {
    private final WebDriver webDriver;



    public CoCartPage(WebDriver webDriver)
    {
        this.webDriver = webDriver;

    }

    public String getURL() {
        return webDriver.getCurrentUrl();
    }


}
