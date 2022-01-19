package com.SpartaGlobal.GroupA.WebFramework.pom.Pages;

import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private WebDriver webDriver;

    public InventoryPage(WebDriver webDriver, String username, String password) {
        LoginPage loginPage = new LoginPage(webDriver, username, password);
        this.webDriver = webDriver;
        loginPage.login();
    }

    public String getURL() {
        return webDriver.getCurrentUrl();
    }



}
