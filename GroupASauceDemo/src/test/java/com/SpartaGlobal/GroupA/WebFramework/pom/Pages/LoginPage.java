package com.SpartaGlobal.GroupA.WebFramework.pom.Pages;

import com.SpartaGlobal.GroupA.WebFramework.pom.Tests.NavigationTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver webDriver;
    private final String LOGINURL = "https://www.saucedemo.com/";
    private String username;
    private String password;

<<<<<<< HEAD
    public LoginPage(WebDriver webDriver){
    }

    public LoginPage(WebDriver webDriver, String username, String password) {
        this.username = username;
        this.password = password;
=======
    public LoginPage(WebDriver webDriver, String username, String password){
>>>>>>> 7905a96c3d517a2346bf736d5b1dcc4ef26ab541
        this.webDriver = webDriver;
        this.username = username;
        this.password = password;
        goToLoginPage();
    }

    private void goToLoginPage() {
        webDriver.get(LOGINURL);
    }

    public String getURL() {
        return webDriver.getCurrentUrl();
    }

    public String login() {
        webDriver.findElement(By.name("user-name")).sendKeys(username);
        webDriver.findElement(By.name("password")).sendKeys(password);
        webDriver.findElement(By.name("login-button")).click();
        return webDriver.getCurrentUrl();
    }


}
