package com.SpartaGlobal.GroupA.WebFramework.pom.Tests;

import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.LoginPage;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {
    private static WebDriver webDriver;
    private LoginPage loginPage;
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";

    @BeforeAll
    static void beforeAll() {
        System.setProperty("webdriver.chrome.driver", DRIVER_LOCATION);
    }

    @BeforeEach
    void setupEach() {
        ChromeOptions chromeOptions = new ChromeOptions();
        // chromeOptions.addArguments("headless");
        webDriver = new ChromeDriver(chromeOptions);
        loginPage = new LoginPage(webDriver, "standard_user", "secret_sauce");
    }

    @Test

    @DisplayName("Check Login")
    public void checkLoginWorks() {
        String login = loginPage.login();
        MatcherAssert.assertThat(login, Matchers.equalTo("https://www.saucedemo.com/inventory.html"));
    }

    @AfterEach
    void teardown() {
        webDriver.close();
    }

    @AfterAll
    static void teardownAll() {
        webDriver.quit();
    }

}
