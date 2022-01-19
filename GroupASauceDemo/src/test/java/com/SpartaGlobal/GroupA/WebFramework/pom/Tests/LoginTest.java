package com.SpartaGlobal.GroupA.WebFramework.pom.Tests;

import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.LoginPage;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;

public class LoginTest {
    private static WebDriver webDriver;
    private LoginPage loginPage;
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";

    @BeforeAll
    static void beforeAll(){
        System.setProperty("webdriver.chrome.driver", DRIVER_LOCATION);
    }

    @BeforeEach
    void setupEach(){
        ChromeOptions chromeOptions = new ChromeOptions();
        // chromeOptions.addArguments("headless");
        webDriver = new ChromeDriver(chromeOptions);

    }

    @Test
    @DisplayName("Check Login")
    public void checkLoginWorks(){
        loginPage = new LoginPage(webDriver, "standard_user", "secret_sauce");
        String login = loginPage.login();
        MatcherAssert.assertThat(login, equalTo("https://www.saucedemo.com/inventory.html"));
    }

    @Test
    @DisplayName("Check Wrong Login")
    public void checkWrongLoginWorks(){
        loginPage = new LoginPage(webDriver, "", "secret_sauce");
        loginPage.login();
        var error = webDriver.findElement(By.className("error-message-container"));
        MatcherAssert.assertThat(error.getText(), containsString("Epic sadface: Username is required"));
    }

    @AfterEach
    void teardown(){ webDriver.close(); }

    @AfterAll
    static void teardownAll(){ webDriver.quit();}

}
