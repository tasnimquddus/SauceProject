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
        inventoryPage = new InventoryPage(webDriver, "standard_user", "secret_sauce");
        yourCartPage = inventoryPage.gotoCartPage();
    }

    @Test
    @DisplayName("Check Inventory Page goes to Your Cart page")
    public void InventoryToCartPage(){
      Assertions.assertEquals("https://www.saucedemo.com/cart.html",  inventoryPage.gotoCartPage().getURL());

    }

    @Test
    @DisplayName("Check Continue Shopping button on Cart Page goes back to Inventory Page")
    public void CartToInventoryPage(){
        yourCartPage.goBackToInventory();
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", yourCartPage.getURL());
    }

    @Test
    @DisplayName("Check Checkout button on Cart Page goes back to Checkout Information page")
    public void CartToCheckoutPage(){
        yourCartPage.goToCheckoutInformation();
        Assertions.assertEquals("https://www.saucedemo.com/checkout-step-one.html", yourCartPage.getURL());
    }


    @AfterEach
    void teardown(){ webDriver.close(); }

    @AfterAll
    static void teardownAll(){ webDriver.quit();}
}
