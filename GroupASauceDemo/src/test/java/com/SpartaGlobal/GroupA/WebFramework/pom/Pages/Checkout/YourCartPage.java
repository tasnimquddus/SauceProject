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
    private By InventoryPg = By.xpath("//*[@id=\"continue-shopping\"]");
    private By CheckoutBtn = By.xpath("//*[@id=\"checkout\"]");




    public YourCartPage(WebDriver webDriver)
    {
        this.webDriver = webDriver;

    }

    public String getURL() {
        return webDriver.getCurrentUrl();
    }

    public InventoryPage gotoInventoryPage() {
        WebElement toInventoryPg = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(InventoryPg));

        toInventoryPg.click();
        return new InventoryPage(webDriver);
    }

    public CheckoutInfoPage gotoCheckoutInfoPage() {
        WebElement toCheckoutInfo = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(CheckoutBtn));
        toCheckoutInfo.click();
        return new CheckoutInfoPage(webDriver);
    }


}
