package com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutInfoPage {
    private final WebDriver webDriver;
    private By CancelBtn = By.xpath("//*[@id=\"cancel\"]");



    public CheckoutInfoPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getURL() {
        return webDriver.getCurrentUrl();
    }

       public YourCartPage gotoYourCartPage() {
        webDriver.findElement(CancelBtn).click();

//        WebElement toCartPg = new WebDriverWait(webDriver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.elementToBeClickable(OverviewPg));
//        gotoOverviewPg.click();
        return new YourCartPage(webDriver);
    }

}
