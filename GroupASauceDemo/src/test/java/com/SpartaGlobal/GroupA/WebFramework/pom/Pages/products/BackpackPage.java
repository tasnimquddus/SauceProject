package com.SpartaGlobal.GroupA.WebFramework.pom.Pages.products;

import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.InventoryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BackpackPage {
    private WebDriver webDriver;

    public BackpackPage(WebDriver webDriver) {
        this.webDriver = webDriver;
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

    public int itemsInCart() {
        String number = webDriver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a/span")).getText();
        return Integer.parseInt(number);
    }

    public void backToProductsButton() {
        webDriver.findElement(By.name("back-to-products")).click();
    }
}
