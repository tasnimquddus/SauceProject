package com.SpartaGlobal.GroupA.WebFramework.pom.Pages.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestTShirtPage {
    private WebDriver webDriver;

    public TestTShirtPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getURL() {
        return webDriver.getCurrentUrl();
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

    public void backToProductsButton() {
        webDriver.findElement(By.name("back-to-products")).click();
    }
}
