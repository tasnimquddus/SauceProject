package com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Checkout;

import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.InventoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YourCartPage {
    private final WebDriver webDriver;

    public YourCartPage(WebDriver webDriver)
    {
        this.webDriver = webDriver;

    }

    public String getURL() {
        return webDriver.getCurrentUrl();
    }


    public void goBackToInventory() {
        webDriver.findElement(By.id("continue-shopping")).click();
    }

    public CheckoutInfoPage goToCheckoutInformation() {
        webDriver.findElement(By.id("checkout")).click();
        return new CheckoutInfoPage(webDriver);
    }

}
