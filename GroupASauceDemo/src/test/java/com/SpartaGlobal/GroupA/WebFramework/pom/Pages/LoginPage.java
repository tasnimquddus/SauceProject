package com.SpartaGlobal.GroupA.WebFramework.pom.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver webDriver;
    private final String LOGINURL = "https://www.saucedemo.com/";
    private String username;
    private String password;

    public LoginPage(WebDriver webDriver, String username, String password){

        this.username = username;
        this.password = password;


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

//    public String getErrorMessage() {
//         var error = webDriver.findElement(By.className("error-message-container"));
//
////        return webDriver.findElement(By.tagName("h3")).getAttribute("data-test");
//    }
}
