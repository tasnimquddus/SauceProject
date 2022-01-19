package com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Checkout;

import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.InventoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CoCompletePage {
    private WebDriver webDriver;

    public CoCompletePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getURL() {
        return webDriver.getCurrentUrl();
    }

    public void backHome() {
        webDriver.findElement(By.id("back-to-products")).click();
    }
}
