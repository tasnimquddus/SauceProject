package com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Social;

import org.openqa.selenium.WebDriver;

public class FacebookPage {
    private WebDriver webDriver;

    public FacebookPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getURL() {
        return webDriver.getCurrentUrl();
    }

}
