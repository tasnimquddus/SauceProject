package com.SpartaGlobal.GroupA.WebFramework.pom.Pages;

import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.products.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private WebDriver webDriver;

    public InventoryPage(WebDriver webDriver, String username, String password) {
        this.webDriver = webDriver;
        LoginPage loginPage = new LoginPage(webDriver, username, password);
        loginPage.login();
    }

    public String getURL() {
        return webDriver.getCurrentUrl();
    }

    public void addBackpackToCart() {
        webDriver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    public void removeBackpackFromCart() {
        webDriver.findElement(By.id("remove-sauce-labs-backpack")).click();
    }

    public void addBikeLightToCart() {
        webDriver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    }

    public void removeBikeLightFromCart() {
        webDriver.findElement(By.id("remove-sauce-labs-bike-light")).click();
    }

    public void addBoltTShirtToCart() {
        webDriver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
    }

    public void removeBoltTShirtFromCart() {
        webDriver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
    }

    public void addFleeceJacketToCart() {
        webDriver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
    }

    public void removeFleeceJacketFromCart() {
        webDriver.findElement(By.id("remove-sauce-labs-fleece-jacket")).click();
    }

    public void addOnesieToCart() {
        webDriver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
    }

    public void removeOnesieFromCart() {
        webDriver.findElement(By.id("remove-sauce-labs-onesie")).click();
    }

    public void addTestTShirtToCart() {
        webDriver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
    }

    public void removeTestTShirtFromCart() {
        webDriver.findElement(By.id("remove-test.allthethings()-t-shirt-(red)")).click();
    }

    public int itemsInCart() {
        String number = webDriver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
        return Integer.parseInt(number);
    }

    public BackpackPage goToBackpackPage() {
        webDriver.findElement(By.linkText("Sauce Labs Backpack")).click();
        return new BackpackPage(webDriver);
    }

    public BikeLightPage goToBikeLightPage() {
        webDriver.findElement(By.linkText("Sauce Labs Bike Light")).click();
        return new BikeLightPage(webDriver);
    }

    public BoltTShirtPage goToBoltTShirtPage() {
        webDriver.findElement(By.linkText("Sauce Labs Bolt T-Shirt")).click();
        return new BoltTShirtPage(webDriver);
    }

    public FleeceJacketPage goToFleeceJacketPage() {
        webDriver.findElement(By.linkText("Sauce Labs Fleece Jacket")).click();
        return new FleeceJacketPage(webDriver);
    }

    public OnesiePage goToOnesiePage() {
        webDriver.findElement(By.linkText("Sauce Labs Onesie")).click();
        return new OnesiePage(webDriver);
    }

    public TestTShirtPage goToTestTShirtPage() {
        webDriver.findElement(By.linkText("Test.allTheThings() T-Shirt (Red)")).click();
        return new TestTShirtPage(webDriver);
    }
}
