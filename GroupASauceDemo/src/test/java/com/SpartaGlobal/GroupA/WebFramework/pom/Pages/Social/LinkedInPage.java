package com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Social;

import org.openqa.selenium.WebDriver;

public class LinkedInPage {
    private WebDriver webDriver;

    public LinkedInPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public String getURL(){
        return webDriver.getCurrentUrl();
    }
}
