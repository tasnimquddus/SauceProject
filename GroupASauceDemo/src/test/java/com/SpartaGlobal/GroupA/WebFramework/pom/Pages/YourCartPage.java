package com.SpartaGlobal.GroupA.WebFramework.pom.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YourCartPage {
    private final WebDriver webDriver;
    private By checkoutButton = new By.ById("checkout");
    private By continueShoppingButton = By.xpath("//a[text()='Continue Shopping']");

    public YourCartPage(WebDriver webDriver, String username, String password) {
        this.webDriver = webDriver;
        LoginPage loginPage = new LoginPage(webDriver, username, password);
        webDriver.get(loginPage.getURL());
    }

    public YourCartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void getUrl(){ webDriver.getCurrentUrl();}

    public InventoryPage pressingContinueShoppingButton() {
        WebElement firstResult = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        webDriver.findElement(continueShoppingButton).click();
        return new InventoryPage(webDriver);
    }


}
