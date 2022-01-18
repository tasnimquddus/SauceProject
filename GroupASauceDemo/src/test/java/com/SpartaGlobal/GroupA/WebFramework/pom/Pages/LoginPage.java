package com.SpartaGlobal.GroupA.WebFramework.pom.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver webDriver;
    private final String LOGINURL = "https://www.saucedemo.com/";

    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        goToLoginPage();
    }

    private void goToLoginPage() {
        webDriver.get(LOGINURL);
    }


    public String getURL() {
        return webDriver.getCurrentUrl();
    }

    public String login(String username, String password) {
        webDriver.findElement(By.name("user-name")).sendKeys(username);
        webDriver.findElement(By.name("password")).sendKeys(password);
        webDriver.findElement(By.name("login-button")).click();
        return webDriver.getCurrentUrl();
    }
}
