package com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoOverviewPage {
    private WebDriver webDriver;


    public CoOverviewPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getURL() {
        return webDriver.getCurrentUrl();
    }

    public void cancelCheckout() {
        webDriver.findElement(By.id("cancel")).click();
    }

    public CoCompletePage finishCheckout() {
        webDriver.findElement(By.id("finish")).click();
        return new CoCompletePage(webDriver);
    }
}
