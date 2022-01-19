package com.SpartaGlobal.GroupA.WebFramework.pom.Tests;

import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Checkout.CheckoutInfoPage;
import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.Checkout.YourCartPage;
import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.InventoryPage;
import com.SpartaGlobal.GroupA.WebFramework.pom.Pages.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CartPageTest {
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
    @DisplayName("Check Inventory Page goes to Your Cart page")
    public void InventoryToCartPage(){
      String login = loginPage.login();
      Assertions.assertEquals("https://www.saucedemo.com/cart.html",  inventoryPage.gotoCartPage().getURL());

    }

    @Test
    @DisplayName("Check Continue Shopping button on Cart Page goes back to Inventory Page")
    public void CartToInventoryPage(){
        String login = loginPage.login();
        YourCartPage cartPage  = inventoryPage.gotoCartPage();
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", yourCartPage.gotoInventoryPage().getURL());
    }

    @Test
    @DisplayName("Check Checkout button on Cart Page goes back to Checkout Information page")
    public void CartToCheckoutPage(){
        String login = loginPage.login();
        YourCartPage cartPage  = inventoryPage.gotoCartPage();
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-one.html", yourCartPage.gotoCheckoutInfoPage().getURL());
    }


    @AfterEach
    void teardown(){ webDriver.close(); }

    @AfterAll
    static void teardownAll(){ webDriver.quit();}
}
