package com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutInfoPage {
    private final WebDriver webDriver;



    public CheckoutInfoPage(WebDriver webDriver)
     {
        this.webDriver = webDriver;

    }

    public String getURL() {
        return webDriver.getCurrentUrl();
    }

       public void gotoYourCartPage() {
        webDriver.findElement(By.id("cancel")).click();
    }

        public CoOverviewPage continueCheckout() {
            webDriver.findElement(By.name("continue")).click();
            return new CoOverviewPage(webDriver);
        }

    public void fillInfo(String firstname, String lastname, String postcode) {
        webDriver.findElement(By.name("firstName")).sendKeys(firstname);
        webDriver.findElement(By.name("lastName")).sendKeys(lastname);
        webDriver.findElement(By.name("postalCode")).sendKeys(postcode);

    }

}
