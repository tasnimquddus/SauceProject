package com.SpartaGlobal.GroupA.WebFramework.pom.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private WebDriver webDriver;


    public InventoryPage(WebDriver webDriver, String username, String password) {
        this.webDriver= webDriver;
        LoginPage loginPage= new LoginPage(webDriver,username,password);
        webDriver.get(loginPage.getURL());
        goToInventoryPage();
    }

    public InventoryPage(WebDriver webDriver) {
    }


    private void goToInventoryPage() {
        webDriver.get("https://www.saucedemo.com/inventory.html");
    }

    public String getURL() {
        return webDriver.getCurrentUrl();
    }
}
