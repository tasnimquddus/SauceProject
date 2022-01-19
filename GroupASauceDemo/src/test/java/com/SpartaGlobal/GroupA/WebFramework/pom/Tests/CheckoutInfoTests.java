package com.SpartaGlobal.GroupA.WebFramework.pom.Tests;

import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Checkout.CheckoutInfoPage;
import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Checkout.YourCartPage;
import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.InventoryPage;
import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckoutInfoTests {
    private static WebDriver webDriver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private YourCartPage yourCartPage;
    private CheckoutInfoPage checkoutInfoPage;
    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver";

    @BeforeAll
    static void beforeAll(){
        System.setProperty("webdriver.chrome.driver", DRIVER_LOCATION);
    }

    @BeforeEach
    void setupEach(){
        ChromeOptions chromeOptions = new ChromeOptions();
        // chromeOptions.addArguments("headless");
        webDriver = new ChromeDriver(chromeOptions);
        loginPage = new LoginPage(webDriver, "standard_user", "secret_sauce");
        inventoryPage = new InventoryPage(webDriver);
        yourCartPage = new YourCartPage(webDriver);
    }

    @Test
    @DisplayName("Check Cancel button on Check Your Information Pg to Your cart Page")
    public void CheckoutToCartPage(){
        String login = loginPage.login();
        YourCartPage cartPage  = inventoryPage.gotoCartPage();
        CheckoutInfoPage checkoutPg = yourCartPage.gotoCheckoutInfoPage();

        Assertions.assertEquals("https://www.saucedemo.com/cart.html",  checkoutPg.gotoYourCartPage().getURL());

    }


    @AfterEach
    void teardown(){ webDriver.close(); }

    @AfterAll
    static void teardownAll(){ webDriver.quit();}
}
