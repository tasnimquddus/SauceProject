package com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Social;

import org.openqa.selenium.WebDriver;

public class TwitterPage {
    private WebDriver webDriver;

    public TwitterPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public String getURL(){
        return webDriver.getCurrentUrl();
    }
}
