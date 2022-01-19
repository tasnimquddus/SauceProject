package com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Checkout;

import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.InventoryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CoCompletePage {
    private WebDriver webDriver;

    public CoCompletePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getURL() {
        return webDriver.getCurrentUrl();
    }


}
