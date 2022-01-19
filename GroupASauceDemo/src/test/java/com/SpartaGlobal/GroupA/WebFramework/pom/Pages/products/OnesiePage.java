package com.SpartaGlobal.GroupA.WebFramework.pom.Pages.products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OnesiePage {
    private WebDriver webDriver;

    public OnesiePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getURL() {
        return webDriver.getCurrentUrl();
    }

    public void addOnesieToCart() {
        webDriver.findElement(By.id("add-to-cart-sauce-labs-onesie")).click();
    }

    public void removeOnesieFromCart() {
        webDriver.findElement(By.id("remove-sauce-labs-onesie")).click();
    }

    public int itemsInCart() {
        String number = webDriver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
        return Integer.parseInt(number);
    }

    public void backToProductsButton() {
        webDriver.findElement(By.name("back-to-products")).click();
    }
}
